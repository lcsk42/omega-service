package com.lcsk42.biz.cs.model.convert;

import com.lcsk42.biz.cs.model.ChatConfigPO;
import com.lcsk42.biz.cs.model.dto.ChatConfigDTO;
import com.lcsk42.biz.cs.model.vo.ChatConfigVO;
import com.lcsk42.frameworks.starter.common.convert.TriConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatConfigConverter extends TriConverter<ChatConfigPO, ChatConfigDTO, ChatConfigVO> {
    ChatConfigConverter INSTANCE = Mappers.getMapper(ChatConfigConverter.class);
}
