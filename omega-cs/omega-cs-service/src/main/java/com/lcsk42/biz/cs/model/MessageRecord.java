package com.lcsk42.biz.cs.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lcsk42.biz.cs.common.enums.MessageTypeEnum;
import com.lcsk42.biz.cs.common.enums.UserTypeEnum;
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
@TableName("message_record")
@Tag(name = "MessageRecord", description = "留言记录")
public class MessageRecord {
    @TableId
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "房间 ID")
    private Long roomId;

    @Schema(description = "用户 ID")
    private String userId;

    @Schema(description = "用户类型")
    private UserTypeEnum userType;

    @Schema(description = "消息类型")
    private MessageTypeEnum messageType;

    @Schema(description = "消息内容")
    private String content;

    @Schema(description = "是否删除")
    @TableField(value = "is_deleted")
    private Boolean deleted;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
