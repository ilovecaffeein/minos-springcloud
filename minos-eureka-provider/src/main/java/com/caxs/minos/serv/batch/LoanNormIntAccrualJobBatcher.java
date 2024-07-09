package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.INormIntAccrualSerivce;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanNormIntAccrualJobBatcher
 * @Description(描述) : 正常利息计提,本程序会产生子线程。
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanNormIntAccrualJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private INormIntAccrualSerivce iNormIntAccrualSerivce;

    private SBch sbch;

    public SBch getSbch() {
        return sbch;
    }

    public void setSbch(SBch sbch) {
        this.sbch = sbch;
    }

    public LoanNormIntAccrualJobBatcher(INormIntAccrualSerivce iNormIntAccrualSerivce,
                                        BatchJobContextTrans batchJobContext, SBch sbch  ) {
        super(batchJobContext);
        this.sbch = sbch;
        this.iNormIntAccrualSerivce = iNormIntAccrualSerivce;
    }

    public LoanNormIntAccrualJobBatcher() {
        super();
    }

    @Override
    public BatcherCode getBatcherCode() {
        return BatcherCode.LNAE;
    }

    @Override
    public void runBatch(){
        try {
            iNormIntAccrualSerivce.listtransAccrueDBTrans(this.getJobContext(),sbch);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanNormIntAccrualBatcher.currentThread++;
        }
    }
}
