package com.lcsk42.biz.cs.service.impl;

import com.lcsk42.biz.cs.common.constant.CsRedisKeyConstant;
import com.lcsk42.biz.cs.mapper.ChatConfigMapper;
import com.lcsk42.biz.cs.model.ChatConfigPO;
import com.lcsk42.biz.cs.service.ChatConfigService;
import com.lcsk42.frameworks.starter.cache.core.Cache;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatConfigServiceImpl
        extends ServiceImpl<ChatConfigMapper, ChatConfigPO>
        implements ChatConfigService {

    private final Cache cache;

    @Override
    public ChatConfigPO getOrCreate() {
        String cacheKey = CsRedisKeyConstant.ChatConfig.getCacheKey(0L);
        if (cache.exists(cacheKey)) {
            return cache.get(cacheKey, ChatConfigPO.class);
        }
        ChatConfigPO configPO = lambdaQuery().oneOpt()
                .orElseGet(() -> {
                    ChatConfigPO chatConfigPO = new ChatConfigPO();
                    chatConfigPO.setId(0L);
                    save(chatConfigPO);
                    return chatConfigPO;
                });
        cache.put(cacheKey, configPO);
        return configPO;
    }
}
