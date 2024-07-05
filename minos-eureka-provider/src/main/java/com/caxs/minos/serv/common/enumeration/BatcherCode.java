package com.caxs.minos.serv.common.enumeration;

import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.core.CoreConst;
/**
 * @ClassName: BatcherCode
 * @Description: 日终作业函数
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum BatcherCode {
    LNAM, // 日终初始化
    LNAO, // 贷款展期
    LN12, // 贷款展期
    STARNDARD, NULL,
    LNAF; // 贷款自动扣款


    /**
     * 返回字符串编码
     *
     * @return
     */
    public String getCode() {
        switch (values()[ordinal()]) {
            case LNAM:
                return "LNAM";
            case LNAO:
                return "LNAO";
            case LN12:
                return "LN12";
            case LNAF:
                return "LNAF";
        }
        throw new MinosException("not found");
    }
    //获取对应交易处理类路径
    public String getWholePath(String key) {
        String head = "com.caxs.minos.batch.";
        if ("LNAM".equals(key)) {
            return head + CoreConst.LNAM;
        }
        if ("LNAO".equals(key)) {
            return head + CoreConst.LNAO;
        }
        if ("LN12".equals(key)) {
            return head + CoreConst.LN12;
        }
        if ("LNAF".equals(key)) {
            return head + CoreConst.LNAF;
        }
        throw new MinosException("not found");
    }

}
