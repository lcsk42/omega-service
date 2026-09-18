package com.lcsk42.biz.admin.service.impl;

import com.lcsk42.biz.admin.mapper.SystemPermissionMapper;
import com.lcsk42.biz.admin.model.po.SystemPermissionPO;
import com.lcsk42.biz.admin.service.SystemPermissionService;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SystemPermissionServiceImpl
        extends ServiceImpl<SystemPermissionMapper, SystemPermissionPO>
        implements SystemPermissionService {
}
