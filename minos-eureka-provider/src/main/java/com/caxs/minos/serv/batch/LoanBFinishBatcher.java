package com.caxs.minos.serv.batch;

import com.caxs.minos.dao.SCtrlDao;
import com.caxs.minos.domain.SCtrl;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ILoanBFinishBatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/***
 * @ClassName(类名) : LoanBFinishBatch
 * @Description(描述) : 日初完成
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanBFinishBatcher implements ILoanBFinishBatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    private SCtrlDao sCtrlDao;

    public LoanBFinishBatcher(){
        super();
    }

    public BatcherCode getBatcherCode() {
        return BatcherCode.BEND;
    }

    @Override
    public void run() {

    }

    @Override
    public void runBatch(BatchJobContextTrans batchJobContext) {
        /**
         * 将批处理执行标志改为未执行状态,解开柜面交易
         * 因ctrl表的其他字段在主控修改,这里禁止改变除batching 字段以外的字段
         */
        List<SCtrl> clist =sCtrlDao.selectListByObject(new SCtrl());
        if (clist != null && clist.size() > 0) {
            SCtrl ctrl = clist.get(0);
            ctrl.setBatching(YnFlagEnum.NO.getCodeInDb());
            ctrl.setNight(YnFlagEnum.NO.getCodeInDb());
            ctrl.setDayendDt(ctrl.getCurPrcsDt());
            ctrl.setIntfInd(YnFlagEnum.NO.getCodeInDb());
            sCtrlDao.update(ctrl);
        }
    }
}
