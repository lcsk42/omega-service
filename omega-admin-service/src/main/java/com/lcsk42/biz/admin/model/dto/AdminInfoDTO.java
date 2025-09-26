package com.lcsk42.biz.admin.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AdminInfoDTO {
    private Long id;

    private String username;

    private Boolean enabled;

    private List<String> roles;
}
