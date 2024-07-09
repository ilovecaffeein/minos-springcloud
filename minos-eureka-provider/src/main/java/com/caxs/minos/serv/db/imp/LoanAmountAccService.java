package com.caxs.minos.serv.db.imp;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.serv.db.*;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/***
 * @ClassName(类名) : LoanAmountAccService
 * @Description(描述) : 金额摊销 or 合并日间总账 or 日终机构总账内部合并
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanAmountAccService implements ILoanAmountAccService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Reference
    ILoanEndOfDayDataFlowService loanEndOfDayDataFlowService;

    @Reference
    ILmChgStatRuleService lmChgStatRuleService;

    @Reference
    IBatchJoErrorLogService batchJoErrorLogService;

    @Reference
    ISystemInfoService systemInfoService;


    @Override
    public void listtransAmountACC(BatchJobContextTrans jobContext, SBch sbch) {

    }

    @Override
    public void listtransRegenLmBchGlTx(BatchJobContextTrans jobContext, SBch sbch) {

    }

    @Override
    public void listtransSumAccountOs(BatchJobContextTrans jobContext, SBch sbch) {

    }
}
