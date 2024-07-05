package com.caxs.minos.enums;

/**
 * @ClassName: DateOperation
 * @Description: 还款方式定义
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum PLoanMtdCodeEnum {
    /**
     * 利随本清
     */
    MTD_CODE_03("03", "利随本清"),
    /**
     * 按期还息到期还本
     */
    MTD_CODE_04("04", "按期还息到期还本"),
    /**
     * 等额本息
     */
    MTD_CODE_01("01", "等额本息"),
    /**
     * 等额本金
     */
    MTD_CODE_02("02", "等额本金"),
    /**
     * 弹性还款
     */
    MTD_CODE_07("07", "弹性还款"),
    /**
     * 气球贷
     */
    MTD_CODE_08("08", "气球贷"),
    /**
     * 利随本清
     */
    MTD_CODE_09("09", "一次付息，到期返本"),
    /**
     * 前期按月付息，后期等额本金/本息
     */
    MTD_CODE_10("10", "前期按月付息，后期等额本金/本息");

    private String strCode;
    private String desc;

    PLoanMtdCodeEnum(String strCode, String desc) {
        this.strCode = strCode;
        this.desc = desc;
    }

    public static PLoanMtdCodeEnum getByIntCode(String strCode) {
        for (PLoanMtdCodeEnum modeEnum : PLoanMtdCodeEnum.values()) {
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
