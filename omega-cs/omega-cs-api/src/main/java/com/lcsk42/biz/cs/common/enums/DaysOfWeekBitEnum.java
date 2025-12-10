package com.lcsk42.biz.cs.common.enums;

import com.lcsk42.frameworks.starter.convention.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public enum DaysOfWeekBitEnum implements BaseEnum<Integer> {
    UNKNOWN(0, "未知"),
    // 00000001 -> 1
    MONDAY(1, "周一"),
    // 00000010 -> 2
    TUESDAY(1 << 1, "周二"),
    // 0000100 -> 4
    WEDNESDAY(1 << 2, "周三"),
    // 00001000 -> 8
    THURSDAY(1 << 3, "周四"),
    // 00010000 -> 16
    FRIDAY(1 << 4, "周五"),
    // 00100000 -> 32
    SATURDAY(1 << 5, "周六"),
    // 01000000 -> 64
    SUNDAY(1 << 6, "周日"),
    // 周一到周五
    WORKING_DAY(0b00011111, "工作日"),
    // 全部值(全选周一到周日)
    All(0b01111111, "全选"),

    ;
    private final Integer value;

    private final String description;

    /**
     * 判断某天是否在提供的值中
     *
     * @param targetValue 组合后的需要判断的值
     * @param day         需要判断的天
     * @return boolean
     */
    public static boolean contains(int targetValue, DaysOfWeekBitEnum day) {
        return (targetValue & day.getValue()) != 0;
    }

    /**
     * 获取今天是周几
     *
     * @return DaysOfWeekBitEnum
     */
    public static DaysOfWeekBitEnum getToday() {
        return BaseEnum.fromValue(1 << (LocalDate.now().getDayOfWeek().getValue() - 1), DaysOfWeekBitEnum.class);
    }
}
