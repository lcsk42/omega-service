package com.lcsk42.biz.admin.client.fallback;

import com.lcsk42.biz.admin.client.SystemPermissionClient;
import org.springframework.cloud.openfeign.FallbackFactory;

public class SystemPermissionClientFallbackFactory implements FallbackFactory<SystemPermissionClient> {

    @Override
    public SystemPermissionClient create(Throwable cause) {
        return null;
    }
}
