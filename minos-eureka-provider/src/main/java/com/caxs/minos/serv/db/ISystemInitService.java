package com.caxs.minos.serv.db;

/***
 * @ClassName(类名) : SystemInit
 * @Description(描述) : TODD
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/8/19 14:35
 */
public interface ISystemInitService {

    /**
     *在这里初始化
     */
     abstract void findInit();

    /**
     * 返回业务时间
     *
     * @return
     */
    String findBuzDate();

    /**
     * 返回系统时间
     *
     * @return
     */
     String findSysTemDate();

}
