package com.lcsk42.biz.admin.controller;

import com.lcsk42.biz.admin.common.enums.BizSourceEnum;
import com.lcsk42.biz.admin.model.dto.AdminFileMetadataDTO;
import com.lcsk42.biz.admin.model.vo.AdminFileVO;
import com.lcsk42.biz.admin.service.AdminFileService;
import com.lcsk42.frameworks.starter.common.util.IdUtil;
import com.lcsk42.frameworks.starter.log.core.annotation.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@Slf4j
@RestController
@RequestMapping("/admin-file")
@RequiredArgsConstructor
@Tag(description = "管理员文件管理", name = "AdminFileController")
public class AdminFileController {

    private final AdminFileService adminFileService;

    @Log
    @PostMapping("/upload")
    @Operation(summary = "上传文件", description = "管理员上传文件的端点")
    public AdminFileVO uploadFile(@RequestParam("file")
    @Parameter(description = "要上传的文件", required = true) MultipartFile file,
            @RequestParam(name = "bizSource", required = false)
            @Parameter(description = "文件的业务来源（例如：DEFAULT, USER_UPLOAD）",
                    example = "default") BizSourceEnum bizSource,
            @RequestParam(name = "publicRead", required = false)
            @Parameter(description = "文件是否公开可读",
                    example = "false") Boolean publicRead,
            @RequestParam(name = "batchId", required = false)
            @Parameter(description = "用于分组文件的批次ID（如未提供则自动生成）") String batchId,
            @RequestParam(name = "id", required = false)
            @Parameter(description = "文件的自定义ID（如未提供则自动生成）") Long id,
            @RequestParam(name = "name", required = false)
            @Parameter(description = "文件的自定义名称（如未提供则使用原始文件名）") String name) {
        return adminFileService.upload(
                file,
                ObjectUtils.defaultIfNull(bizSource, BizSourceEnum.DEFAULT),
                ObjectUtils.defaultIfNull(publicRead, Boolean.FALSE),
                StringUtils.defaultIfBlank(batchId, IdUtil.generateCompactUuid()),
                ObjectUtils.defaultIfNull(id, IdUtil.getSnowflakeNextId()),
                StringUtils.defaultIfBlank(name, file.getOriginalFilename()));
    }

    @GetMapping("/download")
    @Operation(summary = "下载文件", description = "管理员下载文件的端点")
    public void download(@RequestParam("id") Long id, HttpServletResponse response) {
        adminFileService.download(id, response);
    }

    @GetMapping("/pre-signed-download-url")
    @Operation(summary = "生成预签名下载URL", description = "生成用于下载文件的预签名URL")
    public URL generatePreSignedDownloadUrl(@RequestParam("id") Long id) {
        return adminFileService.generatePreSignedDownloadUrl(id);
    }

    @Log
    @PostMapping("/pre-signed-upload-url")
    @Operation(summary = "生成预签名上传URL", description = "生成用于上传文件的预签名URL")
    public URL generatePreSignedUploadUrl(
            @RequestParam(name = "bizSource", required = false)
            @Parameter(description = "文件的业务来源（例如：DEFAULT, USER_UPLOAD）",
                    example = "default") BizSourceEnum bizSource,
            @RequestParam(name = "publicRead", required = false)
            @Parameter(description = "文件是否公开可读",
                    example = "false") Boolean publicRead,
            @RequestParam(name = "batchId", required = false)
            @Parameter(description = "用于分组文件的批次ID（如未提供则自动生成）") String batchId,
            @RequestParam(name = "id", required = false)
            @Parameter(description = "文件的自定义ID（如未提供则自动生成）") Long id,
            @RequestParam(name = "name", required = false)
            @Parameter(description = "文件的自定义名称（如未提供则使用默认文件名）") String name) {
        return adminFileService.generatePreSignedUploadUrl(
                ObjectUtils.defaultIfNull(bizSource, BizSourceEnum.DEFAULT),
                ObjectUtils.defaultIfNull(publicRead, Boolean.FALSE),
                StringUtils.defaultIfBlank(batchId, IdUtil.generateCompactUuid()),
                ObjectUtils.defaultIfNull(id, IdUtil.getSnowflakeNextId()),
                StringUtils.defaultIfBlank(name, "unnamed_file.unknown"));
    }

    @Log
    @PutMapping("/file-metadata")
    @Operation(summary = "更新文件元数据", description = "更新现有文件的元数据")
    public void updateFileMetadata(@RequestBody AdminFileMetadataDTO fileMetadataDTO) {
        adminFileService.updateFileMetadata(fileMetadataDTO);
    }
}

