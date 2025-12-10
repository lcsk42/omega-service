package com.lcsk42.biz.gateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;

import java.util.Map;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public CommandLineRunner logExceptionHandlers(ApplicationContext ctx) {
        return args -> {
            Map<String, ErrorWebExceptionHandler> handlers = ctx.getBeansOfType(ErrorWebExceptionHandler.class);
            handlers.forEach((name, handler) -> {
                System.out.println("Handler: " + name + ", Order: " +
                        AnnotationUtils.findAnnotation(handler.getClass(), Order.class));
            });
        };
    }
}
