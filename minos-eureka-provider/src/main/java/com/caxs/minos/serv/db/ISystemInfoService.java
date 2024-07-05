package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmGlnoLog;
import com.caxs.minos.domain.PLoanTypGl;
import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.SCtrl;
import com.caxs.minos.domain.trans.LmGlnoLogTrans;
import com.caxs.minos.domain.trans.PkgTypInfoTrans;
import com.caxs.minos.domain.trans.TradeCancelCfgTrans;
import java.util.List;
/***
 * @ClassName(类名) : ISystemInfo
 * @Description(描述) : 获取系统信息
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/8/19 11:37
 */
public interface ISystemInfoService {
    /**
     *
     * @Description(功能描述)  :  获取业务时间，在取业务时间的时候，必须在类中复制给一个字段， 不要在循环中，循环去取 获取系统业务时间
     * @author(作者)      ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午11:30:28

     * @exception         :
     * @param
     * @return  String
     */
    String getBuzDate();

    /**
     *
     * @Description(功能描述)  :  返回日终时间
     * @author(作者)      ：  coffee
     * @date (开发日期)    :  2020-8-19 上午11:30:28

     * @exception         :
     * @param
     * @return  String
     */
    String getDayendDt();

    /**
     *
     * @Description(功能描述)  :  获取下一个交易流水号
     * @author(作者)      ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午14:30:28
     * @exception         :
     * @param
     * @return  String
     */
    String getPayPkgSeq();

    /**
     *
     * @Description(功能描述)  :  获取下一个交易流水号
     * @author(作者)      ：  fengdetian
     * @date (开发日期)    :  2020-8-19 上午14:30:28
     * @exception         :
     * @param
     * @return  String
     */
     String getNextValDual();

    /**
     *
     * @Description(功能描述)  :  获取默认银行代码
     * @author(作者)      ：  fengdetian
     * @date (开发日期)    :  2020-8-19 下午14:30:28
     * @exception         :
     * @param
     * @return  String
     */
    String getDefaultBankCde();

    /**
     *
     * @Description(功能描述)  :  获取系统配置信息
     * @author(作者)      ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     * @exception         :
     * @param
     * @return  String
     */
    SCtrl getSystemConfig();

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  获取联机交易授权交易日志初始化实例
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     */
     LmGlnoLog getLmGlnoLog(LmGlnoLogTrans lmGlnoLogTrans);

    /**
     * @Description(功能描述)  :  获取系统配置信息
     * @author(作者)      ：  coffee
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     * @exception         :
     * @param
     * @return  String
     */
     boolean isNight();

    /**
     * @Description(功能描述)  :  获取机构信息
     * @author(作者)      ：  coffee
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     * @exception         :
     * @param
     * @return  String
     */
    List<SBch> getBranchList();

    /**
     * @Description(功能描述)  :  根据银行代码和机构号查询子机构
     * @author(作者)      ：  coffee
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     * @exception         :
     * @param
     * @return  String
     */
    String getSubBranchCommaStringIncludeSelf(String bankCde,String bchCde);
    /**
     * @Description(功能描述)  :  进入 白天
     * @author(作者)      ：  coffee
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     * @exception         :
     * @param
     */
    void enterNewDayTime();
    /**
     * @throws :
     * @Description(功能描述) :   获取贷款品种核算参数
     * @author(作者) ：  coffee
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
     List<PLoanTypGl> getPLoanTypGl();
    /**
     * @throws :
     * @Description(功能描述) :  查询包类型信息
     * @author(作者) ：  coffee
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
    PkgTypInfoTrans getPkgTypInfo(long pkgTyp);
    /**
     * @throws :
     * @Description(功能描述) :  查询交易撤销记录
     * @author(作者) ：  coffee
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
     void initTradeCancelCfg(String transCode);
    /**
     * @throws :
     * @Description(功能描述) :  查询交易撤销记录
     * @author(作者) ：  coffee
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
      List<TradeCancelCfgTrans> getCfgList();

    /**
     * @throws :
     * @Description(功能描述) :  获取线程随机数
     * @author(作者) ：  coffee
     * @date (开发日期)    :  2020-8-19 上午11:30:28
     */
    int getThreadCnt();
    /**
     * 保存错误信息
     * @param loanNo
     * @param jobName
     * @param errMsg
     * @param errCode
     */
    void writeErrorCodeToDb(RuntimeException re,String loanNo,String jobName,
                       String errCode,String errMsg) ;
    /**
     * 保存错误信息
     * @param loanNo
     * @param jobName
     * @param errMsg
     * @param errorCode
     */
     void saveErrLog(String loanNo,String jobName,
                           String errorCode,String errMsg);
    /**
     * 线程查找串
     *
     * @param total
     * @param threadCount
     * @param counter
     * @return
     */
     String getThreadAlloStr(int total, int threadCount, int counter);
    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  按照机构级别来取
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     */
     List<SBch> getBranchList(String level);

    /**
     * @return String
     * @throws :
     * @Description(功能描述) :  按照机构级别来取
     * @author(作者) ：  fengdetian
     * @date (开发日期)    :  2020-8-30 上午11:30:28
     */
     String getPrpLRegist(String jobCanal);
}
