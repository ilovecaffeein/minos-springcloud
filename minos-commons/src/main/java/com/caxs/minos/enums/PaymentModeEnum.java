package com.caxs.minos.enums;

/**
 * @ClassName: PaymentModeEnum
 * @Description: 还款类型定义
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum PaymentModeEnum {
    // 正常 提前 全部
    NORMAL, ADVANCE, ALL, PAY_INT, PAY_PRCP, PAY_ADV_PRCP/* 提前还仅还本金，不归还利息 */, CUSTOM/* 自定义归还 */, CUSTOMPI/* 指定扣本扣息 */
    , ADV_RM_INT/* 提前还款免除对应本金部分利息 */;
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case NORMAL:
                return "NM";
            case ADVANCE: {
                return "ER";
            }
            case ALL: {
                return "FS";
            }
            case PAY_INT:
                return "PI";
            case PAY_PRCP:
                return "PP";
            case PAY_ADV_PRCP:
                return "AP";
            case CUSTOM:
                return "CM";
            case CUSTOMPI:
                return "IP";
            case ADV_RM_INT:
                return "RI";

        }
        throw new RuntimeException("not found enum");
    }

    public static PaymentModeEnum getEnum(String paymentMode) {
        if ("NM".equals(paymentMode)) {
            return NORMAL;
        }
        if ("ER".equals(paymentMode)) {
            return ADVANCE;
        }
        if ("FS".equals(paymentMode)) {
            return ALL;
        }
        if ("PI".equals(paymentMode)) {
            return PAY_INT;
        }
        if ("IP".equals(paymentMode)) {
            return CUSTOMPI;
        }
        if ("PP".equals(paymentMode)) {
            return PAY_PRCP;
        }
        if ("AP".equals(paymentMode)) {
            return PAY_ADV_PRCP;
        }
        if ("CM".equals(paymentMode)) {
            return CUSTOM;
        }
        if ("RI".equals(paymentMode)) {
            return ADV_RM_INT;
        }

        throw new RuntimeException("not found enum");
    }
}
