package com.caxs.minos.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author(作者): coffee
 * @Description(方法描述): 读取配置文件
 * @Date(创建日期): Create in 13:34 2017/9/26
 * @Company: 【长安新生（深圳）金融投资有限公司】
 */

public class ReadProperties {

    private static final Logger logger = LoggerFactory.getLogger(ReadProperties.class);
    /**
     * @param propertiesFilename
     * @param property
     * @param vm
     * @return
     */
    public static String readPropertiesFromfiles(String propertiesFilename,String property,String vm){
        Properties props=System.getProperties();
        String confHome = props.getProperty(vm);
        logger.info(vm+ ":" + confHome);
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream( confHome+propertiesFilename );
            prop.load(in);
            String value = prop.getProperty(property);
            logger.info(value);
            in.close();
            return value;
        } catch (IOException e) {
            //e.printStackTrace();
            logger.info(e.getMessage());
        }

        return null;
    }
}

