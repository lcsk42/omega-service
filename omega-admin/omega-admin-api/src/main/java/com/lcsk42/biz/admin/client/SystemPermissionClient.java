package com.lcsk42.biz.admin.client;

import com.lcsk42.biz.admin.client.fallback.SystemPermissionClientFallbackFactory;
import com.lcsk42.biz.admin.common.constant.AdminConstant;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = AdminConstant.SERVICE_NAME,
        path = "/permission",
        contextId = "SystemPermissionClient",
        fallbackFactory = SystemPermissionClientFallbackFactory.class)
public interface SystemPermissionClient {

}
