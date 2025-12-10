package com.lcsk42.biz.admin.client;

import com.lcsk42.biz.admin.client.fallback.SystemUserClientImpl;
import com.lcsk42.biz.admin.common.constant.AdminConstant;
import com.lcsk42.biz.admin.model.vo.SystemUserVO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = AdminConstant.SERVICE_NAME,
        path = "/user",
        fallback = SystemUserClientImpl.class)
public interface SystemUserClient {

    @GetMapping("/{usernameOrEmailOrMobile}")
    @Operation(summary = "查询用户信息", description = "通过用户名/邮箱/手机号")
    SystemUserVO getByUsernameOrEmailOrMobile(@PathVariable String usernameOrEmailOrMobile);

    @GetMapping("/id/{id}")
    @Operation(summary = "查询用户信息", description = "通过用户 ID")
    SystemUserVO get(@PathVariable Long id);
}
