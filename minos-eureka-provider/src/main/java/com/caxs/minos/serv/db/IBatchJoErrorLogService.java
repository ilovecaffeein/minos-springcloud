package com.caxs.minos.serv.db;

/***
 * @ClassName(类名) : IBatchJoErrorLogService
 * @Description(描述) : 存放日志信息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface IBatchJoErrorLogService {
    /**
     * 保存错误信息
     *
     * @param errMsg
     * @param loanNo
     * @param errCode
     */
    public void saveErrLogNoIncCount(String loanNo,String buzDate,
                                     String jobName, String errMsg, String errCode) ;
}
