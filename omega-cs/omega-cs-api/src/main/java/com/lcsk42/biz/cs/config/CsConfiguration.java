package com.lcsk42.biz.cs.config;

import com.lcsk42.biz.cs.common.constant.CsConstant;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(CsConstant.PACKAGE)
@ComponentScan(CsConstant.PACKAGE)
public class CsConfiguration {
}
