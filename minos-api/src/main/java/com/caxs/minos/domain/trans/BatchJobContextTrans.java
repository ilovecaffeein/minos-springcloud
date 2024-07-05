package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
/***
 * @ClassName(类名) : BatchJobContextTrans
 * @Description(描述) : 日终参数赋值封装
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class BatchJobContextTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    //任务编号
    private String seqNo;
    //任务代码
    private String jobExe;
    //任务名称
    private String jobName;
    //任务名称
    private String batchBeanName;
    //错误数
    private AtomicInteger errCount = new AtomicInteger(0);
    //线程总数
    public final static int threadTotal = 100;
    //记录数
    private int recCount = 0;
    //备份序列号
    private long backupSeqNo;
    //交易码
    //private TransCode transCode;
    //是否日终
    private boolean isNight = true;

    //业务日期
    private String buzDate;
    //银行机构号
    private String bankCde;
    //处理机构号
    private String bchCde;
    //借据号
    private String loanNo;

    private String mutiThread; // 是否允许多线程

    private String threadCnt; // 最大线程数

    private String atpySeqNo;

    private String transCode;			//交易码

    private String pchCde;			//交易码
    /**
     * 假期天数
     */
    private int holidayCount = 0;
    //获取假期天数
    public int getHolidayCount() {
        return holidayCount;
    }
    //设置假期天数
    public void setHolidayCount(int holidayCount) {
        this.holidayCount = holidayCount;
    }

    /**
     * 线程机构级别
     */
    private int batchBranchLevel = 1;

    //获取线程机构级别
    public int getBatchBranchLevel() {
        return batchBranchLevel;
    }


    //获取交易机构码
    public String getBchCde() {
        return bchCde;
    }

    //获取日终模式
    public boolean getIsNight() {
        return isNight;
    }

    /**
     * 线程数条件
     */
    private String threadCntStr;
    //获取线程数条件
    public String getThreadCntStr() {
        return threadCntStr;
    }

    //获取线程数条件
    public void setThreadCntStr(String threadCntStr) {
        this.threadCntStr = threadCntStr;
    }

    //渠道代码
    public void setPchCde(String pchCde ) {
        this.pchCde = pchCde;
    }

    //渠道代码
    public String getPchCde() {
        return this.pchCde;
    }

    //借据号
    public void setLoanNo(String loanNo) {
         this.loanNo = loanNo;
    }
    //借据号
    public String getLoanNo() {
        return this.loanNo;
    }

    //交易码
    public String getTransCode() {
        return this.transCode;
    }

    //获取银行码
    public String getBankCde() {
        return bankCde;
    }

    //获取当前业务日期
    public String getAtpySeqNo() {
        return atpySeqNo;
    }

    //获取当前业务日期
    public void setAtpySeqNo(String atpySeqNo ) {
        this.atpySeqNo = atpySeqNo;
    }

    //获取当前业务日期
    public String getBuzDate() {
        return buzDate;
    }

    //获取执行代码
    public String getJobNam() {
        return jobName;
    }


    /**
     * 主函数名字
     */
    private String mainFunctionName;

    //设置主函数名字
    public void setMainFunctionName(String mainFunctionName) {
        this.mainFunctionName = mainFunctionName;
    }
    //获取主函数名字
    public String getMainFunctionName() {
        return mainFunctionName;
    }

    public void setJobExe(String jobExe) {
        this.jobExe = jobExe;
    }

    public String getJobExe() {
        return jobExe;
    }
    //获取批处理入口类名
    public String getBatchBeanName() {
        return batchBeanName;
    }
    //设置批处理入口类名
    public void setBatchBeanName(String batchBeanName) {
        this.batchBeanName = batchBeanName;
    }

    //返回保存到数据库的是否日终属性
    public String getNightStrToDb() {
        return isNight ? "Y" : "N";
    }


    /**
     * 允许单个文件系号对应数据最大笔数
     */
    private long mutiMumber = 5000;

    public long getMutiMumber() {
        return mutiMumber;
    }
    public void setMutiMumber(Long mutiMumber) {
        this.mutiMumber = mutiMumber;
    }

    /**
     * 允许单个文件系号对应数据最大笔数
     */
    private String mutiAbort;

    public String getMutiAbort() {
        return mutiAbort;
    }
    public void setMutiAbort(String mutiAbort) {
        this.mutiAbort = mutiAbort;
    }

    //获取是否允许多线程数据
    public String getMutiThread() {
        return mutiThread;
    }

    /**
     * 线程号
     */
    private Short thdCnt;

    public Short getThdCnt() {
        return thdCnt;
    }

    public void setThdCnt(Short thdCnt) {
        this.thdCnt = thdCnt;
    }

    //获取最大线程数
    public String getThreadCnt() {
        return threadCnt;
    }


    /**
     * 外部渠道
     */
    private String outChn;

    public String getOutChn() {
        return outChn;
    }

    public void setOutChn(String outChn) {
        this.outChn = outChn;
    }

    private String[] filelist;


    public String[] getFilelist() {
        return filelist;
    }

    public void setFilelist(String[] filelist) {
        this.filelist = filelist;
    }


    //批处理上下文对象构造方法
    public BatchJobContextTrans(String jobExe , String jobName, String buzDate, String bankCde,
                                String bchCde, String loanNo, String mutiThread,
                                String threadCnt, boolean isNight, long mutiMumber, String mutiAbort,
                                String transCode) {
        super();
        this.jobName = jobName;
        this.buzDate = buzDate;
        this.bankCde = bankCde;
        this.bchCde = bchCde;
        this.loanNo = loanNo;
        this.mutiThread = mutiThread;
        this.threadCnt = threadCnt;
        this.isNight = isNight;
        this.jobExe = jobExe;
        this.mutiMumber=mutiMumber;
        this.mutiAbort=mutiAbort;
        this.transCode = transCode;
    }

    //复制对象方法
    public BatchJobContextTrans duplicate(int threadTotal, int threadCount,
                                     int threadCounter) {
        BatchJobContextTrans newObj = new BatchJobContextTrans(getJobExe(),getJobNam(),
                getBuzDate(), getBankCde(), null, null, getMutiThread(),
                getThreadCnt(), getIsNight(), getMutiMumber(),getMutiAbort(),getJobExe());

        newObj.batchBranchLevel = this.batchBranchLevel;
        newObj.batchBeanName = this.batchBeanName;
        newObj.mainFunctionName = this.mainFunctionName;
        if (threadCount == -1) {
            newObj.threadCntStr = "";
        } else {
            newObj.threadCntStr = getThreadAlloStr(
                    threadTotal, threadCount, threadCounter);
        }
        return newObj;
    }


    //复制对象方法
    public BatchJobContextTrans duplicate(String bchCde, String outChn, int threadTotal, int threadCount,
                                          int threadCounter) {
        BatchJobContextTrans newObj = new BatchJobContextTrans(getJobExe(),getJobNam(),
                getBuzDate(), getBankCde(), bchCde, null, getMutiThread(),
                getThreadCnt(), getIsNight(), getMutiMumber(),getMutiAbort(),getJobExe());

        newObj.batchBranchLevel = this.batchBranchLevel;
        newObj.batchBeanName = this.batchBeanName;
        newObj.mainFunctionName = this.mainFunctionName;
        newObj.outChn = outChn;
        if (threadCount == -1) {
            newObj.threadCntStr = "";
        } else {
            newObj.threadCntStr = getThreadAlloStr(
                    threadTotal, threadCount, threadCounter);
        }
        return newObj;
    }

    /**
     * 线程查找串
     *
     * @param total
     * @param threadCount
     * @param counter
     * @return
     */
    public String getThreadAlloStr(int total, int threadCount, int counter) {
        if (counter < 0) {
            return "";
        }
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < total; i++) {
            if (i % threadCount == counter) {
                rst.append("'").append(i).append("'").append(",");
            }
        }
        if (rst.length() > 0) {
            rst.deleteCharAt(rst.length() - 1);
        }
        return rst.toString();
    }

    public BatchJobContextTrans() {
    }
}
