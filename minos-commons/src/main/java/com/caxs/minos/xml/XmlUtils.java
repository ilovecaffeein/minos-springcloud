package com.caxs.minos.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
/***
 * @ClassName(类名) : XmlUtils
 * @Description(描述) : Xml
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/8 11:02
 */
public class XmlUtils {
        /**
         * xml字符串转对象
         * @param clazz
         * @param xmlStr
         * @return
         */
        public static Object xmlStrToObject(Class clazz, String xmlStr) {
            Object xmlObject = null;
            try {
                JAXBContext context = JAXBContext.newInstance(clazz);
                // 进行将Xml转成对象的核心接口
                Unmarshaller unmarshaller = context.createUnmarshaller();
                StringReader sr = new StringReader(xmlStr);
                xmlObject = unmarshaller.unmarshal(sr);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return xmlObject;
        }

        /**
         * 对象转xml字符串
         * @param obj
         * @param load
         * @return
         * @throws JAXBException
         */
        public static String objectToXmlStr(Object obj,Class<?> load){
            String result = "";
            try{
                JAXBContext context = JAXBContext.newInstance(load);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.setProperty(Marshaller.JAXB_ENCODING, "GB2312");
                StringWriter writer = new StringWriter();
                marshaller.marshal(obj,writer);
                result = writer.toString();
            }catch (Exception e){
                e.printStackTrace();
            }
            return result;
        }
}
