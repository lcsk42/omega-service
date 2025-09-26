package com.lcsk42.biz.admin.model.convert;

import com.lcsk42.biz.admin.model.po.AdminFilePO;
import com.lcsk42.biz.admin.model.vo.AdminFileVO;
import com.lcsk42.frameworks.starter.common.convert.BiConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminFileConverter extends BiConverter<AdminFilePO, AdminFileVO> {
    AdminFileConverter INSTANCE = Mappers.getMapper(AdminFileConverter.class);
}
