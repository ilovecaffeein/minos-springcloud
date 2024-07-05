package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmAtpyDetl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 批扣序号
	 */
	private String atpySeqNo;
	/**
	 * 交易日
	 */
	private String atpyValDt;
	/**
	 * 数据序号
	 */
	private Long txlogNo;
	/**
	 * 交易流水子序号
	 */
	private Long txlogSeqNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 银行代码
	 */
	private String atpyBankCde;
	/**
	 * 机构代码
	 */
	private String atpyBchCde;
	/**
	 * 保证金编号
	 */
	private String gutrNo;
	/**
	 * 还款帐号银行代码
	 */
	private String atpyAcctBankCde;
	/**
	 * 还款帐号机构代码
	 */
	private String atpyAcctBchCde;
	/**
	 * 扣款账号
	 */
	private String atpyAcctNo;
	/**
	 * 钞汇标志
	 */
	private String atpyAcctNttInd;
	/**
	 * 账户类型
	 */
	private String atpyAcctTyp;
	/**
	 * 账户代码
	 */
	private String atpyAcctCde;
	/**
	 * 账户币种
	 */
	private String atpyAcctCcyCde;
	/**
	 * 户名
	 */
	private String atpyAcctName;
	/**
	 * 证件类型
	 */
	private String atpyAcctIdType;
	/**
	 * 证件号码
	 */
	private String atpyAcctIdNo;
	/**
	 * 发证国家
	 */
	private String atpyAcctIssCtry;
	/**
	 * 账号科目代码
	 */
	private String atpyAcctLdgrCde;
	/**
	 * 扣款币种
	 */
	private String atpyCcyCde;
	/**
	 * 扣款类型
	 */
	private String atpyTyp;
	/**
	 * 本金
	 */
	private BigDecimal atpyPrcpAmt;
	/**
	 * 正常利息
	 */
	private BigDecimal atpyIntAmt;
	/**
	 * 逾期利息
	 */
	private BigDecimal atpyOdInt;
	/**
	 * 复利
	 */
	private BigDecimal atpyCompInt;
	/**
	 * 创建日期
	 */
	private String atpyCreateDt;
	/**
	 * 批扣状态
	 */
	private String atpySts;
	/**
	 * 存款会计科目
	 */
	private String atpyLdgrCde;
	/**
	 * 应扣金额
	 */
	private BigDecimal atpyPaymAmt;
	/**
	 * 生成文件日期
	 */
	private String atpySpoolDt;
	/**
	 * 费用金额
	 */
	private BigDecimal atpyFeeAmt;
	/**
	 * 实还金额
	 */
	private BigDecimal atpyTxAmt;
	/**
	 * 第几期
	 */
	private BigDecimal atpyInstmNo;
	/**
	 * 失败原因
	 */
	private String atpyErrDesc;
	/**
	 * 扣款返回时间
	 */
	private String atpyRtnDt;
	/**
	 * 费用代码
	 */
	private String atpyFeeCde;
	/**
	 * 会计分录交易号
	 */
	private Integer atpyTxNo;
	/**
	 * 批量冲正流水号
	 */
	private String atpyBatRevseNo;
	/**
	 * 摘要代码
	 */
	private String atpySummNo;
	/**
	 * 冻结流水号
	 */
	private String atpyHoldTxNo;
	/**
	 * 冻结业务编号
	 */
	private String atpyHoldBussTyp;
	/**
	 * 处理分页数据标志
	 */
	private String prcsPageDtInd;
	/**
	 * 业务类型
	 */
	private String bussTyp;
	/**
	 * 交易流水
	 */
	private Long txLogSeq;
	/**
	 * 银行名称
	 */
	private String acctBankNm;
	/**
	 * 本行标志
	 */
	private String acctSelfBankInd;
	/**
	 * ${column.comments}
	 */
	private String acctLdgrSeqNo;
	/**
	 * 是否其他银行：CA：长安新生,WeBank：微众银行, ZHXT:中航信托
	 */
	private String zhyCde;
	/**
	 * 发起扣款方：Y：日终批量，N：日间批量，Z：中原批量
	 */
	private String night;
	/**
	 * 逾期天数
	 */
	private Integer debtOverDay;
	/**
	 * 文件系号
	 */
	private String fileSeq;
	/**
	 * 扣款渠道
	 */
	private String pchCde;
	/**
	 * 手机号
	 */
	private String bindMobile;

	/**
	 * 设置：手机号
	 */
	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getBindMobile() {
		return bindMobile;
	}



	/**
	 * 设置：批扣序号
	 */
	public void setAtpySeqNo(String atpySeqNo) {
		this.atpySeqNo = atpySeqNo;
	}
	/**
	 * 获取：批扣序号
	 */
	public String getAtpySeqNo() {
		return atpySeqNo;
	}
	/**
	 * 设置：交易日
	 */
	public void setAtpyValDt(String atpyValDt) {
		this.atpyValDt = atpyValDt;
	}
	/**
	 * 获取：交易日
	 */
	public String getAtpyValDt() {
		return atpyValDt;
	}
	/**
	 * 设置：数据序号
	 */
	public void setTxlogNo(Long txlogNo) {
		this.txlogNo = txlogNo;
	}
	/**
	 * 获取：数据序号
	 */
	public Long getTxlogNo() {
		return txlogNo;
	}
	/**
	 * 设置：交易流水子序号
	 */
	public void setTxlogSeqNo(Long txlogSeqNo) {
		this.txlogSeqNo = txlogSeqNo;
	}
	/**
	 * 获取：交易流水子序号
	 */
	public Long getTxlogSeqNo() {
		return txlogSeqNo;
	}
	/**
	 * 设置：借据号
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	/**
	 * 获取：借据号
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * 设置：银行代码
	 */
	public void setAtpyBankCde(String atpyBankCde) {
		this.atpyBankCde = atpyBankCde;
	}
	/**
	 * 获取：银行代码
	 */
	public String getAtpyBankCde() {
		return atpyBankCde;
	}
	/**
	 * 设置：机构代码
	 */
	public void setAtpyBchCde(String atpyBchCde) {
		this.atpyBchCde = atpyBchCde;
	}
	/**
	 * 获取：机构代码
	 */
	public String getAtpyBchCde() {
		return atpyBchCde;
	}
	/**
	 * 设置：保证金编号
	 */
	public void setGutrNo(String gutrNo) {
		this.gutrNo = gutrNo;
	}
	/**
	 * 获取：保证金编号
	 */
	public String getGutrNo() {
		return gutrNo;
	}
	/**
	 * 设置：还款帐号银行代码
	 */
	public void setAtpyAcctBankCde(String atpyAcctBankCde) {
		this.atpyAcctBankCde = atpyAcctBankCde;
	}
	/**
	 * 获取：还款帐号银行代码
	 */
	public String getAtpyAcctBankCde() {
		return atpyAcctBankCde;
	}
	/**
	 * 设置：还款帐号机构代码
	 */
	public void setAtpyAcctBchCde(String atpyAcctBchCde) {
		this.atpyAcctBchCde = atpyAcctBchCde;
	}
	/**
	 * 获取：还款帐号机构代码
	 */
	public String getAtpyAcctBchCde() {
		return atpyAcctBchCde;
	}
	/**
	 * 设置：扣款账号
	 */
	public void setAtpyAcctNo(String atpyAcctNo) {
		this.atpyAcctNo = atpyAcctNo;
	}
	/**
	 * 获取：扣款账号
	 */
	public String getAtpyAcctNo() {
		return atpyAcctNo;
	}
	/**
	 * 设置：钞汇标志
	 */
	public void setAtpyAcctNttInd(String atpyAcctNttInd) {
		this.atpyAcctNttInd = atpyAcctNttInd;
	}
	/**
	 * 获取：钞汇标志
	 */
	public String getAtpyAcctNttInd() {
		return atpyAcctNttInd;
	}
	/**
	 * 设置：账户类型
	 */
	public void setAtpyAcctTyp(String atpyAcctTyp) {
		this.atpyAcctTyp = atpyAcctTyp;
	}
	/**
	 * 获取：账户类型
	 */
	public String getAtpyAcctTyp() {
		return atpyAcctTyp;
	}
	/**
	 * 设置：账户代码
	 */
	public void setAtpyAcctCde(String atpyAcctCde) {
		this.atpyAcctCde = atpyAcctCde;
	}
	/**
	 * 获取：账户代码
	 */
	public String getAtpyAcctCde() {
		return atpyAcctCde;
	}
	/**
	 * 设置：账户币种
	 */
	public void setAtpyAcctCcyCde(String atpyAcctCcyCde) {
		this.atpyAcctCcyCde = atpyAcctCcyCde;
	}
	/**
	 * 获取：账户币种
	 */
	public String getAtpyAcctCcyCde() {
		return atpyAcctCcyCde;
	}
	/**
	 * 设置：户名
	 */
	public void setAtpyAcctName(String atpyAcctName) {
		this.atpyAcctName = atpyAcctName;
	}
	/**
	 * 获取：户名
	 */
	public String getAtpyAcctName() {
		return atpyAcctName;
	}
	/**
	 * 设置：证件类型
	 */
	public void setAtpyAcctIdType(String atpyAcctIdType) {
		this.atpyAcctIdType = atpyAcctIdType;
	}
	/**
	 * 获取：证件类型
	 */
	public String getAtpyAcctIdType() {
		return atpyAcctIdType;
	}
	/**
	 * 设置：证件号码
	 */
	public void setAtpyAcctIdNo(String atpyAcctIdNo) {
		this.atpyAcctIdNo = atpyAcctIdNo;
	}
	/**
	 * 获取：证件号码
	 */
	public String getAtpyAcctIdNo() {
		return atpyAcctIdNo;
	}
	/**
	 * 设置：发证国家
	 */
	public void setAtpyAcctIssCtry(String atpyAcctIssCtry) {
		this.atpyAcctIssCtry = atpyAcctIssCtry;
	}
	/**
	 * 获取：发证国家
	 */
	public String getAtpyAcctIssCtry() {
		return atpyAcctIssCtry;
	}
	/**
	 * 设置：账号科目代码
	 */
	public void setAtpyAcctLdgrCde(String atpyAcctLdgrCde) {
		this.atpyAcctLdgrCde = atpyAcctLdgrCde;
	}
	/**
	 * 获取：账号科目代码
	 */
	public String getAtpyAcctLdgrCde() {
		return atpyAcctLdgrCde;
	}
	/**
	 * 设置：扣款币种
	 */
	public void setAtpyCcyCde(String atpyCcyCde) {
		this.atpyCcyCde = atpyCcyCde;
	}
	/**
	 * 获取：扣款币种
	 */
	public String getAtpyCcyCde() {
		return atpyCcyCde;
	}
	/**
	 * 设置：扣款类型
	 */
	public void setAtpyTyp(String atpyTyp) {
		this.atpyTyp = atpyTyp;
	}
	/**
	 * 获取：扣款类型
	 */
	public String getAtpyTyp() {
		return atpyTyp;
	}
	/**
	 * 设置：本金
	 */
	public void setAtpyPrcpAmt(BigDecimal atpyPrcpAmt) {
		this.atpyPrcpAmt = atpyPrcpAmt;
	}
	/**
	 * 获取：本金
	 */
	public BigDecimal getAtpyPrcpAmt() {
		return atpyPrcpAmt;
	}
	/**
	 * 设置：正常利息
	 */
	public void setAtpyIntAmt(BigDecimal atpyIntAmt) {
		this.atpyIntAmt = atpyIntAmt;
	}
	/**
	 * 获取：正常利息
	 */
	public BigDecimal getAtpyIntAmt() {
		return atpyIntAmt;
	}
	/**
	 * 设置：逾期利息
	 */
	public void setAtpyOdInt(BigDecimal atpyOdInt) {
		this.atpyOdInt = atpyOdInt;
	}
	/**
	 * 获取：逾期利息
	 */
	public BigDecimal getAtpyOdInt() {
		return atpyOdInt;
	}
	/**
	 * 设置：复利
	 */
	public void setAtpyCompInt(BigDecimal atpyCompInt) {
		this.atpyCompInt = atpyCompInt;
	}
	/**
	 * 获取：复利
	 */
	public BigDecimal getAtpyCompInt() {
		return atpyCompInt;
	}
	/**
	 * 设置：创建日期
	 */
	public void setAtpyCreateDt(String atpyCreateDt) {
		this.atpyCreateDt = atpyCreateDt;
	}
	/**
	 * 获取：创建日期
	 */
	public String getAtpyCreateDt() {
		return atpyCreateDt;
	}
	/**
	 * 设置：批扣状态
	 */
	public void setAtpySts(String atpySts) {
		this.atpySts = atpySts;
	}
	/**
	 * 获取：批扣状态
	 */
	public String getAtpySts() {
		return atpySts;
	}
	/**
	 * 设置：存款会计科目
	 */
	public void setAtpyLdgrCde(String atpyLdgrCde) {
		this.atpyLdgrCde = atpyLdgrCde;
	}
	/**
	 * 获取：存款会计科目
	 */
	public String getAtpyLdgrCde() {
		return atpyLdgrCde;
	}
	/**
	 * 设置：应扣金额
	 */
	public void setAtpyPaymAmt(BigDecimal atpyPaymAmt) {
		this.atpyPaymAmt = atpyPaymAmt;
	}
	/**
	 * 获取：应扣金额
	 */
	public BigDecimal getAtpyPaymAmt() {
		return atpyPaymAmt;
	}
	/**
	 * 设置：生成文件日期
	 */
	public void setAtpySpoolDt(String atpySpoolDt) {
		this.atpySpoolDt = atpySpoolDt;
	}
	/**
	 * 获取：生成文件日期
	 */
	public String getAtpySpoolDt() {
		return atpySpoolDt;
	}
	/**
	 * 设置：费用金额
	 */
	public void setAtpyFeeAmt(BigDecimal atpyFeeAmt) {
		this.atpyFeeAmt = atpyFeeAmt;
	}
	/**
	 * 获取：费用金额
	 */
	public BigDecimal getAtpyFeeAmt() {
		return atpyFeeAmt;
	}
	/**
	 * 设置：实还金额
	 */
	public void setAtpyTxAmt(BigDecimal atpyTxAmt) {
		this.atpyTxAmt = atpyTxAmt;
	}
	/**
	 * 获取：实还金额
	 */
	public BigDecimal getAtpyTxAmt() {
		return atpyTxAmt;
	}
	/**
	 * 设置：第几期
	 */
	public void setAtpyInstmNo(BigDecimal atpyInstmNo) {
		this.atpyInstmNo = atpyInstmNo;
	}
	/**
	 * 获取：第几期
	 */
	public BigDecimal getAtpyInstmNo() {
		return atpyInstmNo;
	}
	/**
	 * 设置：失败原因
	 */
	public void setAtpyErrDesc(String atpyErrDesc) {
		this.atpyErrDesc = atpyErrDesc;
	}
	/**
	 * 获取：失败原因
	 */
	public String getAtpyErrDesc() {
		return atpyErrDesc;
	}
	/**
	 * 设置：扣款返回时间
	 */
	public void setAtpyRtnDt(String atpyRtnDt) {
		this.atpyRtnDt = atpyRtnDt;
	}
	/**
	 * 获取：扣款返回时间
	 */
	public String getAtpyRtnDt() {
		return atpyRtnDt;
	}
	/**
	 * 设置：费用代码
	 */
	public void setAtpyFeeCde(String atpyFeeCde) {
		this.atpyFeeCde = atpyFeeCde;
	}
	/**
	 * 获取：费用代码
	 */
	public String getAtpyFeeCde() {
		return atpyFeeCde;
	}
	/**
	 * 设置：会计分录交易号
	 */
	public void setAtpyTxNo(Integer atpyTxNo) {
		this.atpyTxNo = atpyTxNo;
	}
	/**
	 * 获取：会计分录交易号
	 */
	public Integer getAtpyTxNo() {
		return atpyTxNo;
	}
	/**
	 * 设置：批量冲正流水号
	 */
	public void setAtpyBatRevseNo(String atpyBatRevseNo) {
		this.atpyBatRevseNo = atpyBatRevseNo;
	}
	/**
	 * 获取：批量冲正流水号
	 */
	public String getAtpyBatRevseNo() {
		return atpyBatRevseNo;
	}
	/**
	 * 设置：摘要代码
	 */
	public void setAtpySummNo(String atpySummNo) {
		this.atpySummNo = atpySummNo;
	}
	/**
	 * 获取：摘要代码
	 */
	public String getAtpySummNo() {
		return atpySummNo;
	}
	/**
	 * 设置：冻结流水号
	 */
	public void setAtpyHoldTxNo(String atpyHoldTxNo) {
		this.atpyHoldTxNo = atpyHoldTxNo;
	}
	/**
	 * 获取：冻结流水号
	 */
	public String getAtpyHoldTxNo() {
		return atpyHoldTxNo;
	}
	/**
	 * 设置：冻结业务编号
	 */
	public void setAtpyHoldBussTyp(String atpyHoldBussTyp) {
		this.atpyHoldBussTyp = atpyHoldBussTyp;
	}
	/**
	 * 获取：冻结业务编号
	 */
	public String getAtpyHoldBussTyp() {
		return atpyHoldBussTyp;
	}
	/**
	 * 设置：处理分页数据标志
	 */
	public void setPrcsPageDtInd(String prcsPageDtInd) {
		this.prcsPageDtInd = prcsPageDtInd;
	}
	/**
	 * 获取：处理分页数据标志
	 */
	public String getPrcsPageDtInd() {
		return prcsPageDtInd;
	}
	/**
	 * 设置：业务类型
	 */
	public void setBussTyp(String bussTyp) {
		this.bussTyp = bussTyp;
	}
	/**
	 * 获取：业务类型
	 */
	public String getBussTyp() {
		return bussTyp;
	}
	/**
	 * 设置：交易流水
	 */
	public void setTxLogSeq(Long txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水
	 */
	public Long getTxLogSeq() {
		return txLogSeq;
	}
	/**
	 * 设置：银行名称
	 */
	public void setAcctBankNm(String acctBankNm) {
		this.acctBankNm = acctBankNm;
	}
	/**
	 * 获取：银行名称
	 */
	public String getAcctBankNm() {
		return acctBankNm;
	}
	/**
	 * 设置：本行标志
	 */
	public void setAcctSelfBankInd(String acctSelfBankInd) {
		this.acctSelfBankInd = acctSelfBankInd;
	}
	/**
	 * 获取：本行标志
	 */
	public String getAcctSelfBankInd() {
		return acctSelfBankInd;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setAcctLdgrSeqNo(String acctLdgrSeqNo) {
		this.acctLdgrSeqNo = acctLdgrSeqNo;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getAcctLdgrSeqNo() {
		return acctLdgrSeqNo;
	}
	/**
	 * 设置：是否其他银行：CA：长安新生,WeBank：微众银行, ZHXT:中航信托
	 */
	public void setZhyCde(String zhyCde) {
		this.zhyCde = zhyCde;
	}
	/**
	 * 获取：是否其他银行：CA：长安新生,WeBank：微众银行, ZHXT:中航信托
	 */
	public String getZhyCde() {
		return zhyCde;
	}
	/**
	 * 设置：发起扣款方：Y：日终批量，N：日间批量，Z：中原批量
	 */
	public void setNight(String night) {
		this.night = night;
	}
	/**
	 * 获取：发起扣款方：Y：日终批量，N：日间批量，Z：中原批量
	 */
	public String getNight() {
		return night;
	}
	/**
	 * 设置：逾期天数
	 */
	public void setDebtOverDay(Integer debtOverDay) {
		this.debtOverDay = debtOverDay;
	}
	/**
	 * 获取：逾期天数
	 */
	public Integer getDebtOverDay() {
		return debtOverDay;
	}
	/**
	 * 设置：文件系号
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	/**
	 * 获取：文件系号
	 */
	public String getFileSeq() {
		return fileSeq;
	}
	/**
	 * 设置：扣款渠道
	 */
	public void setPchCde(String pchCde) {
		this.pchCde = pchCde;
	}
	/**
	 * 获取：扣款渠道
	 */
	public String getPchCde() {
		return pchCde;
	}
}
