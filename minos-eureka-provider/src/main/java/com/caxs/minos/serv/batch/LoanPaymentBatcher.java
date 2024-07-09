package com.caxs.minos.serv.batch;

import com.caxs.minos.dao.DeAtpyJobsDao;
import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.trans.AtpyJobTrans;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.JobBussTypeEnum;
import com.caxs.minos.enums.JobStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.IGenerateLoanRepayService;
import com.caxs.minos.serv.db.ILoanPaymentBatcherService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) : LoanPaymentBatcher
 * @Description(描述) : 自动扣款入账
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanPaymentBatcher implements ILoanPaymentBatcherService {
    public static volatile Integer currentThread;// 用于保证执行的线程小于最大线程数
    public static volatile long fileMumberThread;// 允许单个文件系号对应数据最大笔数

    @Resource
    private IGenerateLoanRepayService generateLoanRepayService;

    @Resource
    private DeAtpyJobsDao  deAtpyJobsDao;

    public LoanPaymentBatcher( ) {
        super();
    }

    public BatcherCode getBatcherCode() {
        return BatcherCode.LNAF;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContext) {
        List<Thread> threadList = new ArrayList<Thread>();
        BatchJobContextTrans batchJobContextTrans = batchJobContext;

        // 防止重跑已经完成的任务.
        DeAtpyJobs deAtpyJobs =new DeAtpyJobs();
        deAtpyJobs.setBussTyp(JobBussTypeEnum.ALLLOAN.getCodeInDb());
        deAtpyJobs.setAtpySts(JobStateEnum.INIT.getCodeInDb());
        deAtpyJobs.setAtpyDt(batchJobContextTrans.getBuzDate());
        deAtpyJobs.setNight(batchJobContextTrans.getNightStrToDb());
        List<DeAtpyJobs> jobList = deAtpyJobsDao.selectListByObject(deAtpyJobs);
        if ( CollectionUtils.isEmpty(jobList) ) {
            throw new MinosException("DeAtpyJobs 表无任务,不能执行下面步骤！");
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
        if (batchJobContextTrans.getMutiThread() != null
                && batchJobContextTrans.getMutiThread().equals(YnFlagEnum.YES.getCodeInDb())) {
            for (DeAtpyJobs job : jobList) {
                while (currentThread <= 0) {// 到达最大线程数时
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread thread = new Thread(new LoanPaymentJobBatcher(generateLoanRepayService,batchJobContextTrans,job));
                thread.start();
                threadList.add(thread);
                currentThread--;
            }
        } else {
            for (DeAtpyJobs job : jobList) {
                new LoanPaymentJobBatcher(generateLoanRepayService,batchJobContextTrans, job).run();
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