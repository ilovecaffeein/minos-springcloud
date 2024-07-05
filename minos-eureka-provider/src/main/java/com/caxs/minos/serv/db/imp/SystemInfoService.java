package com.caxs.minos.serv.db.imp;


import com.caxs.minos.dao.*;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.LmGlnoLogTrans;
import com.caxs.minos.domain.trans.PkgTypInfoTrans;
import com.caxs.minos.domain.trans.TradeCancelCfgTrans;
import com.caxs.minos.enums.GenGlIndEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ISystemInfoService;
import com.caxs.minos.serv.db.ISystemInitService;
import com.caxs.minos.utils.DateOperation;
import com.caxs.minos.utils.ObjectUtil;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
/***
 * @ClassName(类名) : SystemInfo
 * @Description(描述) : 获取系统信息
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/8/19 11:48
 */
@Component
@Service
public class SystemInfoService implements ISystemInfoService {
    private Map<Long, PkgTypInfoTrans> pkgTypInfoMap; // 扣款类型信息map
    //交易撤销配置列表属性
    private List<TradeCancelCfgTrans> cfgList;

    private List<SBch> branchList; // 机构信息列表

    @Reference
    private ISystemInitService iSystemInitService;

    @Reference
    private TxLogNoNextValDualDao txLogNoNextValDualDomainMapper;

    @Reference
    private SCtrlDao sCtrlDao;

    @Reference
    private SBchDao sBchDao;

    @Reference
    private PkgTypDao pkgTypDap;

    @Reference
    private PkgTypDtlDao pkgTypDtlDao;

    @Reference
    private PLoanTypGlDao pLoanTypGlDao;

    @Reference
    private LmTdclCfgDao lmTdclCfgDao;

    @Reference
    private DeErrorLogDao deErrorLogDao;


    /**
     * 查询交易撤销记录
     */
    @Override
    public List<TradeCancelCfgTrans> getCfgList() {
        return this.cfgList;
    }

    /**
     * 查询交易撤销记录
     */
    @Override
    public void initTradeCancelCfg(String transCode) {
        LmTdclCfg lmTfclCfg =new LmTdclCfg();
        lmTfclCfg.setTransCode(transCode);
        List<LmTdclCfg> list = lmTdclCfgDao.selectListByObject(lmTfclCfg);
        if (!CollectionUtils.isEmpty(list)) {
            cfgList = new ArrayList<TradeCancelCfgTrans>(list.size());
            for (LmTdclCfg cfg : list) {
                TradeCancelCfgTrans cancelCfg = new TradeCancelCfgTrans();
                cancelCfg.setCancelFieldName(cfg.getClFd());
                cancelCfg.setHistTableName(cfg.getHistTableName());
                cancelCfg.setTableName(cfg.getTableName());
                cancelCfg.setCancelTyp(TradeCancelCfgTrans.CancelType
                        .getEnum(cfg.getClTyp()));
                cancelCfg.setRecover("Y".equals(cfg.getToHistInd()));
                cancelCfg.setToHist("Y".equals(cfg.getToHistInd()));
                cancelCfg.setResultIsList("Y".equals(cfg.getIsList()));
                cancelCfg.setTxLogSeqFieldName("txLogSeq");
                if (cfg.getSrcKeyFd() == null) {
                    cancelCfg.setKeyField("loanNo");
                } else {
                    cancelCfg.setKeyField(cfg.getSrcKeyFd());
                }
                cancelCfg.setSrcIdClassName(cfg.getSrcIdClass());
                cancelCfg.setIdClassName(cfg.getIdClass());
                if (cfg.getHistTxSeqFd() == null) {
                    cancelCfg.setHistTxSeqLogFieldName("txLogSeq");
                } else
                    cancelCfg.setHistTxSeqLogFieldName(cfg.getHistTxSeqFd());
                cfgList.add(cancelCfg);
            }
        }
    }

    /**
     * 查询包类型信息
     */
    @Override
    public PkgTypInfoTrans getPkgTypInfo(long pkgTyp) {
        List<PkgTyp> allList =pkgTypDap.selectAll();
        pkgTypInfoMap = new HashMap<Long, PkgTypInfoTrans>();
        if (!CollectionUtils.isEmpty(allList)) {
            for (PkgTyp pt : allList) {
                List<PkgTypDtl> sPkgTypDtls = pkgTypDtlDao.findByTypId(pt.getTypId());
                PkgTypDtl[] pkgTypDtls = new PkgTypDtl[sPkgTypDtls.size()];
                for (int j = 0; j < sPkgTypDtls.size(); j++) {
                    pkgTypDtls[j] = sPkgTypDtls.get(j);
                }
                PkgTypInfoTrans pti = new PkgTypInfoTrans(pt, pkgTypDtls);
                pkgTypInfoMap.put(pti.getPkgTyp().getTypId(), pti);
            }
        }
        PkgTypInfoTrans pti = this.pkgTypInfoMap.get(pkgTyp);
        if (pti == null) {
            throw new MinosException("没有找到包类型：" + pkgTyp + "的包详细定义");
        }
        return pti;
    }


    /**
     * @return String
     * @throws :
     * @Description(功能描述) :   获取贷款品种核算参数
     * @author(作者) ：  coffee
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
    @Override
    public List<PLoanTypGl> getPLoanTypGl() {
        List<PLoanTypGl> list = pLoanTypGlDao.selectListByObject(new PLoanTypGl());
        if (CollectionUtils.isEmpty(list)) {
            throw new MinosException("没有配置信息",MinosException.ERROR90001);
        }
        return list;
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取业务时间，在取业务时间的时候，必须在类中复制给一个字段， 不要在循环中，循环去取 获取系统业务时间
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
    @Override
    public String getDayendDt() {
        List<SCtrl> list = sCtrlDao.selectListByObject(new SCtrl());
        if (CollectionUtils.isEmpty(list)) {
            throw new MinosException("没有配置信息",MinosException.ERROR90001);
        }
        return list.get(0).getDayendDt();
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取业务时间，在取业务时间的时候，必须在类中复制给一个字段， 不要在循环中，循环去取 获取系统业务时间
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
    @Override
    public boolean isNight() {
        List<SCtrl> list = sCtrlDao.selectListByObject(new SCtrl());
        if (CollectionUtils.isEmpty(list)) {
            throw new MinosException("没有配置信息",MinosException.ERROR90001);
        }
        return !"N".equals(list.get(0).getNight());
    }


    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取业务时间，在取业务时间的时候，必须在类中复制给一个字段， 不要在循环中，循环去取 获取系统业务时间
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
    @Override
    public String getBuzDate() {
        return iSystemInitService.findBuzDate();
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取下一个交易流水号
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午14:30:28
     */
    @Override
    public String getPayPkgSeq() {
        return txLogNoNextValDualDomainMapper.findPayPkgSeq();
    }


    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取下一个交易流水号
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午14:30:28
     */
    @Override
    public String getNextValDual() {
        return txLogNoNextValDualDomainMapper.findNextSeqNo();
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取默认银行代码
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午14:30:28
     */
    @Override
    public String getDefaultBankCde() {
        List<SCtrl> list = sCtrlDao.selectListByObject(new SCtrl());
        if (CollectionUtils.isEmpty(list)) {
            throw new MinosException("没有配置信息",MinosException.ERROR90001);
        }
        return list.get(0).getBankCde();
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取系统配置信息
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     */
    @Override
    public SCtrl getSystemConfig() {
        List<SCtrl> list = sCtrlDao.selectListByObject(new SCtrl());
        if (CollectionUtils.isEmpty(list)) {
            throw new MinosException("没有配置信息",MinosException.ERROR90001);
        }
        return list.get(0);
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取系统配置信息
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     */
    @Override
    public List<SBch> getBranchList() {
        branchList = sBchDao.selectListByObject(null);
        if (CollectionUtils.isEmpty(branchList)) {
            throw new MinosException("机构表无记录",MinosException.ERROR90001);
        }
        return branchList;
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  按照机构级别来取
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     */
    @Override
    public List<SBch> getBranchList(String level) {
        List<SBch> list = new ArrayList<SBch>(20);
        branchList = sBchDao.selectListByObject(null);
        for (SBch sbch : branchList) {
            if (level.equals(sbch.getBchLevel())) {
                list.add(sbch);
            }
        }
        return list;
    }

    @Override
    public String getPrpLRegist(String jobCanal) {
        return "";
    }

    /**
     * 返回子机构的逗号分隔的串代码,每一个机构用''包含。 包含传入的机构
     *
     * @param bankCde
     * @param bchCde
     * @return 'code1','code2' , 如果没有子机构返回空串
     */
    public String getSubBranchCommaStringIncludeSelf(String bankCde,String bchCde) {
        StringBuffer subBranches = getSubBranchCommaString(bankCde, bchCde);
        if (!"".equals(subBranches.toString())) {
            subBranches.append(",");
        }
        subBranches.append("'").append(bchCde).append("'");
        return subBranches.toString();
    }

    /**
     * 返回子机构的逗号分隔的串代码,每一个机构用''包含。
     *
     * @param bankCde
     * @param branchCode
     * @return 'code1','code2' , 如果没有子机构返回空串
     */

    public StringBuffer getSubBranchCommaString(String bankCde,
                                                String branchCode) {
        List<SBch> list = getSubBranchList(bankCde, branchCode);
        if (CollectionUtils.isEmpty(list)) {
            return new StringBuffer("");
        }
        StringBuilder result = new StringBuilder(50);
        result.append("'").append(list.get(0).getBchCde()).append("'");
        for (int i = 1; i < list.size();) {
            result.append(",").append("'").append(
                    list.get(i++).getBchCde()).append("'");
        }
        return new StringBuffer(result);
    }

    /**
     * 查找某个指定机构的所有子机构。
     *
     * @param branchCode
     * @return
     */
    public List<SBch> getSubBranchList(String bankCde, String branchCode) {

        Set<SBch> subList = new HashSet<SBch>(10);
        Stack<String> stack = new Stack<String>();
        stack.add(branchCode);
        if (bankCde == null) {
            throw new MinosException("bankCde param can not null");
        }
        while (!stack.isEmpty()) {
            branchCode = stack.pop();
            for (SBch sbch : branchList) {
                if (bankCde.equals(sbch.getBankCde())) {
                    if (branchCode.equals(sbch.getBchFarCde())) {
                        subList.add(sbch);
                        if (sbch.getBchCde().equals(branchCode)) {
                            throw new MinosException("子机构:" + branchCode + "不能和输入机构相等");
                        }
                        stack.add(sbch.getBchCde());
                    }
                }
            }
        }
        return new ArrayList<SBch>(subList);
    }

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取联机交易授权交易日志初始化实例
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     */
    @Override
    public LmGlnoLog getLmGlnoLog(LmGlnoLogTrans lmGlnoLogTrans) {
        LmGlnoLog lmGlnoLog = new LmGlnoLog(lmGlnoLogTrans.getGenGlNo());
        if (ObjectUtil.objectIsNull(lmGlnoLogTrans.getTxLogSeq())){
            lmGlnoLog.setTxLogSeq(Long.valueOf(getNextValDual()));
        }else{
            lmGlnoLog.setTxLogSeq(Long.valueOf(lmGlnoLogTrans.getTxLogSeq()));
        }
        lmGlnoLog.setTransCode(lmGlnoLogTrans.getTransCode());
        BigDecimal amount = lmGlnoLogTrans.getAmount();
        lmGlnoLog.setAmount(amount == null ||"".equals(amount) ? new BigDecimal(0) : amount);
        lmGlnoLog.setMemo(lmGlnoLogTrans.getMemo());
        lmGlnoLog.setBchCde(lmGlnoLogTrans.getAppUserOrgNo());
        lmGlnoLog.setAppUserId(lmGlnoLogTrans.getAppUserId());
        lmGlnoLog.setAppUserName(lmGlnoLogTrans.getAppUserName());
        lmGlnoLog.setAppUserOrgNo(lmGlnoLogTrans.getAppUserOrgNo());
        lmGlnoLog.setAppDt(getBuzDate());
        lmGlnoLog.setGenGlInd(GenGlIndEnum.DONE.getCodeInDb());
        lmGlnoLog.setCrtDt(DateOperation.formatDate(new Date()));
        lmGlnoLog.setCrtTm(DateOperation.formatTime(new Date()));
        lmGlnoLog.setLoanContNo(lmGlnoLogTrans.getLoanContNo());
        lmGlnoLog.setLoanNo(lmGlnoLogTrans.getLoanNo());
        lmGlnoLog.setInfoCmisInd("Y");
        lmGlnoLog.setSentSys("XD");
        lmGlnoLog.setServiceId(lmGlnoLogTrans.getServiceId());
        return  lmGlnoLog;
    }


    /**
     * 进入 白天
     */
    public void enterNewDayTime() {
        List<SCtrl> list =sCtrlDao.selectListByObject(new SCtrl());
        if (CollectionUtils.isEmpty(list)) {
            throw new MinosException("没有找到系统配置信息:s_ctrl");
        }
        list.get(0).setRtPrcsDt(list.get(0).getCurPrcsDt());
        list.get(0).setNight("N");
        list.get(0).setBatching("N");
        sCtrlDao.update(list.get(0));
    }

    // 获取线程随机数
    public int getThreadCnt() {
        return new Random().nextInt(99);
    }

    /**
     * 保存错误信息
     * @param loanNo
     * @param jobName
     * @param errMsg
     * @param errCode
     */
    public void writeErrorCodeToDb(RuntimeException re,String loanNo,String jobName,
                                     String errCode,String errMsg) {
        if (re instanceof MinosException) {
            String eCode = ((MinosException) re).getErrCode();
            if (org.springframework.util.StringUtils.hasText(eCode)) {
                errCode = eCode;
            }
        }
        if (!org.springframework.util.StringUtils.hasText(errMsg)) {
            errMsg = re.getMessage();
        }
        if (re != null) {
            re.printStackTrace();
            errMsg = re.getMessage();
        }
        saveErrLog(loanNo,jobName,errCode,errMsg);
    }
    /**
     * 保存错误信息
     * @param loanNo
     * @param jobName
     * @param errMsg
     * @param errorCode
     */
    public void saveErrLog(String loanNo,String jobName,
                                   String errorCode,String errMsg){
        DeErrorLog errLog = new DeErrorLog();
        errLog.setErrMsg(errMsg);
        errLog.setJobNam(jobName);
        Date date = new Date();
        errLog.setLogDt(DateOperation.getDateStringToDb(date));
        errLog.setMacTime(DateOperation.formatDate(date));
        errLog.setLoanNo(loanNo);
        errLog.setRtnCde(errorCode);
        errLog.setPrcsDt(getBuzDate());
        deErrorLogDao.insert(errLog);
    }

    /**
     * 线程查找串
     *
     * @param total
     * @param threadCount
     * @param counter
     * @return
     */
    public String getThreadAlloStr(int total, int threadCount, int counter) {
        if (counter < 0) {
            throw new MinosException(
                    "thread counter can not permit negative data");
        }
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < total; i++) {
            if (i % threadCount == counter) {
                rst.append("'").append(i).append("'").append(",");
            }
        }
        if (rst.length() > 0) {
            rst.deleteCharAt(rst.length() - 1);
        }
        return rst.toString();
    }
}
