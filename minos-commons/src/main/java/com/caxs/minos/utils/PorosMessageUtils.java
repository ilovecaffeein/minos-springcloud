package com.caxs.minos.utils;

import java.util.HashMap;
import java.util.Map;

/***
 * @ClassName(类名) : PorosMessageUtils
 * @Description(描述) : 支付平台报文处理工具
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/9 16:50
 */
public class PorosMessageUtils {


    /***
     * @param msg
     * @return boolean
     * @throws :
     * @Description(功能描述) :  写入缓存
     * @author(作者) ： fengdetian
     * @date (开发日期) :  2020年9月9日 上午11:29:14
     */
    public static Map<String,String> messageToMap(String msg){
        Map<String,String> map = new HashMap<>();
        String[] msgArray = msg.split("&");
        for (String str : msgArray){
            String[] strArray = str.split("=");
            map.put(strArray[0],strArray[1]);
        }
        return map;
    }
}
