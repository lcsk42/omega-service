package com.lcsk42.biz.admin.client.fallback;

import com.lcsk42.biz.admin.client.SystemUserClient;
import com.lcsk42.biz.admin.model.vo.SystemUserVO;
import org.springframework.cloud.openfeign.FallbackFactory;

public class SystemUserClientFallbackFactory implements FallbackFactory<SystemUserClient> {
    @Override
    public SystemUserClient create(Throwable cause) {

        return new SystemUserClient() {
            @Override
            public SystemUserVO getByUsernameOrEmailOrMobile(String usernameOrEmailOrMobile) {
                return new SystemUserVO();
            }

            @Override
            public SystemUserVO get(Long id) {
                return new SystemUserVO();
            }
        };
    }
}
