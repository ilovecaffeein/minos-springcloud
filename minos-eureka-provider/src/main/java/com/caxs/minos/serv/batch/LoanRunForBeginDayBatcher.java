package com.caxs.minos.serv.batch;

import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.dao.LmSetlmtTDao;
import com.caxs.minos.dao.SCtrlDao;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.PUBConstant;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmSetlmtT;
import com.caxs.minos.domain.SCtrl;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ILoanRunForBeginDayBatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/***
 * @ClassName(类名) : LoanRunForBeginDayBatcher
 * @Description(描述) : 日终初始化处理
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanRunForBeginDayBatcher implements ILoanRunForBeginDayBatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    private LmLoanDao lmLoanDao;

    @Resource
    private SCtrlDao sCtrlDao;

    @Resource
    private LmSetlmtTDao lmSetlmtTDao;

    public LoanRunForBeginDayBatcher( ) {
        super();
    }

    public BatcherCodeEnum getBatcherCode() {
        return BatcherCodeEnum.LNAM;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContext) {
        // 检查系统表的有效性
        String procsDt = batchJobContext.getBuzDate();
        List<LmLoan> list = lmLoanDao.fndBchInLoanNo();
        if (list  !=null &&  list.size() >0 ) {
            throw new MinosException("存在借据，他的机构号码在系统表sBch中不存在");
        }
        Date procsDate = DateOperation.parseStringToDate(procsDt);
        Calendar calen = Calendar.getInstance();
        calen.setTime(procsDate);
        calen.add(Calendar.DAY_OF_YEAR, -100);
        try {

            /**
             * 将批处理执行标志改为执行状态,封锁柜面交易
             * 因ctrl表的其他字段在主控修改,这里禁止改变除batching 字段以外的字段
             */
            List<SCtrl> clist = sCtrlDao.selectListByObject(null);
            if (clist != null && clist.size() > 0) {
                SCtrl ctrl = clist.get(0);
                ctrl.setBatching(YnFlagEnum.YES.getCodeInDb());
                ctrl.setNight(YnFlagEnum.YES.getCodeInDb());
                sCtrlDao.update(ctrl);
            }

            //判断主动还款是否存在未入账记录
            long total=0;
            long  LoopNum=clist.get(0).getLoopNum();
            do {
                try {
                    LmSetlmtT  lmSetlmtT = new LmSetlmtT();
                    lmSetlmtT.setSetlValDt(procsDt);
                    lmSetlmtT.setSendSts(PUBConstant.CORE_STATUS_SP);
                    lmSetlmtT.setTxAmtSts(PUBConstant.CORE_STATUS_NR);
                    List<LmSetlmtT> lmSetlList = lmSetlmtTDao.selectListByObject(lmSetlmtT);
                    if ( lmSetlList != null && lmSetlList.size() > 0 ){
                        total++;
                        log.debug("累计等次数：" + total);
                        log.debug(">>>>>>>>>>>>>>>>>>>LM_SETLMT_T表中存在未处理完的入账记录，等待5分钟后! ");
                        Thread.sleep(1*60*5* 1000);	//批量获取扣款文件结果需要等待5分钟
                    }else{
                        break;
                    }
                } catch (InterruptedException e) {
                }
            } while (  total < LoopNum );
        } catch (Exception e) {
            e.printStackTrace();
            throw new MinosException("日终初始化相关处理失败");
        }
    }
}
