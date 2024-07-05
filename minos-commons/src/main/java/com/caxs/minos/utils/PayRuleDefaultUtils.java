package com.caxs.minos.utils;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.LmPmShdId;
import com.caxs.minos.domain.trans.RepaymentPlanTrans;
import com.caxs.minos.domain.trans.ShdMtdTrans;
import com.caxs.minos.enums.PrcpAndIntStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import java.math.BigDecimal;
/**
 * @ClassName: PayRuleDefaultUtils
 * @Description: 对象操作工具类
 * @Author: zhuruilong
 * @Date: 2020/8/4 16:23
 * @Version: v1.0 文件初始创建
 */
public class PayRuleDefaultUtils {
    /**
     * 放款试算初始化数据封装
     *
     * @param shdMtd
     */
    public static LmPmShd createHoldNomalMtdT(ShdMtdTrans shdMtd ) {
        RepaymentPlanTrans pepaymentPlanTrans =new RepaymentPlanTrans();
        pepaymentPlanTrans.setId(new LmPmShdId(shdMtd.getLoanNo(),0));
        pepaymentPlanTrans.setPsDueDt(shdMtd.getIntStartDt());
        pepaymentPlanTrans.setPsInstmAmt(MinosConst.ZERO_BIGDECIMAL);
        pepaymentPlanTrans.setPsPrcpAmt(MinosConst.ZERO_BIGDECIMAL);
        pepaymentPlanTrans.setPsNormIntAmt(MinosConst.ZERO_BIGDECIMAL);
        pepaymentPlanTrans.setPsIntRate(shdMtd.getLoanIntRate());
        pepaymentPlanTrans.setPsOdIntRate(shdMtd.getLoanOdIntRate());
        pepaymentPlanTrans.setPsRemPrcp(shdMtd.getTermPrcpAmt());
        return PayRuleDefaultUtils.constructNewLmPmShd(pepaymentPlanTrans);
    }

    /**
     * 构造新的还款计划
     *
     * @param repayment
     * */
    public static LmPmShd constructNewLmPmShd(RepaymentPlanTrans repayment) {
        LmPmShd shd = new LmPmShd();
        shd.setLoanNo(repayment.getId().getLoanNo());
        shd.setPsPerdNo(repayment.getId().getPsPerdNo());
        shd.setPsBillDt(repayment.getPsBillDt());
        shd.setPsDueDt(repayment.getPsDueDt());
        shd.setPsInstmAmt(repayment.getPsInstmAmt());
        shd.setPsPrcpAmt(repayment.getPsPrcpAmt());
        shd.setPsNormIntAmt(repayment.getPsNormIntAmt());
        shd.setPsOdIntAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsCommOdInt(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setProdPrcpAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setProdIntAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setProdCommIntAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setProdFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsRemPrcp(repayment.getPsRemPrcp());
        shd.setSetlPrcp(MinosConst.ZERO_BIGDECIMAL);
        shd.setSetlNormInt(MinosConst.ZERO_BIGDECIMAL);
        shd.setSetlOdIntAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setSetlCommOdInt(MinosConst.ZERO_BIGDECIMAL);
        shd.setSetlFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsIntRate(repayment.getPsIntRate());
        shd.setPsOdIntRate(repayment.getPsOdIntRate());
        shd.setPsOdInd(YnFlagEnum.NO.getCodeInDb());
        shd.setLastSetlDt("");
        shd.setSetlOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        shd.setSetlIncTaken(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsIncTaken(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsWvNmInt(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsWvOdInt(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsWvCommInt(MinosConst.ZERO_BIGDECIMAL);
        shd.setPrcpState(PrcpAndIntStateEnum.NORMAL.getCodeInDb());
        shd.setIntState(PrcpAndIntStateEnum.NORMAL.getCodeInDb());
        shd.setSetlInd(YnFlagEnum.NO.getCodeInDb());
        shd.setPpErInd(YnFlagEnum.NO.getCodeInDb());
        shd.setPsOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        shd.setPsGenProdDt(null);
        shd.setPsCurOdIncTaken(MinosConst.ZERO_BIGDECIMAL);
        return shd;
    }
}
