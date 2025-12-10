package com.lcsk42.biz.authorization.service.impl;

import com.lcsk42.biz.admin.client.SystemUserClient;
import com.lcsk42.biz.admin.model.vo.SystemUserVO;
import com.lcsk42.biz.authorization.common.exception.AuthorizationErrorCode;
import com.lcsk42.biz.authorization.model.dto.UserLoginDTO;
import com.lcsk42.biz.authorization.model.vo.TokenVO;
import com.lcsk42.biz.authorization.service.AuthorizationService;
import com.lcsk42.biz.authorization.util.PasswordUtil;
import com.lcsk42.frameworks.starter.cache.core.Cache;
import com.lcsk42.frameworks.starter.common.util.JwtUtil;
import com.lcsk42.frameworks.starter.common.util.UserContext;
import com.lcsk42.frameworks.starter.common.util.concurrent.ThreadUtil;
import com.lcsk42.frameworks.starter.convention.model.BaseUserInfoDTO;
import com.lcsk42.frameworks.starter.core.constant.RedisKeyConstant;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    @Value("${FRAMEWORK_GATEWAY_TOKEN_SECRET}")
    private final String secret;

    private final SystemUserClient systemUserClient;

    private final Cache cache;

    private final long TEN_MINUTE = 10 * 60L;
    private final long SEVEN_DAY = 7 * 24 * 60 * 60L;

    @Override
    public TokenVO createToken(UserLoginDTO userLoginDTO) {
        String usernameOrEmailOrMobile = userLoginDTO.getUsernameOrEmailOrMobile();
        String password = userLoginDTO.getPassword();

        SystemUserVO user = systemUserClient.getByUsernameOrEmailOrMobile(usernameOrEmailOrMobile);

        if (Objects.isNull(user)
                || !PasswordUtil.verifyPassword(password, user.getPassword(), user.getSalt())) {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 防止暴力破解，延时响应
            throw AuthorizationErrorCode.LOGIN_FAILED.toException();
        }
        Long id = user.getId();
        Map<String, Object> claims = Map.of(
                SystemUserVO.Fields.id, id,
                SystemUserVO.Fields.departmentId, user.getDepartmentId(),
                SystemUserVO.Fields.username, user.getUsername(),
                SystemUserVO.Fields.email, user.getEmail(),
                SystemUserVO.Fields.mobile, user.getMobile(),
                SystemUserVO.Fields.internal, user.getInternal());

        String accessToken = JwtUtil.generateToken(claims, secret, TEN_MINUTE);
        String refreshToken = JwtUtil.generateToken(claims, secret, SEVEN_DAY);

        // 存储 id 和 Token 的对应关系
        cache.put(RedisKeyConstant.User.getUserAccessToken(id), accessToken,
                Duration.ofSeconds(TEN_MINUTE));
        cache.put(RedisKeyConstant.User.getUserRefreshToken(id), refreshToken,
                Duration.ofSeconds(SEVEN_DAY));

        return new TokenVO()
                .setAccessToken(accessToken)
                .setRefreshToken(refreshToken);
    }

    @Override
    public Boolean logout() {
        String token = Optional.ofNullable(UserContext.getUser())
                .map(BaseUserInfoDTO::getToken)
                .orElseThrow(AuthorizationErrorCode.LOGOUT_FAILED::toException);
        Long id = JwtUtil.getClaim(token, secret, SystemUserVO.Fields.id, Long.class)
                .orElseThrow(AuthorizationErrorCode.LOGOUT_FAILED::toException);

        // 根据当前的 UserId 查询现有的 Token
        String accessToken = cache.get(RedisKeyConstant.User.getUserAccessToken(id));
        String refreshToken = cache.get(RedisKeyConstant.User.getUserRefreshToken(id));
        // 删除查询到对应的 Token 数据
        cache.delete(
                RedisKeyConstant.User.getUserAccessToken(id),
                RedisKeyConstant.User.getUserRefreshToken(id));
        // 增加 Token 黑名单
        Stream.of(accessToken, refreshToken)
                .filter(StringUtils::isNoneBlank)
                .map(RedisKeyConstant.User::getUserBlockToken)
                // 这里的 put 使用 refresh token 的时间，肯定没问题
                .forEach(userBlockToken -> cache.put(userBlockToken, 0,
                        Duration.ofSeconds(SEVEN_DAY)));

        return Boolean.TRUE;
    }

    @Override
    public String refreshToken() {
        String accessToken = Optional.ofNullable(UserContext.getUser())
                .map(BaseUserInfoDTO::getToken)
                .flatMap(token -> JwtUtil.refreshToken(token, secret, TEN_MINUTE))
                .orElse(StringUtils.EMPTY);
        if (StringUtils.isNoneBlank(accessToken)) {
            JwtUtil.getClaim(accessToken, secret, SystemUserVO.Fields.id, Long.class)
                    // 存储 id 和 token 的对应关系
                    .ifPresent(id -> cache.put(
                            RedisKeyConstant.User.getUserAccessToken(id),
                            accessToken,
                            Duration.ofSeconds(TEN_MINUTE)));
        }
        return accessToken;
    }
}
