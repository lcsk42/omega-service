package com.lcsk42.biz.cs.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConnectRuleEnum implements BaseEnum<Integer> {

    HUMAN_PRIORITY(1, "优先接入人工，人工客服都不在线时转 AI 客服"),
    HUMAN_EXCLUSIVE(2, "只接入人工，人工客服都不在线时显示留言引导文案，引导客户填写留言表单"),
    AI_PRIORITY(2, "优先接入 AI 客服，访客手动转人工时，再接入人工客服"),

    ;
    private final Integer value;

    private final String description;
}
