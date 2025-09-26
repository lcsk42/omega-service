package com.lcsk42.biz.admin.model.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.lcsk42.frameworks.starter.database.mybatisplus.model.po.BasePO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@TableName("admin_info")
public class AdminInfoPO extends BasePO {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "是否启用")
    private Boolean enabled;

    @Schema(description = "角色列表")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> roles;
}
