package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IOverdueIntAccrualService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanOverdueIntAccrualJobBatcher
 * @Description(描述) : 逾期利息计提,本程序会产生子线程。
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanOverdueIntAccrualJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private IOverdueIntAccrualService overdueIntAccrualService;

    public LoanOverdueIntAccrualJobBatcher(IOverdueIntAccrualService overdueIntAccrualService,
                                           BatchJobContextTrans jobContext, SBch sbch  ) {
        super(jobContext);
        this.sbch = sbch;
        this.overdueIntAccrualService = overdueIntAccrualService;
    }
    public LoanOverdueIntAccrualJobBatcher() {
        super();
    }

    private SBch sbch;

    public SBch getSbch() {
        return sbch;
    }

    public void setSbch(SBch sbch) {
        this.sbch = sbch;
    }

    @Override
    public BatcherCodeEnum getBatcherCode() {
        return BatcherCodeEnum.LNBX;
    }

    @Override
    public void runBatch() {
        try {
            overdueIntAccrualService.listtransOdIntDBTrans(this.getJobContext(),sbch);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanOverdueIntAccrualBatcher.currentThread++;
        }
    }
}
