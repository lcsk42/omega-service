package com.lcsk42.biz.cs.common.constant;

import com.lcsk42.frameworks.starter.core.util.CacheUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CsRedisKeyConstant {
    private static final String ROOT_PREFIX = "cs";

    public static class ChatConfig {
        private static final String PREFIX = CacheUtil.buildKey(ROOT_PREFIX, "chat-config");

        public static String getCacheKey(Long id) {
            return CacheUtil.buildKey(PREFIX, id.toString());
        }
    }
}
