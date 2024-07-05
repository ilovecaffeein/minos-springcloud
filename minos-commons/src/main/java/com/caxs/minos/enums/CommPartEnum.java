package com.caxs.minos.enums;

/**
 * 复利部分代码
 * Created by lenovo on 2020/8/14.
 */
public enum CommPartEnum {
    // /本金
    PROP/* 仅本金收罚息 */, ALL/*所有*/, INTEREST/*仅利息*/, IP/* 利息和本金都收罚息 */, IPALL/*本金和利息所有*/, IPALL1/* 收1次复利 */;
    //获取复利代码对应的字符串
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case PROP:
                return "P";
            case INTEREST:
                return "I";
            case IP:
                return "IP";
            case IPALL:
                return "IPA";
            case IPALL1:
                return "IA";
            case ALL: {
                return "A";
            }
        }
        throw new RuntimeException("not found enum");
    }
    //获取复利代码对应的枚举值
    public static CommPartEnum getEnum(String commpart) {
        if ("P".equals(commpart)) {
            return PROP;
        }
        if ("IA".equals(commpart)) {
            return IPALL1;
        }
        if ("I".equals(commpart)) {
            return INTEREST;
        }
        if ("IPA".equals(commpart)) {
            return IPALL;
        }
        if ("A".equals(commpart)) {
            return ALL;
        }
        if ("IP".equals(commpart)) {
            return IP;
        }
        throw new RuntimeException("not found enum");
    }
}
