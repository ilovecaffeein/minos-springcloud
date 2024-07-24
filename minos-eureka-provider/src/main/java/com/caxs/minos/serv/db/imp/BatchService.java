package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.DeAtpyJobsDao;
import com.caxs.minos.dao.DeProcDao;
import com.caxs.minos.dao.DeProcLogDao;
import com.caxs.minos.dao.SCtrlDao;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.DeProc;
import com.caxs.minos.domain.DeProcLog;
import com.caxs.minos.domain.SCtrl;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BranchLevelEnum;
import com.caxs.minos.enums.JobRunStateEnum;
import com.caxs.minos.enums.JobStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IBatchService;
import com.caxs.minos.serv.db.ISystemInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/***
 * @ClassName(类名) : BatchService
 * @Description(描述) : 日终初始化节点
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class BatchService  implements IBatchService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    private ISystemInfoService systemInfoService;
    @Resource
    private DeAtpyJobsDao  deAtpyJobsDao;
    @Resource
    private DeProcDao  deProcDao;
    @Resource
    private DeProcLogDao deProcLogDao;
    @Resource
    private SCtrlDao  sCtrlDao;


    /**
     * 生成日终作业步骤
     * @author(作者) ： coffee
     * @return true ;false
     */
    public synchronized void genNightBatchStep() {
        checkStep(true);
        genBatchEndDayStep(true);
    }

    /**
     * 检查当天扣款任务包
     */
    @Override
    public void checkJobValidate(BatchJobContextTrans jobContext,
                                 String bussType) {
        DeAtpyJobs deAtpyJobs = new DeAtpyJobs();
        deAtpyJobs.setBussTyp(bussType);
        deAtpyJobs.setAtpyDt(jobContext.getBuzDate());
        deAtpyJobs.setNight(jobContext.getNightStrToDb());
        List<DeAtpyJobs> all = deAtpyJobsDao.selectListByObject(deAtpyJobs);
        if (CollectionUtils.isEmpty(all)) {
            throw new MinosException("没有产生出当天的扣款任务包，请检查机构信息");
        }
    }


    /**
     * 作业步骤验证
     * @author(作者) ： coffee
     * @return true ;false
     */
    private List<DeProc> checkStep(boolean isNight) {
        String buzDate =systemInfoService.getBuzDate();
        List<DeProc> deprocList = deProcDao.findAllForRun("Y", "FIN", buzDate, isNight ? "Y" : "N");
        String desc = isNight ? "日终" : "日初";
        if (CollectionUtils.isEmpty(deprocList)) {
            throw new MinosException("今天已经生成过" + desc + "任务,不能重复生成");
        }
        return deprocList;
    }

    /**
     * 生成日间作业步骤
     * @author(作者) ： coffee
     * @return true ;false
     */
    public void genDayTimeBatchStep(boolean isNight) {
        String  buzDate =systemInfoService.getBuzDate();
        List<DeProc> deprocList = deProcDao.findAllForRun("Y", "FIN", buzDate, isNight ? "Y" : "N");
        String desc = isNight ? "日终" : "日初";
        if (deprocList.size() == 0) {
            throw new MinosException("今天已经生成过" + desc + "任务,不能重复生成");
        }
        List<DeProcLog> loglist = new ArrayList<DeProcLog>(deprocList.size());
        for (DeProc dp : deprocList) {
            if( "160".equals(dp.getSeqNo()) ||  "161".equals(dp.getSeqNo()) ||
                    "162".equals(dp.getSeqNo()) ||  "163".equals(dp.getSeqNo()) ||
                    "164".equals(dp.getSeqNo()) ||  "165".equals(dp.getSeqNo())){
                DeProcLog deProcLog = new DeProcLog();
                deProcLog.setSeqNo(dp.getSeqNo());
                deProcLog.setPrcsDt(buzDate);
                deProcLog.setJobSts(JobStateEnum.INIT.getCodeInDb());
                deProcLog.setJobNam(dp.getJobNam());
                deProcLog.setJobTyp("JAVA");
                deProcLog.setIgnoreFlag(dp.getJobAbort());
                //deProcLog.setJobCanal("");
                //deProcLog.setJobSeq("");
                loglist.add(deProcLog);
            }
        }
        deProcLogDao.insertList(loglist);
    }

    /**
     * 生成日终作业步骤
     * @author(作者) ： coffee
     * @return true ;false
     */
    private void genBatchDayStep(boolean isNight) {
        String  buzDate =systemInfoService.getBuzDate();
        List<DeProc> deprocList = deProcDao.findAllForRun("Y", "FIN", buzDate, isNight ? "Y" : "N");
        String desc = isNight ? "日终" : "日初";
        if (deprocList.size() == 0) {
            throw new MinosException("今天已经生成过" + desc + "任务,不能重复生成");
        }
        List<DeProcLog> loglist = new ArrayList<DeProcLog>(deprocList.size());
        for (DeProc dp : deprocList) {
            if( "160".equals(dp.getSeqNo()) ||  "161".equals(dp.getSeqNo()) ||
                "162".equals(dp.getSeqNo()) ||  "163".equals(dp.getSeqNo()) ||
                "164".equals(dp.getSeqNo()) ||  "165".equals(dp.getSeqNo()) ||
                "166".equals(dp.getSeqNo()) ||  "167".equals(dp.getSeqNo()) ||
                "168".equals(dp.getSeqNo()) ||  "169".equals(dp.getSeqNo()) ||
                "170".equals(dp.getSeqNo())	){
                DeProcLog deProcLog = new DeProcLog();
                deProcLog.setSeqNo(dp.getSeqNo());
                deProcLog.setPrcsDt(buzDate);
                deProcLog.setJobSts(JobStateEnum.INIT.getCodeInDb());
                deProcLog.setJobNam(dp.getJobNam());
                deProcLog.setJobTyp("JAVA");
                deProcLog.setIgnoreFlag(dp.getJobAbort());
                loglist.add(deProcLog);
            }
        }
        deProcLogDao.insertList(loglist);
    }


    private void genBatchEndDayStep(boolean isNight) {
        String  buzDate =systemInfoService.getBuzDate();
        List<DeProc> deprocList = deProcDao.findAllForRun("Y", "FIN", buzDate, isNight ? "Y" : "N");
        String desc = isNight ? "日终" : "日初";
        if (deprocList.size() == 0) {
            throw new MinosException("今天已经生成过" + desc + "任务,不能重复生成");
        }
        List<DeProcLog> loglist = new ArrayList<DeProcLog>(deprocList.size());
        for (DeProc dp : deprocList) {
            DeProcLog deProcLog = new DeProcLog();
            deProcLog.setSeqNo(dp.getSeqNo());
            deProcLog.setPrcsDt(buzDate);
            deProcLog.setJobSts(JobStateEnum.INIT.getCodeInDb());
            deProcLog.setJobNam(dp.getJobNam());
            deProcLog.setJobTyp("JAVA");
            deProcLog.setIgnoreFlag(dp.getJobAbort());
            loglist.add(deProcLog);
        }
        deProcLogDao.insertList(loglist);
    }


    /***
     * @ClassName(类名) : saveSystemChangeDate
     * @Description(描述) : 系统换日
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/4 18:47
     */
    public void saveSystemChangeDate(BatchJobContextTrans bjc) {

        String procsDt = systemInfoService.getBuzDate();// 当前业务日期
        Date procsDate = DateOperation.parseStringToDate(procsDt);
        Calendar calen = Calendar.getInstance();
        calen.setTime(procsDate);
        calen.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calen.getTime();
        calen.add(Calendar.DAY_OF_YEAR, 1);
        Date afterTomrw = calen.getTime();

        SCtrl  sctrl = sCtrlDao.selectOneByObject(new SCtrl());
        sctrl.setCurPrcsDt(DateOperation.getDateStringToDb(tomorrow));
        sctrl.setNextPrcsDt(DateOperation.getDateStringToDb(afterTomrw));
        sctrl.setLastPrcsDt(DateOperation.getDateStringToDb(procsDate));
        sctrl.setIntfInd("C");
        sCtrlDao.update(sctrl);

        try {
            systemInfoService.enterNewDayTime();
        } catch (Exception e) {
            e.printStackTrace();
            throw new MinosException("系统换日处理失败", e);
        }

    }

    /**
     * 生成还款任务
     * @param bussType
     * @param jobContext
     */
    @Override
    public void generateRepayTask(BatchJobContextTrans jobContext,String bussType) {
        log.debug((jobContext.getIsNight()?"日终":"日初")+ "生成类型为【"+bussType+"】的扣款任务");
        if (YnFlagEnum.YES.getCodeInDb().equals(jobContext.getMutiThread())) {
            generateRepayTaskByThdCnt(bussType, jobContext, BranchLevelEnum
                    .getEnum(jobContext.getBatchBranchLevel()),jobContext.getIsNight());
        } else
            generateRepayTask(bussType, jobContext, BranchLevelEnum
                    .getEnum(jobContext.getBatchBranchLevel()),jobContext.getIsNight());
    }


    /**
     * 此种模式下，机构存放线程数
     *
     * @param bussType
     * @param jobContext
     * @param isNight
     * @param bl
     */
    public void generateRepayTaskByThdCnt(String bussType,
                                          BatchJobContextTrans jobContext,
                                          BranchLevelEnum bl,boolean isNight) {

        String fileSeq="0";
        fileSeq= systemInfoService.getPayPkgSeq();
        if (log.isDebugEnabled())
            log.debug("生成扣款条目");
        String buzDate = jobContext.getBuzDate();
        List<DeAtpyJobs> jobList = new ArrayList<DeAtpyJobs>();
        String noFlag = YnFlagEnum.NO.getCodeInDb();
        String startFlag = JobRunStateEnum.START.getCodeInDb();
        String jobState = JobStateEnum.INIT.getCodeInDb();
        // 如果当天的某个机构某个工作类型仅能产生一条，无论什么状态。
        List<DeAtpyJobs> existsJobList = deAtpyJobsDao.selectListByObject(new DeAtpyJobs(bussType,buzDate));
        String thdCnt = jobContext.getThreadCnt() == null ? "1" : jobContext
                .getThreadCnt();
        for (int i = 0; i < Integer.valueOf(thdCnt); i++) {
            String atpySeq;
            DeAtpyJobs job = new DeAtpyJobs();
            job.setBussTyp(bussType);
            job.setBchCde(String.valueOf(i));
            // 货币代码
            job.setCcyCde("");//
            job.setAtpyDt(buzDate);
            job.setAtpySts(jobState);
            job.setAtpyexpSts(startFlag);
            job.setNight(isNight ? "Y" : "N");
            // 文件未发送核心
            job.setAtpyToCorebankSts(noFlag);
            job.setAtpyexpUdpSts(noFlag);
            // /没有创建的job才会创建
            DeAtpyJobs oldJob = hasJobCreated(existsJobList, job);
            atpySeq = systemInfoService.getPayPkgSeq();
            if (oldJob == null) {
                job.setFileSeq("Y".equals(jobContext.getMutiAbort()) ? systemInfoService.getPayPkgSeq() :fileSeq );
                job.setAtpySeqNo(atpySeq);
                jobList.add(job);
            } else {
                oldJob.setFileSeq(atpySeq);
                deAtpyJobsDao.update(oldJob);
            }
        }
        if (!CollectionUtils.isEmpty(jobList))
            try {
                deAtpyJobsDao.saveList(jobList);
            } catch (RuntimeException re) {
                throw new MinosException(re.getMessage(), re);
            }
    }


    /**
     * 生成还款任务
     * @param bussType
     * @param jobContext
     * @param isNight
     * @param bl
     */
    public void generateRepayTask(String bussType,BatchJobContextTrans jobContext,
                                  BranchLevelEnum bl,boolean isNight) {
        String fileSeq="0";
        fileSeq=systemInfoService.getPayPkgSeq();
        List<DeAtpyJobs> jobList = new ArrayList<DeAtpyJobs>();
        String noFlag = YnFlagEnum.NO.getCodeInDb();
        String startFlag = JobRunStateEnum.START.getCodeInDb();
        String jobState = JobStateEnum.INIT.getCodeInDb();
        // 如果当天的某个机构某个工作类型仅能产生一条，无论什么状态。
        List<DeAtpyJobs> existsJobList = deAtpyJobsDao.findJobExistsByBuzi(bussType, jobContext.getBuzDate());
        String atpySeq;
        DeAtpyJobs job = new DeAtpyJobs();
        job.setBussTyp(bussType);
        job.setBchCde(jobContext.getBankCde());
        // 货币代码
        job.setCcyCde("");//
        job.setAtpyDt(jobContext.getBuzDate());
        job.setAtpySts(jobState);
        job.setAtpyexpSts(startFlag);
        job.setNight(isNight ? "Y" : "N");
        // 文件未发送核心
        job.setAtpyToCorebankSts(noFlag);
        job.setAtpyexpUdpSts(noFlag);
        // /没有创建的job才会创建
        DeAtpyJobs oldJob = hasJobCreated(existsJobList, job);
        atpySeq = String.valueOf(fileSeq);
        if (oldJob == null) {
            job.setFileSeq(fileSeq);
            job.setAtpySeqNo(atpySeq);
            jobList.add(job);
        } else {
            oldJob.setFileSeq(atpySeq);
            deAtpyJobsDao.update(oldJob);
        }
        if (!CollectionUtils.isEmpty(jobList))
            try {
                deAtpyJobsDao.saveList(jobList);
            } catch (RuntimeException re) {
                throw new MinosException(re.getMessage(), re);
            }
    }

    /**
     * 检查工作是否创建
     *
     * @param existJobList
     * @param newJob
     * @return
     */
    private DeAtpyJobs hasJobCreated(List<DeAtpyJobs> existJobList,
                                     DeAtpyJobs newJob) {
        for (DeAtpyJobs job : existJobList) {
            if (job.getAtpyDt().equals(newJob.getAtpyDt())) {
                if (job.getBchCde().equals(newJob.getBchCde())) {
                    if (newJob.getNight().equals(job.getNight())) {
                        return job;
                    }
                }
            }
        }
        return null;
    }

}
