package com.lcsk42.biz.authorization.service;

import com.lcsk42.biz.authorization.model.dto.UserLoginDTO;

public interface AuthorizationService {
    public String createToken(UserLoginDTO userLoginDTO);
}
