package com.lcsk42.biz.file.client;

import com.lcsk42.biz.file.api.FileApi;
import com.lcsk42.biz.file.client.impl.FileClientImpl;
import com.lcsk42.biz.file.common.constant.FileConstant;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = FileConstant.SERVICE_NAME,
        path = FileConstant.PATH,
        fallback = FileClientImpl.class)
public interface FileClient extends FileApi {
}
