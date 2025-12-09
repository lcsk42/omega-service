package com.lcsk42.biz.admin.model;

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
@TableName("system_department")
public class SystemDepartmentPO {
    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "父部门id")
    private Long parentId;

    @Schema(description = "祖级列表")
    private String ancestors;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "简称")
    private String abbreviation;

    @Schema(description = "编码")
    private String code;

    @Schema(description = "层级")
    private Integer level;

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
