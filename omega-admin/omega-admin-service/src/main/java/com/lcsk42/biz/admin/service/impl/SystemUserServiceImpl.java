package com.lcsk42.biz.admin.service.impl;

import com.lcsk42.biz.admin.mapper.SystemUserMapper;
import com.lcsk42.biz.admin.model.SystemUserPO;
import com.lcsk42.biz.admin.service.SystemUserService;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUserPO>
        implements SystemUserService {
    @Override
    public Optional<SystemUserPO> getByUsernameOrMailOrPhone(String usernameOrMailOrPhone) {
        return lambdaQuery()
                .eq(SystemUserPO::getUsername, usernameOrMailOrPhone)
                .or()
                .eq(SystemUserPO::getEmail, usernameOrMailOrPhone)
                .or()
                .eq(SystemUserPO::getPhone, usernameOrMailOrPhone)
                .oneOpt();
    }
}
