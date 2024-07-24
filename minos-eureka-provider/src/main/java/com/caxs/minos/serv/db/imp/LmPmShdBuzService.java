package com.caxs.minos.serv.db.imp;

import java.math.BigDecimal;
import java.util.*;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.serv.buz.InterestCalImp;
import com.caxs.minos.serv.db.ILmPmShdBuzService;
import com.caxs.minos.utils.PaymentUtils;
import com.caxs.minos.utils.RateUtils;
import com.caxs.minos.utils.SystemUtils;
import com.yuchengtech.ycloans.buz.Rate;
import com.yuchengtech.ycloans.buz.domain.MtdContext;
import com.yuchengtech.ycloans.buz.domain.ShdMtd;
import com.yuchengtech.ycloans.buz.payment.shd.*;
import com.yuchengtech.ycloans.common.enumeration.LoanRateBase;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
/***
 * @ClassName(类名) : LmPmShdBuzService
 * @Description(描述) : 还款计划试算类
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LmPmShdBuzService  implements ILmPmShdBuzService {
	private final Log log = LogFactory.getLog(getClass());
	/**
	 * 还款计划试算
	 *
	 * @param genShdInfo
	 * @param shdMtdList
	 * @return
	 */
	public List<Shd> shdPreview(GenShdInfoQuery genShdInfo, List<ShdMtd> shdMtdList) {
		List<MtdContext> mtdList = new ArrayList<MtdContext>(10);
		double totalPrcpPct = 0;
		String intStartDt = genShdInfo.getIntStartDt();
		String lastPayDt = null;
		Date lastDueDt = DateOperation.getDateFromDbString(genShdInfo
				.getLastDueDt());
		int i = 0;

		int totalToPerd = shdMtdList.get(shdMtdList.size() - 1).getToPerd();
		int totalPerdCount = totalToPerd - genShdInfo.getCurrDuePerdNo() + 1;
		int remainPerdCount = 0;
		int startPerdCount = genShdInfo.getCurrDuePerdNo();
		boolean hasMulPhase = false;// 多阶段
		int mtdCount = 0;
		for (ShdMtd mtd : shdMtdList) {
			mtdCount++;
			if (!StringUtils.hasText(mtd.getIntStartDt())) {
				if (i == 0) {
					mtd.setIntStartDt(intStartDt);
				} else {
					mtd.setIntStartDt(lastPayDt);
				}
				PaymentFreq freq = genShdInfo.getPaymentFreq();
				if (StringUtils.hasText(mtd.getPaymFreqUnit())) {
					freq = PaymentFreq.getEnum(mtd.getPaymFreqUnit());
				}

				Date firstPayDt;
				int perdCount = mtd.getToPerd() - mtd.getFrmPerd();
				if (i == 0) {
					firstPayDt = DateOperation.getFirstPayDateByPaymentFreq(
							intStartDt, genShdInfo.getPayDay(), freq,
							genShdInfo.getFrequencyRange(), genShdInfo
									.isFirstPerdOverOnePaymentFreq());
				} else {
					firstPayDt = DateOperation.getDateFromDbString(lastPayDt);
					perdCount++;
				}
				String strFirstPayDt = DateOperation
						.getDateStringToDb(firstPayDt);
				lastPayDt = DateOperation.getDateStringToDb(PaymentUtils
						.calLastPayDate(firstPayDt, freq, genShdInfo
										.getFrequencyRange(), lastDueDt, perdCount,
								strFirstPayDt, genShdInfo.getPayDay()));
			}
			i++;
			MtdContext m = new MtdContext(mtd, 0);
			if (mtd.getToPerd() >= genShdInfo.getCurrDuePerdNo()) {
				totalPrcpPct += SystemUtils.getZeroDoubleIfNull(mtd
						.getPrcpPct());
				if (!hasMulPhase) {// 保守,
					hasMulPhase = shdMtdList.size() > mtdCount;
				}
				remainPerdCount = totalToPerd - startPerdCount + 1;
				startPerdCount = mtd.getToPerd() + 1;
				if (hasMulPhase) {
					m.setRemainPerdCount(remainPerdCount);
					m.setTotalPerdCount(totalPerdCount);
				}
			}
			m.setStartPrcpNIntPerdNo(mtd.getStartPrcpNIntPerdNo());
			mtdList.add(m);
		}
		if (SystemUtils.isAmtGreatThanZero(totalPrcpPct)) {
			totalPrcpPct = SystemUtils.getDouble(totalPrcpPct, 9);
			for (MtdContext mtd : mtdList) {
				mtd.setTotalPrcpPct(totalPrcpPct);
				if( ((GenShdInfoQueryImp) genShdInfo).getLoanPaymMtd().equals("RP01")
						|| ((GenShdInfoQueryImp) genShdInfo).getLoanPaymMtd().equals("RP02")){
					mtd.setTotalPrcpPct(shdMtdList.size());
				}
			}
		}
		MtdContext priorMtd = null;
		for (MtdContext m : mtdList) {
			////如果是按照节假日调整放入参数表中 hbs 20150318 end
			if (m.getToPerd() >= genShdInfo.getCurrDuePerdNo()) {
				CalMtd c = new DefaultCalMtd();
				c.cal(m, priorMtd, genShdInfo);
				if (m.getRate() != null) {
					Rate rate = m.getRate();
					if (SystemUtils.isDaylyRateEqual(rate.getDaylyRate(), 0)) {
						double daylyRate = InterestCalImp.computeDaylyRate(
								LoanRateBase.Y, new BigDecimal(rate.getIntRate()),360).doubleValue();
						rate.setDaylyRate(daylyRate);
					}
					if (SystemUtils.isDaylyRateEqual(rate.getTermlyRate(), 0)) {
						double termlyRate = RateUtils.calTermlyRate(rate.getIntRate(),360);
						rate.setTermlyRate(termlyRate);
					}
				}
				priorMtd = m;
			}
		}
		GenShdUsingMtd genShd = new GenShdUsingMtd(genShdInfo, 1, mtdList);
		return genShd.genShdList();
	}
}
