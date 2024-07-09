package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ILoanAmountAccService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanNormIntAccrualJobBatcher
 * @Description(描述) : 正常利息计提,本程序会产生子线程。
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanAmountAccJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private ILoanAmountAccService iLoanAmountAccService;

    private SBch sbch;

    public SBch getSbch() {
        return sbch;
    }

    public void setSbch(SBch sbch) {
        this.sbch = sbch;
    }

    public LoanAmountAccJobBatcher(ILoanAmountAccService iLoanAmountAccService,
                                   BatchJobContextTrans batchJobContext, SBch sbch  ) {
        super(batchJobContext);
        this.sbch = sbch;
        this.iLoanAmountAccService = iLoanAmountAccService;
    }

    public LoanAmountAccJobBatcher() {
        super();
    }

    @Override
    public BatcherCode getBatcherCode() {
        return BatcherCode.LNAE;
    }

    @Override
    public void runBatch(){
        try {
            //iLoanAmountAccService.listtransAmountACC(this.getJobContext(),sbch);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanAmountAccBatcher.currentThread++;
        }
    }
}
