package com.lcsk42.biz.admin.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AdminInfoVO {

    private Long id;

    private String username;

    private Boolean enabled;

    private List<String> roles;
}
