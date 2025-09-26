package com.lcsk42.biz.admin.service;


import com.lcsk42.biz.admin.model.dto.AdminInfoDTO;
import com.lcsk42.biz.admin.model.dto.AdminInfoPageDTO;
import com.lcsk42.biz.admin.model.po.AdminInfoPO;
import com.lcsk42.biz.admin.model.vo.AdminInfoVO;
import com.lcsk42.frameworks.starter.database.core.model.response.BasePageResponse;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.IService;
import jakarta.validation.Valid;

public interface AdminInfoService extends IService<AdminInfoPO> {
    AdminInfoVO upsert(@Valid AdminInfoDTO adminInfoDTO);

    /**
     * 分页查询列表
     *
     * @return 分页列表信息
     */
    BasePageResponse<AdminInfoVO> page(AdminInfoPageDTO adminInfoPageDTO);
}
