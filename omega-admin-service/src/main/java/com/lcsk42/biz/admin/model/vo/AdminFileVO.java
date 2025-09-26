package com.lcsk42.biz.admin.model.vo;

import com.lcsk42.frameworks.starter.file.core.enums.FileUploadType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "文件对象")
public class AdminFileVO {

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "文件名称")
    private String name;

    @Schema(description = "文件大小（字节）")
    private Long size;

    @Schema(description = "文件存储桶")
    private String bucketName;

    @Schema(description = "文件存储路径")
    private String path;

    @Schema(description = "文件类型, 后缀")
    private String fileType;

    @Schema(description = "存储类型")
    private FileUploadType fileUploadType;

    @Schema(description = "业务来源")
    private String bizSource;

    @Schema(description = "是否公开读")
    private Boolean publicRead;

    @Schema(description = "批次 Id")
    private String batchId;
}
