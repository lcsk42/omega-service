package com.lcsk42.biz.cs.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("chat_room")
@Tag(name = "ChatRoomPO", description = "聊天的房间")
public class ChatRoomPO {
    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "游客的 Token")
    private String visitorToken;

    @Schema(description = "游客的 IP")
    private String ip;

    @Schema(description = "游客的位置")
    private String position;

    @Schema(description = "人工客服接入时间")
    private LocalDateTime connectionTime;

    @Schema(description = "当前客服 ID")
    private Long customerServiceId;

    @Schema(description = "当前客服名称")
    private String customerServiceName;

    @Schema(description = "是否是 AI 会话")
    private Boolean aiChat;

    @Schema(description = "AI 回话 ID")
    private Long aiChatId;

    @Schema(description = "游客离开时间")
    private LocalDateTime visitorLeaveTime;

    @Schema(description = "结束时间")
    private LocalDateTime endTime;

    @Schema(description = "客服端未读消息数量")
    private Integer unReadMessageCount;

    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @Schema(description = "是否删除")
    private Boolean deleted;

    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
