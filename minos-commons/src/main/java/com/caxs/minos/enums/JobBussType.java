package com.caxs.minos.enums;

public enum JobBussType {
    NLOAN, TLOAN, FLOAN/* 代保管贷款 ,有表外账 */, DLOAN, ALOAN/**/, BLOAN/*
     * 90天逾期以后用保证金
     */, CLOAN, ELOAN, SLOAN/* 本息有不同帐号扣取 */, ALLLOAN, DISC, ACCP, GUTR, CMMT, CRDPROV, PLEDGE/* 信用证 */, EACCP/* 电票 */
    , FEE_PAY, GUTR_PAY;
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case NLOAN:
                return "NLOAN";
            case DLOAN:
                return "DLOAN";
            case FLOAN:
                return "FLOAN";
            case ALOAN:
                return "ALOAN";
            case BLOAN:
                return "BLOAN";
            case CLOAN:
                return "CLOAN";
            case ELOAN:
                return "ELOAN";
            case SLOAN:
                return "SLOAN";
            case TLOAN:
                return "TLOAN";
            case ALLLOAN:
                return "LOAN";
            case DISC:
                return "DISC";
            case EACCP:
                return "EACCP";
            case ACCP:
                return "ACCP";
            case GUTR:
                return "GUTR";
            case CMMT:
                return "CMMT";
            case CRDPROV:
                return "CRDPROV";
            case PLEDGE:
                return "PLEDGE";// 抵质押品
            case FEE_PAY:
                return "FPAY";
            case GUTR_PAY:
                return "GPAY";
        }
        throw new RuntimeException("not found enum");
    }

    public static JobBussType getEnum(String jobBussType) {
        if ("NLOAN".equals(jobBussType)) {
            return NLOAN;
        }
        if ("ALOAN".equals(jobBussType)) {
            return ALOAN;
        }
        if ("FLOAN".equals(jobBussType)) {
            return FLOAN;
        }
        if ("BLOAN".equals(jobBussType)) {
            return BLOAN;
        }
        if ("CLOAN".equals(jobBussType)) {
            return CLOAN;
        }
        if ("SLOAN".equals(jobBussType)) {
            return SLOAN;
        }
        if ("ELOAN".equals(jobBussType)) {
            return ELOAN;
        }
        if ("DLOAN".equals(jobBussType)) {
            return DLOAN;
        }
        if ("TLOAN".equals(jobBussType)) {
            return TLOAN;
        }
        if ("LOAN".equals(jobBussType)) {
            return ALLLOAN;
        }
        if ("EACCP".equals(jobBussType)) {
            return EACCP;
        }
        if ("ACCP".equals(jobBussType)) {
            return ACCP;
        }
        if ("GUTR".equals(jobBussType)) {
            return GUTR;
        }
        if ("DISC".equals(jobBussType)) {
            return DISC;
        }
        if ("CMMT".equals(jobBussType)) {
            return CMMT;
        }
        if ("CRDPROV".equals(jobBussType)) {
            return CRDPROV;
        }
        if ("PLEDGE".equals(jobBussType)) {
            return PLEDGE;
        }
        if ("FPAY".equals(jobBussType)) {
            return FEE_PAY;
        }
        if ("GPAY".equals(jobBussType)) {
            return GUTR_PAY;
        }
        throw new RuntimeException("not found enum:" + jobBussType);
    }
}
