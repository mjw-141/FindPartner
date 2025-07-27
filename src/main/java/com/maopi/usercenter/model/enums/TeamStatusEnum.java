package com.maopi.usercenter.model.enums;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/24 11:05 （可以根据需要修改）
 * 队伍状态枚举
 * @Version 1.0 （版本号）
 */

public enum TeamStatusEnum {
    PUBLIC(0, "公开"),
    PRIVATE(1, "私有"),
    SECRET(2, "加密");

    private int value;
    private String text;

    TeamStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static TeamStatusEnum getEnumByValue(int value) {
        for (TeamStatusEnum status : TeamStatusEnum.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
