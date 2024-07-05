package com.caxs.minos.enums;

/***
 * @ClassName(类名) : AtpyTypeEnum
 * @Description(描述) : 是否逾期标志
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum AtpyTypeEnum {
    OVERDUE/*逾期*/, NORMAL/*正常*/;// 逾期，正常
    //获取是否逾期标志对应的字符串
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case OVERDUE:
                return "OI";
            case NORMAL:
                return "CI";
        }
        throw new RuntimeException("not found enum");
    }
}
