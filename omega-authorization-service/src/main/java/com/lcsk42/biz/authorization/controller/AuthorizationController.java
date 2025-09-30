package com.lcsk42.biz.authorization.controller;

import com.lcsk42.biz.authorization.model.dto.UserLoginDTO;
import com.lcsk42.biz.authorization.service.AuthorizationService;
import com.lcsk42.frameworks.starter.log.core.annotation.Log;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/authorization")
@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping("/login")
    @Operation(summary = "登录并创建 Token")
    @Log
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        return authorizationService.createToken(userLoginDTO);
    }
}
