package com.caxs.minos.utils;

import com.caxs.minos.def.MinosConst;
import org.xml.sax.SAXException;
import javax.naming.spi.ObjectFactory;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Algebra on 2018/5/18.
 * @description java原生xml_bean转换工具类
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 11:34
 */
public class JaxXmlUtil {

    /**
     * beanToxml
     * @param obj
     * @param load
     * @return
     * @throws JAXBException
     */
    public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();
        // 格式化输出xml(换行)
        // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 设置输出xml编码格式
        marshaller.setProperty(Marshaller.JAXB_ENCODING, MinosConst.FILE_CHARGBK);
        // 设置空值标签的输出
        //marshaller.setListener(new MarshallerListener());
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        // 去掉standalone属性
        return writer.toString().replace("standalone=\"yes\"", "");
    }

    /**
     * xmlToBean
     * @param xml
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T xmlToBean(String xml, Class<T> c) throws JAXBException {
        T t = null;
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        t = (T) unmarshaller.unmarshal(new StringReader(xml));
        return t;
    }

    /**
     * 转换xml文件
     * @param input
     * @param classPath
     * @param schemaResPath
     * @param classLoader
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    public static Object unmarshal(InputStream input, String classPath, String schemaResPath, ClassLoader classLoader)throws JAXBException, SAXException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classPath, classLoader);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        if (schemaResPath != null && !schemaResPath.isEmpty()) {
            URL schemaURL = classLoader.getResource(schemaResPath);
            Schema schema = schemaFactory.newSchema(schemaURL);
            unmarshaller.setSchema(schema);
        }
        Object obj = unmarshaller.unmarshal(input);
        return obj;
    }

    /**
     *	读取xml文件
     * @param fi
     * @return
     * @throws Exception
     */
    public static Object convertor(String fi) throws Exception {
        ClassLoader classLoader = ObjectFactory.class.getClassLoader();
        String contextPath = ObjectFactory.class.getPackage().getName();
        File file = new File(fi);
        if (!file.isDirectory()) {
            InputStream input = new FileInputStream(file);
            Object bean = JaxXmlUtil.unmarshal(input, contextPath, null, classLoader);
            return bean;
        } else {
            File[] fs = file.listFiles();
            List<Object> list = new ArrayList<Object>();
            for (int i = 0; i < fs.length; i++) {
                InputStream input = new FileInputStream(fs[i]);
                Object bean = JaxXmlUtil.unmarshal(input, contextPath, null, classLoader);
                list.add(bean);
            }
            return list;
        }
    }

}
