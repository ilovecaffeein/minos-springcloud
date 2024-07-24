package com.caxs.minos.serv.db.imp;

import java.util.ArrayList;
import java.util.List;
import com.caxs.minos.dao.PLoanMtdDao;
import com.caxs.minos.dao.PLoanMtdDtlDao;
import com.caxs.minos.def.PUBConstant;
import com.caxs.minos.domain.PLoanMtd;
import com.caxs.minos.domain.PLoanMtdDtl;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IMtdUtilsService;
import com.caxs.minos.utils.PaymentUtils;
import com.yuchengtech.ycloans.buz.domain.ShdMtd;
import com.yuchengtech.ycloans.buz.payment.shd.GenShdInfoQueryImp;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/***
 * @ClassName(类名) : MtdUtilsService
 * @Description(描述) :放款试算用
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/17 15:48
 */
@Component
@Service
public class MtdUtilsService  implements IMtdUtilsService {
	private final static Log log = LogFactory.getLog(MtdUtilsService.class);

	@Resource
	PLoanMtdDao pLoanMtdDao;

	@Resource
	PLoanMtdDtlDao pLoanMtdDtlDAO;

	/**
	 * 放款试算用
	 * @param mlt
	 */
	public List<ShdMtd> createNomalMtdT(GenShdInfoQueryImp mlt, PaymentFreq freq) {
		List<ShdMtd> shdMtdList = new ArrayList<ShdMtd>();
		try {
			String mtdCde = mlt.getLoanPaymMtd();
			PLoanMtd plm = pLoanMtdDao.selectByPrimaryKey(new PLoanMtd(mtdCde));
			List<PLoanMtdDtl> plmdList = pLoanMtdDtlDAO.selectListByObject(new PLoanMtdDtl(mtdCde));
			String loanActvDt = mlt.getLoanActvDt();
			String lastDueDt = mlt.getLastDueDt();

			PLoanMtdDtl pLoanMtdDtl = new PLoanMtdDtl();
			pLoanMtdDtl.setMtdCde(mtdCde);

			int loanInstal = PaymentUtils.calPaymentPeriodCount(loanActvDt,
					lastDueDt, freq, mlt.getPayDay(), mlt
							.getFrequencyRange(), YnFlagEnum.YES.getCodeInDb()
							.equals(plm.getInstInd()));

			String ratio = plm.getMtdByRatio();
			int term = plm.getMtdMaxTnr().intValue();// 还款方式配置中的最大期数-即实际配置中使用的期限

			int strInstl = 0; // 开始期数
			int endInstl = 0; // 结束期数
			int instl = 0;
			double instal = loanInstal;

			if (plmdList.size() > 0) {
				PLoanMtdDtl plmd = null;
				for (int j = 0; j < plmdList.size(); j++) {
					pLoanMtdDtl.setMtdDtlSeq( j+ 1);
					plmd = pLoanMtdDtlDAO.selectOneByObject(pLoanMtdDtl);

					// 还款方式配置中的每条策略的执行期数
					int mtdInstl = plmd.getMtdInstl() != null ? plmd
							.getMtdInstl().intValue() : 0;
					int realInstl = 0; // 每阶段的执行期数

					/*
					 * 判断是否为按比例设定阶段期数 如果是：贷款还款方式中每阶段的执行期数 = 还款方式配置中
					 * 每期期数的百分比*贷款申请中的期数 否则： 贷款还款方式中每阶段的执行期数 = 还款方式配置中 执行期数
					 */
					if (ratio != null && ratio.equals(YnFlagEnum.YES.getCodeInDb())) {
						realInstl = (int) Math.ceil(instal * (mtdInstl - instl)
								/ term);
						instl = mtdInstl;
					} else {
						realInstl = (int) (mtdInstl - instl);
						instl = mtdInstl;
					}

					// 贷款还款方式中每阶段的开始期数 = 上阶段结束期数+1
					// 贷款还款方式中每阶段的结束期数 = 贷款还款方式中每阶段的结束期数
					strInstl = endInstl + 1;

					endInstl = realInstl + endInstl;

					if (endInstl > instal || endInstl < strInstl) {
						endInstl = (int) instal;
					}
					ShdMtd shdMtd = new ShdMtd();
					shdMtd.setTermNo(plmd.getMtdDtlSeq().shortValue()); // 阶段号
					shdMtd.setFrmPerd(Short.valueOf(String.valueOf(strInstl))); // 从第几期
					shdMtd.setToPerd(Short.valueOf(String.valueOf(endInstl))); // 到第几期
					double prcpRatio = 0;
					if (plmd.getMtdPrcpRatio() == null) {
						if (plmd.getMtdInstl().intValue() == 998) {
							prcpRatio = 0;
						} else {
							prcpRatio = 1;
						}
					} else {
						prcpRatio = plmd.getMtdPrcpRatio().doubleValue();
					}

					shdMtd.setPrcpAmt(mlt.getOrigPrcp() * prcpRatio); // 该阶段本金
					if (mlt.getPaymentFreq().getCodeInDb() != null
							&& !"".equals(mlt.getPaymentFreq().getCodeInDb())) {
						shdMtd.setPaymFreqUnit(mlt.getPaymentFreq()
								.getCodeInDb()); // 还款间隔单位
					} else {
						shdMtd.setPaymFreqUnit("M"); // 还款间隔单位
					}
					shdMtd.setPaymFreqFreq((short) mlt.getFrequencyRange()); // 还款间隔
					shdMtd.setLoanIntRate(mlt.getLoanIntRate()); // 贷款执行利率

					shdMtd.setPaymTyp(plmd.getMtdSetlTyp()); // 还款类型
					shdMtd.setPaymOpt(plmd.getMtdRpymOpt()); // 还款方式
					// shdMtd.setTermPrcpAmt(cybCheck.getAmt(shdMtdMap
					// .get("TERM_PRCP_AMT"))); // 阶段本金额(拟还本金)
					shdMtd.setPgsPrcpPct(0.0); // 等比递增还款增加额
					shdMtd.setPgsPrcpAmt(0.0); // 等额递增还款增加额
					// 如果是本息不同间隔，获取一下本金间隔字段
					if (PUBConstant.LOAN_PAYM_TYP_BTJG.equals(plm.getMtdTyp())) {
						shdMtd.setPaymOpt("PI");
						shdMtd.setPgsPrcpFreq(((plm.getMtdPrcpFreq() == null ? 0
										: Short.valueOf(plm.getMtdPrcpFreq())))); // 本金间隔
					} else {
						shdMtd.setPgsPrcpFreq((short) 0); // 递增还款周期
					}
					// 如果还款方式配置里有计算期数,那就取库里配的,如果没有,就是0 shanyj start
					if (plmd.getMtdCalcTnr() != null
							&& plmd.getMtdCalcTnr() > 0) {
						shdMtd.setCalTotInstm(Short.valueOf(plmd
								.getMtdCalcTnr().toString())); // 实际计算期数
					} else {
						shdMtd.setCalTotInstm((short) 0);// 实际计算期数
					}
					// 如果还款方式配置里有计算期数,那就取库里配的,如果没有,就是0 shanyj end
					shdMtd.setPrcpPct(prcpRatio); // 本金比例
					// modify by shanyj on 2014-10-30 11:18:21 利率计算基础按还款周期来
					// shdMtd.setRatBase(plmd.getMtdRatBase()); // 计算类型
					shdMtd.setRatBase(mlt.getPaymentFreq().getCodeInDb()); // 计算类型
					// end
					shdMtd.setLoanOdIntRate(mlt.getLoanOdIntRate());

					// 写死的数据
					shdMtd.setIntAdjPct(0D);
					shdMtd.setBaseRate(0D);
					shdMtd.setFxPrcpAmt(0D);
					shdMtd.setIntBase("Y");
					shdMtd.setLoanNo("");
					// shdMtd.setLoanOdIntRate(0D);
					shdMtd.setLoanRateMode("FX");
					shdMtd.setRateTyp("");
					shdMtd.setSprd(0D);
					// 阶段本金 除了弹性还款都应该填空
					shdMtd.setTermPrcpAmt(null);
					shdMtd.setIntStartDt(null);
					shdMtdList.add(shdMtd);
				}
				// 根据项目配置，还款类型为按期付息到期还本时，单独构造还款方式信息 shanyj
				if (PUBConstant.LOAN_PAYM_TYP_AQJX.equals(plm.getMtdTyp())) {
					if (shdMtdList != null && shdMtdList.size() > 1) {
						ShdMtd shdMtd = shdMtdList.get(0);
						shdMtd.setToPerd(Short.valueOf(String
								.valueOf(loanInstal)));
						shdMtd.setPaymOpt("IO");
						shdMtdList.clear();
						shdMtdList.add(shdMtd);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MinosException(Cfs2MinosException.ERROR99999, ex
					.getMessage());
		}
		return shdMtdList;
	}

}
