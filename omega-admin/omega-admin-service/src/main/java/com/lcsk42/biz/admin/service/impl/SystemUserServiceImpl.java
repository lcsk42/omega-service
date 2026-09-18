package com.lcsk42.biz.admin.service.impl;

import com.lcsk42.biz.admin.mapper.SystemUserMapper;
import com.lcsk42.biz.admin.model.po.SystemUserPO;
import com.lcsk42.biz.admin.service.SystemUserService;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUserPO>
        implements SystemUserService {
    @Override
    public Optional<SystemUserPO> getByUsernameOrEmailOrMobile(String usernameOrMailOrPhone) {
        return lambdaQuery()
                .eq(StringUtils.isNotBlank(usernameOrMailOrPhone), SystemUserPO::getUsername, usernameOrMailOrPhone)
                .or()
                .eq(StringUtils.isNotBlank(usernameOrMailOrPhone), SystemUserPO::getEmail, usernameOrMailOrPhone)
                .or()
                .eq(StringUtils.isNotBlank(usernameOrMailOrPhone), SystemUserPO::getMobile, usernameOrMailOrPhone)
                .oneOpt();
    }
}
