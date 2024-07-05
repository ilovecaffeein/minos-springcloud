package com.caxs.minos.enums;

/**
 * @ClassName: RoundingModeEnum
 * @Description: 修约模式枚举
 * @Author: zhuruilong
 * @Date: 2020/7/28 15:32
 * @Version: v1.0 文件初始创建
 */

public enum RoundingModeEnum {
    /**
     * 四舍五入
     */
    FOUR_REMOVE_FIVE_UP(1, "F", "四舍五入"),
    /**
     * 四舍六入五留双规则
     */
    FOUR_REMOVE_SIX_UP(2, "S", "四舍六入五留双规则");

    private int intCode;
    private String strCode;
    private String desc;

    RoundingModeEnum(int intCode, String strCode, String desc) {
        this.intCode = intCode;
        this.strCode = strCode;
        this.desc = desc;
    }

    public static RoundingModeEnum getByIntCode(int intCode) {
        for (RoundingModeEnum modeEnum : RoundingModeEnum.values()) {
            if (modeEnum.intCode == intCode) {
                return modeEnum;
            }
        }
        return null;
    }

    public static RoundingModeEnum getByStrCode(String strCode) {
        for (RoundingModeEnum modeEnum : RoundingModeEnum.values()) {
            if (strCode.equals(modeEnum.strCode)) {
                return modeEnum;
            }
        }
        return null;
    }

    public int getIntCode() {
        return intCode;
    }

    public String getStrCode() {
        return strCode;
    }

    public String getDesc() {
        return desc;
    }
}
