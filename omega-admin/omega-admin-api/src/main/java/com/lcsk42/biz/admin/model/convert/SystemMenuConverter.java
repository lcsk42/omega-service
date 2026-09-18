package com.lcsk42.biz.admin.model.convert;

import com.lcsk42.biz.admin.model.po.SystemMenuPO;
import com.lcsk42.biz.admin.model.vo.SystemMenuVO;
import com.lcsk42.frameworks.starter.common.convert.BiConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemMenuConverter extends BiConverter<SystemMenuPO, SystemMenuVO> {
    SystemMenuConverter INSTANCE = Mappers.getMapper(SystemMenuConverter.class);
}
