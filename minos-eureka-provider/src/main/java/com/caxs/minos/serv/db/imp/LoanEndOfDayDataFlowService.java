package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.LmLnShdMtdDao;
import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.dao.LmPmShdDao;
import com.caxs.minos.domain.LmLnShdMtd;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ILoanEndOfDayDataFlowService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 日终交易数据流操作
 * @Date: 2020/8/17 16:15
 * @Author: coffee
 * @Throws
 */
@Component
@Service
public class LoanEndOfDayDataFlowService implements ILoanEndOfDayDataFlowService {
    private Log log = LogFactory.getLog(getClass());

    @Resource
    LmLoanDao lmLoanDao;

    @Resource
    LmPmShdDao lmPmShdDao;

    @Resource
    LmLnShdMtdDao  lmLnShdMtdDao;




    @Override
    public LmPmShd findCurrDueDtShd(String buzDate) {
        return null;
    }

    @Override
    public LmPmShd getLastPmShd(String loanNO) {
        LmPmShd lmPmShd =lmPmShdDao.findLastPerdNo(loanNO);
        if (lmPmShd == null) {
            throw new MinosException("没有找到最后一期还款计划表");
        }
        return lmPmShd;
    }

    @Override
    public LmPmShd findCurrDueDtShd(String loanNo, String buzDate) {
        LmLoan lmLoan = lmLoanDao.findByLoanNo(loanNo);
        if ( lmLoan == null) {
            throw new MinosException(" 借据表信息不存在:" + buzDate);
        }
        if (lmLoan.getLastDueDt().compareTo(buzDate) <= 0) {
            return getLastPmShd(loanNo);
        }
        LmPmShd curDueShd = lmPmShdDao.findMinPsDueDtAfterBuz(loanNo, buzDate);
        if (curDueShd == null) {
            if (lmLoan.getIntStartDt().equals(buzDate)) {
                return getLmPmShd(loanNo,0);
            } else {
                return getLastPmShd(loanNo);
            }
        }
        if (curDueShd == null) {
            throw new MinosException("没有找到应还期数:" + buzDate);
        }
        return curDueShd;
    }

    @Override
    public LmPmShd getLmPmShd(String loanNO, int perdNo) {
        LmPmShd lmPmShd =new LmPmShd();
        lmPmShd.setPsPerdNo(perdNo);
        lmPmShd.setLoanNo(loanNO);
        return lmPmShdDao.selectOneByObject(lmPmShd);
    }

    @Override
    public LmPmShd findByPsDueDt(String loanNo, String buzDate) {
        try {
            List<LmPmShd> list = lmPmShdDao.findByPsDueDt(loanNo,buzDate);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (RuntimeException e) {
            throw new MinosException("find error!", e);
        }
    }

    @Override
    public int findCurrDuePerdNo(String loanNo, String buzDate) {
        LmPmShd shd = lmPmShdDao.findMaxPerdNoBeforePsDueDt(loanNo, buzDate);
        if (shd == null) {
            throw new MinosException("没有找到最大期");
        }
        return shd.getPsPerdNo() + 1;
    }

    // 获取等于当天的还款计划
    public LmPmShd getInterestDatePmShdEqualToday(String loanNo,String operationDate) {
        return getInterestDateShd(loanNo, operationDate, true);
    }

    /**
     * 查询<=operationDate 的利息计算起始期。
     *
     * @param buzDate
     *            查询日期
     * @return shd 还款计划表
     */
    public LmPmShd getInterestDateShd(String loanNo,String buzDate,boolean isEqualDate) {
        LmLoan lmLoan = lmLoanDao.findByLoanNo(loanNo);
        if ( lmLoan == null ) {
            throw new MinosException(" 借据信息不存在！");
        }
        LmPmShd shd = lmPmShdDao.findMaxPerdNoBefore(lmLoan.getLoanNo(),buzDate);
        if ( shd == null ) {
            if (buzDate.equals(lmLoan.getIntStartDt())) {
                shd = getLmPmShd(lmLoan.getLoanNo(), 0);
                if (shd != null) {
                    return shd;
                }
            }
            throw new MinosException("没有找到利息计算开始日！");
        }
        return shd;
    }


    /**
     * 是否采用实际天数来计算利息
     *
     * @return
     */
    @Override
    public boolean isCaculateAccordingActualDay(String loanNo,int perdNo) {
        LmLnShdMtd lnShdMtd = findMtdByPerdNo(loanNo, perdNo);
        return !"M".equals(lnShdMtd.getRatBase());
    }

    // 根据期号查询还款方式
    public LmLnShdMtd findMtdByPerdNo(String loanNo, int perdNo) {
        LmLnShdMtd lmLnShdMtd =new LmLnShdMtd();
        lmLnShdMtd.setLoanNo(loanNo);
        List<LmLnShdMtd> list =lmLnShdMtdDao.selectListByObject(lmLnShdMtd);
        for (LmLnShdMtd mtd : list) {
            if ( perdNo >= mtd.getFrmPerd().intValue()) {
                if (perdNo <= mtd.getToPerd().intValue()) {
                    return mtd;
                }
            }
        }
        throw new MinosException("借据" + loanNo + "没有找到期号：" + perdNo
                + "，所在的阶段");
    }

}
