package com.lcsk42.biz.admin.controller;

import com.lcsk42.biz.admin.model.dto.XssDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xss")
@Tag(name = "XssController")
public class XssController {

    @GetMapping("/get/{pathVariable}")
    public Pair<String, String> get(@PathVariable String pathVariable, @RequestParam String requestParam) {
        return Pair.of(pathVariable, requestParam);
    }

    @PostMapping("/post")
    public XssDTO post(@RequestBody XssDTO xssDTO) {
        return xssDTO;
    }
}
