package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.AccessTokenInfoDao;
import com.caxs.minos.dao.LmInterfaceInfoDao;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.trans.LmSetLmtTrans;
import com.caxs.minos.domain.trans.SingleResultTrans;
import com.caxs.minos.enums.PkgStateEnum;
import com.caxs.minos.enums.SingStateEnum;
import com.caxs.minos.https.HttpClient;
import com.caxs.minos.serv.core.comm.PikoPayHttpList;
import com.caxs.minos.serv.core.comm.PikoPayHttpMsg;
import com.caxs.minos.serv.core.comm.XYMessageWrapper;
import com.caxs.minos.serv.db.ICoreSystemService;
import com.caxs.minos.serv.db.ISystemInfoService;
import com.caxs.minos.utils.MinosCommUtils;
import com.caxs.minos.xml.JaxbBinder;
import com.google.common.collect.Maps;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
/***
 * @ClassName(类名) : CoreSystemService
 * @Description(描述) : TODD
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/3 10:19
 */
@Component
@Service
public class CoreSystemService implements ICoreSystemService {
    private Log log = LogFactory.getLog(getClass());

    @Reference
    private ISystemInfoService systemInfoService;

    @Reference
    private AccessTokenInfoDao accessTokenInfoDao;

    @Reference
    private LmInterfaceInfoDao lmInterfaceInfoDao;

    @Value( "${porosToPayUrl}" )
    private String porosToPayUrl;

    @Value( "${porosToQueryUrl}" )
    private String porosToQueryUrl;

    private String loansUrl;

    private String loansQueryUrl;

    /**
     * @param lmSetLmtTrans
     * @Description: 代扣数据发送业务逻辑
     * @Date: 2020/9/02 13:37
     * @Author: fengdetian
     * @Return String
     * @Throws
     */
    @Override
    public SingleResultTrans singleToPorosReady(LmSetLmtTrans lmSetLmtTrans) {
        SingleResultTrans  singleResultTrans = new SingleResultTrans();

        String respMsg ="";
        try {
            String params = XYMessageWrapper.xYmessagePayWrapper(lmSetLmtTrans);
            log.info("扣款地址：" + porosToPayUrl);
            log.info("发送扣款，请求支付报文：" + params);
            respMsg = HttpClient.sendHttpPost(porosToPayUrl,params);
            log.info("发送扣款，请求支付响应报文：" + respMsg);
        } catch (Exception e) {
        }

        Map<String, String> paramMap = Maps.newHashMap();
        String[] paramArray = respMsg.split("&");
        for (String val : paramArray) {
            String[] valArray = StringUtils.split(val,'=');
            paramMap.put(valArray[0], valArray[1]);
        }
        singleResultTrans.setRespCode(paramMap.get("respCode"));
        singleResultTrans.setRespMsg(paramMap.get("respMsg"));
        return singleResultTrans;
    }

    /**
     * @param lmSetLmtTrans
     * @Description: 代扣结果查询业务逻辑
     * @Date: 2020/9/08 13:37
     * @Author: fengdetian
     * @Return String
     * @Throws
     */
    @Override
    public SingleResultTrans singleToPorosQuery(LmSetLmtTrans lmSetLmtTrans) {
        SingleResultTrans  singleResultTrans =new SingleResultTrans();
        singleResultTrans.setRespCode(MinosConst.ERROR9999);

        try {
            String result = XYMessageWrapper.xYmessagePayQueryWrapper(lmSetLmtTrans);
            log.info("扣款结果查询地址：" + porosToQueryUrl);
            log.info("发送扣款结果查询，请求支付报文：" + result);
            result = HttpClient.sendHttpPost(porosToQueryUrl,result);
            log.info("发送扣款结果查询，请求支付报文：" + result);
            /*********************************************************
            result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<document>\n" +
                    "<version>1.0.0</version>\n" +
                    "<charset>UTF-8</charset>\n" +
                    "<respCode>00</respCode>\n" +
                    "<respMsg>查询响应成功</respMsg>\n" +
                    "<recordCount>1</recordCount>\n" +
                    "<signMethod>MD5</signMethod>\n" +
                    "<queryorder>\n" +
                    "<payType>B2C</payType>\n" +
                    "<transType>01</transType>\n" +
                    "<merId/>\n" +
                    "<orderNumber>glycloans5000054655</orderNumber>\n" +
                    "<qid>11202012311035150000000008296333</qid>\n" +
                    "<orderAmount>360000</orderAmount>\n" +
                    "<payAmount>360000</payAmount>\n" +
                    "<state>1</state>\n" +
                    "<refundAmount>0</refundAmount>\n" +
                    "<orderCurrency>156</orderCurrency>\n" +
                    "<orderTime>2020-12-31 10:35:17</orderTime>\n" +
                    "<merReserved1>bofo: 交易成功</merReserved1>\n" +
                    "<merReserved2/>\n" +
                    "<merReserved3/>\n" +
                    "<sign/>\n" +
                    "<pchCde>bofo</pchCde>\n" +
                    "</queryorder>\n" +
                    "</document>";
            **************************************************************/
            String errCode = MinosCommUtils.getFieldValue("respCode",result);
            if( MinosConst.ERROR00.equals(errCode) ) {// xml-->doma
                String smerReserved1="";
                String strState=null;
                JaxbBinder jaxbContext = new JaxbBinder(PikoPayHttpMsg.class);
                PikoPayHttpMsg pikoSignHttpMsg = jaxbContext.fromXml(result);
                List<PikoPayHttpList> PikoSignHttpList=pikoSignHttpMsg.getPikoPayHttp();
                if ( CollectionUtils.isEmpty(PikoSignHttpList) ) {
                    return singleResultTrans;
                }
                for ( int i = 0; i < PikoSignHttpList.size(); i++ ){
                    PikoPayHttpList pikoPayHttpList =PikoSignHttpList.get(i);
                    String state = pikoPayHttpList.getState();
                    smerReserved1 = smerReserved1 + pikoPayHttpList.getMerReserved1();
                    singleResultTrans.setPchCde(pikoPayHttpList.getPchCde());
                    if(PkgStateEnum.SU.getCodeInDb().equals(state)){
                        singleResultTrans.setPayAmount(new BigDecimal(
                                pikoPayHttpList.getPayAmount()).divide(new BigDecimal(100)));
                    }
                    strState = strState + state;
                }
                strState.trim();
                singleResultTrans.setRespMsg(smerReserved1);
                singleResultTrans.setRespCode(MinosConst.ERROR00000);
                /***同一笔结果中存在多笔记录，只要有一笔成功,则成功*****************/
                /***同一笔结果中存在多笔记录，要有一笔未支付,则未支付，等待下个循环处理**/
                if( strState.indexOf(SingStateEnum.TWO.getCodeInDb())>0){
                    singleResultTrans.setStatus(SingStateEnum.TWO.getCodeInDb());//支付失败
                }
                if( strState.indexOf(SingStateEnum.ZERO.getCodeInDb())>0){
                    singleResultTrans.setStatus(SingStateEnum.ZERO.getCodeInDb());//未支付
                }
                if( strState.indexOf(SingStateEnum.ONE.getCodeInDb())>0){
                    singleResultTrans.setStatus(SingStateEnum.ONE.getCodeInDb());///支付成功
                }
            }else if( MinosConst.ERROR03.equals(errCode) ) {// xml-->doma
                singleResultTrans.setRespCode(MinosConst.ERROR00000);
                singleResultTrans.setStatus(SingStateEnum.TWO.getCodeInDb());//支付失败
            }else{
                if( result==null || "".equals(result) ){
                    singleResultTrans.setRespCode(MinosConst.ERROR0001);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return singleResultTrans;
    }
}
