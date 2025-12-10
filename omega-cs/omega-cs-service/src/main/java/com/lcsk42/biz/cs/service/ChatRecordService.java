package com.lcsk42.biz.cs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcsk42.biz.cs.model.ChatRecordPO;
import com.lcsk42.biz.cs.model.dto.ChatRecordPageDTO;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.IService;

public interface ChatRecordService extends IService<ChatRecordPO> {
    Page<ChatRecordPO> page(ChatRecordPageDTO chatRecordPageDTO);
}
