package com.caxs.minos.enums;

/**
 * @ClassName: MtdSetLTypCodeEnum
 * @Description: 还款方式定义
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum MtdSetLTypCodeEnum {

    /**
     * 等额本息
     */
    MTD_SETL_TYP_T("T", "等额本息"),
    /**
     * 等额本金
     */
    MTD_SETL_TYP_P("P", "等额本金"), ;

    private String strCode;
    private String desc;

    MtdSetLTypCodeEnum(String strCode, String desc) {
        this.strCode = strCode;
        this.desc = desc;
    }

    public static MtdSetLTypCodeEnum getByIntCode(String strCode) {
        for (MtdSetLTypCodeEnum modeEnum : MtdSetLTypCodeEnum.values()) {
            if (modeEnum.strCode.equals(strCode)) {
                return modeEnum;
            }
        }
        return null;
    }

    public String getStrCode() {
        return strCode;
    }

    public String getDesc() {
        return desc;
    }
}
