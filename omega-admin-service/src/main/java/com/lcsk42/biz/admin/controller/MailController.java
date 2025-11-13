package com.lcsk42.biz.admin.controller;

import com.lcsk42.frameworks.starter.message.mail.util.MailUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@Tag(name = "MailController")
public class MailController {

    @PostMapping("/send")
    @Operation(summary = "Send")
    public void ping() throws MessagingException {
        MailUtil.sendText("lcsk42@163.com","测试邮件发送","测试邮件发送内容");
    }
}
