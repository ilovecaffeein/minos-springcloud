package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.enums.BranchLevelEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ILoanInterestEverydayBatcherService;
import com.caxs.minos.serv.db.INormReckonAccrualEverydayService;
import com.caxs.minos.serv.db.ISystemInfoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/***
 * @ClassName(类名) : LoanInterestEverydayBatch
 * @Description(描述) : 贷款结息 -正常利息结息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanInterestEverydayBatcher implements ILoanInterestEverydayBatcherService {
    //线程总数
    public final static int threadTotal = 100;
    public static volatile int currentThread;//用于保证执行的线程小于最大线程数
    private BatchJobContextTrans batchJobContext;

    @Resource
    ISystemInfoService systemInfoService;


    @Resource
    private INormReckonAccrualEverydayService normReckonAccrualEverydayService;

    public LoanInterestEverydayBatcher() {
        super();
    }

    public BatcherCodeEnum getBatcherCode() {
        return BatcherCodeEnum.LNAA;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContextTrans) {
        List<SBch> sbchList = systemInfoService.getBranchList(BranchLevelEnum.HEAD.getCodeInDb());
        Iterator<SBch> itor2 = sbchList.iterator();
        List<Thread> threadList = new ArrayList<Thread>(sbchList.size());
        currentThread= Integer.valueOf(batchJobContextTrans.getThreadCnt());
        if(batchJobContextTrans.getMutiThread()!=null &&
                batchJobContextTrans.getMutiThread().equals(YnFlagEnum.YES.getCodeInDb())){
            while( itor2.hasNext() ){
                SBch sbch = itor2.next();
                while(currentThread<=0){//到达最大线程数时
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < Integer.valueOf(batchJobContextTrans.getThreadCnt()); i++) {
                    BatchJobContextTrans  batchJobContext = batchJobContextTrans.duplicate(
                            threadTotal, Integer.parseInt(batchJobContextTrans.getThreadCnt()),i);
                    Thread thread = new Thread(new LoanInterestEverydayJobBatcher(normReckonAccrualEverydayService,batchJobContext,sbch));
                    thread.start();
                    threadList.add(thread);
                    currentThread--;
                }
            }
        }else {
            while(itor2.hasNext()){
                SBch sbch = itor2.next();
                BatchJobContextTrans  batchJobContext = batchJobContextTrans.duplicate(
                        threadTotal, Integer.parseInt("1"),0);
                new Thread(new LoanInterestEverydayJobBatcher(normReckonAccrualEverydayService,batchJobContext,sbch)).run();
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
