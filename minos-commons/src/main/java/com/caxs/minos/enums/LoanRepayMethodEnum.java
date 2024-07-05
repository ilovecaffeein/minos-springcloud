package com.caxs.minos.enums;

/**
 * Created by lenovo on 2020/9/22.
 */
public enum LoanRepayMethodEnum {
    AUTOPAY/*自动扣款*/, MANUAL/*人为还款*/;
    //获取扣款方式对应的字符值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case AUTOPAY:
                return "AUTOPAY";
            case MANUAL:
                return "MANUAL";
        }
        throw new RuntimeException("not found enum");
    }

}
