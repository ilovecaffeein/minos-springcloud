package com.caxs.minos.controller;

import com.caxs.minos.cfs2minos.Ser1buzInterface;
import com.caxs.minos.domain.param.serv10000100040.xmlRequest.Serv10000100040XmlRequest;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.domain.trans.PaymentTryTrans;
import com.caxs.minos.enums.PaymentModeEnum;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.xml.XmlTool;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
/***
 * @ClassName(类名) : Serv10000100040BuzService
 * @Description(描述) : 主动还款试算
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@RestController
public class Serv10000100040Buz implements Ser1buzInterface {
    public static final String PAY_MENT_TRY_NM_URL = "http://minos-basic-service:8092/PaymentTryCalculation/Nm/";
    public static final String PAY_MENT_TRY_ER_URL = "http://minos-basic-service:8092/PaymentTryCalculation/Er/";
    public static final String PAY_MENT_TRY_FS_URL = "http://minos-basic-service:8092/PaymentTryCalculation/Fs/";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;

    public Object execute(String context) throws Cfs2MinosException {
        PaymentTryCalculationTrans pay = null;

        try {

            /* 解析返回xml格式数据 */
            Serv10000100040XmlRequest serv10000100040Xml =new Serv10000100040XmlRequest();
            serv10000100040Xml = XmlTool.resolveXmlOfJaxb(context,Serv10000100040XmlRequest.class);
            //还款方法
            String setlMode = serv10000100040Xml.getPAYM_MODE();
            //借据号
            String loanNo = serv10000100040Xml.getLOAN_NO();
            //还款金额
            Double actvPayAmt =serv10000100040Xml.getACTV_PAY_AMT();

            //还款类型
            String seltTyp = PaymentModeEnum.NORMAL.getCodeInDb();
            if (PaymentModeEnum.PAY_PRCP.getCodeInDb().equals(setlMode)) {// 归还欠本 PP
                setlMode = PaymentModeEnum.NORMAL.getCodeInDb();
                seltTyp = PaymentModeEnum.PAY_PRCP.getCodeInDb();
            }else if(PaymentModeEnum.PAY_INT.getCodeInDb().equals(setlMode)) {// 归还欠息PI
                setlMode = PaymentModeEnum.NORMAL.getCodeInDb();
                seltTyp = PaymentModeEnum.PAY_INT.getCodeInDb();
            }

            PaymentTryTrans paymentTryTrans= new PaymentTryTrans(loanNo,"",actvPayAmt,
                    PaymentModeEnum.getEnum(setlMode).getCodeInDb(),PaymentModeEnum.getEnum(seltTyp).getCodeInDb());
            if(PaymentModeEnum.NORMAL.getCodeInDb().equals(setlMode)){//归还欠款
                pay = this.restTemplate.exchange(PAY_MENT_TRY_NM_URL,HttpMethod.POST,new HttpEntity<Object>(paymentTryTrans,this.headers),PaymentTryCalculationTrans.class).getBody();
            }else if(PaymentModeEnum.ADVANCE.getCodeInDb().equals(setlMode)){//提前部分还款
                pay = this.restTemplate.exchange(PAY_MENT_TRY_ER_URL,HttpMethod.POST,new HttpEntity<Object>(paymentTryTrans,this.headers),PaymentTryCalculationTrans.class).getBody();
            }else if(PaymentModeEnum.ALL.getCodeInDb().equals(setlMode)){//提前还款
                pay = this.restTemplate.exchange(PAY_MENT_TRY_FS_URL,HttpMethod.POST,new HttpEntity<Object>(paymentTryTrans,this.headers),PaymentTryCalculationTrans.class).getBody();
            }
        }  catch (Exception e) {
            throw new Cfs2MinosException(MinosException.ERROR99999, e
                    .getMessage());
        }
        return pay;
    }

}
