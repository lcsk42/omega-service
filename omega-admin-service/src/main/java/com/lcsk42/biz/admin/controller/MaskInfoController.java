package com.lcsk42.biz.admin.controller;

import com.lcsk42.biz.admin.model.vo.MaskInfoVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mask")
@Tag(name = "MaskInfoController")
public class MaskInfoController {

    @GetMapping
    public MaskInfoVO mask() {
        return new MaskInfoVO();
    }
}
