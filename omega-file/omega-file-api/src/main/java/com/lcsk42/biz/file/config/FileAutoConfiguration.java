package com.lcsk42.biz.file.config;

import com.lcsk42.biz.file.common.constant.FileConstant;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(FileConstant.PACKAGE)
@ComponentScan(FileConstant.PACKAGE)
public class FileAutoConfiguration {
}
