package com.lcsk42.biz.admin.model.dto;

import com.lcsk42.frameworks.starter.web.annotation.EnumValue;
import com.lcsk42.frameworks.starter.web.annotation.JsonString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class ValidationDTO {

    @EnumValue(enumValues = {"F", "M"})
    String gender;

    @Length(min = 10)
    @JsonString
    String json;
}
