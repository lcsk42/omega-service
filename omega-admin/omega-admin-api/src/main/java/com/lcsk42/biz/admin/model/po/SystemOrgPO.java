package com.lcsk42.biz.admin.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@FieldNameConstants
@TableName("system_org")
public class SystemOrgPO {

    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "编码")
    private String orgCode;

    @Schema(description = "名称")
    private String orgNameEnglish;

    @Schema(description = "名称英文")
    private String orgAbbreviation;

    @Schema(description = "简称英文")
    private String orgLetter_code;

    @Schema(description = "显示顺序")
    private Integer sortOrder;

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
