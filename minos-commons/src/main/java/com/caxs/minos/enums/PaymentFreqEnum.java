package com.caxs.minos.enums;

/**
 * Created by lenovo on 2020/8/13.
 */
public enum PaymentFreqEnum {
    DAY, WEEK, MONTH, QUATER, YEAR, HALFYEAR, NULL;

    public String getCodeInDb() {
        switch (values()[ordinal()]){
            case MONTH:
                return "M";
            case QUATER:
                return "Q";
            case WEEK:
                return "W";
            case YEAR:
                return "Y";
            case HALFYEAR:
                return "H";
            case DAY:
                return "D";
            case NULL:
                return null;
        }
        throw new RuntimeException("not found enum");
    }

    public static PaymentFreqEnum getEnum(String paymentFreq) {
        if ("M".equals(paymentFreq)) {
            return MONTH;
        }
        if ("H".equals(paymentFreq)) {
            return HALFYEAR;
        }
        if ("W".equals(paymentFreq)) {
            return WEEK;
        }
        if ("Q".equals(paymentFreq)) {
            return QUATER;
        }
        if ("Y".equals(paymentFreq)) {
            return YEAR;
        }
        if ("D".equals(paymentFreq)) {
            return DAY;
        }
        return NULL;
    }

    public static PaymentFreqEnum getFromFrequence(PaymentFreqEnum freq) {
        switch (values()[freq.ordinal()]) {
            case MONTH:
                return MONTH;
            case QUATER:
                return QUATER;
            case WEEK:
                return WEEK;
            case DAY:
                return DAY;
            case HALFYEAR:
                return HALFYEAR;
            case YEAR:
                return YEAR;
            case NULL:
                return NULL;
        }
        return NULL;
    }
}
