package com.lcsk42.biz.authorization.service.impl;

import com.lcsk42.biz.authorization.model.dto.UserLoginDTO;
import com.lcsk42.biz.authorization.service.AuthorizationService;
import com.lcsk42.frameworks.starter.common.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final String secret = "omega-authorization-jwt-secret-random";


    @Override
    public String createToken(UserLoginDTO userLoginDTO) {
        return JwtUtil.generateToken(
                Map.of("username", userLoginDTO), secret);
    }
}
