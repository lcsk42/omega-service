package com.lcsk42.biz.cs.service;

import com.lcsk42.biz.cs.model.ChatConfigPO;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.IService;

public interface ChatConfigService extends IService<ChatConfigPO> {
    ChatConfigPO getOrCreate();
}
