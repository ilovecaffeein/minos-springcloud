package com.caxs.minos.serv.batch;

import com.caxs.minos.dao.DeAtpyJobsDao;
import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.enums.JobBussTypeEnum;
import com.caxs.minos.enums.JobStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ILoanTopayIrSingleBatcherService;
import com.caxs.minos.serv.db.ISpeciPaySystemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) : LoanTopayIrSingleBatch
 * @Description(描述) : 日终单笔发送扣款
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanTopayIrSingleBatcher implements ILoanTopayIrSingleBatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    public static volatile int i=0;// 用于保证执行的线程小于最大线程数
    public static volatile int currentThread;// 用于保证执行的线程小于最大线程数

    @Resource
    ISpeciPaySystemService speciPaySystemService;

    @Resource
    DeAtpyJobsDao deAtpyJobsDao;

    public LoanTopayIrSingleBatcher( ) {
        super();
    }

    public BatcherCodeEnum getBatcherCode() {
        return BatcherCodeEnum.LPKK;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContext) {
        List<Thread> threadList = new ArrayList<Thread>();
        currentThread = Integer.valueOf(batchJobContext.getThreadCnt());
        DeAtpyJobs deAtpyJobs =new DeAtpyJobs();
        deAtpyJobs.setBussTyp(JobBussTypeEnum.ALLLOAN.getCodeInDb());
        deAtpyJobs.setAtpySts(JobStateEnum.INIT.getCodeInDb());
        deAtpyJobs.setAtpyDt(batchJobContext.getBuzDate());
        deAtpyJobs.setNight(batchJobContext.getNightStrToDb());
        List<DeAtpyJobs> jobList = deAtpyJobsDao.selectListByObject(deAtpyJobs);
        if (batchJobContext.getMutiThread() != null
            && batchJobContext.getMutiThread().equals(YnFlagEnum.YES.getCodeInDb())) {
            for (DeAtpyJobs job : jobList) {
                while (currentThread <= 0) {// 到达最大线程数时
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread thread = new Thread(new LoanTopayIrSingleJobBatcher(speciPaySystemService,batchJobContext,job));
                thread.start();
                threadList.add(thread);
                currentThread--;
            }
        } else {
            for (DeAtpyJobs job : jobList) {
                new LoanTopayIrSingleJobBatcher(speciPaySystemService,batchJobContext, job).run();
            }
        }
        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new MinosException(e);
            }
        }
    }


}
