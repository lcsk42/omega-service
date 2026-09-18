package com.lcsk42.biz.admin.service.impl;

import com.lcsk42.biz.admin.mapper.SystemRoleMapper;
import com.lcsk42.biz.admin.model.po.SystemRolePO;
import com.lcsk42.biz.admin.service.SystemRoleService;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRolePO>
        implements SystemRoleService {
}
