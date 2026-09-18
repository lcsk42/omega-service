package com.lcsk42.biz.admin.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class SystemMenuVO {
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

    @Schema(description = "是否删除")
    private Boolean deleted;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
