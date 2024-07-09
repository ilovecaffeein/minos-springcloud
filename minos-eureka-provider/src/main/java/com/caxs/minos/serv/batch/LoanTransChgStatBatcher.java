package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ILmChgStatRuleService;
import com.caxs.minos.serv.db.ILoanTransChgStatBatcherService;
import com.caxs.minos.serv.db.ISystemInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/***
 * @ClassName(类名) : LoanTransChgStatBatch
 * @Description(描述) : 超过90天形态转移
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanTransChgStatBatcher implements ILoanTransChgStatBatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    public static volatile int currentThread;//用于保证执行的线程小于最大线程数

    @Resource
    ISystemInfoService systemInfoService;

    @Resource
    ILmChgStatRuleService lmChgStatRuleService;

    public LoanTransChgStatBatcher( ) {
        super();
    }

    public BatcherCode getBatcherCode() {
        return BatcherCode.LNAN;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContext) {
        List<SBch> sbchList = systemInfoService.getBranchList();
        Iterator<SBch> itor2 = sbchList.iterator();
        List<Thread> threadList = new ArrayList<Thread>(sbchList.size());
        BatchJobContextTrans batchJobContextTrans  = batchJobContext;
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
                Thread thread = new Thread(new LoanTransChgStatJobBatcher(
                                    lmChgStatRuleService,batchJobContextTrans,sbch));
                thread.start();
                threadList.add(thread);
                currentThread--;
            }
        }else {
            while(itor2.hasNext()){
                SBch sbch = itor2.next();
                new LoanTransChgStatJobBatcher(lmChgStatRuleService,batchJobContextTrans, sbch).run();
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
