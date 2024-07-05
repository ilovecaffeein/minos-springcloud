package com.caxs.minos.enums;

/**
 * Created by lenovo on 2020/8/24.
 */
public enum PrcpAndIntStateEnum {
    //10:正常（P01)（ 10:拖欠(P02)  15:逾期(P02) --张家港系统未用）  40:表外(P03)  50：核销

    NORMAL/*正常*/, DELQ/*拖欠*/, LATE/*逾期*/, NONACCRUAL/*表外*/, CANCEL/*核销*/,ALL;
    //获取本金利息状态代码值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case NORMAL:
                return "10";
            case DELQ: {
                return "15";
            }
            case LATE: {
                return "20";
            }
            case NONACCRUAL: {
                return "30";
            }
            case CANCEL:
                return "50";
        }
        throw new RuntimeException("not found enum");
    }

    //获取本金利息状态代码对应枚举值
    public static PrcpAndIntStateEnum getEnum(String prcpState) {
        if ("10".equals(prcpState)) {
            return NORMAL;
        }
        if ("15".equals(prcpState)) {
            return DELQ;
        }
        if ("20".equals(prcpState)) {
            return LATE;
        }
        if ("30".equals(prcpState)) {
            return NONACCRUAL;
        }
        if ("50".equals(prcpState)) {
            return CANCEL;
        }
        throw new RuntimeException("not found enum");
    }
}
