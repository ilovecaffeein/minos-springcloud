package com.caxs.minos.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.Map;
/**
 * @ClassName: PayUtils
 * @Description: 对象操作工具类
 * @Author: cpffee
 * @Date: 2020/8/4 16:23
 * @Version: v1.0 文件初始创建
 */
public class PayUtils {
    public static String signDictionary(Map<String, String> paramVal, String[] paramKeys, String charset) {
        String charsetplus = StringUtils.isBlank(charset) ? "UTF-8" : charset;
        StringBuffer envsrc = new StringBuffer("");
        for (int i = 0; i < paramKeys.length; i++) {
            envsrc.append(paramKeys[i]).append("=").append(paramVal.get(paramKeys[i])).append("&");
        }
        return envsrc.toString();
    }
}
