package com.lcsk42.biz.admin.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataScopeEnum implements BaseEnum<String> {

    ALL("ALL", "全部"),
    CUSTOM("CUSTOM", "自定义"),
    ORG("ORG", "本组织"),
    ORG_SUB("ORG_SUB", "本组织及下级"),
    SELF("SELF", "仅本人"),
    ;

    private final String value;

    private final String description;
}
