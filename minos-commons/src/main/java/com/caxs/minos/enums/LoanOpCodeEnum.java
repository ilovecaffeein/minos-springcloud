package com.caxs.minos.enums;

/**
 * Created by lenovo on 2020/9/29.
 */
public enum LoanOpCodeEnum {
    UN_STOP_GRD/*不暂停五级分类*/, STOP_OD_INT/*暂停罚息*/, UN_STOP_OD_INT/*不暂停罚息*/, START_AUTO_PAY/*开始自动扣款*/, END_AUTO_PAY/*结束自动扣款*/, STOP_GRD/* 五级分类 */,
    STP_STS_CHG/*停止自动形态转移*/,AUTO_STS_CHG/*系统自动形态转移*/;
    //获取暂停处理标志对应的字符
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case STOP_OD_INT:
                return "STPACC";
            case UN_STOP_OD_INT:
                return "UNSTPACC";
            case START_AUTO_PAY:
                return "UNSTPATP";
            case END_AUTO_PAY:
                return "STPATP";
            case STOP_GRD:
                return "STPGRD";
            case UN_STOP_GRD:
                return "UNSTPGRD";
            case STP_STS_CHG:
                return "STPSTSCHG";
            case AUTO_STS_CHG:
                return "AUTOSTSCHG";
        }

        throw new RuntimeException("not found enum");
    }
    //获取暂停处理标志对应的枚举
    public static LoanOpCodeEnum getEnum(String codeInDb) {
        if ("STPACC".equals(codeInDb)) {
            return STOP_OD_INT;
        }
        if ("UNSTPACC".equals(codeInDb)) {
            return UN_STOP_OD_INT;
        }
        if ("UNSTPATP".equals(codeInDb)) {
            return START_AUTO_PAY;
        }
        if ("STPATP".equals(codeInDb)) {
            return END_AUTO_PAY;
        }
        if ("STPGRD".equals(codeInDb)) {
            return STOP_GRD;
        }
        if ("UN_STOP_GRD".equals(codeInDb)) {
            return UN_STOP_GRD;
        }
        if ("STPSTSCHG".equals(codeInDb)) {
            return STP_STS_CHG;
        }
        if ("AUTOSTSCHG".equals(codeInDb)) {
            return AUTO_STS_CHG;
        }
        throw new RuntimeException("not found code:" + codeInDb);
    }

}
