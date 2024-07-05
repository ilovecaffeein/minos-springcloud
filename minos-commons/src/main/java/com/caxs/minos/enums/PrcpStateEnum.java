package com.caxs.minos.enums;
/**
 * @ClassName: PrcpStateEnum
 * @Description: 本金状态
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum PrcpStateEnum {
    // 正常 逾期 非应计 核销
    NORMAL/*正常*/, DELQ/*拖欠*/,LATE/*逾期*/, NONACCRUAL/* 非应计*/, CANCEL/*核销*/;
    //获取本金状态对应代码值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case NORMAL:
                return "10";
            case DELQ: {
                return "20";
            }
            case LATE:{
                return "30";
            }
            case NONACCRUAL: {
                return "40";
            }
            case CANCEL:
                return "50";
        }
        throw new RuntimeException("not found enum");
    }
    //获取本金状态对应代码的枚举值
    public static PrcpStateEnum getEnum(String prcpState) {
        if ("10".equals(prcpState)) {
            return NORMAL;
        }
        if ("20".equals(prcpState)) {
            return DELQ;
        }
        if("30".equals(prcpState)){
            return LATE;
        }
        if ("40".equals(prcpState)) {
            return NONACCRUAL;
        }
        if ("50".equals(prcpState)) {
            return CANCEL;
        }
        throw new RuntimeException("not found enum");
    }
}
