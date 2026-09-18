package com.lcsk42.biz.cs.service.impl;

import com.lcsk42.frameworks.starter.cache.core.Cache;
import com.lcsk42.frameworks.starter.message.websocket.service.WebSocketSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WebSocketSessionServiceImpl implements WebSocketSessionService {

    private final Cache cache;

    @Override
    public void add(String key, WebSocketSession session) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public WebSocketSession get(String key) {
        return null;
    }

    @Override
    public Collection<WebSocketSession> listAll() {
        return List.of();
    }

    @Override
    public Set<String> listAllSessionIds() {
        return Set.of();
    }
}
