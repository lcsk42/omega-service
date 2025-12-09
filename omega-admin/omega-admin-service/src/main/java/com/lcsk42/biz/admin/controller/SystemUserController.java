package com.lcsk42.biz.admin.controller;

import com.lcsk42.biz.admin.model.convert.SystemUserConverter;
import com.lcsk42.biz.admin.model.vo.SystemUserVO;
import com.lcsk42.biz.admin.service.SystemUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(description = "用户管理", name = "用户管理")
public class SystemUserController {

    private final SystemUserService systemUserService;

    @GetMapping("/{usernameOrMailOrPhone}")
    @Operation(summary = "查询用户信息", description = "通过用户名/邮箱/手机号")
    public SystemUserVO getByUsernameOrMailOrPhone(@PathVariable String usernameOrMailOrPhone) {
        return systemUserService.getByUsernameOrMailOrPhone(usernameOrMailOrPhone)
                .map(SystemUserConverter.INSTANCE::toT)
                .orElseGet(SystemUserVO::new);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "查询用户信息", description = "通过用户 ID")
    public SystemUserVO get(@PathVariable Long id) {
        return systemUserService.getOptById(id)
                .map(SystemUserConverter.INSTANCE::toT)
                .orElseGet(SystemUserVO::new);
    }
}
