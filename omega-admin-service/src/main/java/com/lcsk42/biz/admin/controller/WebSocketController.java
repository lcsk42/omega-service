package com.lcsk42.biz.admin.controller;

import com.lcsk42.biz.admin.model.dto.MessageDTO;
import com.lcsk42.frameworks.starter.message.websocket.util.WebSocketUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/web-socket")
@RestController
@Tag(name = "WebSocketController")
public class WebSocketController {

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody MessageDTO messageDTO) {
        WebSocketUtil.sendMessage(messageDTO.getClientId(), messageDTO.getMessage());
    }
}
