package com.caxs.minos.utils;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.exception.MinosException;
import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
/**
 * @author coffee
 * @created 2020-08-19 16:32
 * @desc 读取xml 信息的工具类
 **/
public class MinosCommUtils {

    public  Serializable doFormXml(String xmlStr, Class cla){
        Serializable domain = null;
        // 数据转换
        try {
            domain = (Serializable) cla.newInstance();
           return mapTOdomain(domain, xmlStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MinosException(MinosConst.ERROR9999, e.getMessage());
        }
    }

    /**
     * 将 xml 转换成domain
     * @param domain
     * @param xml
     * @return
     */
    public static Serializable mapTOdomain(Serializable domain, String xml)
            throws MinosException {
        if (StringUtils.isBlank(xml)) {
            return null;
        }
        if (domain == null) {
            return null;
        }
        Class[] returnType = new Class[1];
        // 得到所有成员变量
        Field[] fields = domain.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            // 去成员变量名
            String str = fields[i].getName();
            if ("serialVersionUID".equals(str)) {
                continue;
            }
            // 在大写字母前加_ 首字母除外
            String formatName = StringUtil.getInstance()
                    .AddUnderlineByUppercase(str).toUpperCase();
            try {
                String sq1 = "get" + str.substring(0, 1).toUpperCase()
                        + str.substring(1, str.length());
                Method md1 = domain.getClass().getDeclaredMethod(sq1);
                if (md1 != null) {
                    returnType[0] = md1.getReturnType();
                    if (returnType[0].getName().endsWith("String")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                String.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (!StringUtils.isEmpty(kValue)) {
                            md.invoke(domain, kValue);
                        }
                    } else if (returnType[0].getName().endsWith("int")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                int.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (kValue != null  &&  kValue.length() != 0) {
                            md.invoke(domain, kValue);
                        }
                    } else if (returnType[0].getName().endsWith("Integer")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                Integer.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (kValue != null  &&  kValue.length() != 0) {
                            md.invoke(domain, kValue == null? "":new Integer(kValue));
                        }
                    } else if (returnType[0].getName().endsWith("double")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                double.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        md.invoke(domain, kValue == null? "":new Double(kValue));

                    } else if (returnType[0].getName().endsWith("Double")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                Double.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (kValue != null &&  kValue.length() != 0 ) {
                            md.invoke(domain, kValue == null? "":new Double(kValue));
                        }
                    } else if (returnType[0].getName().endsWith("BigDecimal")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,BigDecimal.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (!StringUtils.isEmpty(kValue)) {
                            BigDecimal bv = new BigDecimal(kValue);
                            md.invoke(domain, bv);
                        }
                    }
                    else if (returnType[0].getName().endsWith("Long")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                Long.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (!StringUtils.isEmpty(kValue)) {
                            md.invoke(domain, kValue == null? "":new Long(kValue));
                        }
                    } else if (returnType[0].getName().endsWith("Short")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                Short.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (!StringUtils.isEmpty(kValue)) {
                            md.invoke(domain, kValue == null? "":new Short(kValue));
                        }
                    } else if (returnType[0].getName().endsWith("Byte")) {
                        String sq = "set" + str.substring(0, 1).toUpperCase()
                                + str.substring(1, str.length());
                        Method md = domain.getClass().getDeclaredMethod(sq,
                                Byte.class);
                        String kValue = getFieldValue(formatName,xml) ;
                        if (!StringUtils.isEmpty(kValue)) {
                            md.invoke(domain, kValue == null? "":new Byte(kValue));
                        }
                    } else { // 注意如果上面的类型都没有匹配到,那么把它当做是另一个对象
                        // 比如组合主键中的ID 对象，所以上面的判断一定要涵盖所有bean对象中可能存在的类型
                        Serializable obj = (Serializable) returnType[0]
                                .newInstance();
                        if (obj != null) {
                            mapTOdomain(obj, xml);

                            String sq = "set"
                                    + str.substring(0, 1).toUpperCase()
                                    + str.substring(1, str.length());
                            Method md = domain.getClass().getDeclaredMethod(sq,
                                    obj.getClass());
                            md.invoke(domain, obj);
                        }
                    }
                }
            } catch (Exception e) {
                throw new MinosException(" XML 转为domain出错", e);
            }
        }
        return domain;
    }


    /** 获取xml格式的msg报文里field对应的值，field格式为<值> */
    public static String getFieldValue(String field, String msg) {
        String  str = "<" + field + ">" ;
        int beginIndex = msg.indexOf(str);
        if (beginIndex == -1) {
            return "";
        }
        int endIndex = msg.indexOf("</" + field );
        String fieldStr = msg.substring(beginIndex + str.length(), endIndex);
        return fieldStr;
    }
}
