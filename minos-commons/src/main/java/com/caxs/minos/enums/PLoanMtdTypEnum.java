package com.caxs.minos.enums;

/**
 * @ClassName: DateOperation
 * @Description: 还款类型定义
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum PLoanMtdTypEnum {
    T/*等额本息*/, P/*等额本金*/, L/*利随本清*/, A/*按期还息到期还本*/,
    X/*弹性还款*/, D/*气球贷*/, Y/*一次付息，到期返本*/, Q/*前期按月付息，后期等额本金/本息*/;
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case T:
                return "01";
            case P: {
                return "03";
            }
            case L: {
                return "05";
            }
            case A: {
                return "04";
            }
            case Y: {
                return "02";
            }
            case X: {
                return "07";
            }
            case D: {
                return "08";
            }
            case Q: {
                return "10";
            }
        }
        throw new RuntimeException("not found enum");
    }


    //获取本金利息状态代码对应枚举值
    public static PLoanMtdTypEnum getEnum(String prcpState) {
        if ("01".equals(prcpState)) {
            return T;
        }
        if ("03".equals(prcpState)) {
            return P;
        }
        if ("05".equals(prcpState)) {
            return L;
        }
        if ("04".equals(prcpState)) {
            return A;
        }
        if ("02".equals(prcpState)) {
            return Y;
        }
        if ("07".equals(prcpState)) {
            return X;
        }
        if ("08".equals(prcpState)) {
            return D;
        }
        if ("10".equals(prcpState)) {
            return Q;
        }
        throw new RuntimeException("not found enum");
    }
}
