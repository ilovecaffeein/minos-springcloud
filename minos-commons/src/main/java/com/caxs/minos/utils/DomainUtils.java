package com.caxs.minos.utils;

import com.caxs.minos.domain.LmGlnoLog;
import com.caxs.minos.exception.MinosException;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @ClassName: DomainUtils
 * @Description: 域对象工具
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class DomainUtils {
    /**
     * 根据表名，计算javaBean名字
     *
     * @param tableName
     * @return
     */
    public static String calDomainName(String tableName) {
        if (tableName == null) {
            return null;
        }
        StringBuilder dn = new StringBuilder();
        tableName = tableName.toLowerCase();
        boolean chgUpper = true;
        for (char c : tableName.toCharArray()) {
            if (chgUpper) {
                dn.append(Character.toUpperCase(c));
            } else {
                if (c != '_')
                    dn.append(c);
            }
            chgUpper = c == '_';
        }
        return dn.toString();
    }

    //根据表名获取信贷系统的domain域
    public static Class<?> ycloansDomainClassByTableName(String tableName) {
        String domainName = new StringBuilder(
                "com.caxs.minos.domain.").append(calDomainName(tableName)).toString();
        try {
            return (Class<? extends Serializable>) Class.forName(domainName);
        } catch (ClassNotFoundException e) {
            throw new MinosException(domainName + "没有找到");
        }
    }

    //获取系统的domain域
    public static Class<?> ycloansDomainClass(String domainName) {

        try {
            domainName = new StringBuilder("com.caxs.minos.domain.")
                    .append(domainName).toString();
            return (Class<? extends Serializable>) Class.forName(domainName);
        } catch (ClassNotFoundException e) {
            throw new MinosException(domainName + "没有找到");
        }
    }

    /**
     * @Description: 获取删除key对应的具体值
     * @param keyField 删除操作对应的key
     * @param lmGlnoLog 交易流水
     * @Date: 2020/10/20 11:37
     * @Author: zhuruilong
     * @Return java.lang.Object
     * @Throws
     */
    public static Object getValue(String keyField, LmGlnoLog lmGlnoLog) {
        try {
            Class<? extends LmGlnoLog> aClass = lmGlnoLog.getClass();
            Field field = aClass.getDeclaredField(keyField);
            field.setAccessible(true);
            return field.get(lmGlnoLog);
        } catch (NoSuchFieldException | IllegalAccessException e) {

        }
        return "-1";
    }
}
