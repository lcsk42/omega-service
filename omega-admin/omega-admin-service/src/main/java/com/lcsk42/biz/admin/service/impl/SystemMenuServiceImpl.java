package com.lcsk42.biz.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcsk42.biz.admin.mapper.SystemMenuMapper;
import com.lcsk42.biz.admin.model.dto.SystemMenuDTO;
import com.lcsk42.biz.admin.model.po.SystemMenuPO;
import com.lcsk42.biz.admin.service.SystemMenuService;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenuPO>
        implements SystemMenuService {
    @Override
    public Page<SystemMenuPO> page(SystemMenuDTO systemMenuDTO) {
        return lambdaQuery()
                .like(StringUtils.isNotBlank(systemMenuDTO.getMenuName()),
                        SystemMenuPO::getMenuName, systemMenuDTO.getMenuName())
                .like(StringUtils.isNotBlank(systemMenuDTO.getPath()), SystemMenuPO::getPath,
                        systemMenuDTO.getPath())
                .eq(Objects.nonNull(systemMenuDTO.getVisible()), SystemMenuPO::getVisible,
                        systemMenuDTO.getVisible())
                .eq(Objects.nonNull(systemMenuDTO.getFrame()), SystemMenuPO::getFrame,
                        systemMenuDTO.getFrame())
                .eq(Objects.nonNull(systemMenuDTO.getCache()), SystemMenuPO::getCache,
                        systemMenuDTO.getCache())
                .page(Page.of(systemMenuDTO.getCurrent(), systemMenuDTO.getSize()));
    }
}
