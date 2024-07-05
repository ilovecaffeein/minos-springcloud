package com.caxs.minos.enums;

/**
 * @ClassName: LoanRateModeEnum
 * @Description: 利率模式
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum LoanRateModeEnum {
    RV, //浮动利率
    FX; //固定利率
    //获取利率模式对应的字符值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case RV:
                return "RV";
            case FX:
                return "FX";
        }
        throw new RuntimeException("not found enum");
    }
    //获取利率模式对应的枚举值
    public static LoanRateModeEnum getEnum(String codeInDb) {
        if ("RV".equals(codeInDb)) {
            return RV;
        }
        if ("FX".equals(codeInDb)) {
            return FX;
        }
        throw new RuntimeException("not found enum");
    }
}
