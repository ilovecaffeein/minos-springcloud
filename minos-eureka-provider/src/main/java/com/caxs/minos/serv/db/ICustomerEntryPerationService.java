package com.caxs.minos.serv.db;

import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.AccountTrans;
import com.caxs.minos.domain.trans.BatchJobContextTrans;

import java.util.List;
/**
 * @Description: 删除还款计划表以后的数据
 * @Date: 2020/8/17 16:15
 * @Author: coffee
 * @Throws
 */
public interface ICustomerEntryPerationService {
     /**
     * 计算下次扣款日，仅实时处理函数调用
     * @param loanNo
     * @param buzDate
     * @return
     */
     String calNextDueDt(String loanNo,String buzDate,LmPmShd iShd);
     /**
     * 计算下次利率同步日期 如果没有，那么设置未空
     * @param buzDt
     * @param mtdList
     * @return
     */
     String calNextSynRateDt(String buzDt ,List<LmLnShdMtd> mtdList);
     /**
     * 查询<=operationDate 的利息计算起始期。
     * @param buzDate
     *            查询日期
     * @return shd 还款计划表
     */
     LmPmShd getInterestDateShd(String loanNo,String buzDate,boolean isEqualDate);
     /**
     * 查找还款计划表
     * @param loanNo
     * @param buzDate
     * @author coffee
     */
     LmPmShd findCurrDueDtShd(String loanNo, String buzDate);
     /**
     * 查找最后一期还款计划表
     * @param loanNO
     * @author coffee
     */
     LmPmShd getLastPmShd(String loanNO);
     /**
     * 主动还款数据操作
     * @param lmGlnoLog
     * @param lmFeeTxTs
     * @param lmSetLmt
     * @author coffee
     */
     void activeRepayment( LmGlnoLog lmGlnoLog, List<LmFeeTxT> lmFeeTxTs, LmSetlmtT lmSetLmt);
     /**
      *  获取收费账户，如果收费账户为空，获取贷款还款账户，根据收费账号信息生成账户信息
      * @author coffee
      * @date 2020-11-26
      * @param lstAcctInfo
      * @return
      */
      AccountTrans transAcctInfo(List<LmAcctInfoT> lstAcctInfo);
      /**
      * 更新自动入账数据
      * @param jobContext
      * @param job
       * @param atpySts
      * @author coffee
      */
      void updatePageLmAtpyDetl(BatchJobContextTrans jobContext, DeAtpyJobs job, String atpySts);
}
