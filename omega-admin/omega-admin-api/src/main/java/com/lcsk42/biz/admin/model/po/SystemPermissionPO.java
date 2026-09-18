package com.lcsk42.biz.admin.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcsk42.biz.admin.common.enums.PermissionTypeEnum;
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
@TableName("system_permission")
public class SystemPermissionPO {
    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "权限标识")
    private String permissionCode;

    @Schema(description = "权限名称")
    private String permissionMame;

    @Schema(description = "类型")
    private PermissionTypeEnum permissionType;

    @Schema(description = "关联菜单ID")
    private Long menuId;

    @Schema(description = "HTTP方法")
    private String httpMethod;

    @Schema(description = "接口路径")
    private String apiPath;

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
