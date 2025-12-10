package com.lcsk42.biz.admin.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcsk42.biz.admin.common.enums.GenderEnum;
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
@TableName("system_user")
public class SystemUserPO {

    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "部门ID")
    private Long departmentId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "用户性别 M=男, F=女, O=其他, U=未知")
    private GenderEnum gender;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "密码盐值")
    private String salt;

    @TableField("is_internal")
    @Schema(description = "是否系统内置用户")
    private Boolean internal;

    @TableField("is_disabled")
    @Schema(description = "是否禁用")
    private Boolean disabled;

    @Schema(description = "密码最后更新时间")
    private LocalDateTime lastPasswordUpdateTime;

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
