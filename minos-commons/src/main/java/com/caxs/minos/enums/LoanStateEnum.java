package com.caxs.minos.enums;


import com.caxs.minos.exception.MinosException;

/**
 * @ClassName: MtdSetLTypCodeEnum
 * @Description:  * 贷款状态(loan_debt_sts) NORM: 正常 DELQ: 拖欠 OVER: 逾期 CLSDB: 关闭 CHRGO: 核销 SALE:资产卖出
 * POFF:资产剥离 SETL:已结清 (loan_sts) NBAP:未放款 ACTV:已发放 SETL:已结清  DISP:贷款置换
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum LoanStateEnum {
    NORMAL/*正常*/, DELQ/*拖欠*/, OVER/*逾期 */, CLOSED/*关闭*/, OFFED/*核销*/, ACTIVE/*已发放*/, SETL/*已结清*/, NBAP/*未放款*/, SALE/*资产卖出*/, POFF/*资产剥离*/,
    DELAY/*拖欠*/, ABORT/*冲回*/, OFFED1/* 假核销,该状态不计提,不批扣等*/, DISP/*贷款置换*/;
    //获取贷款状态在数据库中对应的字符值
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case NORMAL:
                return "NORM";
            case DELQ:
                return "DELQ";
            case OVER:
                return "OVER";
            case CLOSED:
                return "CLSDB";
            case OFFED:
                return "CHRGO";
            case OFFED1:
                return "CHRG1";
            case ACTIVE:
                return "ACTV";
            case SETL:
                return "SETL";
            case NBAP:
                return "NBAP";
            case SALE:
                return "SALE";
            case POFF:
                return "POFF";
            case DELAY:
                return "DELQ";
            case ABORT:
                return "ABORT";
            case DISP:
                return "DISP";
        }
        throw new RuntimeException("not found enum");
    }
    //获取贷款状态对应的描述
    public String getCaption() {
        switch (values()[ordinal()]) {
            case NORMAL:
                return "正常";
            case DELQ:
                return "拖欠";
            case OVER:
                return "逾期";
            case CLOSED:
                return "关闭";
            case OFFED:
                return "核销";
            case OFFED1:
                return "假核销";
            case ACTIVE:
                return "激活";
            case SETL:
                return "结清";
            case NBAP:
                return "未放款";
            case SALE:
                return "资产卖出";
            case POFF:
                return "资产剥离";
            case DELAY:
                return "拖欠";
            case DISP:
                return "贷款置换";
        }
        throw new RuntimeException("not found enum");

    }
    //取出数据库的代码对应的枚举型
    public static LoanStateEnum getEnum(String loanState) {
        if ("NORM".equals(loanState)) {
            return NORMAL;
        }
        if ("DELQ".equals(loanState)) {
            return DELQ;
        }
        if ("OVER".equals(loanState)) {
            return OVER;
        }
        if ("CLSDB".equals(loanState)) {
            return CLOSED;
        }
        if ("CHRGO".equals(loanState)) {
            return OFFED;
        }
        if ("CHRG1".equals(loanState)) {
            return OFFED1;
        }
        if ("ACTV".equals(loanState)) {
            return ACTIVE;
        }
        if ("SETL".equals(loanState)) {
            return SETL;
        }
        if ("NBAP".equals(loanState)) {
            return NBAP;
        }
        if ("SALE".equals(loanState)) {
            return SALE;
        }
        if ("POFF".equals(loanState)) {
            return POFF;
        }
        if ("DELAY".equals(loanState)) {
            return DELQ;
        }
        if ("ABORT".equals(loanState)) {
            return ABORT;
        }
        if("DISP".equals(loanState)) {
            return DISP;
        }
        throw new MinosException("not found enum:" + loanState);
    }
}
