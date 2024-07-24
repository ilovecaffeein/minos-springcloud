package com.caxs.minos.domain;

import java.sql.Connection;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *联机参数
 * 
 * @author hb
 * 
 */
/**
 * 联机交易必须登记： custName，txAmt(票面金额)，billNo（凭证编号。）,loanNo借据号,acctNo结算账户， sequence
 * 交易流水. buzDate 贷款发放更新不到凭证票号。 构造参数(Connection conn, long txLogSeq, Object
 * context, TransCode transCode, String buzDate, String loanNo)
 * 
 * @author hb
 * 
 */
public class OnlineParam implements Cloneable {
	private final static Log log = LogFactory.getLog(OnlineParam.class);
	/**
	 * 集合交易，一个大交易包含很多子交易，例如：合同发放的贴现。 集合交易在交易完成以后才生成LmBchGlTx
	 */
	private boolean collectionTransaction;
	/**
	 * 收费列表
	 */
	private String glHolidayAdj;// 节假日是否调整 add hbs 20150318
	private boolean isAdjestPrc = false;// 是否只有当有本金时才调整 add hbs 20150318

	public Double getFormularAmt() {
		return formularAmt;
	}

	public void setFormularAmt(Double formularAmt) {
		this.formularAmt = formularAmt;
	}

	public boolean getIsAlFormAmt() {
		return isAlFormAmt;
	}

	public void setIsAlFormAmt(boolean isAlFormAmt) {
		this.isAlFormAmt = isAlFormAmt;
	}

	public Double formularAmt;// 标准期供
	public boolean isAlFormAmt = false;// 是否根据传入的期供值计算还款计划

	public boolean getIsAdjestPrc() {
		return isAdjestPrc;
	}

	public void setIsAdjestPrc(boolean isAdjestPrc) {
		this.isAdjestPrc = isAdjestPrc;
	}

	public String getGlHolidayAdj() {
		return glHolidayAdj;
	}

	public void setGlHolidayAdj(String glHolidayAdj) {
		this.glHolidayAdj = glHolidayAdj;
	}

	public boolean isCollectionTransaction() {
		return collectionTransaction;
	}

	public void setCollectionTransaction(boolean collectionTransaction) {
		this.collectionTransaction = collectionTransaction;
	}

	/**
	 * 系统默认区域信息
	 */
	private Locale locale = null;
	/**
	 * 操作员对象
	 */
	OperaUserInf operaUserInf = null;
	/**
	 * sessionid属性
	 */
	private String netBankSessionId;
	/**
	 * 会计分录流水,一般同交易流水
	 */
	private long txNo = -1L;

	/**
	 * 获取会计分录流水
	 * 
	 * @return
	 */
	public long getTxNo() {
		return txNo;
	}

	/**
	 * 设置会计分录流水
	 * 
	 * @param txNo
	 */
	public void setTxNo(long txNo) {
		this.txNo = txNo;
	}

	/**
	 * 是否贷款
	 */
	private boolean loan = true;

	/**
	 * 获取是否贷款标志
	 * 
	 * @return
	 */
	public boolean isLoan() {
		return loan;
	}

	/**
	 * 设置是否贷款标志
	 * 
	 * @param loan
	 */
	public void setLoan(boolean loan) {
		this.loan = loan;
	}

	/**
	 *发送日期
	 */
	private String sentDate;

	/**
	 *发送时间
	 */
	private String sentTime;
	private String lisId;// 会计协议号
	/**
	 * 记账科目集合
	 */
	private Map<String, String> amtTypGlMap = null;
	/**
	 * 获取记账科目集合
	 * 
	 * @return
	 */
	public Map<String, String> getAmtTypGlMap() {
		return amtTypGlMap;
	}

	/**
	 * 设置记账科目集合
	 * 
	 * @param amtTypGlMap
	 */
	public void setAmtTypGlMap(Map<String, String> amtTypGlMap) {
		this.amtTypGlMap = amtTypGlMap;
	}

	/**
	 * 获取会计协议号
	 * 
	 * @return
	 */
	public String getLisId() {
		return lisId;
	}

	/**
	 * 设置会计协议号
	 * 
	 * @param lisId
	 */
	public void setLisId(String lisId) {
		this.lisId = lisId;
	}

	/**
	 * 交易币种
	 */
	private String transCcy;
	/**
	 * 是否发放操作
	 */
	private boolean isLoanDownOp = false;
	/**
	 * 假期天数
	 */
	private int holidayCount = 0;
	/**
	 * 数据库连接
	 */
	private Connection conn;
	/**
	 * 交易流水号
	 */
	private long txLogSeq = -1;
	/**
	 * 业务日期
	 */
	private String buzDate;
	/**
	 * 客户姓名
	 */
	private String custName;
	/**
	 * 借据号
	 */
	private String loanNo;
	private long oldTxLogSeq;// 交易撤销时使用的，需要撤销的交易流水号
	private final static String PROCESSING_FLAG = "CORE_EXE_ACC0";


	/**
	 * 是否有交易流水号
	 * 
	 * @return
	 */
	public boolean hasTxLogSeq() {
		return txLogSeq != -1;
	}

	/**
	 * 收费交易流水
	 */
	private long feeTxLogSeq;
	/**
	 * 收付记录交易流水
	 */
	private long pyclTxLogSeq;

	/**
	 * 获取收费交易流水
	 * 
	 * @return
	 */
	public long getFeeTxLogSeq() {
		return feeTxLogSeq;
	}

	/**
	 * 设置收费交易流水
	 * 
	 * @param feeTxLogSeq
	 */
	public void setFeeTxLogSeq(long feeTxLogSeq) {
		this.feeTxLogSeq = feeTxLogSeq;
	}

	/**
	 * 获取收付记录交易流水
	 * 
	 * @return
	 */
	public long getPyclTxLogSeq() {
		return pyclTxLogSeq;
	}

	/**
	 * 设置收付记录交易流水
	 * 
	 * @param pyclTxLogSeq
	 */
	public void setPyclTxLogSeq(long pyclTxLogSeq) {
		this.pyclTxLogSeq = pyclTxLogSeq;
	}

	/**
	 * 是否记日志
	 */
	private boolean isToLog = false;
	/**
	 * 是否发送核心
	 */
	private boolean isToCore = false;
	/**
	 * 是否是金融公司
	 * */
	private boolean isToFC = false;

	public boolean isToFC() {
		return isToFC;
	}

	public void setToFC(boolean isToFC) {
		this.isToFC = isToFC;
	}

	/**
	 * 是否记账
	 */
	private boolean isAccount = false;

	/**
	 * 获取是否记账
	 * 
	 * @return
	 */
	public boolean isAccount() {
		return isAccount;
	}

	/**
	 * 设置是否记账
	 * 
	 * @param isAccount
	 */
	public void setAccount(boolean isAccount) {
		this.isAccount = isAccount;
	}

	/**
	 *交易码
	 */
	private TransCode transCode;

	/**
	 * 获取交易码
	 * 
	 * @return
	 */
	public TransCode getTransCode() {
		return transCode;
	}

	/**
	 * 设置交易码
	 * 
	 * @param transCode
	 */
	public void setTransCode(TransCode transCode) {
		this.transCode = transCode;
	}
	/**
	 * 获取原流水号
	 * 
	 * @return
	 */
	public long getOldTxLogSeq() {
		return oldTxLogSeq;
	}

	/**
	 *借据的机构号
	 */
	private String bchCdeOfLoan;

	/**
	 *借据的机构号
	 */
	private String bankCdeOfLoan;

	/**
	 * 获取借据的银行号码
	 * 
	 * @return
	 */
	public String getBankCdeOfLoan() {
		return this.bankCdeOfLoan;
	}

	/**
	 * 设置借据的银行号码
	 * 
	 * @param bankCdeOfLoan
	 */
	public void setBankCdeOfLoan(String bankCdeOfLoan) {
		this.bankCdeOfLoan = bankCdeOfLoan;
	}

	/**
	 * 设置原交易流水号
	 * 
	 * @param oldTxLogSeq
	 */
	public void setOldTxLogSeq(long oldTxLogSeq) {
		this.oldTxLogSeq = oldTxLogSeq;
	}

	/**
	 * 获取假期天数
	 * 
	 * @return
	 */
	public int getHolidayCount() {
		return holidayCount;
	}

	/**
	 * 设置假期天数
	 * 
	 * @param holidayCount
	 */
	public void setHolidayCount(int holidayCount) {
		this.holidayCount = holidayCount;
	}

	/**
	 * 是否批处理,会影响到分录
	 */
	private boolean isBatch = false;
	/**
	 * 是否日终
	 */
	private boolean isNight = false;

	/**
	 * 获取是否日终交易
	 * 
	 * @return
	 */
	public boolean isNight() {
		return isNight;
	}

	/**
	 * 设置是否日终交易
	 * 
	 * @param isNight
	 */
	public void setNight(boolean isNight) {
		this.isNight = isNight;
	}

	/**
	 * 获取是否批处理交易
	 * 
	 * @return
	 */
	public boolean isBatch() {
		return isBatch;
	}

	/**
	 * 设置是否批处理交易
	 * 
	 * @param isBatch
	 */
	public void setBatch(boolean isBatch) {
		this.isBatch = isBatch;
	}

	/**
	 * 结算账户
	 */
	private String acctNo;

	/**
	 * 交易金额,本次交易的金额，例如：银承，填写票面金额
	 */
	private double txAmt;
	/**
	 *凭证编号。例如：
	 */
	private String billNo;

	/**
	 * 获取借据号
	 * 
	 * @return
	 */
	public String getLoanNo() {
		return loanNo;
	}

	/**
	 * 设置借据号
	 * 
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	/**
	 * 获取交易金额
	 * 
	 * @return
	 */
	public double getTxAmt() {
		return txAmt;
	}

	/**
	 * 设置交易金额
	 * 
	 * @param txAmt
	 */
	public void setTxAmt(double txAmt) {
		this.txAmt = txAmt;
	}

	/**
	 * 获取凭证编号
	 * 
	 * @return
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * 设置凭证编号
	 * 
	 * @param billNo
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	/**
	 * 获取结算账户
	 * 
	 * @return
	 */
	public String getAcctNo() {
		return acctNo;
	}

	/**
	 * 设置结算账户
	 * 
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	/**
	 * 获取客户姓名
	 * 
	 * @return
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * 设置客户姓名
	 * 
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * 获取业务日期
	 * 
	 * @return
	 */
	public String getBuzDate() {
		return buzDate;
	}

	/**
	 * 设置业务日期
	 * 
	 * @param buzDate
	 */
	public void setBuzDate(String buzDate) {
		this.buzDate = buzDate;
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * 设置连接
	 * 
	 * @param conn
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 获取交易流水
	 * 
	 * @return
	 */
	public long getTxLogSeq() {
		return txLogSeq;
	}

	/**
	 * 联机参数构造方法
	 * 
	 * @param conn
	 * @param txLogSeq
	 * @param context
	 * @param transCode
	 * @param buzDate
	 * @param loanNo
	 */
	public OnlineParam(Connection conn, long txLogSeq, Object context,
			TransCode transCode, String buzDate, String loanNo) {
		super();
		this.conn = conn;
		this.txLogSeq = txLogSeq;
		this.feeTxLogSeq = txLogSeq;
		this.pyclTxLogSeq = txLogSeq;
		this.context = context;
		this.transCode = transCode;
		this.buzDate = buzDate;
		this.loanNo = loanNo;
	}

	/**
	 * 设置交易流水号
	 * 
	 * @param txLogSeq
	 */
	public void setTxLogSeq(long txLogSeq) {
		this.txLogSeq = txLogSeq;
	}

	/**
	 * 获取context对象
	 * 
	 * @return
	 */
	public Object getContext() {
		return context;
	}

	/**
	 * 设置context对象
	 * 
	 * @param context
	 */
	public void setContext(Object context) {
		this.context = context;
	}
	/**
	 *emp context
	 */
	private Object context;

	/**
	 * 获取操作员对象
	 * 
	 * @return
	 */
	public OperaUserInf getOperaUserInf() {
		return operaUserInf;
	}

	/**
	 * 设置操作员对象
	 * 
	 * @param operaUserInf
	 */
	public void setOperaUserInf(OperaUserInf operaUserInf) {
		this.operaUserInf = operaUserInf;
	}

	/**
	 * 获取是否需要打印日志
	 * 
	 * @return
	 */
	public boolean isToLog() {
		return isToLog;
	}

	/**
	 * 设置是否记日志
	 * 
	 * @param isToLog
	 */
	public void setToLog(boolean isToLog) {
		this.isToLog = isToLog;
	}

	/**
	 * 获取是否发送核心
	 * 
	 * @return
	 */
	public boolean isToCore() {
		return isToCore;
	}

	/**
	 * 设置是否发送核心
	 * 
	 * @param isToCore
	 */
	public void setToCore(boolean isToCore) {
		this.isToCore = isToCore;
	}

	/**
	 * 是否发放操作
	 * 
	 * @return
	 */
	public boolean isLoanDownOp() {
		return isLoanDownOp;
	}

	/**
	 * 是否发放操作
	 * 
	 * @param isLoanDownOp
	 */
	public void setLoanDownOp(boolean isLoanDownOp) {
		this.isLoanDownOp = isLoanDownOp;
	}

	/**
	 * 获取区域信息
	 * 
	 * @return
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * 设置区域信息
	 * 
	 * @param locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 获取sessionid属性
	 * 
	 * @return
	 */
	public String getNetBankSessionId() {
		return netBankSessionId;
	}

	/**
	 * 设置sessionid属性
	 * 
	 * @param netBankSessionId
	 */
	public void setNetBankSessionId(String netBankSessionId) {
		this.netBankSessionId = netBankSessionId;
	}

	/**
	 * 获取交易币种信息
	 * 
	 * @return
	 */
	public String getTransCcy() {
		return transCcy;
	}

	/**
	 * 设置交易币种信息
	 * 
	 * @param transCcy
	 */
	public void setTransCcy(String transCcy) {
		this.transCcy = transCcy;
	}
	/**
	 * 获取发送日期
	 * 
	 * @return
	 */
	public String getSentDate() {
		return sentDate;
	}

	/**
	 * 设置发送日期
	 * 
	 * @param sentDate
	 */
	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	/**
	 * 获取发送时间
	 * 
	 * @return
	 */
	public String getSentTime() {
		return sentTime;
	}

	/**
	 * 设置发送时间
	 * 
	 * @param sentTime
	 */
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}

	/*NM:正常还款 ,DC: 代偿还款*/
	/**
	 * 贷款置换类型
	 */
	private String dpTyp ="NM";

	/**
	 * 贷款置换类型
	 */
	public String getDpTyp() {
		return dpTyp;
	}

	/**
	 * 贷款置换类型
	 */
	public void setDpTyp(String dpTyp) {
		this.dpTyp = dpTyp;
	}

	/**
	 * 借新还旧旧借据号
	 */
	private String oldLoanNo;

	public String getOldLoanNo() {
		return oldLoanNo;
	}

	public void setOldLoanNo(String oldLoanNo) {
		this.oldLoanNo = oldLoanNo;
	}

	/**
	 * 是否只还本金
	 */
	private boolean isOnlyPrcp;

	public boolean isOnlyPrcp() {
		return isOnlyPrcp;
	}

	public void setOnlyPrcp(boolean isOnlyPrcp) {
		this.isOnlyPrcp = isOnlyPrcp;
	}

	//是否计算担保费入账：Y：计算，N：不计算
	private String feeType="N";              
	
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	//是否判断担保费结清状态：Y：判断，N：不判断
	private String feeInd="N";              
	
	public String getFeeInd() {
		return feeInd;
	}
	public void setFeeInd(String feeInd) {
		this.feeInd = feeInd;
	}
}
