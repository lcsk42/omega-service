package com.lcsk42.biz.file.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.frameworks.starter.database.mybatisplus.model.po.BasePO;
import com.lcsk42.frameworks.starter.file.core.enums.FileUploadType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("admin_file")
public class FilePO extends BasePO {
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
    private BizSourceEnum bizSource;

    @Schema(description = "是否公开读")
    @TableField(value = "is_public_read")
    private Boolean publicRead;

    @Schema(description = "批次 Id")
    private String batchId;
}
