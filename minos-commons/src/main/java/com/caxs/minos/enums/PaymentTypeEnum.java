package com.caxs.minos.enums;

/**
 * @ClassName: PaymentTypeEnum
 * @Description: 还款顺序
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum PaymentTypeEnum {
    // 当前本金 当前利息 当前逾期利息 当前复利
    NOW_PROP/* 当前本金 */, NOW_INT/* 当前利息 */, NOW_LATE_INT/* 当前逾期利息 */, NOW_COMM/* 当前复利 */, FEE;
    // 获取还款类型对应的字符值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case NOW_PROP:
                return "CRP";
            case NOW_INT: {
                return "CRI";
            }
            case NOW_LATE_INT: {
                return "PDI";
            }
            case NOW_COMM: {
                return "ODI";
            }
            case FEE: {
                return "FEE";
            }
        }
        throw new RuntimeException("not found enum");
    }

    // 获取还款类型对应的枚举值
    public static PaymentTypeEnum getEnum(String paymentType) {
        if ("CRP".equals(paymentType)) {
            return NOW_PROP;
        }
        if ("CRI".equals(paymentType)) {
            return NOW_INT;
        }
        if ("PDI".equals(paymentType)) {
            return NOW_LATE_INT;
        }
        if ("ODI".equals(paymentType)) {
            return NOW_COMM;
        }
        if ("FEE".equals(paymentType)) {
            return FEE;
        }
        throw new RuntimeException("not found enum:" + paymentType);
    }
}
