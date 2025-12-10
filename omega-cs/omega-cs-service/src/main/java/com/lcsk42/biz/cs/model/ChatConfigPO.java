package com.lcsk42.biz.cs.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcsk42.biz.cs.common.enums.ConnectRuleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@FieldNameConstants
@TableName("chat_config")
@Tag(name = "ChatConfigPO", description = "聊天的相关配置")
public class ChatConfigPO {
    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "聊天接入规则")
    private ConnectRuleEnum connectRule = ConnectRuleEnum.HUMAN_PRIORITY;

    @Schema(description = "自动邀请(用户停留在页面指定市场后，自动弹出客服聊天框)")
    private Boolean autoInvitation = Boolean.TRUE;

    @Schema(description = "自动邀请等待时长")
    private Integer autoInvitationWaitingTime = 30;

    @Schema(description = "是否启用客服超时未回复安抚语")
    @TableField(value = "is_comfort")
    private Boolean comfort = Boolean.TRUE;

    @Schema(description = "安抚语超时规则（超过 xx 秒未回复）")
    private Integer comfortTimeoutSecond = 30;

    @Schema(description = "是否允许多次安抚")
    @TableField(value = "is_comfort_multiple")
    private Boolean comfortMultiple = Boolean.TRUE;

    @Schema(description = "是否顺序发送安抚语")
    @TableField(value = "is_comfort_random")
    private Boolean comfortRandom = Boolean.TRUE;

    @Schema(description = "是否会话超时关闭和提示")
    @TableField(value = "is_timeout_close_and_prompt")
    private Boolean timeoutCloseAndPrompt = Boolean.TRUE;

    @Schema(description = "关闭规则(超过 xx 秒访客无消息自动关闭)")
    private Integer closeSecond = 180;

    @Schema(description = "即将关闭提示时间(关闭前 xx 秒发送提示)")
    private Integer promptSecond = 10;

    @Schema(description = "是否访客离开页面超时关闭")
    @TableField(value = "is_leave_close")
    private Boolean leaveClose = Boolean.TRUE;

    @Schema(description = "关闭规则(访客离开网页超过 xx 秒自动关闭)")
    private Integer leaveSecond = 60;

    @TableField(value = "is_deleted")
    @Schema(description = "是否删除")
    private Boolean deleted;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
