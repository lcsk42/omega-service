package com.lcsk42.biz.cs.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum implements BaseEnum<Integer> {
    VISITOR(1, "游客"),
    CUSTOMER_SERVICE(2, "客服"),
    BOT(3, "机器人"),
    ;

    private final Integer value;

    private final String description;
}
