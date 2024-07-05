package com.caxs.minos.enums;

/**
 * @ClassName: AdvancePaymentIntBaseEnum
 * @Description: 剩余本金  提前本金  不计息
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum AdvancePaymentIntBaseEnum {
    // 剩余本金  提前本金  不计息
    REMAINING_PRINCIPAL/*剩余本金*/, ADVANCE_PRINCIPAL/*提前本金*/, NO_INTEREST/*不计息*/,NULL/*无*/;
    //获取提前还款计息基础对应的字符串
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case REMAINING_PRINCIPAL:
                return "OSP";
            case ADVANCE_PRINCIPAL: {
                return "PPP";
            }
            case NO_INTEREST: {
                return "NA";
            }
        }
        throw new RuntimeException("not found enum");
    }
    //获取提前还款计息基础对应的枚举类型
    public static AdvancePaymentIntBaseEnum getEnum(String advancePaymentIntBase) {
        if ("OSP".equals(advancePaymentIntBase)) {
            return REMAINING_PRINCIPAL;
        }
        if ("PPP".equals(advancePaymentIntBase)) {
            return ADVANCE_PRINCIPAL;
        }
        if ("NA".equals(advancePaymentIntBase)) {
            return NO_INTEREST;
        }
        if("".equals(advancePaymentIntBase) || advancePaymentIntBase == null) {
            return NULL;
        }
        throw new RuntimeException("not found enum");
    }
}
