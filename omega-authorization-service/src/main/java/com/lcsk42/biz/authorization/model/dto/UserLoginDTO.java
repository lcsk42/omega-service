package com.lcsk42.biz.authorization.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "用户 Login 参数")
public class UserLoginDTO {
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String usernameOrMailOrPhone;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;
}
