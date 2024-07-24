package com.caxs.minos.controller;

import com.caxs.minos.domain.param.serv10000100027.xmlRequest.Serv10000100027XmlRequest;
import com.caxs.minos.domain.trans.ShdMtdTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.serv.db.ILmPmShdBuzService;
import com.caxs.minos.serv.db.IMtdUtilsService;
import com.caxs.minos.serv.db.IPaymentLastDueDtCalService;
import com.caxs.minos.serv.db.ISystemInfoService;
import com.caxs.minos.utils.RateUtils;
import com.caxs.minos.utils.StringUtils;
import com.caxs.minos.xml.XmlTool;
import com.yuchengtech.ycloans.accounting.business.LoanRates;
import com.yuchengtech.ycloans.buz.domain.PaymentTerm;
import com.yuchengtech.ycloans.buz.domain.ShdMtd;
import com.yuchengtech.ycloans.buz.payment.shd.GenShdInfoQueryImp;
import com.yuchengtech.ycloans.buz.payment.shd.Shd;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.caxs.minos.utils.SystemUtils;
/***
 * @ClassName(类名) : LmPmShdBuzController
 * @Description(描述) : 还款计划试算
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@RestController
public class Serv10000100027BuzService {
	@Resource
	private IPaymentLastDueDtCalService iPaymentLastDueDtCalService;

	@Resource
	ILmPmShdBuzService iLmPmShdBuzService;

	@Resource
	IMtdUtilsService iMtdUtilsService;

	@Resource
	private ISystemInfoService systemInfoService;

	/**
	 * 还款计划试算
	 */
	@RequestMapping(value = "/lmPmShdBuz/shd",method = RequestMethod.POST)
	public List<Shd> shdPreview(@RequestBody Map<String, Object> map) throws JAXBException, Cfs2MinosException {

		Serv10000100027XmlRequest serv10000100027Xml =new Serv10000100027XmlRequest();
		String context =  map.get("context").toString();
		serv10000100027Xml = XmlTool.resolveXmlOfJaxb(context, Serv10000100027XmlRequest.class);

		GenShdInfoQueryImp genShdInfo = new GenShdInfoQueryImp();

		if ( !StringUtils.isNullOrEmpty(serv10000100027Xml.getIntStartDt())) {
		 	genShdInfo.setIntStartDt(serv10000100027Xml.getIntStartDt()); // 起息日期
		}

		if ( ! StringUtils.isNullOrEmpty(serv10000100027Xml.getLoanActvDt())) {
		 	genShdInfo.setLoanActvDt(serv10000100027Xml.getLoanActvDt()); //放款日
		}
		genShdInfo.setOrigPrcp(SystemUtils.getBigToAmt(serv10000100027Xml.getOrigPrcp())); // 放款本金
		genShdInfo.setPayDay(Integer.parseInt(serv10000100027Xml.getDueDay())); // 还款日
		genShdInfo.setPaymentFreq(PaymentFreq.getEnum(serv10000100027Xml.getPaymFreqUnit())); //还款频率
		genShdInfo.setFrequencyRange(Integer.parseInt(serv10000100027Xml.getPaymFreqFreq())); // 还款间隔
		genShdInfo.setBillDay(0);
		genShdInfo.setBuzDate(genShdInfo.getBuzDate());
		genShdInfo.setCurrDueInterest(0);
		genShdInfo.setCurrDuePerdNo(1);
		genShdInfo.setFirstBillDate(null);
		genShdInfo.setLoanIntRate(SystemUtils.getObToRate(serv10000100027Xml.getLoanIntRate()));//执行利率
		genShdInfo.setLoanPaymMtd(serv10000100027Xml.getLoanPaymMtd());//还款方式
		genShdInfo.setFirstPerdOverOnePaymentFreq(YnFlagEnum.YES.getCodeInDb().equals(serv10000100027Xml.getInstmInd()));// 首次是否跨期
		genShdInfo.setIntStartPerdNo(0);
		genShdInfo.setMergeToLastDueDt(true);
		genShdInfo.setOsPrcpAfterOp(SystemUtils.getBigToAmt(serv10000100027Xml.getOrigPrcp()));
		genShdInfo.setLastDueDt(serv10000100027Xml.getLastDueDt());


		genShdInfo.setIntStartDt(map.get("intStartDt").toString()); // 起息日期

		if ( StringUtils.isNullOrEmpty(genShdInfo.getIntStartDt())) {
			genShdInfo.setIntStartDt(systemInfoService.getBuzDate()); // 起息日期
		}

		if (  StringUtils.isNullOrEmpty(genShdInfo.getLoanActvDt())) {
			genShdInfo.setLoanActvDt(systemInfoService.getBuzDate()); //放款日
		}

		if ( StringUtils.isNullEmpty(genShdInfo.getLastDueDt())) {
			ShdMtdTrans shdMtdTrans=new ShdMtdTrans(genShdInfo.getIntStartDt(),
					genShdInfo.getFrequencyRange(),"y");
			genShdInfo.setLastDueDt(iPaymentLastDueDtCalService.calLastDueDt(shdMtdTrans));
		}

		List<ShdMtd> shdMtdList = new ArrayList<ShdMtd>();
		shdMtdList=iMtdUtilsService.createNomalMtdT(genShdInfo,genShdInfo.getPaymentFreq());

		// 获取利率信息
		LoanRates loanRates = new LoanRates(RateUtils.buildRate(shdMtdList.get(0)));
		for (ShdMtd m : shdMtdList) {
			PaymentTerm term = new PaymentTerm(m.getTermNo(), m.getFrmPerd(), m
					.getToPerd());
			loanRates.addTermRate(term, RateUtils.buildRate(m));
		}
		genShdInfo.setLoanRates(loanRates);
		return this.iLmPmShdBuzService.shdPreview(genShdInfo,shdMtdList);
	}

}