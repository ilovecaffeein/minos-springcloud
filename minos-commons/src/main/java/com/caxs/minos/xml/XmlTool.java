package com.caxs.minos.xml;

import com.caxs.minos.utils.JaxXmlUtil;
import javax.xml.bind.JAXBException;
/**
 * Created by Algebra on 2018/5/18.
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 11:34
 */
public class XmlTool {
    /**
     * Jaxb方式BeanToXml
     * @param obj
     * @param load
     * @return
     * @throws
     */
    public static String buildXmlOfJaxb(Object obj, Class<?> load) throws JAXBException {
        return  JaxXmlUtil.beanToXml(obj,load);
    }

    /**
     * Jaxb方式XmlToBean
     * @param xmlStr
     * @param load
     * @param <T>
     * @return
     * @throws
     */
    public static <T>T resolveXmlOfJaxb(String xmlStr,Class<?> load) throws JAXBException {
        return (T) JaxXmlUtil.xmlToBean(xmlStr,load);
    }

}
