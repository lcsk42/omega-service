package com.lcsk42.biz.admin.client.fallback;

import com.lcsk42.biz.admin.client.SystemRoleClient;
import org.springframework.cloud.openfeign.FallbackFactory;

public class SystemRoleClientFallbackFactory implements FallbackFactory<SystemRoleClient> {

    @Override
    public SystemRoleClient create(Throwable cause) {
        return null;
    }
}
