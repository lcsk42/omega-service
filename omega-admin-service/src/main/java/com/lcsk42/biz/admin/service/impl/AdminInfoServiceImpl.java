package com.lcsk42.biz.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcsk42.biz.admin.mapper.AdminInfoMapper;
import com.lcsk42.biz.admin.model.convert.AdminInfoConverter;
import com.lcsk42.biz.admin.model.dto.AdminInfoDTO;
import com.lcsk42.biz.admin.model.dto.AdminInfoPageDTO;
import com.lcsk42.biz.admin.model.po.AdminInfoPO;
import com.lcsk42.biz.admin.model.vo.AdminInfoVO;
import com.lcsk42.biz.admin.service.AdminInfoService;
import com.lcsk42.frameworks.starter.database.core.model.response.BasePageResponse;
import com.lcsk42.frameworks.starter.database.mybatisplus.model.page.PageResponse;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfoPO>
        implements AdminInfoService {
    @Override
    public AdminInfoVO upsert(AdminInfoDTO adminInfoDTO) {
        Long id = adminInfoDTO.getId();

        AdminInfoPO adminInfoPO = AdminInfoConverter.INSTANCE.toP(adminInfoDTO);

        if (Objects.isNull(id)) {
            save(adminInfoPO);
        } else {
            updateById(adminInfoPO);
        }

        return AdminInfoConverter.INSTANCE.toV(adminInfoPO);
    }

    @Override
    public BasePageResponse<AdminInfoVO> page(AdminInfoPageDTO adminInfoPageDTO) {
        IPage<AdminInfoPO> page = lambdaQuery()
                .like(StringUtils.isNoneBlank(adminInfoPageDTO.getUsername()),
                        AdminInfoPO::getUsername, adminInfoPageDTO.getUsername())
                .page(new Page<>(adminInfoPageDTO.getCurrent(), adminInfoPageDTO.getSize()));
        return PageResponse.of(page, AdminInfoConverter.INSTANCE::toV);
    }
}
