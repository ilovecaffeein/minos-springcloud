package com.caxs.minos.enums;

/**
 * @ClassName: LoanAccountTypEnum
 * @Description: 账户类型
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum LoanAccountTypEnum {
    // 还款账号 放款账号 最终收款账号 贴息账号 费用收取账号 委托存款账号,最后还款账户相关账户S03
    REPAY /* 还款账号 */, RELEASE_LOAN/* 放款账号 */, LASTGATHER/* 最终收款账号 */,
    DISCINTEREST/* 贴息账号 */, FEE/* 费用收取账号 */, TLOAN/* 委托存款账号 */, TURE_I/* 委托利息归集账号 */,
    TURE_P/* 委托本金归集账号 */,
    LAST_GATHER_RELATE/* 最后还款账户相关账户 */, REPAY1/* 还款账号 */, REPAY2, REPAY3,
    REPAY_SBSY/* 贴息扣款帐号 */, THIR/* 第三方帐号,* 需要验证密码*/, GUTR, STAMP/* 印花税帐号 */;
    // 获取账号类型对应的字符值
    private String seqNo = "";

    public String getSeqNo() {
        return seqNo;
    }

    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case REPAY:
                return "PAYM";
            case THIR:
                return "THIR";
            case REPAY1:
                return "PAYM1";
            case REPAY2:
                return "PAYM2";
            case REPAY3:
                return "PAYM3";
            case REPAY_SBSY:
                return "PAYM4";
            case RELEASE_LOAN: {
                return "ACTV";
            }
            case LASTGATHER: {
                return "EACT" + seqNo;
            }
            case DISCINTEREST: {
                return "4";
            }
            case FEE: {
                return "FEE" + seqNo;
            }
            case STAMP: {
                return "STAMP" + seqNo;
            }
            case TLOAN: {
                return "TURE";
            }
            case TURE_I: {
                return "TURE_I";
            }
            case TURE_P: {
                return "TURE_P";
            }
            case GUTR: {
                return "GUTR";
            }
            case LAST_GATHER_RELATE: {
                return "20";
            }
        }
        throw new RuntimeException("not found enum");
    }

    // 获取账号类型对应的枚举值
    public static LoanAccountTypEnum getEnum(String accountCatalog) {
        if ("PAYM".equals(accountCatalog)) {
            return REPAY;
        }
        if ("THIR".equals(accountCatalog)) {
            return THIR;
        }
        if ("PAYM1".equals(accountCatalog)) {
            return REPAY1;
        }
        if ("PAYM2".equals(accountCatalog)) {
            return REPAY2;
        }
        if ("PAYM3".equals(accountCatalog)) {
            return REPAY3;
        }
        if ("PAYM4".equals(accountCatalog)) {
            return REPAY_SBSY;
        }
        if ("ACTV".equals(accountCatalog)) {
            return RELEASE_LOAN;
        }
        if ("EACT".equals(accountCatalog)) {
            return LASTGATHER;
        }
        if (accountCatalog != null && accountCatalog.startsWith("EACT")) {
            LoanAccountTypEnum lat = LoanAccountTypEnum.LASTGATHER;
            lat.seqNo = accountCatalog.substring(4);
            return lat;
        }
        if ("4".equals(accountCatalog)) {
            return DISCINTEREST;
        }
        if ("FEE".equals(accountCatalog)) {
            return FEE;
        }
        if (accountCatalog != null && accountCatalog.startsWith("FEE")) {
            LoanAccountTypEnum lat = LoanAccountTypEnum.FEE;
            lat.seqNo = accountCatalog.substring(4);
            return lat;
        }
        if (accountCatalog != null && accountCatalog.startsWith("STAMP")) {
            LoanAccountTypEnum lat = LoanAccountTypEnum.STAMP;
            lat.seqNo = accountCatalog.substring(4);
            return lat;
        }
        if ("TURE".equals(accountCatalog)) {
            return TLOAN;
        }
        if ("TURE_I".equals(accountCatalog)) {
            return TURE_I;
        }
        if ("TURE_P".equals(accountCatalog)) {
            return TURE_P;
        }
        if ("20".equals(accountCatalog)) {
            return LAST_GATHER_RELATE;
        }
        if ("GUTR".equals(accountCatalog)) {
            return GUTR;
        }
        throw new RuntimeException("not found enum:" + accountCatalog);
    }
}
