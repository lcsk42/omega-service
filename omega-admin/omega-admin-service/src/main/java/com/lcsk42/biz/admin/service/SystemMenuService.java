package com.lcsk42.biz.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcsk42.biz.admin.model.dto.SystemMenuDTO;
import com.lcsk42.biz.admin.model.po.SystemMenuPO;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.IService;

public interface SystemMenuService extends IService<SystemMenuPO> {

    Page<SystemMenuPO> page(SystemMenuDTO systemMenuDTO);
}
