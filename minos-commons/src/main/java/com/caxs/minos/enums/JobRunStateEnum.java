package com.caxs.minos.enums;

/***
 * @ClassName(类名) : JobRunStateEnum
 * @Description(描述) : 工作状态
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum JobRunStateEnum {
    START/*开始*/, COMPLETE/*结束*/;
    //获取工作状态对应的字符
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case START:
                return "PD";
            case COMPLETE:
                return "CP";

        }
        throw new RuntimeException("not found enum");
    }
}
