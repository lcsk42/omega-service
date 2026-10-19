package com.lcsk42.biz.file.util;

import feign.Response;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FeignFileDownloadUtil {
    public static void writeToResponse(
            Response feignResponse,
            HttpServletResponse response) throws IOException {

        if (feignResponse == null) {
            response.sendError(
                    HttpServletResponse.SC_BAD_GATEWAY,
                    "文件服务无响应");
            return;
        }

        try (Response closeableResponse = feignResponse) {
            int status = closeableResponse.status();

            if (status < 200 || status >= 300) {
                response.sendError(
                        HttpServletResponse.SC_BAD_GATEWAY,
                        "文件下载失败，下游服务状态码：" + status);
                return;
            }

            // 复制常用响应头
            copyHeader(closeableResponse, response,
                    HttpHeaders.CONTENT_TYPE);
            copyHeader(closeableResponse, response,
                    HttpHeaders.CONTENT_DISPOSITION);
            copyHeader(closeableResponse, response,
                    HttpHeaders.CONTENT_LENGTH);
            copyHeader(closeableResponse, response,
                    HttpHeaders.CACHE_CONTROL);
            copyHeader(closeableResponse, response,
                    HttpHeaders.ETAG);
            copyHeader(closeableResponse, response,
                    HttpHeaders.LAST_MODIFIED);

            Response.Body body = closeableResponse.body();
            if (body == null) {
                return;
            }

            try (InputStream inputStream = body.asInputStream()) {
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
            }
        }
    }

    private static void copyHeader(
            Response source,
            HttpServletResponse target,
            String headerName) {

        for (Map.Entry<String, Collection<String>> entry : source.headers().entrySet()) {
            if (headerName.equalsIgnoreCase(entry.getKey())) {
                for (String value : entry.getValue()) {
                    target.addHeader(headerName, value);
                }
                return;
            }
        }
    }
}
