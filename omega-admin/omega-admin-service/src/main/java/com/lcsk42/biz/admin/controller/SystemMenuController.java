package com.lcsk42.biz.admin.controller;

import com.lcsk42.biz.admin.model.convert.SystemMenuConverter;
import com.lcsk42.biz.admin.model.dto.SystemMenuDTO;
import com.lcsk42.biz.admin.model.vo.SystemMenuVO;
import com.lcsk42.biz.admin.service.SystemMenuService;
import com.lcsk42.frameworks.starter.convention.model.response.PageResult;
import com.lcsk42.frameworks.starter.database.mybatisplus.model.page.PageResults;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Tag(description = "菜单管理", name = "菜单管理")
public class SystemMenuController {

    private final SystemMenuService systemMenuService;

    @GetMapping("/page")
    @Operation(summary = "查询菜单信息", description = "根据条件查询菜单列表")
    public PageResult<SystemMenuVO> page(@ParameterObject SystemMenuDTO SystemMenuDTO) {
        return PageResults.of(systemMenuService.page(SystemMenuDTO), SystemMenuConverter.INSTANCE::toT);
    }
}
