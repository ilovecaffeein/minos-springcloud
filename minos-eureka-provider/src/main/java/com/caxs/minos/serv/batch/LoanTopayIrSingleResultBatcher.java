package com.caxs.minos.serv.batch;

import com.caxs.minos.dao.DeAtpyJobsDao;
import com.caxs.minos.dao.ToPayIrDao;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.ToPayIr;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.JobBussTypeEnum;
import com.caxs.minos.enums.JobStateEnum;
import com.caxs.minos.enums.PkgStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ILoanTopayIrSingleResultBatcherService;
import com.caxs.minos.serv.db.ISpeciPaySystemService;
import com.caxs.minos.serv.db.ISystemInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) : LoanTopayIrSingleResultBatch
 * @Description(描述) : 日终单笔获取核心批扣结果
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanTopayIrSingleResultBatcher implements ILoanTopayIrSingleResultBatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    public static volatile int i=0;// 用于保证执行的线程小于最大线程数
    public static volatile int currentThread;// 用于保证执行的线程小于最大线程数

    @Resource
    private ISystemInfoService systemInfoService;

    @Resource
    ISpeciPaySystemService speciPaySystemService;

    @Resource
    DeAtpyJobsDao deAtpyJobsDao;

    @Resource
    ToPayIrDao toPayIrDao;

    public LoanTopayIrSingleResultBatcher() {
        super();
    }

    public BatcherCode getBatcherCode() {
        return BatcherCode.LNBS;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContext) {
        int loopNum= systemInfoService.getSystemConfig().getLoopNum();
        List<Thread> threadList = new ArrayList<Thread>();
        BatchJobContextTrans batchJobContextTrans = batchJobContext ;
        currentThread = Integer.valueOf(batchJobContextTrans.getThreadCnt());

        DeAtpyJobs deAtpyJobs =new DeAtpyJobs();
        deAtpyJobs.setBussTyp(JobBussTypeEnum.ALLLOAN.getCodeInDb());
        deAtpyJobs.setAtpySts(JobStateEnum.INIT.getCodeInDb());
        deAtpyJobs.setAtpyDt(batchJobContextTrans.getBuzDate());
        deAtpyJobs.setNight(batchJobContextTrans.getNightStrToDb());
        List<DeAtpyJobs> jobList = deAtpyJobsDao.selectListByObject(deAtpyJobs);
        int total = 0;
        do{
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
                    Thread thread = new Thread(new LoanTopayIrSingleResultJobBatcher(speciPaySystemService,batchJobContextTrans,job));
                    thread.start();
                    threadList.add(thread);
                    currentThread--;
                }
            } else {
                for (DeAtpyJobs job : jobList) {
                    new LoanTopayIrSingleResultJobBatcher(speciPaySystemService,batchJobContextTrans, job).run();
                }
            }

            total++;
            log.info("累计循环扣款次数:" + total);
            List<ToPayIr> TToPayIrs1 = toPayIrDao.findByToPayIrPkgSts(batchJobContext.getBuzDate(), PkgStateEnum.FZ.getCodeInDb());
            if( TToPayIrs1.size() == 0 ){
                break;
            }
            if( total == loopNum ){
                List<ToPayIr> TToPayIrs2 = toPayIrDao.findByToPayIrPkgSts(batchJobContext.getBuzDate(), PkgStateEnum.FZ.getCodeInDb());
                if( TToPayIrs2.size() > 0 ){
                    throw new MinosException("存在未获取建行扣款结果的记录，请核查！", ErrorCode.ERROR20006);
                }
            }
            threadSleep(5*60* 1000);//批量扣款异步获取结果需要等待5分钟
            jobList = deAtpyJobsDao.selectListByObject(deAtpyJobs);
        } while (  total < loopNum );
        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new MinosException(e);
            }
        }
    }

    /**
     * 线程等待
     */
    public void threadSleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
