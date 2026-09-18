package com.lcsk42.biz.cs.common.constant;

import com.lcsk42.frameworks.starter.core.util.CacheUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CsRedisKeyConstant {
    private static final String ROOT_PREFIX = "cs";


    public static String getChatConfigKey(Long configId) {
        return CacheUtil.buildKey(ROOT_PREFIX, "chat-config", configId.toString());
    }

    public static String getWebsocketSession(String client) {
        return CacheUtil.buildKey(ROOT_PREFIX, "websocket-session", client);
    }

    public static String getWebsocketSessionContent(String client) {
        return CacheUtil.buildKey(ROOT_PREFIX, "websocket-session", "content", client);
    }
}
