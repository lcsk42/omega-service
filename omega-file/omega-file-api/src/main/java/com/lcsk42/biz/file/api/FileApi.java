package com.lcsk42.biz.file.api;

import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.vo.FileVO;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

public interface FileApi {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FileVO upload(@RequestParam("file")
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
            @Parameter(description = "文件的自定义名称（如未提供则使用原始文件名）") String name);

    @GetMapping("/download")
    void download(@RequestParam("id") Long id, HttpServletResponse response);

    @GetMapping("/pre-signed-download-url")
    URL generatePreSignedDownloadUrl(@RequestParam("id") Long id);

    @PostMapping("/pre-signed-upload-url")
    URL generatePreSignedUploadUrl(
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
            @Parameter(description = "文件的自定义名称（如未提供则使用默认文件名）") String name);


    @PutMapping("/file-metadata")
    void updateFileMetadata(@RequestBody FileMetadataDTO fileMetadataDTO);

    @PutMapping("/mock-upload")
    FileVO mockUpload();
}
