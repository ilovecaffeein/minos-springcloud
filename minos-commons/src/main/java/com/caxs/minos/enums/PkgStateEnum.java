package com.caxs.minos.enums;

/**
 * Created by lenovo on 2020/9/22.
 */
public enum PkgStateEnum {
    SU/*初始*/,FZ/*已完成*/,CP/*已记账*/;
    //扣款状态对应的交易码
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case SU:
                return "1";
            case FZ:
                return "9";
            case CP:
                return "10";
        }
        throw new RuntimeException("not found enum");
    }
}
