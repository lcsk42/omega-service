package com.lcsk42.biz.file.controller;

import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.model.convert.FileConverter;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.po.FilePO;
import com.lcsk42.biz.file.model.vo.FileVO;
import com.lcsk42.biz.file.service.FileService;
import com.lcsk42.frameworks.starter.common.util.IdUtil;
import com.lcsk42.frameworks.starter.log.core.annotation.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
@Tag(description = "文件管理", name = "文件管理")
public class FileController {

    private final FileService fileService;

    @Log
    @Operation(summary = "上传文件", description = "管理员上传文件的端点")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileVO upload(
            @RequestParam("file") @Parameter(description = "要上传的文件", required = true) MultipartFile file,
            @RequestParam(name = "bizSource", required = false) @Parameter(description = "文件的业务来源（例如：DEFAULT, USER_UPLOAD）", example = "default") BizSourceEnum bizSource,
            @RequestParam(name = "publicRead", required = false) @Parameter(description = "文件是否公开可读", example = "false") Boolean publicRead,
            @RequestParam(name = "batchId", required = false) @Parameter(description = "用于分组文件的批次ID（如未提供则自动生成）") String batchId,
            @RequestParam(name = "id", required = false) @Parameter(description = "文件的自定义ID（如未提供则自动生成）") Long id,
            @RequestParam(name = "name", required = false) @Parameter(description = "文件的自定义名称（如未提供则使用原始文件名）") String name) {
        return FileConverter.INSTANCE.toT(
                fileService.upload(
                        file,
                        ObjectUtils.defaultIfNull(bizSource, BizSourceEnum.DEFAULT),
                        ObjectUtils.defaultIfNull(publicRead, Boolean.FALSE),
                        StringUtils.defaultIfBlank(batchId, IdUtil.generateCompactUuid()),
                        ObjectUtils.defaultIfNull(id, IdUtil.getSnowflakeNextId()),
                        StringUtils.defaultIfBlank(name, file.getOriginalFilename())
                )
        );
    }

    @GetMapping("/download/{id}")
    @Operation(summary = "下载文件", description = "管理员下载文件的端点")
    public void download(@PathVariable("id") Long id, HttpServletResponse response) {
        fileService.download(id, response);
    }

    @Log
    @GetMapping("/pre-signed-download-url/{id}")
    @Operation(summary = "生成预签名下载URL", description = "生成用于下载文件的预签名URL")
    public URL generatePreSignedDownloadUrl(@PathVariable("id") Long id) {
        return fileService.generatePreSignedDownloadUrl(id);
    }

    @GetMapping("/info/{id}")
    @Operation(summary = "根据文件 id 查询上传的文件信息", description = "查询文件 id 对应的文件信息")
    public FileVO getById(@PathVariable Long id) {
        return fileService.getById(id)
                .map(FileConverter.INSTANCE::toT)
                .orElseGet(FileVO::new);
    }

    @GetMapping("/info/batch/{batchId}")
    @Operation(summary = "根据批次 id 查询上传的文件信息", description = "查询批从下所有上传的文件")
    public List<FileVO> listByBatchId(@PathVariable String batchId) {
        List<FilePO> filePOS = fileService.listByBatchId(batchId);
        if (CollectionUtils.isEmpty(filePOS)) {
            return Collections.emptyList();
        }
        return FileConverter.INSTANCE.toT(filePOS);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "根据文件 id 删除上传的文件", description = "删除文件 id 对应的文件信息")
    public Boolean deleteById(@PathVariable Long id) {
        return fileService.deleteById(id);
    }

    @DeleteMapping("/batch/{batchId}")
    @Operation(summary = "根据批次 id 删除上传的文件信息", description = "删除批从下所有上传的文件")
    public Boolean deleteByBatchId(@PathVariable String batchId) {
        return fileService.deleteByBatchId(batchId);
    }

    @Log
    @PostMapping("/pre-signed-upload-url")
    @Operation(summary = "生成预签名上传URL", description = "生成用于上传文件的预签名URL")
    public URL generatePreSignedUploadUrl(
            @RequestParam(name = "bizSource", required = false)
            @Parameter(description = "文件的业务来源（例如：DEFAULT, USER_UPLOAD）", example = "default") BizSourceEnum bizSource,
            @RequestParam(name = "publicRead", required = false) @Parameter(description = "文件是否公开可读", example = "false") Boolean publicRead,
            @RequestParam(name = "batchId", required = false) @Parameter(description = "用于分组文件的批次ID（如未提供则自动生成）") String batchId,
            @RequestParam(name = "id", required = false) @Parameter(description = "文件的自定义ID（如未提供则自动生成）") Long id,
            @RequestParam(name = "name", required = false) @Parameter(description = "文件的自定义名称（如未提供则使用默认文件名）") String name
    ) {
        return fileService.generatePreSignedUploadUrl(
                ObjectUtils.defaultIfNull(bizSource, BizSourceEnum.DEFAULT),
                ObjectUtils.defaultIfNull(publicRead, Boolean.FALSE), StringUtils.defaultIfBlank(batchId, IdUtil.generateCompactUuid()),
                ObjectUtils.defaultIfNull(id, IdUtil.getSnowflakeNextId()),
                StringUtils.defaultIfBlank(name, "unnamed_file.unknown")
        );
    }

    @Log
    @PutMapping("/file-metadata")
    @Operation(summary = "更新文件元数据", description = "更新现有文件的元数据")
    public FilePO updateFileMetadata(@RequestBody FileMetadataDTO fileMetadataDTO) {
        return fileService.updateFileMetadata(fileMetadataDTO);
    }
}
