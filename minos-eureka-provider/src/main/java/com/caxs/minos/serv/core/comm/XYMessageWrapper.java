package com.caxs.minos.serv.core.comm;

import com.caxs.minos.domain.trans.LmSetLmtTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.utils.AppUtils;
import com.caxs.minos.utils.PayUtils;
import com.caxs.minos.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
/***
 * @ClassName(类名) : XYMessageWrapper
 * @Description(描述) : 组装报文
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class XYMessageWrapper {
    @Value("${topic.singkey}")
    static  private String singkey;

    /**
     * @Description: 主动还款查询交易组装报文
     * @param lmSetLmtTrans
     * @Date: 2020/7/29 16:50
     * @Author: coffee
     * @Return java.util.Date
     * @Throws
     */
    public static String xYmessagePayQueryWrapper(LmSetLmtTrans lmSetLmtTrans){
        //定义接口字段
        final String[] DataKey = {"version","charset","signMethod","payType","transType","merId","orderNumber","orderTime","qid"
                ,"trstplnNo","trstplnName","sign","rqsId","rqsName","rqsSecret","rqsToken"};

        Map<String, String> reqMessage = new HashMap<String, String>();

        reqMessage.put("version", "1.0.0");
        reqMessage.put("charset", "UTF-8");
        reqMessage.put("signMethod", "MD5");
        reqMessage.put("payType", "B2C");
        reqMessage.put("transType", "01");
        reqMessage.put("merId", "10324");
        reqMessage.put("orderNumber", lmSetLmtTrans.getGenGlNo());// rqsid+流水号
        reqMessage.put("orderTime","");
        reqMessage.put("qid","");
        reqMessage.put("trstplnNo", lmSetLmtTrans.getTrstplnNo());
        reqMessage.put("trstplnName", lmSetLmtTrans.getTrstplnName());
        reqMessage.put("rqsId", lmSetLmtTrans.getRqsId());
        reqMessage.put("rqsName", lmSetLmtTrans.getRqsName());
        reqMessage.put("rqsSecret", lmSetLmtTrans.getRqsSecret());
        reqMessage.put("rqsToken", lmSetLmtTrans.getRqsToken());

        String sign="";
        try {
            Map<String, String> paraMap = AppUtils.prepareDataMap(reqMessage, DataKey);//数据预处理
            sign = AppUtils.signDictionary(paraMap, singkey,reqMessage.get("charset"));
            reqMessage.put("sign", sign);
        } catch (Exception e) {
            throw new MinosException(e);
        }

        String signMsg="";
        try {
            signMsg = PayUtils.signDictionary(reqMessage, DataKey, reqMessage.get("charset"));// 生成加密签名串
        } catch (Exception e) {
            throw new MinosException(e);
        }
        return  signMsg;
    }

    /**
     * @Description: 代扣数据发送参数组装
     * @param lmSetLmtTrans
     * @Date: 2020/7/29 16:50
     * @Author: fengdetian
     * @Return java.util.Date
     * @Throws
     */
    public static String xYmessagePayWrapper(LmSetLmtTrans lmSetLmtTrans){
        //定义接口字段
        final String[] DataKey = {"version","charset","signMethod","payType","transType","merId","backEndUrl","orderTime",
                "orderNumber","orderAmount","orderCurrency","merReserved1","merReserved2","merReserved3","accName",
                "accNo","bankNo","protocolNo","agentAmount","sign","acctIdNoType","certifId","phoneNo","trstplnNo","trstplnName",
                "rqsId","rqsName","rqsSecret","rqsToken"};

        BigDecimal RecvAmtD = lmSetLmtTrans.getSetlRecvAmt().multiply(BigDecimal.valueOf(100));
        DecimalFormat df2  = new DecimalFormat("###");
        String RecvAmt=df2.format(RecvAmtD);

        Map<String, String> reqMap = new HashMap<String, String>();
        reqMap.put("version", "2.0");
        reqMap.put("charset", "UTF-8");
        reqMap.put("signMethod", "MD5");
        reqMap.put("payType", "B2C");
        reqMap.put("transType", "23");
        reqMap.put("merId", "10324");
        reqMap.put("backEndUrl", "");
        reqMap.put("orderTime", StringUtil.getCurTimeStamp4PK());
        reqMap.put("orderNumber", lmSetLmtTrans.getGenGlNo());
        reqMap.put("orderAmount", RecvAmt);
        reqMap.put("orderCurrency", "156");
        reqMap.put("merReserved1", "B2C");
        reqMap.put("merReserved2", "B2C");
        reqMap.put("merReserved3", "B2C");
        reqMap.put("accName", lmSetLmtTrans.getPaymAcctNam());
        reqMap.put("accNo", lmSetLmtTrans.getPaymAcctNo());
        reqMap.put("bankNo", lmSetLmtTrans.getBankCde());
        reqMap.put("protocolNo", "");//协议号
        reqMap.put("agentAmount", "");
        reqMap.put("acctIdNoType", lmSetLmtTrans.getIdType());
        reqMap.put("certifId", lmSetLmtTrans.getIdNo());
        reqMap.put("phoneNo", lmSetLmtTrans.getBindMobile());
        reqMap.put("trstplnNo", lmSetLmtTrans.getTrstplnNo());
        reqMap.put("trstplnName", lmSetLmtTrans.getTrstplnName());
        reqMap.put("rqsId", lmSetLmtTrans.getRqsId());
        reqMap.put("rqsName", lmSetLmtTrans.getRqsName());
        reqMap.put("rqsSecret", lmSetLmtTrans.getRqsSecret());
        reqMap.put("rqsToken", lmSetLmtTrans.getRqsToken());

        String sign="";
        try {
            Map<String, String> paraMap = AppUtils.prepareDataMap(reqMap, DataKey);//数据预处理
            sign = AppUtils.signDictionary(paraMap, singkey,reqMap.get("charset"));
            reqMap.put("sign", sign);
        } catch (Exception e) {
            throw new MinosException(e);
        }

        String signMsg="";
        try {
            signMsg = PayUtils.signDictionary(reqMap, DataKey, reqMap.get("charset"));// 生成加密签名串
        } catch (Exception e) {
            throw new MinosException(e);
        }
        return  signMsg;
    }

}
