package com.caxs.minos.enums;

import com.caxs.minos.exception.MinosException;

/**
 * @ClassName: LoanOverToCalcOdTypEnum
 * 贷款到期后逾期结息方式
 * P:普通做法每月20号结息   M:按月结息，F:按原有频率结息
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum LoanOverToCalcOdTypEnum {
    P/** 普通做法每月20号结息*/ , M/** 按月结息*/,  F/** 按原有频率结息*/;
    /**
     * 获取贷款到期后逾期结息方式对应的字符
     * @return
     */
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case P:
                return "P";
            case M:
                return "M";
            case F:
                return "F";
        }
        throw new RuntimeException("not found enum");
    }
    //获取贷款到期后逾期结息方式对应的枚举
    public static LoanOverToCalcOdTypEnum getEnum(String code){
        if("P".equals(code)){
            return P;
        }else if("M".equals(code)){
            return M;
        }else if("F".equals(code)){
            return F;
        }
        throw new MinosException("No defined enum LoanOverToCalcOdTyp");
    }
}
