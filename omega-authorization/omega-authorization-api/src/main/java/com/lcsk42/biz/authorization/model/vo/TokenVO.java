package com.lcsk42.biz.authorization.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TokenVO {
    @Schema(description = "访问 Token（10 M）")
    private String accessToken;

    @Schema(description = "刷新 Token（7 Day）")
    private String refreshToken;
}
