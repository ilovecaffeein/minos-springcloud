package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BranchLevelEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ILoanAccountingFacadeBatcherService;
import com.caxs.minos.serv.db.ILoanAmountAccService;
import com.caxs.minos.serv.db.ISystemInfoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/***
 * @ClassName(类名) : LoanAccountingFacade
 * @Description(描述) : 合并日间总账
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanAccountingFacadeBatcher implements ILoanAccountingFacadeBatcherService {
    //线程总数
    public final static int threadTotal = 100;
    public static volatile int currentThread;//用于保证执行的线程小于最大线程数

    @Resource
    ISystemInfoService systemInfoService;

    @Resource
    private ILoanAmountAccService iNormIntAccrualSerivce;

    public LoanAccountingFacadeBatcher() {
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
                    Thread thread = new Thread(new LoanAccountingFacadeJobBatcher(iNormIntAccrualSerivce,batchJobContext,sbch));
                    thread.start();
                    threadList.add(thread);
                    currentThread--;
                }
            }
        }else {
            while(itor2.hasNext()){
                SBch sbch = itor2.next();
                new LoanAccountingFacadeJobBatcher(iNormIntAccrualSerivce,batchJobContextTrans, sbch).run();
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
