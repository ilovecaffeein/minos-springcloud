package com.caxs.minos.enums;

import com.caxs.minos.exception.MinosException;

/**
 * Created by lenovo on 2020/9/27.
 */
public enum LoanStpAccIndEnum {
    YES/*已转表外*/, RET/*非应计转回*/, NO/*未转表外*/;
    //获取是否转表外标志在数据库中对应的字符值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case YES:
                return "Y";
            case RET:
                return "R";//非应计转回，但是没有转回
            case NO:
                return "N";
        }
        throw new RuntimeException("not found enum");
    }
    //取出数据库的代码对应的枚举型
    public static LoanStpAccIndEnum getEnum(String code){
        if("Y".equals(code)){
            return YES;
        }else if("N".equals(code)){
            return NO;
        }else if("R".equals(code)){
            return RET;
        }
        throw new MinosException("No defined enum LoanStpAccInd");
    }
}
