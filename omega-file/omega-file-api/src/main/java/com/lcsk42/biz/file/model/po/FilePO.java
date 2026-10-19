package com.lcsk42.biz.file.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.frameworks.starter.file.core.enums.FileUploadType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("file_info")
public class FilePO {

    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "文件名称")
    private String fileName;

    @Schema(description = "文件大小（字节）")
    private Long fileSize;

    @Schema(description = "文件存储桶")
    private String bucketName;

    @Schema(description = "文件存储路径")
    private String filePath;

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

    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @Schema(description = "是否删除")
    private Boolean deleted;

    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
