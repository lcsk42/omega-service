package com.lcsk42.biz.admin.model.dto;

import com.lcsk42.frameworks.starter.convention.model.query.PageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@NoArgsConstructor
@FieldNameConstants
public class SystemMenuDTO extends PageQuery {

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "路由地址")
    private String path;

    @Schema(description = "是否显示：1显示 0隐藏")
    private Boolean visible;

    @Schema(description = "是否外链：1否 0是")
    private Boolean frame;

    @Schema(description = "是否缓存：1缓存 0不缓存")
    private Boolean cache;
}
