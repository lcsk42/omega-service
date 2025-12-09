package com.lcsk42.biz.authorization.controller;

import com.lcsk42.biz.authorization.model.dto.UserLoginDTO;
import com.lcsk42.biz.authorization.model.vo.TokenVO;
import com.lcsk42.biz.authorization.service.AuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization")
@RequiredArgsConstructor
@Tag(description = "权限管理", name = "权限管理")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping("/login")
    @Operation(summary = "登录并创建 Token")
    public TokenVO login(@RequestBody UserLoginDTO userLoginDTO) {
        return authorizationService.createToken(userLoginDTO);
    }

    @PostMapping("/refresh")
    @Operation(summary = "生成新的 Token")
    public String refreshToken() {
        return authorizationService.refreshToken();
    }

    @PostMapping("/logout")
    @Operation(summary = "退出")
    public Boolean logout() {
        return authorizationService.logout();
    }
}
