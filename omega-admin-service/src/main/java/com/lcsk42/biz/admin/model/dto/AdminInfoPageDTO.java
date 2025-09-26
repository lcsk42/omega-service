package com.lcsk42.biz.admin.model.dto;

import com.lcsk42.frameworks.starter.database.core.model.query.PageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminInfoPageDTO extends PageQuery {
    @Schema(description = "用户名")
    private String username;
}
