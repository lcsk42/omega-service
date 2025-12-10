package com.lcsk42.biz.cs.model.convert;

import com.lcsk42.biz.cs.model.ChatRecordPO;
import com.lcsk42.biz.cs.model.dto.ChatRecordDTO;
import com.lcsk42.biz.cs.model.vo.ChatRecordVO;
import com.lcsk42.frameworks.starter.common.convert.TriConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatRecordConverter extends TriConverter<ChatRecordPO, ChatRecordDTO, ChatRecordVO> {
    ChatRecordConverter INSTANCE = Mappers.getMapper(ChatRecordConverter.class);
}
