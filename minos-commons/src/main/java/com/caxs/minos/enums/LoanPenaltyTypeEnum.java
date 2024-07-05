package com.caxs.minos.enums;

/**
 * @ClassName: LoanPenaltyTypeEnum
 * @Description: 贷款利率
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum LoanPenaltyTypeEnum {
    // 执行利率 , 其他利率
    ACTION/*执行利率*/, OTHER/*其他利率*/, LoanPenaltyTypeEnum;
    //利率执行种类对应的字符
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case ACTION:
                return "L";
            case OTHER: {
                return "O";
            }
        }
        throw new RuntimeException("not found enum");
    }
    //利率执行种类对应的枚举值
    public static LoanPenaltyTypeEnum getEnum(String loanPenaltyType) {
        if ("L".equals(loanPenaltyType)) {
            return ACTION;
        }
        if ("O".equals(loanPenaltyType)) {
            return OTHER;
        }
        throw new RuntimeException("LoanPenaltyType枚举类型" + "not found enum:["
                + loanPenaltyType + "]");
    }
}
