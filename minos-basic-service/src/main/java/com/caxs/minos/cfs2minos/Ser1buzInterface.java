package com.caxs.minos.cfs2minos;

import com.caxs.minos.exception.Cfs2MinosException;

import javax.xml.bind.JAXBException;

/***
 * @ClassName(类名) : Ser1buzInterface
 * @Description(描述) : 执行业务处理
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface Ser1buzInterface {
    /**
     * 执行业务处理
     * @param context
     * @throws
     */
    Object execute(String context) throws Cfs2MinosException, JAXBException;
}
