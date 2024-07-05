package com.caxs.minos.enums;

/**
 * @ClassName: SingStateEnum
 * @Description: 扣款状态
 * @Author: coffee
 * @Date: 2020/7/28 15:32
 * @Version: v1.0 文件初始创建
 */
public enum SingStateEnum {
    ZERO/*未支付*/,ONE/*支付成功*/,TWO/*支付失败*/,THREE/*无此记录*/,FOUR,FIVE,SIX;
    //扣款状态对应的交易码
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case ZERO :
                return "0";
            case ONE:
                return "1";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
        }
        throw new RuntimeException("not found enum");
    }
}
