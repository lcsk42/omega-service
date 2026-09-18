package com.lcsk42.biz.admin.service.impl;

import com.lcsk42.biz.admin.mapper.SystemOrgMapper;
import com.lcsk42.biz.admin.model.po.SystemOrgPO;
import com.lcsk42.biz.admin.service.SystemOrgService;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SystemOrgServiceImpl extends ServiceImpl<SystemOrgMapper, SystemOrgPO>
        implements SystemOrgService {
}
