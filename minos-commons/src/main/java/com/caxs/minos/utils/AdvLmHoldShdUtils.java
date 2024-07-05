package com.caxs.minos.utils;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmHoldInfo;
import com.caxs.minos.domain.LmHoldShd;
import com.caxs.minos.domain.trans.RepaymentPlanTrans;
import com.caxs.minos.enums.YnFlagEnum;

import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) : AdvLmHoldShdUtils
 * @Description(描述) : 构造新的收益人计划
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class AdvLmHoldShdUtils {

    public AdvLmHoldShdUtils(){

    }

    /**
     * 构造新的收益人计划
     * @param
     * @return
     */
    public static LmHoldShd constructSLmHoldShd(RepaymentPlanTrans repaymentPlanTrans,
                                                LmHoldInfo lmHoldInfoDomainT) {
      LmHoldShd lmHoldShd = new LmHoldShd();
        lmHoldShd.setLoanNo(lmHoldInfoDomainT.getLoanNo());
        lmHoldShd.setPsPerdNo(Integer.valueOf(repaymentPlanTrans.getId().getPsPerdNo()));
        lmHoldShd.setPsDueDt(repaymentPlanTrans.getPsDueDt());
        lmHoldShd.setPsInstmAmt(repaymentPlanTrans.getPsInstmAmt());
        lmHoldShd.setPsPrcpAmt(repaymentPlanTrans.getPsPrcpAmt());
        lmHoldShd.setPsNormIntAmt(repaymentPlanTrans.getPsNormIntAmt());
        lmHoldShd.setPsOdIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        lmHoldShd.setPsCommOdInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        lmHoldShd.setPsRemPrcp(repaymentPlanTrans.getPsRemPrcp());
        lmHoldShd.setSetlPrcp(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        lmHoldShd.setSetlNormInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        lmHoldShd.setSetlCommOdInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        lmHoldShd.setSetlOdIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        lmHoldShd.setIncAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
        lmHoldShd.setIncPct(lmHoldInfoDomainT.getIncPct());
        lmHoldShd.setSetlInd(YnFlagEnum.NO.getCodeInDb());
        lmHoldShd.setDcInd(YnFlagEnum.NO.getCodeInDb());
        return lmHoldShd;
    }


    /**
     * 生成新添加的投资人还款计划表
     * @param
     * @return
     */
    public static List<LmHoldShd>  buildLmHoldShdList(
            List<RepaymentPlanTrans> repaymentPlanTransList, LmHoldInfo lmHoldInfoDomainT) {
        List<LmHoldShd> LmHoldShdList = new ArrayList<LmHoldShd>();
        for(RepaymentPlanTrans   repaymentPlanTrans : repaymentPlanTransList) {
            LmHoldShd lmHoldShd = new LmHoldShd();
            lmHoldShd.setLoanNo(lmHoldInfoDomainT.getLoanNo());
            lmHoldShd.setCustId(lmHoldInfoDomainT.getCustId());
            lmHoldShd.setPsPerdNo(Integer.valueOf(repaymentPlanTrans.getId().getPsPerdNo()));
            lmHoldShd.setPsDueDt(repaymentPlanTrans.getPsDueDt());
            lmHoldShd.setPsInstmAmt(repaymentPlanTrans.getPsInstmAmt());
            lmHoldShd.setPsPrcpAmt(repaymentPlanTrans.getPsPrcpAmt());
            lmHoldShd.setPsNormIntAmt(repaymentPlanTrans.getPsNormIntAmt());
            lmHoldShd.setPsOdIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmHoldShd.setPsCommOdInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmHoldShd.setPsRemPrcp(repaymentPlanTrans.getPsRemPrcp());
            lmHoldShd.setSetlPrcp(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmHoldShd.setSetlNormInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmHoldShd.setSetlCommOdInt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmHoldShd.setSetlOdIntAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmHoldShd.setIncAmt(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmHoldShd.setIncPct(lmHoldInfoDomainT.getIncPct());
            lmHoldShd.setSetlInd(YnFlagEnum.NO.getCodeInDb());
            lmHoldShd.setDcInd(YnFlagEnum.NO.getCodeInDb());
            LmHoldShdList.add(lmHoldShd);
        }
        return LmHoldShdList;
    }
}
