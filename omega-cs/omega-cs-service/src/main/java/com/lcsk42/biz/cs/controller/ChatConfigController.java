package com.lcsk42.biz.cs.controller;

import com.lcsk42.biz.cs.model.ChatConfigPO;
import com.lcsk42.biz.cs.model.convert.ChatConfigConverter;
import com.lcsk42.biz.cs.model.dto.ChatConfigDTO;
import com.lcsk42.biz.cs.model.vo.ChatConfigVO;
import com.lcsk42.biz.cs.service.ChatConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/chat/config")
@RequiredArgsConstructor
@Tag(description = "回话设置", name = "回话设置")
public class ChatConfigController {

    private final ChatConfigService chatConfigService;

    @GetMapping
    @Operation(summary = "会话配置信息", description = "获取会话配置信息")
    public ChatConfigVO get() {
        return ChatConfigConverter.INSTANCE.toV(chatConfigService.getOrCreate());
    }

    @PutMapping
    @Operation(summary = "会话配置信息(修改)", description = "修改回话配置信息")
    public ChatConfigVO update(@RequestBody ChatConfigDTO chatConfigDTO) {
        ChatConfigPO po = ChatConfigConverter.INSTANCE.toP(chatConfigDTO);
        chatConfigService.updateById(po);
        return ChatConfigConverter.INSTANCE.toV(po);
    }
}
