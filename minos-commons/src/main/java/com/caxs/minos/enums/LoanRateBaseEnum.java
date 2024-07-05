package com.caxs.minos.enums;

/**
 * Created by lenovo on 2020/8/14.
 */
public enum LoanRateBaseEnum {
    Y, M, D;

    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case Y:
                return "Y";
            case M:
                return "M";
            case D:
                return "D";
        }
        throw new RuntimeException("not found enum");
    }

    public static  LoanRateBaseEnum getEnum(String codeInDb) {
        if ("Y".equals(codeInDb)) {
            return Y;
        }
        if ("M".equals(codeInDb)) {
            return M;
        }
        if ("D".equals(codeInDb)) {
            return D;
        }
        throw new RuntimeException("not found enum");
    }
}
