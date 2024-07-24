package com.caxs.minos.enums;

import com.caxs.minos.exception.MinosException;
/**
 * @ClassName: ServBuzCode
 * @Description: 交易码
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum ServBuzCodeEnum {
    serv10000100027, // 日终初始化
    serv10000100040, // 核算内部信息更新
    STARNDARD, NULL;

    /**
     * 返回字符串编码
     * @return
     */
    public String getCode() {
        switch (values()[ordinal()]) {
            case serv10000100027:
                return "Serv10000100027Buz";
            case serv10000100040:
                return "Serv10000100040Buz";
        }
        throw new MinosException("not found");
    }

    /**
     * 获取对应交易处理类路径
     * @return
     */
    public String getWholePath(String key) {
        String head = "com.caxs.minos.controller.";
        if ("serv10000100027".equals(key)) {
            return  head + "Serv10000100027Buz";
        }
        if ("serv10000100040".equals(key)) {
            return head + "Serv10000100040Buz";
        }
        throw new MinosException("not found");
    }
}
