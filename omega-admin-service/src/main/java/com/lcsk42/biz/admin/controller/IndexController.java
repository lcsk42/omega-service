package com.lcsk42.biz.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "IndexController")
public class IndexController {

    @GetMapping("/")
    @Operation(summary = "Index")
    public String index() {
        return "ok";
    }

    @GetMapping("/ping")
    @Operation(summary = "Ping")
    public String ping() {
        return "pong";
    }
}
