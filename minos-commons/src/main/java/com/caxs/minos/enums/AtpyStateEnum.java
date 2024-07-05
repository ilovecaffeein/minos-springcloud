package com.caxs.minos.enums;

/***
 * @ClassName(类名) : AtpyStateEnum
 * @Description(描述) : 扣款状态
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum AtpyStateEnum {
    SU/*初始*/,FREEZE/*已完成*/,COMPLETE/*已记账*/;
    //扣款状态对应的交易码
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case SU:
                return "SU";
            case FREEZE:
                return "FZ";
            case COMPLETE:
                return "CP";
        }
        throw new RuntimeException("not found enum");
    }
}
