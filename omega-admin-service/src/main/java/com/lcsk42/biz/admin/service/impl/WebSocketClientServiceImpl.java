package com.lcsk42.biz.admin.service.impl;

import com.lcsk42.frameworks.starter.message.websocket.service.WebSocketClientService;
import com.lcsk42.frameworks.starter.web.util.ServletUtil;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WebSocketClientServiceImpl implements WebSocketClientService {

    @Override
    public String getClientId(ServletServerHttpRequest request) {
        Map<String, String> paramMap = ServletUtil.getParamMap(request.getServletRequest());
        return paramMap.getOrDefault("clientId", "");
    }
}
