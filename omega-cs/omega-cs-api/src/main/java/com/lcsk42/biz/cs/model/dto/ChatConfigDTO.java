package com.lcsk42.biz.cs.model.dto;

import com.lcsk42.biz.cs.common.enums.ConnectRuleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Tag(name = "ChatConfigVO", description = "聊天的相关配置")
public class ChatConfigDTO {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "聊天接入规则")
    private ConnectRuleEnum connectRule;

    @Schema(description = "自动邀请(用户停留在页面指定市场后，自动弹出客服聊天框)")
    private Boolean autoInvitation;

    @Schema(description = "自动邀请等待时长")
    private Integer autoInvitationWaitingTime;

    @Schema(description = "是否启用客服超时未回复安抚语")
    private Boolean comfort;

    @Schema(description = "安抚语超时规则（超过 xx 秒未回复）")
    private Integer comfortTimeoutSecond;

    @Schema(description = "是否允许多次安抚")
    private Boolean comfortMultiple;

    @Schema(description = "是否顺序发送安抚语")
    private Boolean comfortRandom;

    @Schema(description = "是否会话超时关闭和提示")
    private Boolean timeoutCloseAndPrompt;

    @Schema(description = "关闭规则(超过 xx 秒访客无消息自动关闭)")
    private Integer closeSecond;

    @Schema(description = "即将关闭提示时间(关闭前 xx 秒发送提示)")
    private Integer promptSecond;

    @Schema(description = "是否访客离开页面超时关闭")
    private Boolean leaveClose;

    @Schema(description = "关闭规则(访客离开网页超过 xx 秒自动关闭)")
    private Integer leaveSecond;
}
