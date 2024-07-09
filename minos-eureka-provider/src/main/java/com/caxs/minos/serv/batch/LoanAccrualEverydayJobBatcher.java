package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.IOverReckonAccrualEverydayService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanAccrualEverydayJobBatcher
 * @Description(描述) : 贷款结息 -罚息及复利结息,本程序会产生子线程。
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanAccrualEverydayJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private IOverReckonAccrualEverydayService overReckonAccrualEverydayService;

    private SBch sbch;
    public SBch getSbch() {
        return sbch;
    }
    public void setSbch(SBch sbch) {
        this.sbch = sbch;
    }

    public LoanAccrualEverydayJobBatcher(IOverReckonAccrualEverydayService overReckonAccrualEverydayService,
                                         BatchJobContextTrans batchJobContext, SBch sbch  ) {
        super(batchJobContext);
        this.sbch = sbch;
        this.overReckonAccrualEverydayService = overReckonAccrualEverydayService;
    }

    public LoanAccrualEverydayJobBatcher() {
        super();
    }

    @Override
    public BatcherCode getBatcherCode() {
        return BatcherCode.LNAA;
    }

    @Override
    public void runBatch() {
        try {
            overReckonAccrualEverydayService.listtransReckonAccrual(this.getJobContext(),sbch);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanAccrualEverydayBatcher.currentThread++;
        }
    }
}
