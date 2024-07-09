package com.caxs.minos.serv.batch;

import com.caxs.minos.dao.DeAtpyJobsDao;
import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.AtpyJobTrans;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BranchLevelEnum;
import com.caxs.minos.enums.JobBussTypeEnum;
import com.caxs.minos.enums.JobStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.IBatchService;
import com.caxs.minos.serv.db.ILoanCalculateLateFeeBatcherService;
import com.caxs.minos.serv.db.INormIntAccrualSerivce;
import com.caxs.minos.serv.db.ISystemInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/***
 * @ClassName(类名) : LoanRunForBeginDayBatcher
 * @Description(描述) : 滞纳金结记
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanCalculateLateFeeBatcher implements ILoanCalculateLateFeeBatcherService {
    //线程总数
    public final static int threadTotal = 100;
    public static volatile Integer currentThread;// 用于保证执行的线程小于最大线程数
    public static volatile long fileMumberThread;// 允许单个文件系号对应数据最大笔数

    @Resource
    IBatchService batchService;

    @Resource
    DeAtpyJobsDao deAtpyJobsDao;

    @Resource
    private INormIntAccrualSerivce iNormIntAccrualSerivce;

    public LoanCalculateLateFeeBatcher() {
        super();
    }

    public BatcherCode getBatcherCode() {
        return BatcherCode.LNAE;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContextTrans) {
        List<Thread> threadList = new ArrayList<Thread>();

        // 防止重跑已经完成的任务.
        DeAtpyJobs deAtpyJobs =new DeAtpyJobs();
        deAtpyJobs.setBussTyp(JobBussTypeEnum.ALLLOAN.getCodeInDb());
        deAtpyJobs.setAtpySts(JobStateEnum.INIT.getCodeInDb());
        deAtpyJobs.setAtpyDt(batchJobContextTrans.getBuzDate());
        deAtpyJobs.setNight(batchJobContextTrans.getNightStrToDb());
        List<DeAtpyJobs> jobList = deAtpyJobsDao.selectListByObject(deAtpyJobs);
        if ( CollectionUtils.isEmpty(jobList) ) {
            batchService.generateRepayTask(batchJobContextTrans,JobBussTypeEnum.ALLLOAN.getCodeInDb());
            jobList = deAtpyJobsDao.selectListByObject(deAtpyJobs);

        }
        List<DeAtpyJobs> newJobList = new ArrayList<DeAtpyJobs>();
        if (!CollectionUtils.isEmpty(jobList)) {
            for (DeAtpyJobs oldJob : jobList) {
                newJobList.add(new AtpyJobTrans(true, oldJob).getJob());
            }
        }
        jobList = newJobList;
        currentThread = Integer.valueOf(batchJobContextTrans.getThreadCnt());
        fileMumberThread = batchJobContextTrans.getMutiMumber();

        if ( batchJobContextTrans.getMutiThread() != null
                && batchJobContextTrans.getMutiThread().equals(YnFlagEnum.YES.getCodeInDb())) {
            for (DeAtpyJobs job : jobList) {
                while (currentThread <= 0) {// 到达最大线程数时
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                BatchJobContextTrans  batchJobContext = batchJobContextTrans.duplicate(
                        threadTotal, Integer.parseInt(batchJobContextTrans.getThreadCnt()),Integer.parseInt(job.getBchCde()));
                Thread thread = new Thread(new LoanCalculateLateFeeJobBatcher(batchJobContext,job));
                thread.start();
                threadList.add(thread);
                currentThread--;
            }
        } else {
            for (DeAtpyJobs job : jobList) {
                new LoanCalculateLateFeeJobBatcher(batchJobContextTrans, job).run();
            }
        }
        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new MinosException(e);
            }
        }
    }
}