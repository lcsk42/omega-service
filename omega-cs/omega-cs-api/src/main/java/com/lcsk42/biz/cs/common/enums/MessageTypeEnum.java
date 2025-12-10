package com.lcsk42.biz.cs.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageTypeEnum implements BaseEnum<Integer> {
    TEXT(1, "文本消息"),
    IMAGE(2, "图片消息"),
    FILE(3, "文件消息"),
    NOTIFICATION(4, "系统通知"),
    ;
    private final Integer value;

    private final String description;
}
