package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.AccessTokenInfoDao;
import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.domain.AccessTokenInfo;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.ToPayIr;
import com.caxs.minos.domain.trans.LmSetLmtTrans;
import com.caxs.minos.domain.trans.SingleResultTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IBatchThirdPartyInterfaceService;
import com.caxs.minos.serv.db.IHttpReqMsgService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
/***
 * @ClassName(类名) : BatchThirdPartyInterfaceService
 * @Description(描述) : 调第三方接口服务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class BatchThirdPartyInterfaceService implements IBatchThirdPartyInterfaceService {
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    IHttpReqMsgService httpReqMsgService;

    @Resource
    private AccessTokenInfoDao accessTokenInfoDao;

    @Resource
    private LmLoanDao lmLoanDao;


    /**
     * @desc 单笔扣款发送支付请求
     * @author coffee
     * @throws
     * @date 2020-09-13
     */
    @Override
    public void SingleBatch(ToPayIr toPayIr) {
        List<AccessTokenInfo> accessTokenInfos = accessTokenInfoDao.selectListByObject(new AccessTokenInfo());
        if ( CollectionUtils.isEmpty(accessTokenInfos) ) {
            throw  new MinosException("Token表无对应记录", ErrorCode.ERROR20002);
        }
        LmLoan lmLoan = lmLoanDao.findByLoanNo(toPayIr.getLoanNo());
        if ( lmLoan ==null ) {
            throw  new MinosException(" lmLoan 表无对应记录", ErrorCode.ERROR20002);
        }
        LmSetLmtTrans lmSetLmtTrans =new LmSetLmtTrans();
        lmSetLmtTrans.setRqsId(accessTokenInfos.get(0).getCallId());
        lmSetLmtTrans.setRqsName(accessTokenInfos.get(0).getCallName());
        lmSetLmtTrans.setRqsSecret(accessTokenInfos.get(0).getCallSecret());
        lmSetLmtTrans.setRqsToken(accessTokenInfos.get(0).getCallToken());
        lmSetLmtTrans.setLoanNo(toPayIr.getLoanNo());
        // rqsid+流水号
        lmSetLmtTrans.setGenGlNo(String.valueOf(accessTokenInfos.get(0).getCallId()+ toPayIr.getBuzSeqNo()));
        lmSetLmtTrans.setSetlRecvAmt(toPayIr.getRawTxAmt());
        lmSetLmtTrans.setPaymAcctNam(toPayIr.getAcctNm());
        lmSetLmtTrans.setPaymAcctNo(toPayIr.getAcctNo());
        lmSetLmtTrans.setBankCde(toPayIr.getAccBankCde());
        lmSetLmtTrans.setIdType(toPayIr.getAcctIdTyp());
        lmSetLmtTrans.setIdNo(toPayIr.getAcctIdNo());
        lmSetLmtTrans.setBindMobile(toPayIr.getBindMobile());
        lmSetLmtTrans.setTrstplnName(lmLoan.getTrstplnName());
        lmSetLmtTrans.setTrstplnNo(lmLoan.getTrstplnNo());

        try {
            httpReqMsgService.SingleChargeCollection(lmSetLmtTrans);
        } catch (Exception e) {
            log.error("借据号：" + toPayIr.getLoanNo() + ",批量还款发送清算时出现异常，"
                    + e.getMessage());
        }
    }


    /**
     * @desc  扣款查询发送支付请求
     * @author coffee
     * @PARM object
     * @date 2015-01-13
     */
    public SingleResultTrans SingleResultBatch(ToPayIr toPayIr){
        List<AccessTokenInfo> accessTokenInfos = accessTokenInfoDao.selectListByObject(new AccessTokenInfo());
        if ( CollectionUtils.isEmpty(accessTokenInfos) ) {
            throw  new MinosException("Token表无对应记录", ErrorCode.ERROR20002);
        }
        LmSetLmtTrans lmSetLmtTrans =new LmSetLmtTrans();
        lmSetLmtTrans.setRqsId(accessTokenInfos.get(0).getCallId());
        lmSetLmtTrans.setRqsName(accessTokenInfos.get(0).getCallName());
        lmSetLmtTrans.setRqsSecret(accessTokenInfos.get(0).getCallSecret());
        lmSetLmtTrans.setRqsToken(accessTokenInfos.get(0).getCallToken());
        LmLoan lmLoan = lmLoanDao.findByLoanNo(toPayIr.getLoanNo());
        if ( lmLoan ==null ) {
            throw  new MinosException(" lmLoan 表无对应记录", ErrorCode.ERROR20002);
        }
        lmSetLmtTrans.setTrstplnName(lmLoan.getTrstplnNo());
        lmSetLmtTrans.setTrstplnNo(lmLoan.getTrstplnNo());
        // rqsid+流水号
        lmSetLmtTrans.setGenGlNo(String.valueOf(accessTokenInfos.get(0).getCallId()+ toPayIr.getBuzSeqNo()));

        try {
            return  httpReqMsgService.SingleChargeCollectionQry(lmSetLmtTrans);
        } catch (Exception e) {
            log.error("借据号：" + toPayIr.getLoanNo() + ",批量还款发送清算时出现异常，"
                    + e.getMessage());
        }
        return null;
    }
}
