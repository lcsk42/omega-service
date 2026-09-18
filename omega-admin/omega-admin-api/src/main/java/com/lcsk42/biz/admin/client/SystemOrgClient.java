package com.lcsk42.biz.admin.client;

import com.lcsk42.biz.admin.client.fallback.SystemOrgClientFallbackFactory;
import com.lcsk42.biz.admin.common.constant.AdminConstant;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = AdminConstant.SERVICE_NAME + "-org",
        path = "/org",
        fallbackFactory = SystemOrgClientFallbackFactory.class)
public interface SystemOrgClient {

}
