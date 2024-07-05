package com.caxs.minos.serv.db;

/***
 * @ClassName(类名) : IRunForEndDayService
 * @Description(描述) : 日终批量调用
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface IRunForEndDayService extends Runnable{
    /**
     * 日终作业步骤主方法
     * @author(作者) ： coffee
     * @return true ;false
     */
    void run(int lastStep,String dayEndDt);
    /**
     * 日终作业步骤主方法
     * @author(作者) ： coffee
     * @return true ;false
     */
    void run(int lastStep , String  mtdDtlSeq, String dayEndDt);
}
