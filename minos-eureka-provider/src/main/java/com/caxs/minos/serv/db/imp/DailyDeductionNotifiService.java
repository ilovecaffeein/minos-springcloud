package com.caxs.minos.serv.db.imp;

import com.alibaba.fastjson.JSONObject;
import com.caxs.minos.dao.LmAtpyDetlDao;
import com.caxs.minos.dao.LmNotifyDao;
import com.caxs.minos.dao.LmPmShdDao;
import com.caxs.minos.domain.LmAtpyDetl;
import com.caxs.minos.domain.LmNotify;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.https.HttpClient;
import com.caxs.minos.serv.db.IDailyDeductionNotifiService;
import com.caxs.minos.serv.db.ILoanRelateInterestCalcService;
import com.caxs.minos.serv.db.ISystemInfoService;
import com.caxs.minos.utils.CommonUtil;
import com.caxs.minos.utils.DateOperation;
import com.caxs.minos.utils.SpringUtils;
import com.caxs.minos.utils.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * @ClassName(类名) : DailyDeductionNotifiService
 * @Description(描述) : 每日扣款统计短信通知
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class DailyDeductionNotifiService implements IDailyDeductionNotifiService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    ILoanRelateInterestCalcService loanRelateInterestCalcService;

    @Resource
    ISystemInfoService systemInfoService;

    @Resource
    LmPmShdDao lmPmShdDao;

    @Resource
    LmAtpyDetlDao  lmAtpyDetlDao;

    @Resource
    LmNotifyDao lmNotifyDao;

    @Value("${phone}")
    private String phone;

    @Value("${sndTotal}")
    private String sndTotal;

    @Value("${smsAddress}")
    private String smsAddress;


    /**
     * 发送短信
     * @param jobContext
     * @return
     */
    @Override
    public void listDeductionNotifiTrans(BatchJobContextTrans jobContext){
        long sndValue=Long.valueOf(sndTotal);
        String psDueDt="";
        String noteMsg = "";
        String noteTxt = "";

        List<LmNotify> lmNotifyList = lmNotifyDao.selectByLmNotify("900000000", "07");
        for(LmNotify lmNotify :lmNotifyList){
            noteTxt=lmNotify.getNoteTxt();
            if( "00".equals(lmNotify.getDueDay())){
                noteTxt=noteTxt.replace("%BUZ_DT%", jobContext.getBuzDate()); //日期
                noteMsg=noteMsg+noteTxt;
                continue;
            }
            if( Integer.parseInt(lmNotify.getDueDay())<0 || Integer.parseInt(lmNotify.getDueDay())>31){
                throw new MinosException("LmNotify 表中还款日有误，请检查！");
            }
            int Year=DateOperation.getYear(jobContext.getBuzDate());//获取年份
            int nMonth= DateOperation.getMonth(jobContext.getBuzDate());//获取月份
            String Month=jobContext.getBuzDate().substring(5, 7);//获取月份
            String Day=jobContext.getBuzDate().substring(8, 10);//获取日
            if( Integer.parseInt(Day)>= Integer.parseInt(lmNotify.getDueDay()) ){
                psDueDt=String.valueOf(Year)+"-"+Month+"-"+lmNotify.getDueDay();//获取当月扣款日期
            }else{
                if( nMonth==1 ){
                    Year=Year-1;//判断是否1月份，如果是1月份则获取上年12月份
                    psDueDt=String.valueOf(Year)+"-"+"12"+"-"+lmNotify.getDueDay();//获取上月扣款日期
                }else{
                    int LastMonth=DateOperation.getMonth(jobContext.getBuzDate())-1;
                    String MMoth= CommonUtil.fill(String.valueOf(LastMonth), '0', 2, true);
                    psDueDt=String.valueOf(Year)+"-"+MMoth+"-"+lmNotify.getDueDay();//获取上月扣款日期
                }
            }
            log.info("系统当前日期：" + jobContext.getBuzDate());
            log.info("统计扣款日期：" + psDueDt);
            BigDecimal InsmAmt= new BigDecimal(0.0);
            DecimalFormat df=new DecimalFormat(".##");
            noteTxt=noteTxt.replace("%DUE_DAY%", lmNotify.getDueDay()); //扣款日

            LmPmShd lmPmShd = new LmPmShd();
            lmPmShd.setPsPerdNo(0);
            lmPmShd.setPsDueDt(jobContext.getBuzDate());
            List<LmPmShd>lmPmShdNList= lmPmShdDao.selectListByObject(lmPmShd);
            noteTxt=noteTxt.replace("%PAY_COUNT%", String.valueOf(lmPmShdNList.size())); //应扣笔数

            lmPmShd.setPsPerdNo(0);
            lmPmShd.setPsDueDt(jobContext.getBuzDate());
            lmPmShd.setSetlInd(YnFlagEnum.YES.getCodeInDb());
            List<LmPmShd>lmPmShdYList = lmPmShdDao.selectListByObject(lmPmShd);
            noteTxt=noteTxt.replace("%PAY_SUCC_COUNT%", String.valueOf(lmPmShdYList.size())); //扣款成功笔数
            noteTxt=noteTxt.replace("%PAY_FAIL_COUNT%", String.valueOf(lmPmShdNList.size()-lmPmShdYList.size())); //扣款失败笔数
            noteTxt=noteTxt.replace("%COUNT%", String.valueOf(lmPmShdNList.size()-lmPmShdYList.size())); //扣款失败笔数

            List<LmAtpyDetl> lmAtpyDetls =lmAtpyDetlDao.findBuzDateOverdue(psDueDt,jobContext.getBuzDate());
            for(LmAtpyDetl lmAtpyDetl : lmAtpyDetls){
                InsmAmt= SystemUtils.getBigDecimalWhenEvenUp(lmAtpyDetl.getAtpyPaymAmt().add(InsmAmt));
            }
            noteTxt=noteTxt.replace("%PAY_AMT%", df.format(InsmAmt)); //未还金额
            noteMsg=noteMsg+noteTxt;
            noteTxt="";
            //判断切割短信发送日期时间段
            if( SpringUtils.splitDayBool(lmNotify.getSplitDay(),lmNotify.getDueDay())){
                //获取时间
                long txLogSeq = Long.valueOf(systemInfoService.getNextValDual());
                String TxnTmstmp = new SimpleDateFormat("yyyyMMddkkmmss") .format(new Date());
                //报文体
                Map<String, String> reqBody = new HashMap<String, String>();
                reqBody.put("sendNo", phone);//短信接收电话号码
                reqBody.put("sendMsg", noteMsg);//短信内容
                reqBody.put("signature", "长安新生");	//短信类型
                reqBody.put("sendUser", "admin");//发送人
                //报文格式
                Map<String, Object> reqMsg = new HashMap<String, Object>();
                reqMsg.put("apiCode", "MDBAOC1009");//内部平台标识
                reqMsg.put("serialNumber", TxnTmstmp+txLogSeq);//内部平台标识
                reqMsg.put("applicationCode", "CFS");//内部平台标识
                reqMsg.put("interfaceType", "1009");//内部平台标识
                reqMsg.put("data", reqBody);//内部平台标识
                //转换格式
                String reqMsgSnd=JSONObject.toJSONString(reqMsg);
                log.info("发送报文内容: 【" + reqMsgSnd + "】");
                while( sndValue>0 ){//发送三次
                    String  result= HttpClient.senJsonPost(smsAddress,reqMsgSnd);
                    log.info("短信返回码:: 【" + result + "】");
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    String messageCode=jsonObject.getString("messageCode");
                    if("0000".equals(messageCode))
                        break;
                    log.info("发送短信次数: 【" + sndValue + "】");
                    sndValue--;
                }
                noteMsg ="";
            }
        }
    }
}
