package com.lcsk42.biz.authorization.config;

import com.lcsk42.biz.authorization.common.constant.AuthorizationConstant;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(AuthorizationConstant.PACKAGE)
@ComponentScan(AuthorizationConstant.PACKAGE)
public class AuthorizationConfiguration {
}
