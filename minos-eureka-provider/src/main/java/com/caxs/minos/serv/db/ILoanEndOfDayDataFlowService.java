package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmPmShd;
/**
 * @Description: 日终交易数据流操作
 * @Date: 2020/8/17 16:15
 * @Author: coffee
 * @Throws
 */
public interface ILoanEndOfDayDataFlowService {
    LmPmShd findCurrDueDtShd(String buzDate);
    /**
     * 寻找最后一期还款计划表
     * @param loanNO
     * @return
     */
    LmPmShd getLastPmShd(String loanNO);
    /**
     * 查找当前应还期。
     * @param buzDate
     * @return
     */
    LmPmShd findCurrDueDtShd(String loanNo,String buzDate);
    /**
     * 寻找最后一期还款计划表
     * @param loanNO
     * @return
     */
    LmPmShd getLmPmShd(String loanNO, int perdNo);
    /**
     * 查询等于当前业务日期非主动还款的还款计划
     * @param loanNo
     * @param buzDate
     * @return
     */
    LmPmShd findByPsDueDt(String loanNo,String buzDate);
    /**
     * 查询等于当前业务日期非主动还款的还款计划
     * @param loanNo
     * @param buzDate
     * @return
     */
    int findCurrDuePerdNo(String loanNo,String buzDate);

    /**
     * 查询指定借据的小于等于当前业务日志的最大期号
     * @param loanNo
     * @param operationDate
     * @return
     */
     LmPmShd getInterestDatePmShdEqualToday(String loanNo,String operationDate);
    /**
     * 是否采用实际天数来计算利息
     * @param loanNo
     * @param perdNo
     * @return
     */
     boolean isCaculateAccordingActualDay(String loanNo,int perdNo);
}
