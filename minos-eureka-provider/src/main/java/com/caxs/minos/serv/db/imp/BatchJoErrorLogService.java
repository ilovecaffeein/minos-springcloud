package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.DeErrorLogDao;
import com.caxs.minos.dao.TxLogNoNextValDualDao;
import com.caxs.minos.domain.DeErrorLog;
import com.caxs.minos.serv.db.IBatchJoErrorLogService;
import com.caxs.minos.utils.DateOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
/***
 * @ClassName(类名) : IBatchJoErrorLogService
 * @Description(描述) : 存放日志信息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class BatchJoErrorLogService implements IBatchJoErrorLogService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    DeErrorLogDao  errorLogDao;

    @Resource
    TxLogNoNextValDualDao txLogNoNextValDualDao;


    @Override
    public void saveErrLogNoIncCount(String loanNo,String buzDate,
                                     String jobName, String errMsg, String errCode) {
        DeErrorLog errLog = new DeErrorLog();
        errLog.setDeErrSeq(Long.valueOf(txLogNoNextValDualDao.findPayPkgSeq()));
        errLog.setErrMsg(errMsg);
        errLog.setJobNam(jobName);
        Date date = new Date();
        errLog.setLogDt(DateOperation.getDateStringToDb(date));
        errLog.setMacTime(DateOperation.formatTime(date));
        errLog.setLoanNo(loanNo);
        errLog.setRtnCde(errCode);
        errLog.setPrcsDt(buzDate);
        errorLogDao.insert(errLog);
    }
}
