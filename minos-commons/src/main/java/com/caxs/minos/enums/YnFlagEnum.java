package com.caxs.minos.enums;


import com.caxs.minos.exception.MinosException;

/**
 * @ClassName: YnFlagEnum
 * @Description:  是否标志
 * @Author: coffee
 * @Date: 2020/7/28 15:32
 * @Version: v1.0 文件初始创建
 */
public enum YnFlagEnum {
    YES/*是*/, NO/*否*/, YnFlag;
    //获取是否标志对应的字符代码
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case YES:
                return "Y";
            case NO:
                return "N";
        }
        throw new RuntimeException("not found enum");
    }
    //是否为是
    public boolean isTrue() {
        return YES.equals(values()[ordinal()]);
    }

    /**
     * 是否成功
     *
     * @param flag
     * @return
     */
    public static boolean isTrue(String flag) {
        return YnFlagEnum.YES.equals(getEnum(flag));

    }
    //获取是否标志对应的枚举值
    public static YnFlagEnum getEnum(String code) {
        if ("Y".equals(code)) {
            return YES;
        } else if ("N".equals(code)) {
            return NO;
        }
        throw new MinosException("No defined enum Ynflag");
    }
    //获取是否标志对应的枚举值
    public static YnFlagEnum getEnum(boolean isTrue) {
        if (isTrue) {
            return YnFlagEnum.YES;
        } else
            return YnFlagEnum.NO;
    }

}
