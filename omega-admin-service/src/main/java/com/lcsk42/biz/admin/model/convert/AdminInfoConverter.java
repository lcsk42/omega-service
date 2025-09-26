package com.lcsk42.biz.admin.model.convert;

import com.lcsk42.biz.admin.model.dto.AdminInfoDTO;
import com.lcsk42.biz.admin.model.po.AdminInfoPO;
import com.lcsk42.biz.admin.model.vo.AdminInfoVO;
import com.lcsk42.frameworks.starter.common.convert.TriConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminInfoConverter extends TriConverter<AdminInfoPO, AdminInfoDTO, AdminInfoVO> {
    AdminInfoConverter INSTANCE = Mappers.getMapper(AdminInfoConverter.class);
}
