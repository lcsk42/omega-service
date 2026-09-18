package com.lcsk42.biz.admin.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PermissionTypeEnum implements BaseEnum<String> {

    MENU("M", "菜单"),
    BUTTON("B", "按钮"),
    INTERFACE("I", "接口"),
    ;

    private final String value;

    private final String description;
}
