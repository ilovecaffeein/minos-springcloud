package com.caxs.minos.enums;

/***
 * @ClassName(类名) : JobStateEnum
 * @Description(描述) : 工作状态
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum JobStateEnum {
    INIT/*开始*/,RUN/*运行*/, FIN/*完成*/, PARTFIN/*部分完成*/, ERR/*错误*/;
    //获取工作状态对应的字符值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case INIT:
                return "INIT";
            case RUN:
                return "RUN";
            case FIN:
                return "FIN";
            case PARTFIN:
                return "PFIN";
            case ERR:
                return "ERR";
        }
        throw new RuntimeException("not found enum");
    }
}
