package com.lcsk42.biz.admin.model.convert;

import com.lcsk42.biz.admin.model.SystemUserPO;
import com.lcsk42.biz.admin.model.vo.SystemUserVO;
import com.lcsk42.frameworks.starter.common.convert.BiConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemUserConverter extends BiConverter<SystemUserPO, SystemUserVO> {
    SystemUserConverter INSTANCE = Mappers.getMapper(SystemUserConverter.class);
}
