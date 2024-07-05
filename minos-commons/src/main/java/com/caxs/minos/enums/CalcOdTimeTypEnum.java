package com.caxs.minos.enums;

import com.caxs.minos.exception.MinosException;

/***
 * @ClassName(类名) : CalcOdTimeTypEnum
 * @Description(描述) : 贷款结息类型
 * B 扣款日前一天结息   C 扣款日结息
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum CalcOdTimeTypEnum {
    /** 扣款日前一天结息 */ B, /** 扣款日结息*/ C;
    //获取贷款结息类型对应的字符串
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case B:
                return "B";
            case C:
                return "C";
        }
        throw new RuntimeException("not found enum");
    }
    //获取贷款结息类型对应的枚举值
    public static CalcOdTimeTypEnum getEnum(String code){
        if("B".equals(code)){
            return B;
        }else if("C".equals(code)){
            return C;
        }
        throw new MinosException("No defined enum CalcOdTimeTyp");
    }
}
