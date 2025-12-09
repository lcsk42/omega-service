package com.lcsk42.biz.admin.config;

import com.lcsk42.biz.admin.common.constant.AdminConstant;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(AdminConstant.PACKAGE)
@ComponentScan(AdminConstant.PACKAGE)
public class AdminConfiguration {
}
