package com.lcsk42.biz.cs.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcsk42.biz.cs.mapper.ChatRecordMapper;
import com.lcsk42.biz.cs.model.ChatRecordPO;
import com.lcsk42.biz.cs.model.dto.ChatRecordPageDTO;
import com.lcsk42.biz.cs.service.ChatRecordService;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRecordServiceImpl
        extends ServiceImpl<ChatRecordMapper, ChatRecordPO>
        implements ChatRecordService {
    @Override
    public Page<ChatRecordPO> page(ChatRecordPageDTO chatRecordPageDTO) {
        return lambdaQuery()
                .orderByDesc(ChatRecordPO::getCreateTime)
                .page(new Page<>(chatRecordPageDTO.getCurrent(), chatRecordPageDTO.getSize()));
    }
}
