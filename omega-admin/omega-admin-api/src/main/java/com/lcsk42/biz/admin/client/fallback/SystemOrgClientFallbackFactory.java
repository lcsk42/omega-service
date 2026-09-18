package com.lcsk42.biz.admin.client.fallback;

import com.lcsk42.biz.admin.client.SystemOrgClient;
import org.springframework.cloud.openfeign.FallbackFactory;

public class SystemOrgClientFallbackFactory implements FallbackFactory<SystemOrgClient> {

    @Override
    public SystemOrgClient create(Throwable cause) {
        return null;
    }
}
