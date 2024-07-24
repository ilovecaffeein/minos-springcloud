package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.LmLoanContDao;
import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.dao.SCcyDao;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.SCcy;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;
import com.caxs.minos.enums.CommPartEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.buz.InterestCalImp;
import com.caxs.minos.serv.db.IPunishCalorService;
import com.caxs.minos.utils.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * @Description: 宽限期计算
 * @Author: coffee
 * @Date: 2020/7/28 14:24
 * @Version: v1.0 文件初始创建
 */
@Component
@Service
public class PunishCalorService implements IPunishCalorService {
    //打印日志属性
    private Log log = LogFactory.getLog(getClass());

    @Autowired
    private LmLoanDao lmLoanDao;

    @Autowired
    private LmLoanContDao lmLoanContDao;

    @Autowired
    SCcyDao sCcyDao;

    //复利部分代码
    private CommPartEnum commPart;
    public void setCommPart(CommPartEnum commPart) {
        this.commPart = commPart;
    }

    //还款计划计算器列表对象属性
    private List<PayShchedueCalUtils> payShdCals;
    //是否计算复利和罚息
    private YnFlagEnum isCalCommAndOdInt;
    public void setIsCalCommAndOdInt(YnFlagEnum isCalCommAndOdInt) {
        this.isCalCommAndOdInt = isCalCommAndOdInt;
    }

    //最大日期串
    private String maxDateString = null;
    public void setMaxDateString(String maxDateString) {
        this.maxDateString = maxDateString;
    }

    //上次罚息积数日期
    private String priorOdGenDate;
    public void setPriorOdGenDate(String priorOdGenDate) {
        this.priorOdGenDate = priorOdGenDate;
    }

    //是否在利息宽限期
    private boolean isInIntGrace;
    public void setInIntGrace(boolean isInIntGrace) {
        this.isInIntGrace = isInIntGrace;
    }

    //是否在本金宽限期
    private boolean isInPrcpGrace;
    public void setInPrcpGrace(boolean isInPrcpGrace) {
        this.isInPrcpGrace = isInPrcpGrace;
    }

    //罚息参数
    public PunishConfigUtils punishConfig;
    //贷款所有利率对象
    private LoanRelateUtils loanRates;

    /**
     * 设置附加的本金积数
     */
    private double appendedProdPrcp = 0;

    //获取罚息参数对象
    public PunishConfigUtils getPc() {
        return punishConfig;
    }
    public void setPunishConfig(PunishConfigUtils punishConfig) {
        this.punishConfig = punishConfig;
    }

    /**
     * 是否计算最后一天利息
     */
    private boolean isCalLastDayInterest = false;

    //贷款所有利率对象
    private Double defaultLoanRate;
    public void setDefaultLoanRate(Double defaultLoanRate) {
        this.defaultLoanRate = defaultLoanRate;
    }

    //获取还款计划计算器列表
    public List<PayShchedueCalUtils> getPayShdCals() {
        return payShdCals;
    }
    public void setPayShdCals(List<PayShchedueCalUtils> payShdCals) {
        this.payShdCals = payShdCals;
    }

    /**
     * 构造函数
     */
    public PunishCalorService() {

    }

    /**
     * 借据罚息计算构造方法
     * @param payShdCals
     * @param punishConfig
     * @param defaultLoanRate
     * @param isInIntGrace
     * @param isInPrcpGrace
     * @newDaylyRate
     */
    public PunishCalorService(List<PayShchedueCalUtils> payShdCals , PunishConfigUtils punishConfig,
                              double defaultLoanRate, boolean isInIntGrace, boolean isInPrcpGrace) {
        this.payShdCals = payShdCals;
        this.commPart = punishConfig.getCommPart();
        this.punishConfig = punishConfig;
        this.defaultLoanRate = defaultLoanRate;
        this.isInIntGrace = isInIntGrace;
        this.isInPrcpGrace = isInPrcpGrace;
        this.isCalCommAndOdInt = punishConfig.getIsCalCommAndOdInt();
    }


    /**
     * 计算罚息
     * @param shdCalList
     * @param checkGraceDay
     * @param isToPay
     * @return
     */
    public IPunishCalorService buildPunishCal(List<PayShchedueCalUtils> shdCalList,
                                             PunishConfigUtils punishConfig, LoanRelateUtils loanRelate ,
                                             String buzDate, boolean checkGraceDay, boolean isToPay) {
        boolean isInPrcpGrace = false;//本金宽限期(计算罚息)
        boolean isInIntGrace = false;//利息宽限期(计算复利)
        // 检查宽限期
        if (checkGraceDay) {
            //是否在本金宽限期
            if (isInGraceDay(shdCalList,loanRelate,buzDate,isToPay)) {
                isInPrcpGrace = true;
            }
            //是否在罚息宽限期
            if (isInIntGrace(shdCalList,loanRelate,buzDate,isToPay)) {
                isInIntGrace = true;
            }
        }
        IPunishCalorService punishCalor = new PunishCalorService(shdCalList, punishConfig,
                loanRelate.getDefaultLoanRate(),isInIntGrace,isInPrcpGrace);
        return punishCalor;
    }

    /**
     * 是否在宽限期内 在宽限期内不扣罚息
     *
     * @param payShd
     * @param isToPay
     * @return
     */
    public boolean isInGraceDay(List<PayShchedueCalUtils> payShd,LoanRelateUtils loanRelate,
                                String buzDate,boolean isToPay) {
        if (CollectionUtils.isEmpty(payShd)) {
            return false;
        }
        PayShchedueCalUtils firstOwePsc = payShd.get(0);
        if (firstOwePsc.getPeriodNo() == 0) {
            if (payShd.size() > 1) {
                firstOwePsc = payShd.get(1);
            }
        }
        return loanRelate.isInGraceDay(buzDate,firstOwePsc.getPsDueDt(), isToPay);

    }

    /**
     * 是否在利息宽限期内 在利息宽限期内不扣复利
     *
     * @param payShd
     * @param isToPay
     * @return
     */
    public boolean isInIntGrace(List<PayShchedueCalUtils> payShd,LoanRelateUtils loanRelate ,
                                String buzDate,boolean isToPay) {
        if (CollectionUtils.isEmpty(payShd)) {
            return false;
        }
        PayShchedueCalUtils firstOwePsc = payShd.get(0);
        if (firstOwePsc.getPeriodNo() == 0) {
            if (payShd.size() > 1) {
                firstOwePsc = payShd.get(1);
            }
        }
        return loanRelate.isInIntGraceDay(buzDate, firstOwePsc.getPsDueDt(), isToPay);
    }

    /**
     * 计算罚息信息
     * @param dayCountYearly
     * @param isCalInterest
     */
    @Override
    public Map<Integer, PunishIntFieldsTrans> execute(int dayCountYearly, boolean isCalInterest) {
        Map<Integer, PunishIntFieldsTrans> result = new TreeMap<Integer, PunishIntFieldsTrans>();
        calNewRateInterst(result,true);
        roundResult(result);
        return result;
    }


    /**
     * 计算罚息信息
     * @param shdList
     * @param buzDate
     * @param checkGraceDay
     * @param isToPay
     * @param isToPay
     */
    @Override
    public Map<Integer, PunishIntFieldsTrans> execute(List<LmPmShd> shdList,
                           String buzDate, boolean checkGraceDay, boolean isToPay,boolean isCalInterest) {

        LmLoan lmLoan = lmLoanDao.findByLoanNo(shdList.get(0).getLoanNo());
        if (lmLoan == null) {
            throw new MinosException("此借据无借据主表信息！");
        }
        LmLoanCont lmLoanCont = lmLoanContDao.selectOneByLoanContNo(lmLoan.getLoanContNo());
        if (lmLoanCont == null) {
            throw new MinosException("此借据无合同主表信息！");
        }
        SCcy sCcy = sCcyDao.selectOneBySCcy(lmLoan.getLoanCcy());
        if (sCcy == null)
            throw new MinosException("not found ccyCde");
        LoanRelateUtils loanRelate = new LoanRelateUtils(lmLoan, lmLoanCont);

        /* 取贷款参数 是否计算复利 */
        /* 新罚息利率 */
        LoanRateUtils loanRate = new LoanRateUtils(lmLoan, lmLoanCont,sCcy.getCcyBase());
        //计算宽限期概念
        CommPartEnum odCommPart = CommPartEnum.getEnum(loanRelate.getLoanOdCommPart());
        PunishConfigUtils punishConfig = new PunishConfigUtils();
        punishConfig.setCommPart(odCommPart);
        //设置是否计算罚息复利
        YnFlagEnum ynFlagEnum = YnFlagEnum.getEnum(lmLoanCont.getLoanOdCpdInd());
        punishConfig.setIsCalCommAndOdInt(ynFlagEnum);
        //是否停止罚息
        punishConfig.setLoanOdGraceInd(YnFlagEnum.isTrue(lmLoanCont.getLoanOdGraceInd()));
        //是否停止复利
        punishConfig.setLoanOdIntGraceInd(YnFlagEnum.isTrue(lmLoanCont.getLoanOdIntGraceInd()));

        // payShchedueCalList 赋值
        List<PayShchedueCalUtils> payShchedueCalList = new ArrayList<PayShchedueCalUtils>();
        for (int index = 0; index < shdList.size(); index++) {
            PayShchedueCalUtils payShchedueCal = new PayShchedueCalUtils(shdList
                    .get(index), DateOperation.parseStringToDate(buzDate));
            payShchedueCal.setDaylyRate(loanRate.getLendOdIntRateDayly());
            payShchedueCal.setCheckDayCount(true);
            payShchedueCalList.add(payShchedueCal);
        }
        boolean isInPrcpGrace = false;//本金宽限期(计算罚息)
        boolean isInIntGrace = false;//利息宽限期(计算复利)
        // 检查宽限期
        if (checkGraceDay) {
            //是否在本金宽限期
            if (isInGraceDay(payShchedueCalList,loanRelate,buzDate,isToPay)) {
                isInPrcpGrace = true;
            }
            //是否在罚息宽限期
            if (isInIntGrace(payShchedueCalList,loanRelate,buzDate,isToPay)) {
                isInIntGrace = true;
            }
        }
        this.setPayShdCals(payShchedueCalList);
        this.setPunishConfig(punishConfig);
        this.setDefaultLoanRate(loanRelate.getDefaultLoanRate());
        this.setInIntGrace(isInIntGrace);
        this.setInPrcpGrace(isInPrcpGrace);
        this.setIsCalCommAndOdInt(punishConfig.getIsCalCommAndOdInt());
        this.setCommPart(punishConfig.getCommPart());

        Map<Integer, PunishIntFieldsTrans> result = new TreeMap<Integer, PunishIntFieldsTrans>();
        calNewRateInterst(result,isCalInterest);
        roundResult(result);
        return result;
    }

    /**
     * 新利率 增加一个零填充
     * @param result
     * @param isCalInterest
     */
    private void calNewRateInterst(Map<Integer, PunishIntFieldsTrans> result, boolean isCalInterest) {
        Integer perNo;
        double commInt = 0;// 复利利息
        double odInt = 0;
        double prodPrcp;
        double prodNormInt;
        double prodComm;
        PunishIntFieldsTrans fields;
        long nDays;
        for (PayShchedueCalUtils cal : payShdCals) {
            if ( punishConfig.isStopOdInt()) {
                nDays = 0;
            } else {
                nDays = cal.calIntProdDayCount();
            }
            if (isCalInterest) {
                if (cal.isCheckDayCount()) {
                    nDays = 0;
                }
            }
            odInt = 0;
            commInt = 0;

            double prcpAmt = DigitalUtils.getAmtForInterestCal(cal.getPrcp());  //当期应还本金
            double oweNormIntAmt = DigitalUtils.getAmtForInterestCal(cal.getNormInt());//应还利息
            double oweOdIntAmt = DigitalUtils.getAmtForInterestCal(cal.getOdInt());//应还罚息
            double oweCommIntAmt = DigitalUtils.getAmtForInterestCal(cal.getCommInt());//应还复利

            // 积数分类
            prodPrcp = DigitalUtils.getAmtForInterestCal(cal.getProdPrcpAmt() + prcpAmt * nDays);  //本金积数
            prodNormInt = DigitalUtils.getAmtForInterestCal(cal.getProdIntAmt() + oweNormIntAmt * nDays); //利息积数
            prodComm = DigitalUtils.getAmtForInterestCal(cal.getProdCommIntAmt() + oweCommIntAmt * nDays
                    + oweOdIntAmt * nDays); //复利积数
            if (log.isDebugEnabled()) {
                log.info("期数=" + cal.getPeriodNo());
                log.info("天数=" + nDays);
                log.info("本金积数=" + String.valueOf(prodPrcp));
                log.info("利息积数=" + prodNormInt);
                log.info("罚息积数=" + oweOdIntAmt);
                log.info("复利积数=" + oweOdIntAmt);
            }

            // 利率必须大于0
            if (isCalInterest
                    && (cal.getDaylyRate().doubleValue() >= MinosConst.DEFAULT_FLOAT_COMPARE_VALUE)) {
                PunishInterest punishInterest = calPunishInterest(prodPrcp,prodNormInt,
                        prodComm, cal.getDaylyRate());
                odInt = punishInterest.odInt;
                commInt = punishInterest.commInt;
            }
            perNo = cal.getPeriodNo();
            fields = new PunishIntFieldsTrans();
            if (isCalInterest) {
                fields.setCommInt(commInt);
                fields.setOdInt(odInt);
                if (log.isDebugEnabled()) {
                    log.info("new commint=" + commInt);
                    log.info("new Odint=" + odInt);
                }
            }
            fields.setProdPrcpAmt(prodPrcp);//本金积数
            fields.setProdOdAmt(prodNormInt);//利息积数
            fields.setProdCommAmt(prodComm);//复利积数
            fields.setSum(commInt + odInt); //（复利+ 复利）金额
            result.put(perNo, fields);
        }
    }

    /**
     * 计算罚息信息汇总
     * @param map
     */
    @Override
    public PunishIntFieldsTrans sumAllInt(Map<Integer, PunishIntFieldsTrans> map) {
        PunishIntFieldsTrans result = new PunishIntFieldsTrans();
        double commInt = 0;
        double odInt = 0;
        for (PunishIntFieldsTrans f : map.values()) {
            odInt += f.getOdInt();
            commInt += f.getCommInt();
        }
        result.setCommInt(commInt);
        result.setOdInt(odInt);
        result.setSum(commInt + odInt);
        return result;
    }

    /**
     * 计算罚息信息汇总
     * @param map
     */
    @Override
    public PunishIntFieldsTrans sumAllIntByMap(Map<Integer, PunishIntFieldsTrans> map) {
        return sumAllInt(map);
    }


    /**
     * 结果信息修约
     * @param result
     */
    private void roundResult(Map<Integer, PunishIntFieldsTrans> result) {
        PunishIntFieldsTrans fields;
        for (Integer perdNo : result.keySet()) {
            fields = result.get(perdNo);
            double commInt = SystemUtils.getDoubleWhenEvenUp(fields.getCommInt());
            double odInt = SystemUtils.getDoubleWhenEvenUp(fields.getOdInt() + fields.getAppedOdInt());
            fields.setCommInt(commInt);
            fields.setOdInt(odInt);
        }
    }

    /**
     * 罚息
     * @author coffe
     *
     */
    private class PunishInterest {
        double odInt = 0;
        double commInt = 0;
    }

    /**
     * 计算罚息信息
     * @param prodNormInt
     * @param prodComm
     * @param prodPrcp
     * @param daylyRate
     */
    private PunishInterest calPunishInterest(double prodPrcp,double prodNormInt,double prodComm, BigDecimal daylyRate) {
        PunishInterest pi = new PunishInterest();
        if (isCalCommAndOdInt != YnFlagEnum.YES) {
            return pi;
        }
        double prodForOdIntCal = 0;
        double prodForCommIntCal = 0;
        boolean hasCommInt = false;
        switch (commPart) {
            case INTEREST:// 正常利息算作罚息，本金不算
                prodForOdIntCal = prodNormInt + prodComm;
                break;
            case PROP:
                prodForOdIntCal = prodPrcp;
                break;
            case IP:
                prodForOdIntCal = prodPrcp + prodNormInt + prodComm;
                break;
            case ALL:
            case IPALL1:
                if(punishConfig.getLoanOdIntGraceInd())
                    prodForOdIntCal = prodPrcp;
                if(punishConfig.getLoanOdGraceInd());
                prodForCommIntCal = prodComm + prodNormInt;
                hasCommInt = true;
                break;
            case IPALL:
                    prodForCommIntCal = prodComm;
                    prodForOdIntCal = prodPrcp + prodNormInt;
                hasCommInt = true;
                break;
            default:
                throw new MinosException("not support Comm parameter:"
                        + commPart.getCodeInDb());
        }
        prodForOdIntCal = DigitalUtils.getAmtForInterestCal(prodForOdIntCal);
        //不在本金宽限期才计算罚息
        if (!isInPrcpGrace) {
            pi.odInt = InterestCalImp.computeInterest(daylyRate.doubleValue(),prodForOdIntCal,2);
        }
        //不在利息宽限期才计算复利
        if (hasCommInt && !isInIntGrace) {
            pi.commInt = InterestCalImp.computeInterest(daylyRate.doubleValue(), prodForCommIntCal,2);
        }
        return pi;
    }

}
