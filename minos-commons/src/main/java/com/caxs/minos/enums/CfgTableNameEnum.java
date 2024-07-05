package com.caxs.minos.enums;

/***
 * @ClassName(类名) : CfgTableNameEnum
 * @Description(描述) : 获取表名
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum CfgTableNameEnum {
    LmMrtyExtnLogDao, LmPyclTxDao, LmPmLogDao,LmSetlmtLogDao,LmGlnoLogDao,LmFeeTxDao,LmPmShdDao,LmLnRepcLogDao,LmLnInfoDao,LmLoanDao,LmLnShdMtdDao;

    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case LmMrtyExtnLogDao:
                return "LM_MRTY_EXTN_LOG";
            case LmPyclTxDao:
                return "LM_PYCL_TX";
            case LmPmLogDao:
                return "LM_PM_LOG";
            case LmSetlmtLogDao:
                return "lM_SETLMT_LOG";
            case LmGlnoLogDao:
                return "LM_GLNO_LOG";
            case LmFeeTxDao:
                return "LM_FEE_TX";
            case LmPmShdDao:
                return "LM_PM_SHD";
            case LmLnRepcLogDao:
                return "LM_LN_REPC_LOG";
            case LmLnInfoDao:
                return "LM_LN_INFO";
            case LmLoanDao:
                return "LM_LOAN";
            case LmLnShdMtdDao:
                return "LM_LN_SHD_MTD";
        }
        throw new RuntimeException("not found enum");
    }


    public static CfgTableNameEnum  getEnum(String cfgTableName) {
        if ("LM_MRTY_EXTN_LOG".equals(cfgTableName)) {
            return LmMrtyExtnLogDao;
        }
        if ("LM_PYCL_TX".equals(cfgTableName)) {
            return LmPyclTxDao;
        }
        if ("LM_PM_LOG".equals(cfgTableName)) {
            return LmPmLogDao;
        }
        if ("lM_SETLMT_LOG".equals(cfgTableName)) {
            return LmSetlmtLogDao;
        }
        if ("LM_GLNO_LOG".equals(cfgTableName)) {
            return LmGlnoLogDao;
        }
        if ("LM_FEE_TX".equals(cfgTableName)) {
            return LmFeeTxDao;
        }
        if ("LM_PM_SHD".equals(cfgTableName)) {
            return LmPmShdDao;
        }
        if ("LM_LN_REPC_LOG".equals(cfgTableName)) {
            return LmLnRepcLogDao;
        }
        if ("LM_LN_INFO".equals(cfgTableName)) {
            return LmLnInfoDao;
        }
        if ("LM_LOAN".equals(cfgTableName)) {
            return LmLoanDao;
        }
        if ("LM_LN_SHD_MTD".equals(cfgTableName)) {
            return LmLnShdMtdDao;
        }
        throw new RuntimeException("not found enum");
    }
}
