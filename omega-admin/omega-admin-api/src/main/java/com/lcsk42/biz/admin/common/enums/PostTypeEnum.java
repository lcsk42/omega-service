package com.lcsk42.biz.admin.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostTypeEnum implements BaseEnum<String> {
    MANAGER("M", "管理类"),
    FUNCTIONAL("F", "职能类"),
    TECHNICAL("T", "技术类"),
    SALES_MARKETING("S", "销售与市场类"),
    PRODUCTION_OPERATIONS("P", "生产与运营类"),
    SERVICE("SV", "服务类"),
    ;

    private final String value;

    private final String description;
}
