package com.lcsk42.biz.admin.controller;


import com.lcsk42.biz.admin.model.dto.ValidationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/validation")
@RestController
@Tag(name = "ValidationController")
public class ValidationController {

    @PostMapping("/validate")
    @Operation(summary = "校验", description = "参数校验")
    public ValidationDTO validate(@Validated @RequestBody ValidationDTO validationDTO) {
        return validationDTO;
    }

}
