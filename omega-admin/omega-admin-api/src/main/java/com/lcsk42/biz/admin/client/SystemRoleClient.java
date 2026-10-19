package com.lcsk42.biz.admin.client;

import com.lcsk42.biz.admin.client.fallback.SystemRoleClientFallbackFactory;
import com.lcsk42.biz.admin.common.constant.AdminConstant;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = AdminConstant.SERVICE_NAME,
        path = "/role",
        contextId = "SystemRoleClient",
        fallbackFactory = SystemRoleClientFallbackFactory.class)
public interface SystemRoleClient {

}
