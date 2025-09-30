package com.lcsk42.biz.admin.controller;

import com.lcsk42.frameworks.starter.common.util.ThreadUtil;
import com.lcsk42.frameworks.starter.core.constant.HttpHeaderConstant;
import com.lcsk42.frameworks.starter.idempotent.annotation.Idempotent;
import com.lcsk42.frameworks.starter.idempotent.enums.IdempotentTypeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Tag(name = "IndexController")
public class IndexController {
    @GetMapping("/ping")
    @Operation(summary = "Ping")
    public String ping() {
        return "pong";
    }

    @Idempotent(type = IdempotentTypeEnum.SPEL, key = "#timeout")
    @GetMapping("/sleep/seconds/{timeout}")
    @Parameter(
            name = HttpHeaderConstant.IDEMPOTENT_TOKEN,
            description = "幂等校验的请求头",
            required = false,
            in = ParameterIn.HEADER
    )
    @Operation(summary = "休眠{timeout}秒", description = "多长时间之后返结果")
    public void sleep(@PathVariable Long timeout) {
        ThreadUtil.sleep(timeout, TimeUnit.SECONDS);
    }
}
