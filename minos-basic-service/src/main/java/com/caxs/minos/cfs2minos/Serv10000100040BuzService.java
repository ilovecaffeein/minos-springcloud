package com.caxs.minos.cfs2minos;

import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.param.serv10000100040.xmlRequest.Serv10000100040XmlRequest;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.enums.PaymentModeEnum;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IPaymentTryCalculationService;
import com.caxs.minos.serv.db.ISystemInfoService;
import com.caxs.minos.utils.DateOperation;
import com.caxs.minos.xml.XmlTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/***
 * @ClassName(类名) : Serv10000100040BuzService
 * @Description(描述) : 主动还款试算
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Controller
@RequestMapping("/minos-basic-service")
public class Serv10000100040BuzService implements Ser1buzInterface {

    @Resource
    private IPaymentTryCalculationService iPaymentTryCalculationService;

    @Resource
    private ISystemInfoService systemInfoService;

    @Resource
    private LmLoanDao lmLoanDao;


    @RequestMapping("/Cfs2MinosHttpChannel")
    public Object execute(String context) throws Cfs2MinosException {


        PaymentTryCalculationTrans pay = null;
        /* 解析返回xml格式数据 */
        Serv10000100040XmlRequest serv10000100040Xml =new Serv10000100040XmlRequest();
        try {

            serv10000100040Xml = XmlTool.resolveXmlOfJaxb(context,Serv10000100040XmlRequest.class);
            //还款方法
            String buzDate = systemInfoService.getBuzDate();
            //还款方法
            String setlMode = serv10000100040Xml.getPAYM_MODE();
            //借据号
            String loanNo = serv10000100040Xml.getLOAN_NO();
            //还款金额
            Double actvPayAmt =serv10000100040Xml.getACTV_PAY_AMT();

            LmLoan lmLoan = lmLoanDao.findByLoanNo(loanNo);
            if (lmLoan == null) {
                throw new MinosException("此借据无借据主表信息！");
            }
            if ( PaymentModeEnum.ALL.getCodeInDb().equals(setlMode) ||
                    PaymentModeEnum.ADVANCE.getCodeInDb().equals(setlMode) ){//提前还款
                if ( DateOperation.compareTo(buzDate,lmLoan.getNextDueDt())){
                    throw new MinosException(
                            MinosException.ERROR90001,"该贷款已经拖欠,不可做普通(FS 或者 ER)还款");
                }
            }

            //还款类型
            String seltTyp = PaymentModeEnum.NORMAL.getCodeInDb();
            if (PaymentModeEnum.PAY_PRCP.getCodeInDb().equals(setlMode)) {// 归还欠本 PP
                setlMode = PaymentModeEnum.NORMAL.getCodeInDb();
                seltTyp = PaymentModeEnum.PAY_PRCP.getCodeInDb();
            }else if(PaymentModeEnum.PAY_INT.getCodeInDb().equals(setlMode)) {// 归还欠息PI
                setlMode = PaymentModeEnum.NORMAL.getCodeInDb();
                seltTyp = PaymentModeEnum.PAY_INT.getCodeInDb();
            }

            if(PaymentModeEnum.NORMAL.getCodeInDb().equals(setlMode)){//归还欠款
                pay = iPaymentTryCalculationService.paymentTryCalForPay(
                        loanNo,buzDate,Double.valueOf(actvPayAmt),
                        PaymentModeEnum.getEnum(setlMode).getCodeInDb(),PaymentModeEnum.getEnum(seltTyp).getCodeInDb());
            }else if(PaymentModeEnum.ADVANCE.getCodeInDb().equals(setlMode)){//提前部分还款
                pay = iPaymentTryCalculationService.paymentTryCalForPartActvPay(
                        loanNo,buzDate,Double.valueOf(actvPayAmt),
                        PaymentModeEnum.getEnum(setlMode).getCodeInDb(),PaymentModeEnum.getEnum(seltTyp).getCodeInDb());
            }else if(PaymentModeEnum.ALL.getCodeInDb().equals(setlMode)){//提前还款
                pay = iPaymentTryCalculationService.paymentTryCalForAllActvPay(
                        loanNo,buzDate,Double.valueOf(actvPayAmt),
                        PaymentModeEnum.getEnum(setlMode).getCodeInDb(),PaymentModeEnum.getEnum(seltTyp).getCodeInDb());
            }else if (PaymentModeEnum.PAY_ADV_PRCP.getCodeInDb().equals(setlMode)) {// 部分提前还本 ，提取还款不还息

            }
        }  catch (Exception e) {
            throw new Cfs2MinosException(MinosException.ERROR99999, e
                    .getMessage());
        }
        return pay;
    }

}
