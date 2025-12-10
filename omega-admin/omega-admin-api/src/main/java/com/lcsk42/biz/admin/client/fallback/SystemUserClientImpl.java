package com.lcsk42.biz.admin.client.fallback;

import com.lcsk42.biz.admin.client.SystemUserClient;
import com.lcsk42.biz.admin.model.vo.SystemUserVO;

public class SystemUserClientImpl implements SystemUserClient {
    @Override
    public SystemUserVO getByUsernameOrEmailOrMobile(String usernameOrMailOrPhone) {
        return new SystemUserVO();
    }

    @Override
    public SystemUserVO get(Long id) {
        return new SystemUserVO();
    }
}
