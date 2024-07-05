package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.LmLoanSuspFuncDao;
import com.caxs.minos.domain.LmLoanSuspFunc;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.LoanOpCodeEnum;
import com.caxs.minos.enums.LoanRepayMethodEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ISuspensionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
/***
 * @ClassName(类名) : SuspensionService
 * @Description(描述) : 贷款停息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class SuspensionService implements ISuspensionService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    LmLoanSuspFuncDao lmLoanSuspFuncDao;

    /**
     * 内部信息变更批处理
     *
     * @param jobContext
     *            批处理参数
     *
     * @return
     */
    @Override
    public void listtransUpDateLoanInfo(BatchJobContextTrans jobContext) {
        try {

            List<LmLoanSuspFunc> list =lmLoanSuspFuncDao.findAllBySuspDt(jobContext.getBuzDate());
            for ( LmLoanSuspFunc func : list ) {
                 saveLoanSuspOp(jobContext, func);
            }
        } catch (Exception e) {
            throw new MinosException("批量处理停息日志表信息失败！", e);
        }
    }



    /**
     * 保存暂停相关信息
     */
    public void saveLoanSuspOp(BatchJobContextTrans jobContext, LmLoanSuspFunc func) {
        // 启动自动扣款处理
        if (LoanOpCodeEnum.START_AUTO_PAY.getCodeInDb().equals(func.getSuspCde())) {
            saveLoanContBySuspCde(jobContext, func,
                    LoanRepayMethodEnum.AUTOPAY.getCodeInDb());
            // 删除停止扣款记录
            LmLoanSuspFunc lmLoanSuspFunc = new LmLoanSuspFunc();
            lmLoanSuspFunc.setLoanNo(func.getLoanNo());
            lmLoanSuspFunc.setSuspCde(LoanOpCodeEnum.END_AUTO_PAY.getCodeInDb());
            //DAOContainer.getLmLoanSuspFuncDAO(false).deleteById(null, id);
        } else if (LoanOpCodeEnum.END_AUTO_PAY.getCodeInDb().equals(func.getSuspCde())) {// 停止自动扣款处理
            saveLoanContBySuspCde(jobContext, func, LoanRepayMethodEnum.MANUAL
                    .getCodeInDb());
        } else if (LoanOpCodeEnum.STOP_OD_INT.getCodeInDb().equals(
                func.getSuspCde())) {// 停止罚息处理
        } else if (LoanOpCodeEnum.UN_STOP_OD_INT.getCodeInDb().equals(
                func.getSuspCde())) {// 取消停止罚息处理
            //stopOdIntAccount(onlineParam, func);
        } else if (LoanOpCodeEnum.STOP_GRD.getCodeInDb().equals(
                func.getSuspCde())) {// 停止五级分类处理
            // 保存信息到日志表中
            //saveLmLnSuspLog(jobContext.getBuzDate(), func);
            func.setProcInd(YnFlagEnum.YES.getCodeInDb());
            // 更新停息日志记录的处理标志
           // DAOContainer.getLmLoanSuspFuncDAO(false).merge(null, func);
        }
    }

    /**
     * 记录暂停日志，并删除相关暂停信息
     *
     * @param jobContext
     * @param func
     * @param loanRepayMethod
     */
    public void saveLoanContBySuspCde(BatchJobContextTrans jobContext,
                                      LmLoanSuspFunc func, String loanRepayMethod) {
        /************
        LoanRelate loanRelate = LoanRelate.queryLoanRelate(null, func.getLoanNo());
        if (loanRelate.getLoanCcy().equals(
                SystemInfo.getSystemInfo().getDefautCoinKind())) {
            loanRelate.getLoanCont().setLoanRepayMthd(loanRepayMethod);
            loanRelate.mergeLoanCont(null);
        }
        saveLmLnSuspLog(jobContext.getBuzDate(), func);
        DAOContainer.getLmLoanSuspFuncDAO(false).delete(null, func);
         ****************/
    }
}
