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
@TableName("system_menu")
public class SystemMenuPO {
    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "父菜单ID")
    private Long parentId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "路由地址")
    private String path;

    @TableField(value = "is_visible")
    @Schema(description = "是否显示：1显示 0隐藏")
    private Boolean visible;

    @TableField(value = "is_frame")
    @Schema(description = "是否外链：1否 0是")
    private Boolean frame;

    @TableField(value = "is_cache")
    @Schema(description = "是否缓存：1缓存 0不缓存")
    private Boolean cache;

    @Schema(description = "备注")
    private String remark;

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
