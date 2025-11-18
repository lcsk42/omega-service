package com.lcsk42.biz.admin.model.vo;

import com.lcsk42.frameworks.starter.security.mask.annotation.JsonMask;
import com.lcsk42.frameworks.starter.security.mask.enums.MaskType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaskInfoVO {

    @JsonMask(left = 1, right = 3, character = '_')
    private String customString = "custom_string_xxx_mask";

    @JsonMask(MaskType.MOBILE_PHONE)
    private String mobilePhone = "18800000001";

    @JsonMask(MaskType.EMAIL)
    private String email = "lcsk42@163.com";

    @JsonMask(MaskType.CAR_LICENSE)
    private String carLicense = "豫AD20151";

    @JsonMask(MaskType.CHINESE_NAME)
    private String chineseName = "张建军";

    @JsonMask(MaskType.PASSWORD)
    private String password = "random-password";

    @JsonMask(MaskType.BANK_CARD)
    private String bankCard1 = "1234 2222 3333 4444 6789 9";

    @JsonMask(MaskType.BANK_CARD)
    private String bankCard2 = "1234 2222 3333 4444 6789 91";

    @JsonMask(MaskType.BANK_CARD)
    private String bankCard3 = "1234 2222 3333 4444 678";

    @JsonMask(MaskType.BANK_CARD)
    private String bankCard4 = "1234 2222 3333 4444 6789";

    @JsonMask(MaskType.ID_CARD)
    private String idCard = "123456789012345678";
}
