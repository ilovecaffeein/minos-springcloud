package com.caxs.minos.serv.buz;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.LmSetlmtLog;
import com.caxs.minos.domain.trans.MoneyPayTrans;
import com.caxs.minos.domain.trans.ShdTrans;
import com.caxs.minos.enums.PrcpStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.utils.LoanRelateUtils;
import com.caxs.minos.utils.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import static com.caxs.minos.enums.YnFlagEnum.YnFlag;
/**
 * @ClassName: AdvPaymentLmPmShd
 * 还款计划构造方法
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
@Repository
public class AdvPayMentLmPmShd {
    //打印日志属性
    private Log log = LogFactory.getLog(getClass());

    private MoneyPayTrans money;

    //从命名表对象属性
    private LoanRelateUtils loanRelate;
    //提前本金
    private BigDecimal advPrcp;
    //扩展的还款计划
    private LmPmShd appendedLmPmShd;
    //当前计提金额
    private double curPsIncTaken;
    //利息计算起始还款计划对象
    private LmPmShd interestShd;
    //还款流水
    private  LmSetlmtLog lmSetlmtLog;
    //新期号
    private Integer newPerdNo;
    //新追加的还款计划表是否新记录
    private boolean isShdNewly = false;
    //计算利息的本金值
    private BigDecimal interestPrcp = new BigDecimal(0);
    //计算利息的本金值
    private BigDecimal interestNormalInt = new BigDecimal(0);
    //当前系统日期
    private String buzDate;
    //提前还款标识
    private String setlMode;
    //提前还款标识
    private String setlInd;

    //实际入账金额
    private BigDecimal trueRecvAmt = new BigDecimal(0);

    public void  setSetlMode(String setlMode) {
        this.setlMode = setlMode;
    }

    public void  setSetlInd(String setlInd) {
        this.setlInd = setlInd;
    }

    public String getSetlInd() {
        return setlInd;
    }

    public void  setInterestPrcp(BigDecimal interestPrcp) {
        this.interestPrcp = interestPrcp;
    }

    public void  setLoanRelateUtils(LoanRelateUtils loanRelate) {
        this.loanRelate = loanRelate;
    }

    public void  setInterestNormalInt(BigDecimal interestNormalInt) {
        this.interestNormalInt = interestNormalInt;
    }
    public void  setTrueRecvAmt(BigDecimal trueRecvAmt) {
        this.trueRecvAmt = trueRecvAmt;
    }

    //获取计算利息的本金值
    public BigDecimal getInterestNormalInt() {
        return interestNormalInt;
    }

    //提前还款
    public LmPmShd getInterestShd() {
        return appendedLmPmShd;
    }

    public LmPmShd getAppendedLmPmShd() {
        return appendedLmPmShd;
    }

    public void setAppendedLmPmShd(LmPmShd appendedLmPmShd) {
        this.appendedLmPmShd = appendedLmPmShd;
    }

    /**
     * 新追加的还款计划表是否新记录，理论上应该总是否
     *
     * @return
     */
    public boolean isShdNewly() {
        return isShdNewly;
    }
    //获取计算利息的本金值
    public BigDecimal getInterestPrcp() {
        return interestPrcp;
    }
    //获取新的期号
    public Integer getNewPerdNo() {
        return newPerdNo;
    }

    //获取新的期号
    public void setNewPerdNo(Integer  newPerdNo) {
        this.newPerdNo = newPerdNo;
    }

    //提前还款调整构造方法
    public AdvPayMentLmPmShd(){

    }
    //提前还款调整构造方法
    public AdvPayMentLmPmShd(LmPmShd interestShd, LoanRelateUtils loanRelate,
                             MoneyPayTrans money, LmSetlmtLog lmSetlmtLog) {
        this.interestShd = interestShd;
        this.loanRelate = loanRelate;
        this.money = money;
        this.newPerdNo = interestShd.getPsPerdNo() + 1;
        this.lmSetlmtLog = lmSetlmtLog;
    }

    /**
     * 生成新添加的还款计划表
     * @param
     * @return
     */
    public LmPmShd buildAppendShdWhenPayAllOrPart() {
        this.appendedLmPmShd = new LmPmShd();
        this.appendedLmPmShd.setLoanNo(loanRelate.getLoan().getLoanNo());
        this.appendedLmPmShd.setPsPerdNo(newPerdNo);
        this.appendedLmPmShd.setPsDueDt(lmSetlmtLog.getSetlValDt());
        this.appendedLmPmShd.setPsInstmAmt(money.getpsPaymentAmountAll());
        this.appendedLmPmShd.setPsPrcpAmt(money.getPsPayPrcpAmount());
        this.appendedLmPmShd.setPsNormIntAmt(money.getPsPayNormPrcpAmount());
        this.appendedLmPmShd.setPsOdIntAmt(money.getPsPayOdIntAmount());
        this.appendedLmPmShd.setPsCommOdInt(money.getPsPayCommIntAmount());
        this.appendedLmPmShd.setPsFeeAmt(money.getPsPayPayedFee());
        this.appendedLmPmShd.setPsIntRate(loanRelate.getLoan().getLoanIntRate());
        this.appendedLmPmShd.setPsOdIntRate(loanRelate.getLoan().getLoanOdIntRate());
        this.appendedLmPmShd.setPrcpState(PrcpStateEnum.NORMAL.getCodeInDb());
        this.appendedLmPmShd.setIntState(PrcpStateEnum.NORMAL.getCodeInDb());
        this.appendedLmPmShd.setSetlPrcp(money.getPrcp());
        this.appendedLmPmShd.setSetlNormInt(money.getNormInt());
        this.appendedLmPmShd.setSetlCommOdInt(money.getOdInt());
        this.appendedLmPmShd.setSetlOdIntAmt(money.getCommInt());
        this.appendedLmPmShd.setSetlFeeAmt(money.getFeeAmt());
        this.appendedLmPmShd.setPpErInd(YnFlag.YES.getCodeInDb());
        this.appendedLmPmShd.setPsIncTaken(money.getPsPayNormPrcpAmount());
        this.appendedLmPmShd.setIntState(PrcpStateEnum.NORMAL.getCodeInDb());
        this.appendedLmPmShd.setPsRemPrcp(
                SystemUtils.getBigDecimalWhenEvenUp(interestShd.getPsRemPrcp().subtract(money.getPrcp())));
        this.appendedLmPmShd.setSetlMode(lmSetlmtLog.getSetlMode());
        this.appendedLmPmShd.setPsOdInd(YnFlag.NO.getCodeInDb());
        this.appendedLmPmShd.setLastSetlDt(lmSetlmtLog.getSetlValDt());
        this.appendedLmPmShd.setCommOdGenDt(lmSetlmtLog.getSetlValDt());
        this.appendedLmPmShd.setProdPrcpAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setProdIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setProdCommIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setProdFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsWvCommInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsWvOdInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsWvNmInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSbsyIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlInd(setlInd);
        this.appendedLmPmShd.setPsCurOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsIncTaken(SystemUtils.getDoubleToBigDecimal(curPsIncTaken));
        return this.appendedLmPmShd;
    }

    /**
     * 生成新添加的还款计划表
     * @param
     * @return
     */
    public LmPmShd buildAppendShdWhenPayAllOrPart(String loanNo, ShdTrans tShd) {
        this.appendedLmPmShd = new LmPmShd();
        this.appendedLmPmShd.setLoanNo(loanNo);
        this.appendedLmPmShd.setPsPerdNo(tShd.getPsPerdNo());
        this.appendedLmPmShd.setPsDueDt(tShd.getPsDueDt());
        this.appendedLmPmShd.setPsInstmAmt(tShd.getPsInstmAmt());
        this.appendedLmPmShd.setPsPrcpAmt(tShd.getPsPrcpAmt());
        this.appendedLmPmShd.setPsNormIntAmt(tShd.getPsNormIntAmt());
        this.appendedLmPmShd.setPsOdIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsCommOdInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsRemPrcp(tShd.getPsRemPrcp());
        // /设置逾期等金额
        this.appendedLmPmShd.setSetlPrcp(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlNormInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlCommOdInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlOdIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPpErInd(YnFlag.NO.getCodeInDb());
        this.appendedLmPmShd.setPsIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setIntState(PrcpStateEnum.NORMAL.getCodeInDb());
        this.appendedLmPmShd.setPsIntRate(tShd.getPsIntRate());
        this.appendedLmPmShd.setPsOdIntRate(tShd.getPsOdIntRate());
        this.appendedLmPmShd.setPsOdInd(YnFlagEnum.NO.getCodeInDb());
        // 利息变动
        this.appendedLmPmShd.setSetlMode(setlMode);
        this.appendedLmPmShd.setLastSetlDt(buzDate);
        this.appendedLmPmShd.setProdPrcpAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setProdIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setProdCommIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setProdFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsWvCommInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsWvOdInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsWvNmInt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setIntState(PrcpStateEnum.NORMAL.getCodeInDb());
        this.appendedLmPmShd.setSbsyIntAmt(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setSetlInd(YnFlagEnum.NO.getCodeInDb());
        this.appendedLmPmShd.setPsCurOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        this.appendedLmPmShd.setPsIncTaken(SystemUtils.getDoubleToBigDecimal(curPsIncTaken));
        this.appendedLmPmShd.setPrcpState(PrcpStateEnum.NORMAL.getCodeInDb());
        return this.appendedLmPmShd;
    }

    /**
     * 生成新添加的还款计划表
     * @param
     * @return
     */
    public LmPmShd buildAppendShdWhenNull(String loanNo, Integer psPerdNo, String psDueDt,
                     BigDecimal psInstmAmt, BigDecimal psPrcpAmt, BigDecimal psNormIntAmt,
                                         BigDecimal psRemPrcp, BigDecimal psIntRate,BigDecimal  psOdIntRate) {
        this.appendedLmPmShd = new LmPmShd();
        this.appendedLmPmShd.setLoanNo(loanNo);
        this.appendedLmPmShd.setPsPerdNo(psPerdNo);
        this.appendedLmPmShd.setPsDueDt(psDueDt);
        this.appendedLmPmShd.setPsInstmAmt(psInstmAmt);
        this.appendedLmPmShd.setPsPrcpAmt(psPrcpAmt);
        this.appendedLmPmShd.setPsNormIntAmt(psNormIntAmt);
        this.appendedLmPmShd.setPsRemPrcp(psRemPrcp);
        this.appendedLmPmShd.setSetlPrcp(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setSetlNormInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setPsIntRate(psIntRate);
        this.appendedLmPmShd.setPsOdIntRate(psOdIntRate);
        this.appendedLmPmShd.setPrcpState(PrcpStateEnum.NORMAL.getCodeInDb());
        this.appendedLmPmShd.setIntState(PrcpStateEnum.NORMAL.getCodeInDb());
        // /设置逾期等金额
        this.appendedLmPmShd.setSetlCommOdInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setSetlOdIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setPsOdIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setPsCommOdInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setPpErInd(YnFlag.YES.getCodeInDb());
        this.appendedLmPmShd.setPsIncTaken(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        // 利息变动
        this.appendedLmPmShd.setPsWvCommInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setPsWvOdInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setPsWvNmInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setSbsyIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setProdIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setProdCommIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setProdPrcpAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setPsIncTaken(SystemUtils.getDoubleToBigDecimal(curPsIncTaken));
        this.appendedLmPmShd.setPsOdIncTaken(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setSetlOdIncTaken(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setSetlIncTaken(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        this.appendedLmPmShd.setSetlInd(YnFlagEnum.NO.getCodeInDb());
        this.appendedLmPmShd.setPsCurOdIncTaken(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        return this.appendedLmPmShd;
    }
}
