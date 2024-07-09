package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ILmChgStatRuleService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanTransChgStatBatch
 * @Description(描述) : 超过90天形态转移
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanTransChgStatJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private ILmChgStatRuleService lmChgStatRuleService;

    private SBch sbch;

    public LoanTransChgStatJobBatcher(ILmChgStatRuleService lmChgStatRuleService,
                                      BatchJobContextTrans jobContext, SBch sbch  ) {
        super(jobContext);
        this.sbch = sbch;
        this.lmChgStatRuleService = lmChgStatRuleService;
    }

    public LoanTransChgStatJobBatcher() {
    }


    @Override
    public BatcherCode getBatcherCode() {
        return BatcherCode.LNAN;
    }

    @Override
    public void runBatch() {
        try {
            log.info("贷款形态转移处理机构："+ sbch.getBchCde() + " 开始");
            lmChgStatRuleService.listtransChgStatDBTrans(this.getJobContext(),sbch);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanTransChgStatBatcher.currentThread++;
        }
    }
}
