package com.caxs.minos.serv.db.imp;

import com.caxs.minos.aeskey.EnDe3DES;
import com.caxs.minos.dao.*;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.*;
import com.caxs.minos.enums.*;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.files.PakAgeDataWriterContentWraper;
import com.caxs.minos.files.PakAgeDateResultReader;
import com.caxs.minos.serv.db.*;
import com.caxs.minos.utils.CommonUtil;
import com.caxs.minos.utils.SystemUtils;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/***
 * @ClassName(类名) : SpeciPaySystemService
 * @Description(描述) : 批处理扣款
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class SpeciPaySystemService implements ISpeciPaySystemService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    private final String TRANS_TYP_CANCEL_FLAG = "F";/* 撤销交易标志 */
    public final String TRANS_TYP_ORDINAL_FLAG = "T";/* 正交易标志 */
    private PakAgeDataWriterContentWraper pakAgeataWriterContentWraper; // 清算对账文件报文内容
    /**
     * 批量锁
     */
    private Object lockbatch = new Object();

    @Reference
    IBatchThirdPartyInterfaceService batchThirdPartyInterfaceService;

    @Resource
    IBatchJoErrorLogService batchJoErrorLogService;

    @Reference
    IFileSourceService fileSourceService;

    @Reference
    ISystemInfoService systemInfoService;

    @Resource
    LmExternalFileDao  lmExternalFileDao;

    @Resource
    LmAcctInfoDao  lmAcctInfoDao;

    @Resource
    LmLoanDao  lmLoanDao;

    @Resource
    LmAtpyDetlDao  lmAtpyDetlDao;

    @Resource
    LmPmShdDao  lmPmShdDao;

    @Resource
    IntfCaxtTransInfoDao  intfCaxtTransInfoDao;

    @Resource
    IntfDgxtTransInfoDao  intfDgxtTransInfoDao;

    @Resource
    IntfZhxtTransInfoDao  intfZhxtTransInfoDao;

    @Resource
    SCtrlDao sCtrlDao;

    @Resource
    ToPayIrDao  toPayIrDao;

    @Resource
    PkgTypDao  pkgTypDao;

    @Resource
    PkgTypDtlDao pkgTypDtlDao;

    @Resource
    PayRstDao  payRstDao;

    @Value("${ipConfig1}")
    private String ipConfig1;

    @Value("${inetaddressname1}")
    private String inetaddressname1;

    @Value("${ipConfig2}")
    private String ipConfig2;

    @Value("${inetaddressname2}")
    private String inetaddressname2;

    @Value("${singkey}")
    private String singkey;



    /**
     * 插入批量扣款数据(to_pay_ir), 准备扣款 (non-Javadoc)
     * @param jobContext
     * @param loan
     * @param lmAtpyDetl
     * @param job
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void saveAppendBatchPayData(BatchJobContextTrans jobContext, LmLoan loan ,
                                                     LmAtpyDetl lmAtpyDetl, DeAtpyJobs job) {
        if (log.isDebugEnabled()){
            log.debug("生成借据【" + lmAtpyDetl.getLoanNo() + "】的TO_PAY信息");
        }
        // 如果扣款成功，则不能重复发送
        ToPayIr sToPayIr = new ToPayIr();
        String pc = "R" ;
        if ("R".equals(pc)) {
            pc = "D";
        } else if ("P".equals(pc)) {
            pc = "C";
        }
        sToPayIr.setBuzSeqNo(lmAtpyDetl.getTxlogNo());
        sToPayIr.setTxSeq(Long.valueOf(systemInfoService.getNextValDual()));
        sToPayIr.setSeqNo(String.valueOf(sToPayIr.getBuzSeqNo()));
        sToPayIr.setSubTxSeq(1);
        sToPayIr.setAmntcd(pc); // 借贷方向 R-D P-C
        sToPayIr.setCcyCde(lmAtpyDetl.getAtpyCcyCde());// 币种
        sToPayIr.setSummam(lmAtpyDetl.getAtpyPaymAmt());// 发起交易金额
        sToPayIr.setTranam("0");// 实际交易金额
        sToPayIr.setErrtcd("1");// 错误代码
        sToPayIr.setErrtxt("1");// 错误原因
        sToPayIr.setPkgSts(PkgStateEnum.SU.getCodeInDb());// 开始
        sToPayIr.setPaySucc(PkgStateEnum.SU.getCodeInDb());//开始
        sToPayIr.setRawTxAmt(lmAtpyDetl.getAtpyPaymAmt());
        sToPayIr.setPrcsPageDtInd("N");
        sToPayIr.setLoanNo(lmAtpyDetl.getLoanNo());
        sToPayIr.setToDate(DateOperation.formatDate(new Date()));
        sToPayIr.setToTime(DateOperation.formatTime(new Date()));
        sToPayIr.setTransCode(jobContext.getTransCode());
        sToPayIr.setBuzDt(lmAtpyDetl.getAtpyValDt());
        sToPayIr.setTxAmt(String.valueOf(lmAtpyDetl.getAtpyPaymAmt()));
        sToPayIr.setTransTyp(TRANS_TYP_ORDINAL_FLAG);
        sToPayIr.setOpId(loan.getBankCde());
        sToPayIr.setPayInd("1");
        sToPayIr.setPayChn("poros");
        sToPayIr.setAccBchCde(lmAtpyDetl.getAtpyAcctBchCde());
        sToPayIr.setAcctIdTyp(lmAtpyDetl.getAtpyAcctIdType());// 证件类型
        sToPayIr.setAcctIdNo(lmAtpyDetl.getAtpyAcctIdNo());// 证件号码
        sToPayIr.setAcctNm(lmAtpyDetl.getAtpyAcctName());// 持卡人姓名
        sToPayIr.setAcctNo(lmAtpyDetl.getAtpyAcctNo()); //账户
        sToPayIr.setAccBankCde(lmAtpyDetl.getAtpyAcctBankCde());// 银行代号
        sToPayIr.setBchCde(lmAtpyDetl.getAtpyBchCde());//机构代码
        sToPayIr.setThdCnt(loan.getThdCnt());//线程编号
        sToPayIr.setAtpySeqNo(lmAtpyDetl.getAtpySeqNo());
        sToPayIr.setTransCode(jobContext.getTransCode());
        sToPayIr.setBatTxSeq(Integer.valueOf(job.getAtpySeqNo()));
        sToPayIr.setOpNm("admin");
        sToPayIr.setTransTyp("T");
        sToPayIr.setPaySty("P");
        sToPayIr.setValid("Y");
        sToPayIr.setFileSeq(Integer.valueOf(lmAtpyDetl.getFileSeq()));
        sToPayIr.setPchCde(lmAtpyDetl.getPchCde());
        sToPayIr.setBindMobile(lmAtpyDetl.getBindMobile());
        toPayIrDao.insert(sToPayIr);
    }

    /**
     * 发送扣款请求
     * @param jobContext
     * @param job
     */
    @Override
    public void listtransTopayIrSingleBatch(BatchJobContextTrans jobContext, DeAtpyJobs job){
        try {
            if( ipConfig1.equals(SystemUtils.getAddress(inetaddressname1))
                                || ipConfig2.equals(SystemUtils.getAddress(inetaddressname2))){
                toPayIrDao.updateByBuzDt(jobContext.getBuzDate(), PkgStateEnum.SU.getCodeInDb(),job.getAtpySeqNo());
                List<ToPayIr> sToPayIrs = null;
                do {
                    sToPayIrs = toPayIrDao.findByBuzDate(jobContext.getBuzDate(), PkgStateEnum.SU.getCodeInDb(),job.getAtpySeqNo());
                    for (int k = 0; k < sToPayIrs.size(); k++) {
                        ToPayIr toPayIr = sToPayIrs.get(k);
                        batchThirdPartyInterfaceService.SingleBatch(toPayIr);
                        toPayIr.setPkgSts(PkgStateEnum.FZ.getCodeInDb());
                        toPayIr.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                        toPayIrDao.update(toPayIr);
                    }
                } while (sToPayIrs.size() == DBConst.PAGE_RECORD);
            }
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            log.info("扣款发送扣款请求结束！" );
        }
    }


    /**
     * 扣款查询获取结果
     * @param jobContext
     * @param job
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void listtransTopayIrSingleResultBatch(BatchJobContextTrans jobContext, DeAtpyJobs job){
        long   total=0;
        long   succtotal=0;
        try {
            if( ipConfig1.equals(SystemUtils.getAddress(inetaddressname1))
                    || ipConfig2.equals(SystemUtils.getAddress(inetaddressname2))){
                toPayIrDao.updateByBuzDt(jobContext.getBuzDate(), PkgStateEnum.FZ.getCodeInDb(),job.getAtpySeqNo());
                List<ToPayIr> sToPayIrs = null;
                do {
                    sToPayIrs = toPayIrDao.findByBuzDate(jobContext.getBuzDate(), PkgStateEnum.FZ.getCodeInDb(),job.getAtpySeqNo());
                    for (int k = 0; k < sToPayIrs.size(); k++) {
                        ++total; //统计笔数
                        ToPayIr toPayIr = sToPayIrs.get(k);
                        SingleResultTrans singleResultTrans = null;
                        singleResultTrans = batchThirdPartyInterfaceService.SingleResultBatch(toPayIr);
                        if( MinosConst.ERROR9999.equals(singleResultTrans.getRespCode())
                                 || MinosConst.ERROR0001.equals(singleResultTrans.getRespCode())){
                            toPayIr.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                            toPayIrDao.update(toPayIr);
                            continue;
                        }else if( MinosConst.ERROR03.equals(singleResultTrans.getRespCode())){
                            toPayIr.setPkgSts(PkgStateEnum.CP.getCodeInDb());
                            toPayIr.setPaySucc(PkgStateEnum.FZ.getCodeInDb());
                            toPayIr.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                            toPayIrDao.update(toPayIr);
                            continue;
                        }else{
                        }
                        if ( SingStateEnum.ONE.getCodeInDb().equals(singleResultTrans.getStatus())){
                            log.info("订单号:" + toPayIr.getBuzSeqNo().toString()+" 扣款状态，成功！");
                            PayRst sPayRst = new PayRst();
                            sPayRst.setTxlogSeq(toPayIr.getBuzSeqNo());
                            sPayRst.setBatSeqNo(toPayIr.getBuzSeqNo());// 批量流水
                            sPayRst.setSubTxlogSeq(1);
                            sPayRst.setLoanNo((toPayIr.getLoanNo()));
                            sPayRst.setAcctNo(toPayIr.getAcctNo());// 交易帐号
                            sPayRst.setPrcsPageDtInd(YnFlagEnum.NO.getCodeInDb());
                            sPayRst.setAppAmt(toPayIr.getRawTxAmt());// 发起交易金额
                            sPayRst.setActAmt(singleResultTrans.getPayAmount());// 实际交易金额
                            sPayRst.setErrCde(singleResultTrans.getRespCode());// 错误代码
                            sPayRst.setErrMsg(singleResultTrans.getRespMsg());// 错误原因
                            sPayRst.setSucInd(YnFlagEnum.YES.getCodeInDb());
                            sPayRst.setTransCode(jobContext.getTransCode());
                            toPayIr.setPkgSts(PkgStateEnum.CP.getCodeInDb());
                            toPayIr.setPaySucc(PkgStateEnum.CP.getCodeInDb());
                            payRstDao.insert(sPayRst);
                            succtotal++;
                        }else if ( SingStateEnum.TWO.getCodeInDb().equals(singleResultTrans.getStatus())){
                            log.info("订单号:" + toPayIr.getBuzSeqNo().toString()+" 扣款状态，失败！");
                            toPayIr.setPkgSts(PkgStateEnum.CP.getCodeInDb());
                            toPayIr.setPaySucc(PkgStateEnum.FZ.getCodeInDb());
                            toPayIr.setErrtxt(singleResultTrans.getRespMsg());
                        }else if ( SingStateEnum.ZERO.getCodeInDb().equals(singleResultTrans.getStatus())){
                            log.info("订单号:" + toPayIr.getBuzSeqNo().toString()+" 未支付!");
                        }else if ( "".equals(singleResultTrans.getStatus())
                                || singleResultTrans.getStatus() == null){
                        }
                        toPayIr.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                        toPayIrDao.update(toPayIr);
                    }
                } while (sToPayIrs.size() == DBConst.PAGE_RECORD);
            }
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            log.info("查询扣款成功：" + succtotal +" 笔, 扣款失败："+ (total -succtotal)+ " 笔");
        }
    }

    /**
     * 批量下载外部扣款文件
     * @param jobContext
     */
    @Override
    public void listExternalDebitBatcher(BatchJobContextTrans jobContext, DeAtpyJobs job){
        long  loopNum=0;
        long  total=0;

        try {
            String  filename= getZhxtFileName(jobContext);
            List<SCtrl> list = sCtrlDao.selectListByObject(new SCtrl());
            loopNum=list.get(0).getLoopNum();
            do {
                LmExternalFile lmExternalFile =null;
                synchronized (lockbatch) {
                    lmExternalFile= lmExternalFileDao.selectByOutChn(jobContext.getOutChn());
                    if( lmExternalFile ==null){
                        throw new MinosException("LmExternalFile 表无记录！", ErrorCode.ERROR20006);
                    }
                }
                if( !loanDownFileReady(jobContext,lmExternalFile,filename)){
                    total++;
                    log.debug("批量下载扣款文件次数：" + total + ",渠道来源：" + jobContext.getOutChn());
                    if( total == loopNum ){
                        throw new MinosException("批量下载扣款文件失败，请核查！", ErrorCode.ERROR20006);
                    }
                    threadSleep(15*60 * 1000);//批量获取扣款文件结果需要等待15分钟
                }else{
                    saveAnalyseFile(jobContext,lmExternalFile,filename);
                    break;
                }
            } while (  total < loopNum );
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            log.info("中航信托扣款文件下载结束！" );
        }
    }


    /**
     * 解析扣款文件
     * @param bjc
     * @param lmExternalFile bjc
     * @param filename
     */
    public void saveAnalyseFile(BatchJobContextTrans bjc,
                                   LmExternalFile lmExternalFile,String filename){
        long other = 0;
        PakAgeDateResultReader reader = null;

        try {
            String buzDate = bjc.getBuzDate();
            File rspFile = new File(lmExternalFile.getFilePath(), filename); //读取文件
            if (!rspFile.exists()) {
                throw new MinosException("文件" + rspFile.getPath() + "不存在");
            }
            //与清算对账结果包行信息
            PkgTypInfoTrans pkgTypInfoTrans =systemInfoService.getPkgTypInfo(Long.parseLong(MinosConst.PKGTYP));
            PkgTyp pkgtyp = pkgTypDao.selectByPrimaryKey(Long.parseLong(MinosConst.PKGTYP));
            PkgInfoTrans pkginfo =new PkgInfoTrans(pkgtyp,pkgTypInfoTrans);

            reader = new PakAgeDateResultReader(lmExternalFile.getFilePath(), filename,
                    pkginfo, this.pakAgeataWriterContentWraper);
            while (reader.hasNext()) {
                PakAgeDataTrans pakAgeData = null;
                pakAgeData = (PakAgeDataTrans) reader.next();

                String AccNo = EnDe3DES.DeEnycrptDes(pakAgeData.getAccNo(), singkey, MinosConst.FILE_CHARUTF_8);
                String AccName = EnDe3DES.DeEnycrptDes(pakAgeData.getAccName(), singkey, MinosConst.FILE_CHARUTF_8);
                BigDecimal OrderAmount = new BigDecimal(pakAgeData.getOrderAmount());
                OrderAmount = OrderAmount.divide(new BigDecimal(100));

                log.info("解析文件数据订单号	   :" + pakAgeData.getOrderNumber());
                log.info("解析文件数据姓名		   :" + AccName);
                log.info("解析文件数据账号 		   :" + AccNo);
                log.info("解析文件数据订单金额(分:" + OrderAmount);
                log.info("解析文件数据交易状态 	 :" + pakAgeData.getSuccflag());
                log.info("解析文件清算流水号 	 	 :" + pakAgeData.getSubtxseq());
                log.info("解析文件清算交易摘要	 :" + pakAgeData.getTxMemo());
                log.info("解析文件清算交易借据号 :" + pakAgeData.getLoanNo());
                log.info("解析文件清算交易渠道	 :" + pakAgeData.getPchCde());

                String loanNo = "";
                if ("zhxt".equals(bjc.getOutChn())) {
                    IntfZhxtTransInfo intfZhxtTransInfo = intfZhxtTransInfoDao.selectByLoanNo(pakAgeData.getLoanNo());
                    if (intfZhxtTransInfo == null) {
                        batchJoErrorLogService.saveErrLogNoIncCount(pakAgeData.getLoanNo(),bjc.getBuzDate(),
                                bjc.getJobExe(),"INTF_ZHXT_TRANS_INFO 中无记录,借据号 [" + pakAgeData.getLoanNo() +
                                        " ] , 错误信息 [ " + "" + " ]", ErrorCode.ERROR00009);
                        other++;
                        continue;
                    }
                    loanNo = intfZhxtTransInfo.getLoanNo();
                } else if ("dgxt".equals(bjc.getOutChn())) {
                    IntfDgxtTransInfo intfDgxtTransInfo = intfDgxtTransInfoDao.selectByLoanNo(pakAgeData.getLoanNo());
                    if (intfDgxtTransInfo == null) {
                        batchJoErrorLogService.saveErrLogNoIncCount(pakAgeData.getLoanNo(),bjc.getBuzDate(),
                                bjc.getJobExe(),"INTF_DGXT_TRANS_INFO 中无记录 [" + pakAgeData.getLoanNo() +
                                        " ] , 错误信息 [ " + "" + " ]", ErrorCode.ERROR00009);
                        other++;
                        continue;
                    }
                    loanNo = intfDgxtTransInfo.getLoanNo();
                } else if ("caitc".equals(bjc.getOutChn())) {
                    IntfCaxtTransInfo intfCaxtTransInfo = intfCaxtTransInfoDao.selectByLoanNo(pakAgeData.getLoanNo());
                    if (intfCaxtTransInfo == null) {
                        batchJoErrorLogService.saveErrLogNoIncCount(pakAgeData.getLoanNo(),bjc.getBuzDate(),
                                bjc.getJobExe(),"INTF_CAXT_TRANS_INFO 中无记录 [" + pakAgeData.getLoanNo() +
                                        " ] , 错误信息 [ " + "" + " ]", ErrorCode.ERROR00009);
                        other++;
                        continue;
                    }
                    loanNo = intfCaxtTransInfo.getLoanNo();
                } else {
                    batchJoErrorLogService.saveErrLogNoIncCount(pakAgeData.getLoanNo(),bjc.getBuzDate(),
                            bjc.getJobExe(),"未知的渠道记录,借据号 [" + pakAgeData.getLoanNo() +
                                    " ] , 错误信息 [ " + "" + " ]", ErrorCode.ERROR00009);
                    other++;
                    continue;
                }
                List<LmAtpyDetl> lmAtpyDetlList = lmAtpyDetlDao.findByLoanNoAndDate(loanNo,buzDate);
                if (CollectionUtils.isEmpty(lmAtpyDetlList)) {
                    batchJoErrorLogService.saveErrLogNoIncCount(pakAgeData.getLoanNo(),bjc.getBuzDate(),
                            bjc.getJobExe(),"LM_ATPY_DETL 中无记录 [" + pakAgeData.getLoanNo() +
                                    " ] , 错误信息 [ " + "" + " ]", ErrorCode.ERROR00009);
                    other++;
                    continue;
                }
                if ( SingStateEnum.ONE.getCodeInDb().equals(pakAgeData.getSuccflag())) {
                    LmAcctInfo lmAcctInfo =new LmAcctInfo();
                    lmAcctInfo.setLoanAcctTyp(LoanAccountTypEnum.REPAY.getCodeInDb());
                    lmAcctInfo.setLoanNo(loanNo);
                    lmAcctInfo = lmAcctInfoDao.selectOneByObject(lmAcctInfo);
                    if ( lmAcctInfo == null ){
                        batchJoErrorLogService.saveErrLogNoIncCount(pakAgeData.getLoanNo(),bjc.getBuzDate(),
                                bjc.getJobExe(), "账户信息表无此记录！" , ErrorCode.ERROR00009);
                        other++;
                        continue;
                    }
                    if (!lmAcctInfo.getAcctCardNo().equals(AccNo)) {
                        String errMsg = "扣款账号【" + lmAtpyDetlList.get(0).getAtpyAcctNo() + "】和扣款文件中的交易账户【" + AccNo + "】不一致！";
                        batchJoErrorLogService.saveErrLogNoIncCount(pakAgeData.getLoanNo(),bjc.getBuzDate(),
                                bjc.getJobExe(), errMsg , ErrorCode.ERROR00009);
                        other++;
                        continue;
                    }
                    lmAtpyDetlList.get(0).setAtpyTxAmt(OrderAmount);
                }
                lmAtpyDetlList.get(0).setPchCde(pakAgeData.getPchCde());
                lmAtpyDetlList.get(0).setAtpyErrDesc(pakAgeData.getTxMemo());
                lmAtpyDetlList.get(0).setAtpySts(AtpyStateEnum.FREEZE.getCodeInDb());
                lmAtpyDetlDao.update(lmAtpyDetlList.get(0));
            }
            if( other>0 ){
                throw new MinosException("批量下载中航信托扣款文件存在异常数据，" +
                        "请检查", ErrorCode.ERROR20006);
            }
        }catch (Throwable t) {
            throw new MinosException(t);
        }
    }

    /**
     * 下载文件
     * @param bjc
     * @param lmExternalFile
     * @param filename
     */
    public boolean loanDownFileReady(BatchJobContextTrans bjc,LmExternalFile lmExternalFile,String filename) {
        boolean result=false;

        try {
            log.info("本机IP："+SystemUtils.getAddress(inetaddressname1));
            log.info("本机IP："+SystemUtils.getAddress(inetaddressname2));
            if( YnFlagEnum.YES.getCodeInDb().equals(lmExternalFile.getDownInd())){
                if( ipConfig1.equals(SystemUtils.getAddress(inetaddressname1))
                        || ipConfig2.equals(SystemUtils.getAddress(inetaddressname2))){ //发送扣款接口
                    if( ! downloadFile(bjc,lmExternalFile,filename) ){
                        log.info("文件下载失败："+filename);
                        return result;
                    }
                    result=true;
                }
            }else{
                result=true;
                log.info(filename + "：文件，系统配置不下载！");
            }
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
        }
        return result;
    }

    /**
     * 下载中航信托对账文件
     * @param bjc
     * @param lmExternalFile
     * @param localFileName
     * @return
     */
    public boolean downloadFile(BatchJobContextTrans bjc,
                                    LmExternalFile lmExternalFile,String localFileName) {
        try {
            log.info("目标路径:" + lmExternalFile.getRetrunFilePath() +",原路劲："+lmExternalFile.getFilePath());
            log.info("ip:" + lmExternalFile.getFileIp()+",端口:"+ lmExternalFile.getFilePort() +",用户:" +
                    ""+lmExternalFile.getUserName() +",密码:"+lmExternalFile.getUserPasswd()+",上传文件："+localFileName);
            //初始化FTP端口
            FtpConfigTrans ftpConfig=new FtpConfigTrans();
            ftpConfig.setIpAddr(lmExternalFile.getFileIp());//IP
            ftpConfig.setPort(Integer.valueOf(lmExternalFile.getFilePort()));//端口
            ftpConfig.setUser(lmExternalFile.getUserName());//用户
            ftpConfig.setPassword(lmExternalFile.getUserPasswd());//密码
            //将文件从FTP服务下载
            fileSourceService.setFtpConfig(ftpConfig);
            //下载目的文件名，下载目的路径，下载原文件名，下载原本地路径
            return fileSourceService.copyFileFrom(localFileName, lmExternalFile.getRetrunFilePath(),
                    localFileName, lmExternalFile.getFilePath());
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * 生成文件名称
     * @param bjc
     * @return
     */
    private String getZhxtFileName(BatchJobContextTrans bjc) {
        String fileName=null;
        String ddDate = bjc.getBuzDate().replace("-", "");
        fileName =bjc.getOutChn()
                + "-"
                + "Repay"
                + "-"
                + CommonUtil.fill(bjc.getBchCde(), '0', 10, true)
                + "-"
                + ddDate
                + ".data";
        return fileName;
    }

    /**
     * 线程等待
     */
    public void threadSleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /**
     * 长安新生与外部渠道还款计划金额核对
     * @param bjc
     */
    @Override
    public void listExternalLmPmShdDebitBatcher(BatchJobContextTrans bjc){
        // 生成下载文件名
        String YYYYMMDD = bjc.getBuzDate().replace("-", "");
        String filename = bjc.getOutChn() + "-" + bjc.getBchCde() + "-" + "LmPmShd" + "-"
                + CommonUtil.fill("1", '0', 10, true) + "-" + YYYYMMDD + ".data";
        LmExternalFile lmExternalFile=lmExternalFileDao.selectByPrimaryKey(bjc.getOutChn());
        if( lmExternalFile ==null){
            throw new MinosException("LmExternalFile 表无记录！", ErrorCode.ERROR20006);
        }
        log.info("远程地址：" + lmExternalFile.getRetrunFilePath());
        log.info("文件全路径：" + lmExternalFile.getRetrunFilePath()+filename);
        if (!loanDownFileReady(bjc,lmExternalFile, filename)) {
            throw new MinosException("没有需要下载的文件记录！");
        }
        InputStreamReader bre = null;
        BufferedReader reader = null;
        try {
            bre = new InputStreamReader(new FileInputStream(lmExternalFile.getFilePath()+filename), "UTF-8");
            reader = new BufferedReader(bre);
            int line = 0;
            String payPlan = null;
            // 一次读入一行，直到读入null为文件结束
            while ((payPlan = reader.readLine()) != null) {
                line++;
                String loanNo="";
                String delimeter = "\\|"; // 指定分割字符
                String[] payData = payPlan.split(delimeter); // 分割字符串
                // 显示行号
                System.out.println("line " + line + ": " + payPlan);
                if( "dgxt".equals(bjc.getOutChn())){
                    IntfDgxtTransInfo intfDgxtTransInfo =intfDgxtTransInfoDao.selectByLoanNo(payData[1]);
                    if ( intfDgxtTransInfo == null) {
                        log.info("解析文件中交易借据号：" + payData[1]
                                + "在表 INTF_DGXT_TRANS_INFO 中无记录!");
                        throw new MinosException("在表INTF_DGXT_TRANS_INFO 中无记录，借据号："+payData[1]);
                    }
                    loanNo = intfDgxtTransInfo.getLoanNo();
                }else if( "zhxt".equals(bjc.getOutChn())){
                    IntfZhxtTransInfo intfZhxtTransInfo = intfZhxtTransInfoDao.selectByLoanNo(payData[1]);
                    if (intfZhxtTransInfo == null) {
                        log.info("解析文件中交易借据号：" + payData[1]
                                + "在表INTF_ZHXT_TRANS_INFO 中无记录!");
                        throw new MinosException("在表INTF_ZHXT_TRANS_INFO 中无记录，借据号："+payData[1]);
                    }
                    loanNo = intfZhxtTransInfo.getLoanNo();
                }else if( "caitc".equals(bjc.getOutChn())){
                    IntfCaxtTransInfo intfCaxtTransInfo = intfCaxtTransInfoDao.selectByLoanNo(payData[1]);
                    if ( intfCaxtTransInfo == null) {
                        log.info("解析文件中交易借据号：" + payData[1]
                                + "在表INTF_CAXT_TRANS_INFO 中无记录!");
                        throw new MinosException("在表INTF_CAXT_TRANS_INFO 中无记录，借据号："+payData[1]);
                    }
                    loanNo = intfCaxtTransInfo.getLoanNo();
                }else{
                    throw new MinosException(" 未知的渠道来源："+ bjc.getOutChn());
                }
                List<LmPmShd> lmPmShds = lmPmShdDao.selectListByObject(new LmPmShd(loanNo));
                if ( !CollectionUtils.isEmpty(lmPmShds) ) {
                    BigDecimal paysum = new BigDecimal(0);
                    for (int i = 0; i < lmPmShds.size(); i++) {
                        LmPmShd lmPmShd = lmPmShds.get(i);
                        paysum = paysum.add(lmPmShd.getPsNormIntAmt()).add(lmPmShd.getPsNormIntAmt());
                        paysum = paysum.add(lmPmShd.getPsOdIntAmt()).add(lmPmShd.getPsCommOdInt());
                    }
                    paysum =  SystemUtils.getBigDecimalWhenEvenUp(paysum);
                    LmLoan lmloan=lmLoanDao.findByLoanNo(loanNo);
                    if( lmloan == null ){
                        throw new MinosException("LM_LOAN 中无记录，借据号："+lmPmShds.get(0).getLoanNo());
                    }
                    if ( !SystemUtils.isRateEqual(lmloan.getLoanOdIntRate().doubleValue(), Double.valueOf(payData[9])) ){
                        log.info("借据表中逾期利率：" + lmloan.getLoanOdIntRate() + "与文件中逾期利率设置值:" + payData[9] + "不符");
                        throw new MinosException(
                                MinosException.ERROR90001, "借据表中逾期利率:"
                                + lmloan.getLoanOdIntRate() + "与文件中逾期利率设置值:" + payData[9] + "不符");
                    }
                    if ( paysum.compareTo(new BigDecimal(payData[7])) >0) {
                        throw new MinosException("in file:" + lmExternalFile.getFilePath()+filename
                                + " 与 LM_PM_SHD 表中记录不一致, 文件中记录为" + payPlan);
                    }
                }else{
                    throw new MinosException("in file:" + lmExternalFile.getFilePath()+filename
                            + " 在 LM_PM_SHD 中无记录, 文件中记录为" + payPlan);
                }
                LmLoan lmLoan = new LmLoan();
                lmLoan.setLoanActvDt(systemInfoService.getBuzDate());
                List<LmLoan> lmLoanList =lmLoanDao.selectListByObject(lmLoan);
                if(lmLoanList.size() > line ||  lmLoanList.size() < line )
                    throw new MinosException("in file:" + lmExternalFile.getFilePath()+filename
                            + " 与 LM_LOAN 表中记录不一致, 文件中记录为：" + line + "， LM_LOAN 个数："  + lmLoanList.size());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
