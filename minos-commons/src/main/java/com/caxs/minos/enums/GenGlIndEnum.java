package com.caxs.minos.enums;

/***
 * @ClassName(类名) : GenGlIndEnum
 * @Description(描述) : 授权状态
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum GenGlIndEnum {
    UN_PROCESSED/* 未处理 */, DONE/* 已处理 */, UNDO/* 撤销 */,UN_INIT/*未审批通过*/,AUTO_UNDO/*自动撤销*/;
    //获取授权状态对应的字符
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case DONE:
                return "1";
            case UN_PROCESSED:
                return "0";
            case AUTO_UNDO:
                return "5";
            case UNDO:
                return "2";
            case UN_INIT:
                return "9";

        }
        throw new RuntimeException("not found enum");
    }
    //获取授权状态对应的枚举值
    public static GenGlIndEnum getEnum(String source) {
        if ("1".equals(source)) {
            return DONE;
        }
        if ("0".equals(source)) {
            return UN_PROCESSED;
        }
        if ("2".equals(source)) {
            return UNDO;
        }
        if ("9".equals(source)) {
            return UN_INIT;
        }
        if ("5".equals(source)) {
            return AUTO_UNDO;
        }

        throw new RuntimeException("not found enum:" + source);
    }
}
