package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ILoanAmountAccService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanAccountingFacadeJobBatcher
 * @Description(描述) : 合并日间总账
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanAccountingFacadeJobBatcher extends BatcherService {
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

    public LoanAccountingFacadeJobBatcher(ILoanAmountAccService iLoanAmountAccService,
                                          BatchJobContextTrans batchJobContext, SBch sbch  ) {
        super(batchJobContext);
        this.sbch = sbch;
        this.iLoanAmountAccService = iLoanAmountAccService;
    }

    public LoanAccountingFacadeJobBatcher() {
        super();
    }

    @Override
    public BatcherCodeEnum getBatcherCode() {
        return BatcherCodeEnum.LNAE;
    }

    @Override
    public void runBatch(){
        try {
            iLoanAmountAccService.listtransRegenLmBchGlTx(this.getJobContext(),sbch);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanAccountingFacadeBatcher.currentThread++;
        }
    }
}
