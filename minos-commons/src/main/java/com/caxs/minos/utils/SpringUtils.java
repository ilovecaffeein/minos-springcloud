package com.caxs.minos.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * @ClassName: SpringUtils
 * @Description: ClassPathXmlApplicationContext 应用
 * @Author: coffee
 * @Date: 2020/7/28 14:39
 * @Version: v1.0 文件初始创建
 */
@Component
public class SpringUtils  implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 从容器根据配置的bean 名称 取出bean
     * @Author: coffee
     * @Date: 2020/7/28 14:39
     * @param beanName
     * @return
     */
    public static Object fetchBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    /**判断切割函数
     * @author coffee
     * @param splitDay
     * @return true
     */
    public static boolean splitDayBool(String splitDay, String Day) {
        String[] paramArray = splitDay.split(",");
        for (String val : paramArray) {
            if( Day.equals(val)){	return true; }
        }
        return false;
    }

    public static boolean isNullOrEmpty(String   collection) {
        return collection != null && collection.isEmpty();
    }
}
