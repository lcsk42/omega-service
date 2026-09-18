package com.lcsk42.biz.admin.client.fallback;

import com.lcsk42.biz.admin.client.SystemMenuClient;
import com.lcsk42.biz.admin.model.dto.SystemMenuDTO;
import com.lcsk42.biz.admin.model.vo.SystemMenuVO;
import com.lcsk42.frameworks.starter.convention.model.response.PageResult;
import org.springframework.cloud.openfeign.FallbackFactory;

public class SystemMenuClientFallbackFactory implements FallbackFactory<SystemMenuClient> {

    @Override
    public SystemMenuClient create(Throwable cause) {
        return new SystemMenuClient() {
            @Override
            public PageResult<SystemMenuVO> page(SystemMenuDTO SystemMenuDTO) {
                return new PageResult<>();
            }
        };
    }
}
