package com.caxs.minos.controller;

import com.caxs.minos.cfs2minos.Cfs2MinosBuzCheck;
import com.caxs.minos.cfs2minos.Ser1buzInterface;
import com.caxs.minos.domain.param.serv10000100027.xmlRequest.Serv10000100027XmlRequest;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.xml.XmlTool;
import com.yuchengtech.ycloans.buz.payment.shd.Shd;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * @ClassName(类名) : Serv10000100027Buz
 * @Description(描述) : 放款还款计划试算
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Controller
public class Serv10000100027Buz implements Ser1buzInterface {
    public static final String SHD_TRY_PRE_URL = "http://MINOS-EUREKA-PROVIDER:8092/lmPmShdBuz/shd";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders headers;

    @Override
    public Object execute(String context) throws Cfs2MinosException, JAXBException {
        /* 解析返回xml格式数据 */
        try {

            // 非公用数据验证
            Cfs2MinosBuzCheck cybCheck = new Cfs2MinosBuzCheck();
            Serv10000100027XmlRequest serv10000100027Xml =new Serv10000100027XmlRequest();
            serv10000100027Xml = XmlTool.resolveXmlOfJaxb(context, Serv10000100027XmlRequest.class);


            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("intStartDt", serv10000100027Xml.getIntStartDt());
            paramMap.put("loanActvDt", serv10000100027Xml.getLoanActvDt());
            paramMap.put("buzDate", serv10000100027Xml.getLoanActvDt());
            paramMap.put("origPrcp", cybCheck.getDeAmt(serv10000100027Xml.getOrigPrcp()));
            paramMap.put("payDay",Integer.parseInt(serv10000100027Xml.getDueDay()));
            paramMap.put("paymentFreq", PaymentFreq.getEnum(serv10000100027Xml.getPaymFreqUnit()));
            paramMap.put("frequencyRange", Integer.parseInt(serv10000100027Xml.getPaymFreqFreq()));
            paramMap.put("loanIntRate", cybCheck.getRate(serv10000100027Xml.getLoanIntRate()));
            paramMap.put("loanPaymMtd", serv10000100027Xml.getLoanPaymMtd());
            paramMap.put("lastDueDt", serv10000100027Xml.getLastDueDt());
            paramMap.put("context", context);

            // 设置请求头
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity httpEntity=new HttpEntity(paramMap,headers);

            /***************
            if ( !StringUtils.isNullOrEmpty(serv10000100027Xml.getIntStartDt())) {
                genShdInfo.setIntStartDt(serv10000100027Xml.getIntStartDt()); // 起息日期
            }

            if ( ! StringUtils.isNullOrEmpty(serv10000100027Xml.getLoanActvDt())) {
                genShdInfo.setLoanActvDt(serv10000100027Xml.getLoanActvDt()); //放款日
            }
            genShdInfo.setOrigPrcp(cybCheck.getDeAmt(serv10000100027Xml.getOrigPrcp())); // 放款本金
            genShdInfo.setPayDay(Integer.parseInt(serv10000100027Xml.getDueDay())); // 还款日
            genShdInfo.setPaymentFreq(PaymentFreq.getEnum(serv10000100027Xml.getPaymFreqUnit())); //还款频率
            genShdInfo.setFrequencyRange(Integer.parseInt(serv10000100027Xml.getPaymFreqFreq())); // 还款间隔
            genShdInfo.setBillDay(0);
            genShdInfo.setBuzDate(genShdInfo.getBuzDate());
            genShdInfo.setCurrDueInterest(0);
            genShdInfo.setCurrDuePerdNo(1);
            genShdInfo.setFirstBillDate(null);
            genShdInfo.setLoanIntRate(cybCheck.getRate(serv10000100027Xml.getLoanIntRate()));//执行利率
            genShdInfo.setLoanPaymMtd(serv10000100027Xml.getLoanPaymMtd());//还款方式
            genShdInfo.setFirstPerdOverOnePaymentFreq(YnFlagEnum.YES.getCodeInDb().equals(serv10000100027Xml.getInstmInd()));// 首次是否跨期
            genShdInfo.setIntStartPerdNo(0);
            genShdInfo.setMergeToLastDueDt(true);
            genShdInfo.setOsPrcpAfterOp(cybCheck.getDeAmt(serv10000100027Xml.getOrigPrcp()));
            genShdInfo.setLastDueDt(serv10000100027Xml.getLastDueDt());
            ****************/

            List<Shd> shdList=null;
            shdList = this.restTemplate.exchange(SHD_TRY_PRE_URL,HttpMethod.POST,httpEntity,List.class).getBody();

        } catch (Exception e) {
            throw new Cfs2MinosException(MinosException.ERROR99999, e
                    .getMessage());
        }
        return null;
    }
}