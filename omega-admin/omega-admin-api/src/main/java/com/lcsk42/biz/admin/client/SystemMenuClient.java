package com.lcsk42.biz.admin.client;

import com.lcsk42.biz.admin.client.fallback.SystemMenuClientFallbackFactory;
import com.lcsk42.biz.admin.common.constant.AdminConstant;
import com.lcsk42.biz.admin.model.dto.SystemMenuDTO;
import com.lcsk42.biz.admin.model.vo.SystemMenuVO;
import com.lcsk42.frameworks.starter.convention.model.response.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = AdminConstant.SERVICE_NAME + "-menu",
        path = "/menu",
        fallbackFactory = SystemMenuClientFallbackFactory.class)
public interface SystemMenuClient {

    @GetMapping("/page")
    @Operation(summary = "查询菜单信息", description = "根据条件查询菜单列表")
    PageResult<SystemMenuVO> page(SystemMenuDTO SystemMenuDTO);
}
