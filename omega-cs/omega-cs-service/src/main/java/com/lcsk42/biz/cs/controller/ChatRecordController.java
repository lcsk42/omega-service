package com.lcsk42.biz.cs.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcsk42.biz.cs.model.ChatRecordPO;
import com.lcsk42.biz.cs.model.convert.ChatRecordConverter;
import com.lcsk42.biz.cs.model.dto.ChatRecordDTO;
import com.lcsk42.biz.cs.model.dto.ChatRecordPageDTO;
import com.lcsk42.biz.cs.model.vo.ChatRecordVO;
import com.lcsk42.biz.cs.service.ChatRecordService;
import com.lcsk42.frameworks.starter.database.core.model.response.BasePageResponse;
import com.lcsk42.frameworks.starter.database.mybatisplus.model.page.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/chat/record")
@RequiredArgsConstructor
@Tag(description = "留言记录", name = "留言记录")
public class ChatRecordController {

    private final ChatRecordService chatRecordService;

    @PostMapping
    @Operation(summary = "留言信息", description = "新增留言")
    public ChatRecordVO add(@RequestBody ChatRecordDTO chatRecordDTO) {
        ChatRecordPO po = ChatRecordConverter.INSTANCE.toP(chatRecordDTO);
        chatRecordService.save(po);
        return ChatRecordConverter.INSTANCE.toV(po);
    }

    @GetMapping("/page")
    @Operation(summary = "留言信息(page)", description = "列表查看")
    public BasePageResponse<ChatRecordVO> page(@ModelAttribute @ParameterObject ChatRecordPageDTO chatRecordPageDTO) {
        Page<ChatRecordPO> page = chatRecordService.page(chatRecordPageDTO);
        return PageResponse.of(page, ChatRecordConverter.INSTANCE::toV);
    }
}
