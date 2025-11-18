package com.lcsk42.biz.admin.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class XssDTO {

    private String normalValue;

    private String xssValue;
}
