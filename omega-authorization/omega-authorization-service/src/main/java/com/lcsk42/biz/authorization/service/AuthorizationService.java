package com.lcsk42.biz.authorization.service;

import com.lcsk42.biz.authorization.model.dto.UserLoginDTO;
import com.lcsk42.biz.authorization.model.vo.TokenVO;

public interface AuthorizationService {
    TokenVO createToken(UserLoginDTO userLoginDTO);

    Boolean logout();

    String refreshToken();
}
