package com.lcsk42.biz.admin.service;

import com.lcsk42.biz.admin.model.SystemUserPO;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.IService;

import java.util.Optional;

public interface SystemUserService extends IService<SystemUserPO> {
    Optional<SystemUserPO> getByUsernameOrMailOrPhone(String usernameOrMailOrPhone);
}
