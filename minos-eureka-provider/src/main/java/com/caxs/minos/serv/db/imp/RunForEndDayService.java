package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.DeErrorLogDao;
import com.caxs.minos.dao.DeProcDao;
import com.caxs.minos.dao.DeProcLogDao;
import com.caxs.minos.domain.DeErrorLog;
import com.caxs.minos.domain.DeProc;
import com.caxs.minos.domain.DeProcLog;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.enums.JobStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.batch.LoanInteriorInfoModifyBatcher;
import com.caxs.minos.serv.batch.LoanRunForBeginDayBatcher;
import com.caxs.minos.serv.batch.LoanSuspensionBatcher;
import com.caxs.minos.serv.db.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/***
 * @ClassName(类名) : RunForEndDayService
 * @Description(描述) : 日终调度功能
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class RunForEndDayService implements IRunForEndDayService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    public static volatile int isexception = 0;// 判断子线程是否出错
    public static int lastStep = -1;
    private static volatile boolean isRunning = false;
    private static volatile int runingCount = 0;

    @Resource
    private ISystemInfoService systemInfoService;

    @Resource
    ILoanRunForBeginDayBatcherService iLoanRunForBeginDayBatcherService;

    @Resource
    ILoanInteriorInfoModifyBatcherService iLoanInteriorInfoModifyBatchService;

    @Resource
    ILoanSuspensionBatcherService iLoanSuspensionBatcherService;

    @Resource
    private DeProcDao deProcDao;

    @Resource
    private DeProcLogDao deProcLogDao;

    @Resource
    private DeErrorLogDao deErrorLogDao;

    public RunForEndDayService() {
    }

    public RunForEndDayService(int lastStep) {
        this.lastStep = lastStep;
        RunForEndDayService.setRunFlag();
    }

    @Override
    public void run() {

    }

    public static synchronized void incThreadCount() {
        runingCount++;
    }

    public static synchronized void decThreadCount() {
        runingCount--;
    }

    public static synchronized void setRunFlag() {
        if (RunForEndDayService.isRunning) {
            throw new MinosException("正在运行请不要重复跑批!");
        }
        RunForEndDayService.isRunning = true;
    }

    /**
     * 页面日终作业步骤主步骤
     * @author(作者) ： coffee
     * @return true ;false
     */
    @Override
    public void run(int lastStep,String dayEndDt) {
        try {
            this.lastStep = lastStep;
            startRun(dayEndDt);
        } finally {
            isRunning = false;
        }
    }

    /**
     * 批量日终作业步骤主步骤
     * @author(作者) ： coffee
     * @return true ;false
     */
    @Override
    public void run(int lastStep , String  mtdDtlSeq, String dayEndDt) {
        try {
            this.lastStep = lastStep;
            startRun(mtdDtlSeq,dayEndDt);
        } finally {
            isRunning = false;
        }
    }


    /**
     * 页面日终作业步骤主步骤
     * @author(作者) ： coffee
     * @return true ;false
     */
    public void startRun(String dayEndDt) {
        isexception = 0;
        DeProc deProc = null;
        try {
            List<DeProc> list = deProcDao.findAllForRun(YnFlagEnum.YES.getCodeInDb(), JobStateEnum.FIN.getCodeInDb(),
                    dayEndDt, YnFlagEnum.YES.getCodeInDb());
            Iterator<DeProc> itor = list.iterator();
            while (itor.hasNext()) {
                deProc = itor.next();
                DeProcLog deProcLog = new DeProcLog();
                deProcLog.setSeqNo(deProc.getSeqNo());
                deProcLog.setPrcsDt(dayEndDt);
                deProcLog = deProcLogDao.selectOneByObject(deProcLog);
                if (deProcLog == null) {
                    continue;
                }
                if (lastStep > 0) {
                    int curStep = Integer.parseInt(deProcLog.getSeqNo());
                    if (curStep > lastStep) {
                        return;
                    }
                }
                String job = deProc.getJobExe().trim();
                if (job == null || "".equals(job)) {
                    continue;
                }
                String jobFrq = deProc.getJobFreq();
                if (jobFrq == null) {
                    continue;
                }
                if (JobStateEnum.RUN.getCodeInDb().equals(deProcLog.getJobSts())) {
                    throw new Exception("当前节点正在运行，请稍后执行！");
                }
                //设置状态为处理中状态
                deProcLog.setJobSts(JobStateEnum.RUN.getCodeInDb());
                deProcLog.setStartRunTime(new SimpleDateFormat(
                        "HH:mm:ss").format(new Date()));// 任务开始时间
                deProcLog.setMacTime(new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss").format(new Date()));
                deProcLogDao.update(deProcLog);

                // 运行程序
                BatchJobContextTrans jobContext = null;
                try {
                    jobContext = new BatchJobContextTrans(deProc.getJobExe(), deProc.getJobNam(),
                            systemInfoService.getBuzDate(), systemInfoService.getDefaultBankCde(), null, null,
                            deProc.getMutiThread(), String.valueOf(deProc.getThreadCnt()),
                            systemInfoService.isNight(), deProc.getMutiMumber(), deProc.getMutiAbort(),deProc.getJobExe());
                    jobContext.setMainFunctionName(deProc.getMainFuncName());
                    this.reflect(jobContext, list.size());
                } catch (Exception e) {
                    isexception = -1;
                    deProcLog.setErrMsg(e.toString());
                }
                List<DeErrorLog> deErrorLogList = deErrorLogDao.selectListByObject(new DeErrorLog(dayEndDt,deProc.getJobExe()));
                if (!CollectionUtils.isEmpty(deErrorLogList))
                    isexception = -1;
                if (isexception == 0 ) {
                    deProcLog.setJobSts(JobStateEnum.FIN.getCodeInDb());
                    deProcLog.setErrMsg("");
                } else {
                    isexception = -1;
                    deProcLog.setJobSts(JobStateEnum.ERR.getCodeInDb());
                }
                deProcLog.setJobNam(deProc.getJobNam());
                deProcLog.setJobTyp(deProc.getJobTyp());
                deProcLog.setMacTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                deProcLogDao.update(deProcLog);
                if (isexception == -1) {
                    if (YnFlagEnum.YES.getCodeInDb().equals(deProcLog.getIgnoreFlag())) {
                        throw new Exception("执行日终调度处理失败！");
                    }
                }
            }
        } catch (Exception re) {
            re.printStackTrace();
            throw new MinosException("执行日终调度处理失败!",re);
        } finally {
        }
        return;
    }


    /**
     * 调度平台日终作业步骤主步骤
     * @author(作者) ： coffee
     * @return true ;false
     */
    public void startRun(String mtdDtlSeq,String dayEndDt) {
        isexception = 0;
        DeProc deProc = null;
        try {
            List<DeProc> list = deProcDao.findAllForRuning(YnFlagEnum.YES.getCodeInDb(), JobStateEnum.FIN.getCodeInDb(),
                    dayEndDt, YnFlagEnum.YES.getCodeInDb(), mtdDtlSeq);
            Iterator<DeProc> itor = list.iterator();
            while (itor.hasNext()) {
                deProc = itor.next();
                DeProcLog deProcLog = new DeProcLog();
                deProcLog.setSeqNo(deProc.getSeqNo());
                deProcLog.setPrcsDt(dayEndDt);
                deProcLog = deProcLogDao.selectOneByObject(deProcLog);
                if (deProcLog == null) {
                    continue;
                }
                if (lastStep > 0) {
                    int curStep = Integer.parseInt(deProcLog.getSeqNo());
                    if (curStep > lastStep) {
                        return;
                    }
                }
                String job = deProc.getJobExe().trim();
                if (job == null || "".equals(job)) {
                    continue;
                }
                String jobFrq = deProc.getJobFreq();
                if (jobFrq == null) {
                    continue;
                }
                if (JobStateEnum.RUN.getCodeInDb().equals(deProcLog.getJobSts())) {
                    throw new Exception("当前节点正在运行，请稍后执行！");
                }
                //设置状态为处理中状态
                deProcLog.setJobSts(JobStateEnum.RUN.getCodeInDb());
                deProcLog.setStartRunTime(new SimpleDateFormat(
                        "HH:mm:ss").format(new Date()));// 任务开始时间
                deProcLog.setMacTime(new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss").format(new Date()));
                deProcLogDao.update(deProcLog);

                // 运行程序
                BatchJobContextTrans jobContext = null;
                try {
                    jobContext = new BatchJobContextTrans(deProc.getJobExe(), deProc.getJobNam(),
                            systemInfoService.getBuzDate(), systemInfoService.getDefaultBankCde(), null, null,
                            deProc.getMutiThread(), String.valueOf(deProc.getThreadCnt()),
                            systemInfoService.isNight(), deProc.getMutiMumber(), deProc.getMutiAbort(),deProc.getJobExe());
                    jobContext.setMainFunctionName(deProc.getMainFuncName());
                    this.reflect(jobContext, list.size());
                } catch (Exception e) {
                    isexception = -1;
                    deProcLog.setErrMsg(e.getMessage());
                }
                List<DeErrorLog> deErrorLogList = deErrorLogDao.selectListByObject(new DeErrorLog(dayEndDt,deProc.getJobExe()));
                if (!CollectionUtils.isEmpty(deErrorLogList))
                    isexception = -1;
                if (isexception == 0) {
                    deProcLog.setJobSts(JobStateEnum.FIN.getCodeInDb());
                    deProcLog.setErrMsg("");
                } else {
                    isexception = -1;
                    deProcLog.setJobSts(JobStateEnum.ERR.getCodeInDb());
                }
                deProcLog.setJobNam(deProc.getJobNam());
                deProcLog.setJobTyp(deProc.getJobTyp());
                deProcLog.setMacTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                deProcLogDao.update(deProcLog);
                if (isexception == -1) {
                    if (YnFlagEnum.YES.getCodeInDb().equals(deProcLog.getIgnoreFlag())) {
                        throw new Exception("执行日终调度处理失败！");
                    }
                }
            }
        } catch (Exception re) {
            throw new MinosException("执行日终调度处理失败!",re);
        } finally {
        }
        return;
    }

    /**
     * 日终作业步骤主方法
     * @author(作者) ： coffee
     * @return true ;false
     */
    private synchronized void reflect(BatchJobContextTrans jobContext, int size)
            throws Exception {
        if ( runingCount > 0 ) {
            throw new MinosException("还有线程数在运行,请等待！");
        }
        try {
            String jobExe = jobContext.getJobExe();
            if (log.isDebugEnabled())
                log.debug("日终批处理：" + jobExe + " 开始！");
            Class<? extends Serializable> destClass  = (Class<? extends Serializable>) Class.forName(
                    BatcherCodeEnum.NULL.getWholePath(jobExe));
            log.debug("日终批处理类：" + destClass);
            if ( destClass.newInstance() instanceof LoanRunForBeginDayBatcher)
                iLoanRunForBeginDayBatcherService.runBatch(jobContext);//日终初始化处理
            else if( destClass.newInstance() instanceof LoanInteriorInfoModifyBatcher)
                iLoanInteriorInfoModifyBatchService.runBatch(jobContext);//内部信息变更批处理
            else if( destClass.newInstance() instanceof LoanSuspensionBatcher)
                iLoanSuspensionBatcherService.runBatch(jobContext);//贷款停息
            else
                throw new MinosException("无效的日终步骤节点参数配置！");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
