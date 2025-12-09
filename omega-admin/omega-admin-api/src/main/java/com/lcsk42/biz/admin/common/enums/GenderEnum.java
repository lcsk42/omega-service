package com.lcsk42.biz.admin.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum implements BaseEnum<String> {

    MALE("M", "男"),
    FEMALE("F", "女"),
    OTHER("O", "其他"),
    UNKNOWN("U", "未知"),

    ;

    private final String value;

    private final String description;

}
