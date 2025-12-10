package com.lcsk42.biz.cs.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WsCommandEnum implements BaseEnum<Integer> {

    UNKNOWN(0, "未知命令"),

    // 聊天室相关命令 (1_xxx)
    CHAT_ROOM_CREATE(1_001, "创建聊天房间"),
    CHAT_ROOM_GET_INFO(1_002, "获取聊天房间信息"),
    CHAT_ROOM_CLOSE(1_003, "关闭房间"),
    CHAT_ROOM_REENTER(1_004, "重新进入房间"),
    CHAT_ROOM_JOIN(1_005, "加入房间"),
    CHAT_ROOM_LEAVE(1_006, "离开房间"),

    // 用户相关命令 (2_xxx)
    USER_HEARTBEAT(2_000, "心跳检测"),
    USER_AUTHENTICATE(2_001, "用户认证"),
    USER_DISCONNECT(2_005, "用户断开连接"),

    // 系统相关命令 (3_xxx)
    SYSTEM_NOTIFICATION(3_001, "系统通知"),
    ;

    private final Integer value;

    private final String description;
}
