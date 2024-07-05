package com.caxs.minos.enums;

import com.caxs.minos.exception.MinosException;

/***
 * @ClassName(类名) : BranchLevelEnum
 * @Description(描述) : 利息计算基础
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum MtdRatBaseEnum {
    M/*按月计算利息*/, D/*按天计算利息*/;
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case M:
                return "M";
            case D:
                return "D";
        }
        throw new RuntimeException("not found enum");
    }

    //取出数据库的代码对应的枚举型
    public static MtdRatBaseEnum getEnum(String code){
        if("M".equals(code)){
            return M;
        }else if("D".equals(code)){
            return D;
        }
        throw new MinosException("No defined enum LoanStpAccInd");
    }
}
