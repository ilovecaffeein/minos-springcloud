package com.caxs.minos.serv.db;

/***
 * @ClassName(类名) : IBatcherService
 * @Description(描述) : 批处理接口。要实现批处理的必须继承此接口。 需实现Run方法。参数自己定义
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface IBatcherService extends Runnable{
    /**
     * 日终步骤入口
     */
    void runBatch();
}
