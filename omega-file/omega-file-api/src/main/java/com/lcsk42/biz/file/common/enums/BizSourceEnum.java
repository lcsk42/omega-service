package com.lcsk42.biz.file.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import com.lcsk42.frameworks.starter.web.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BizSourceEnum implements BaseEnum<String> {

    DEFAULT("default", "default module"),
    ADMIN("admin", "admin module"),
    USER("user", "user module"),
    ;

    @EnumValue
    @JsonValue
    private final String value;

    private final String description;
}
