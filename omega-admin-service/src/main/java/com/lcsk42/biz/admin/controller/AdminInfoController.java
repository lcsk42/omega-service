package com.lcsk42.biz.admin.controller;

import com.lcsk42.biz.admin.model.convert.AdminInfoConverter;
import com.lcsk42.biz.admin.model.dto.AdminInfoDTO;
import com.lcsk42.biz.admin.model.dto.AdminInfoPageDTO;
import com.lcsk42.biz.admin.model.po.AdminInfoPO;
import com.lcsk42.biz.admin.model.vo.AdminInfoVO;
import com.lcsk42.biz.admin.service.AdminInfoService;
import com.lcsk42.frameworks.starter.convention.errorcode.SqlErrorCode;
import com.lcsk42.frameworks.starter.database.core.model.response.BasePageResponse;
import com.lcsk42.frameworks.starter.log.core.annotation.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/admin-info")
@RequiredArgsConstructor
@Tag(description = "Admin Information Management", name = "AdminInfoController")
public class AdminInfoController {

    private final AdminInfoService adminInfoService;

    @GetMapping
    @Operation(summary = "Get Admin Info by ID",
            description = "Fetches admin information based on the provided ID")
    public AdminInfoVO get(@RequestParam("id") Long id) {
        return Optional.ofNullable(adminInfoService.getById(id))
                .map(AdminInfoConverter.INSTANCE::toV)
                .orElseThrow(SqlErrorCode.RECORD_NOT_FOUND_EXCEPTION::toException);
    }

    @PostMapping("/page")
    @Operation(summary = "Get Admin Info Page",
            description = "Fetches a paginated list of admin information based on the provided criteria")
    public BasePageResponse<AdminInfoVO> page(
            @ModelAttribute @ParameterObject AdminInfoPageDTO adminInfoPageDTO) {
        return adminInfoService.page(adminInfoPageDTO);
    }

    @Log
    @PostMapping
    @Operation(summary = "Save Admin Info",
            description = "Saves new admin information or updates existing information")
    public AdminInfoVO save(@RequestBody AdminInfoDTO adminInfoDTO) {
        AdminInfoPO adminInfoPO = AdminInfoConverter.INSTANCE.toP(adminInfoDTO);
        adminInfoService.save(adminInfoPO);
        return AdminInfoConverter.INSTANCE.toV(adminInfoPO);
    }

    @Log
    @PutMapping
    @Operation(summary = "Update Admin Info",
            description = "Updates existing admin information based on the provided DTO")
    public AdminInfoVO update(@RequestBody AdminInfoDTO adminInfoDTO) {
        AdminInfoPO adminInfoPO = AdminInfoConverter.INSTANCE.toP(adminInfoDTO);
        adminInfoService.updateById(adminInfoPO);
        return AdminInfoConverter.INSTANCE.toV(adminInfoPO);
    }

    @Log
    @DeleteMapping
    @Operation(summary = "Delete Admin Info by ID",
            description = "Deletes admin information based on the provided ID")
    public boolean deleteById(@RequestParam("id") Long id) {
        return adminInfoService.removeById(id);
    }
}
