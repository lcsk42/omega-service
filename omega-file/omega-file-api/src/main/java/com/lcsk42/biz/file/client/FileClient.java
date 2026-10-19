package com.lcsk42.biz.file.client;

import com.lcsk42.biz.file.client.fallback.FileClientFallbackFactory;
import com.lcsk42.biz.file.common.constant.FileConstant;
import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.po.FilePO;
import com.lcsk42.biz.file.model.vo.FileVO;
import feign.Response;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.time.Duration;
import java.util.List;

@FeignClient(name = FileConstant.SERVICE_NAME,
        path = "/file",
        contextId = "FileClient",
        fallbackFactory = FileClientFallbackFactory.class)
public interface FileClient {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "上传文件", description = "管理员上传文件的端点")
    FileVO upload(
            @RequestPart("file") MultipartFile file,
            @RequestParam(name = "bizSource", required = false) BizSourceEnum bizSource,
            @RequestParam(name = "publicRead", required = false) Boolean publicRead,
            @RequestParam(name = "batchId", required = false) String batchId,
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name
    );

    @GetMapping("/download/{id}")
    @Operation(summary = "下载文件", description = "管理员下载文件的端点")
    Response download(@PathVariable("id") Long id);

    @GetMapping("/pre-signed-download-url/{id}")
    @Operation(summary = "生成预签名下载URL", description = "生成用于下载文件的预签名URL")
    URL generatePreSignedDownloadUrl(@PathVariable("id") Long id, @RequestParam(required = false, defaultValue = "PT24H") Duration signatureDuration);

    @GetMapping("/info/{id}")
    @Operation(summary = "根据文件 id 查询上传的文件信息", description = "查询文件 id 对应的文件信息")
    FileVO getById(@PathVariable("id") Long id);

    @GetMapping("/info/batch/{batchId}")
    @Operation(summary = "根据批次 id 查询上传的文件信息", description = "查询批从下所有上传的文件")
    List<FileVO> listByBatchId(@PathVariable("batchId") String batchId);

    @DeleteMapping("/{id}")
    @Operation(summary = "根据文件 id 删除上传的文件", description = "删除文件 id 对应的文件信息")
    Boolean deleteById(@PathVariable("id") Long id);

    @DeleteMapping("/batch/{batchId}")
    @Operation(summary = "根据批次 id 删除上传的文件信息", description = "删除批从下所有上传的文件")
    Boolean deleteByBatchId(@PathVariable("batchId") String batchId);

    @PostMapping("/pre-signed-upload-url")
    @Operation(summary = "生成预签名上传URL", description = "生成用于上传文件的预签名URL")
    URL generatePreSignedUploadUrl(
            @RequestParam(name = "bizSource", required = false) BizSourceEnum bizSource,
            @RequestParam(name = "publicRead", required = false) Boolean publicRead,
            @RequestParam(name = "batchId", required = false) String batchId,
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(required = false, defaultValue = "PT15M") Duration signatureDuration
    );

    @PutMapping("/file-metadata")
    @Operation(summary = "更新文件元数据", description = "更新现有文件的元数据")
    FilePO updateFileMetadata(@RequestBody FileMetadataDTO fileMetadataDTO);
}
