package com.caxs.minos.enums;

/**
 * Created by lenovo on 2020/9/24.
 */
public enum LoanDevaIndEnum {
    YES/*已减值*/,NO /*未减值*/;
    //获取减值标志对应的字符
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case YES:
                return "Y";
            case NO:
                return "N";
        }
        throw new RuntimeException("not found enum");
    }
    //获取减值标志对应的描述
    public String getCaption() {
        switch (values()[ordinal()]) {
            case YES:
                return "已减值";
            case NO:
                return "未减值";
        }
        throw new RuntimeException("not found enum");
    }
    //获取减值标志对应的枚举
    public static LoanDevaIndEnum getEnum(String loanDevaInd){
        if("Y".equals(loanDevaInd)){
            return YES;
        }
        if("N".equals(loanDevaInd)){
            return NO;
        }
        throw new RuntimeException("not found enum");
    }
}
