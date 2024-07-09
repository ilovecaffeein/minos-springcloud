package com.caxs.minos.utils;

import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.exception.MinosException;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2020/8/14.
 */
public class PayShchedueCalUtils {
    //还款计划对象
    private LmPmShd paySchedue;
    //期号
    private int perdNo;
    //当前业务日期
    private Date buzDate;

    private BigDecimal daylyRate;

    //设置日利率
    public BigDecimal getDaylyRate() {
        return daylyRate;
    }

    public void setDaylyRate(BigDecimal daylyRate) {
        this.daylyRate = daylyRate;
    }

    /**
     * 当期正常应还金额
     * @return 当期正常应还金额
     */
    public double getNormInstPrcp() {
        double prcp = 0;
        double setl = 0;
        double normalInt = 0;
        double normalSetl = 0;
        if (paySchedue.getPsPrcpAmt() != null) {
            prcp = paySchedue.getPsPrcpAmt().doubleValue();
        }
        if (paySchedue.getSetlPrcp() != null) {
            setl = paySchedue.getSetlPrcp().doubleValue();
        }

        if (paySchedue.getPsNormIntAmt() != null) {
            normalInt = paySchedue.getPsNormIntAmt().doubleValue();
        }

        if (paySchedue.getSetlNormInt() != null) {
            normalSetl = paySchedue.getSetlNormInt().doubleValue();
        }

        return SystemUtils.getDoubleWhenEvenUp(DigitalUtils.subtract(prcp, setl))
                + SystemUtils.getDoubleWhenEvenUp(DigitalUtils.subtract(
                normalInt, normalSetl));
    }

    /**
     * 正常应还利息
     * @return 正常应还利息
     */
    public double getNormInt() {
        double normalInt = 0;
        double normalSetl = 0;
        if (paySchedue.getPsNormIntAmt() != null) {
            normalInt = paySchedue.getPsNormIntAmt().doubleValue();
        }

        if (paySchedue.getSetlNormInt() != null) {
            normalSetl = paySchedue.getSetlNormInt().doubleValue();
        }

        return DigitalUtils.subtract(normalInt, normalSetl);

    }

    /**
     * 未计提金额
     * @return 未计提金额
     */
    public double getOsIncTaken() {
        double normalIntAmt = 0;
        double incTaken = 0;
        if (paySchedue.getPsNormIntAmt() != null) {
            normalIntAmt = paySchedue.getPsNormIntAmt().doubleValue();
        }

        if (paySchedue.getPsIncTaken() != null) {
            incTaken = paySchedue.getPsIncTaken().doubleValue();
        }

        return DigitalUtils.subtract(normalIntAmt, incTaken);

    }

    /**
     * 当期应扣
     * @return 当期应扣
     */
    public double getThisPerdAllOwe() {
        return this.getNormInstPrcp() + this.getOdInt() + this.getCommInt();
    }

    /**
     * 返回应付正常利息+应付复利+应付逾期利息
     * @return 返回 应付正常利息+应付复利+应付逾期利息
     */
    public double getAllInterest() {
        double sum = DigitalUtils.amtAdd(getOdInt(), getCommInt());
        sum = DigitalUtils.amtAdd(getNormInt(), sum);
        return sum;
    }

    /**
     * 当期应还本金
     * @return 当期应还本金
     */
    public double getPrcp() {
        double prcp = 0;
        double setl = 0;
        if (paySchedue.getPsPrcpAmt() != null) {
            prcp = paySchedue.getPsPrcpAmt().doubleValue();
        }
        if (paySchedue.getSetlPrcp() != null) {
            setl = paySchedue.getSetlPrcp().doubleValue();
        }
        return SystemUtils.getDoubleWhenEvenUp(DigitalUtils.subtract(prcp, setl));

    }

    /**
     * 当期应还逾期利息
     * @return 当期应还逾期利息
     */
    public double getOdInt() {
        double odInt = 0;
        double setl = 0;
        if (paySchedue.getPsOdIntAmt() != null) {
            odInt = paySchedue.getPsOdIntAmt().doubleValue();
        }
        if (paySchedue.getSetlOdIntAmt() != null) {
            setl = paySchedue.getSetlOdIntAmt().doubleValue();
        }
        return SystemUtils
                .getDoubleWhenEvenUp(DigitalUtils.subtract(odInt, setl));
    }

    /**
     * 获取期号
     * @return 获取期号
     */
    public Integer getPeriodNo() {
        return paySchedue.getPsPerdNo();
    }

    /**
     * 到期时间
     *
     * @return
     */
    public String getDueDate() {
        return this.paySchedue.getPsDueDt();
    }

    /**
     * 罚息产生的利息
     * @return 罚息产生的利息
     */
    public double getCommInt() {
        double odInt = 0;
        double setl = 0;
        if (paySchedue.getPsCommOdInt() != null) {
            odInt = paySchedue.getPsCommOdInt().doubleValue();
        }
        if (paySchedue.getSetlCommOdInt() != null) {
            setl = paySchedue.getSetlCommOdInt().doubleValue();
        }
        return SystemUtils
                .getDoubleWhenEvenUp(DigitalUtils.subtract(odInt, setl));
    }


    /**
     * 费用产生
     * @return 费用
     */
    public double getFeeAmt() {
        double feeAmt = 0;
        double setFeeAmt = 0;
        if (paySchedue.getPsFeeAmt() != null) {
            feeAmt = paySchedue.getPsFeeAmt().doubleValue();
        }
        if (paySchedue.getSetlFeeAmt() != null) {
            setFeeAmt = paySchedue.getSetlFeeAmt().doubleValue();
        }
        return SystemUtils
                .getDoubleWhenEvenUp(SystemUtils.amtSubs(feeAmt, setFeeAmt));
    }

    /**
     * 逾期费用产生
     * @return 逾期费用
     */
    public double getOdFeeAmt() {
        double feeOdAmt = 0;
        double setOdFeeAmt = 0;
        if (paySchedue.getPsOdIntFeeAmt() != null) {
            feeOdAmt = paySchedue.getPsOdIntFeeAmt().doubleValue();

        }
        if (paySchedue.getSetlOdIntFeeAmt() != null) {
            setOdFeeAmt = paySchedue.getSetlOdIntFeeAmt().doubleValue();
        }
        return SystemUtils
                .getDoubleWhenEvenUp(SystemUtils.amtSubs(feeOdAmt, setOdFeeAmt));
    }


    /**
     * 上次逾期产生日
     * @return 上次逾期产生日
     */
    public Date getCommOdGenDate() {
        return DateOperation.parseStringToDate(this.paySchedue.getCommOdGenDt());
    }

    /**
     * 上次逾期产生日
     * @return 上次逾期产生日
     */
    public String getCommOdGenDateString() {
        return this.paySchedue.getCommOdGenDt();
    }

    /**
     * 上次逾期产生日
     * @return 上次逾期产生日
     */
    public String getPsGenProdDtString() {
        return this.paySchedue.getPsGenProdDt();
    }

    /**
     * 返回还款计划表
     * @return 返回还款计划表
     */
    public LmPmShd getLmPmShd() {
        return this.paySchedue;
    }

    //还款计划对象
    public PayShchedueCalUtils(LmPmShd paySchedue, Date buzDate) {
        this.paySchedue = paySchedue;
        this.buzDate = buzDate;
        this.perdNo = getPeriodNo();
    }

    /**
     * 在list中查找本对象。
     *
     * @param list
     * @param perdNo
     * @return
     */
    public static PayShchedueCalUtils findInList(List<PayShchedueCalUtils> list,
                                                 int perdNo) {
        for (PayShchedueCalUtils cal : list) {
            if (cal.getPeriodNo() == perdNo) {
                return cal;
            }
        }
        throw new MinosException("not found PayShchedueCal");
    }

    /**
     * 本金积数
     * @return 本金积数
     */
    public double getProdPrcpAmt() {
        return SystemUtils.getZeroDoubleIfNull(paySchedue.getProdPrcpAmt().doubleValue());
    }
    //获取利息积数
    public double getProdIntAmt() {
        return SystemUtils.getZeroDoubleIfNull(paySchedue.getProdIntAmt().doubleValue());
    }
    //获取复利积数
    public double getProdCommIntAmt() {
        return SystemUtils.getZeroDoubleIfNull(paySchedue.getProdCommIntAmt().doubleValue());
    }
    //获取扣款日
    public String getPsDueDt() {
        return paySchedue.getPsDueDt();
    }

    /**
     * 是否检查滚积数天数
     */
    private boolean checkDayCount = true;

    /**
     * 设置是否检查滚积数天数
     */
    public void setCheckDayCount(boolean checkDayCount) {
        this.checkDayCount = checkDayCount;
    }
    /**
     * 最后一次滚积数日期，可以通过这个覆盖数据的已滚积数日期
     */
    private String curProdDt=null;


    public String getCurProdDt() {
        return curProdDt;
    }

    public void setCurProdDt(String curProdDt) {
        this.curProdDt = curProdDt;
    }

    /**
     * 计算积数天数 应该总是1
     *
     * @return
     */
    public int calIntProdDayCount() {
        String genProdDt = paySchedue.getPsGenProdDt();
        if (curProdDt != null) {
            genProdDt = curProdDt;
        }
        if (StringUtils.isEmpty(genProdDt)) {
            // 减少一天。
            return 1;
        } else {
            int nDays = (int) DateOperation.DateCal(DateOperation.formatDate(buzDate), genProdDt);
            if (checkDayCount) {
                if (nDays > 1) {
                    if (SystemUtils.isAmtGreatThanZero(this.getNormInt())
                            || SystemUtils.isAmtGreatThanZero(this.getOdInt())
                            || SystemUtils.isAmtGreatThanZero(this.getPrcp())) {
                        throw new MinosException(paySchedue.getLoanNo()
                                + "上次罚息积数日期:"
                                + genProdDt
                                + "，累计天数:"
                                + nDays
                                + "不能>1");
                    }
                }
            } else {
            }
            return nDays;
        }
    }
    //获取罚息利率
    public double getOdIntRate() {
        return SystemUtils.getZeroDoubleIfNull(paySchedue.getPsOdIntRate().doubleValue());
    }

    //获取哈希值
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + perdNo;
        return result;
    }

    //判断是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PayShchedueCalUtils other = (PayShchedueCalUtils) obj;
        if (perdNo != other.perdNo)
            return false;
        return true;
    }
    //是否检查滚积数天数
    public boolean isCheckDayCount() {
        return checkDayCount;
    }
}
