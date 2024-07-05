package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * TO_PAY_IR(扣款文件表流水)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class ToPayIr implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 流水号
	 */
	private Long txSeq;
	/**
	 * TO_PAY的流水号
	 */
	private Long buzSeqNo;
	/**
	 * 渠道
	 */
	private String payChn;
	/**
	 * 发送核心的流水号
	 */
	private String seqNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 发送系统日期
	 */
	private String toDate;
	/**
	 * 发送时间
	 */
	private String toTime;
	/**
	 * 交易码
	 */
	private String transCode;
	/**
	 * 业务日期
	 */
	private String buzDt;
	/**
	 * 交易金额
	 */
	private String txAmt;
	/**
	 * 证件类型编码
	 */
	private String acctIdTyp;
	/**
	 * 证件号码
	 */
	private String acctIdNo;
	/**
	 * 操作员
	 */
	private String opNm;
	/**
	 * 币种
	 */
	private String ccyCde;
	/**
	 * 支付类型
	 */
	private String paySty;
	/**
	 * 包处理状态
	 */
	private String pkgSts;
	/**
	 * 批量流水号
	 */
	private Integer batTxSeq;
	/**
	 * 分页标识
	 */
	private String prcsPageDtInd;
	/**
	 * 银行账户
	 */
	private String bankAcctNo;
	/**
	 * 银行名称
	 */
	private String bankAcctNm;
	/**
	 * 帐户名
	 */
	private String acctNm;
	/**
	 * 账号
	 */
	private String acctNo;
	/**
	 * 有效标志
	 */
	private String valid;
	/**
	 * 备注
	 */
	private String payMemo;
	/**
	 * 交易类型
	 */
	private String transTyp;
	/**
	 * 未乘100的扣款金额
	 */
	private BigDecimal rawTxAmt;
	/**
	 * 地区码
	 */
	private String districtCoding;
	/**
	 * 业务单位
	 */
	private String businessUnit;
	/**
	 * 业务种类
	 */
	private String businessClass;
	/**
	 * 核心交易码
	 */
	private String coreTransCode;
	/**
	 * 序号
	 */
	private String stdseqno;
	/**
	 * 被撤销的交易流水
	 */
	private String stdorefnum;
	/**
	 * 被撤销的交易流水的业务日期
	 */
	private String ibsolocdt;
	/**
	 * VER_ACC_IND
	 */
	private String verAccInd;
	/**
	 * 银行代码
	 */
	private String accBankCde;
	/**
	 * 银行机构名称
	 */
	private String accBchNam;
	/**
	 * 银行联行行号
	 */
	private String bankUnionCde;
	/**
	 * 操作员编号
	 */
	private String opId;
	/**
	 * 批量流水
	 */
	private String bachno;
	/**
	 * 交易流水
	 */
	private String lttssq;
	/**
	 * 传票序号
	 */
	private Integer vchrsq;
	/**
	 * 借贷方向
	 */
	private String amntcd;
	/**
	 * 发起交易金额
	 */
	private BigDecimal summam;
	/**
	 * 实际交易金额
	 */
	private String tranam;
	/**
	 * 错误代码
	 */
	private String errtcd;
	/**
	 * 错误描述
	 */
	private String errtxt;
	/**
	 * 子序号
	 */
	private Integer subTxSeq;
	/**
	 * 支付标志
	 */
	private String payInd;
	/**
	 * 发往核心的记账机构
	 */
	private String accBchCde;
	/**
	 * 线程编号
	 */
	private String bchCde;
	/**
	 * 短信处理标志
	 */
	private String paySucc;
	/**
	 * 短信次数
	 */
	private Integer payTol;
	/**
	 * 短信内容
	 */
	private String msgNotify;
	/**
	 * 线程编号
	 */
	private String thdCnt;
	/**
	 * 批扣序号
	 */
	private String atpySeqNo;
	/**
	 * 文件系号
	 */
	private Integer fileSeq;
	/**
	 * 扣款渠道
	 */
	private String pchCde;

	/**
	 * 设置：流水号
	 */
	public void setTxSeq(Long txSeq) {
		this.txSeq = txSeq;
	}
	/**
	 * 获取：流水号
	 */
	public Long getTxSeq() {
		return txSeq;
	}
	/**
	 * 设置：TO_PAY的流水号
	 */
	public void setBuzSeqNo(Long buzSeqNo) {
		this.buzSeqNo = buzSeqNo;
	}
	/**
	 * 获取：TO_PAY的流水号
	 */
	public Long getBuzSeqNo() {
		return buzSeqNo;
	}
	/**
	 * 设置：渠道
	 */
	public void setPayChn(String payChn) {
		this.payChn = payChn;
	}
	/**
	 * 获取：渠道
	 */
	public String getPayChn() {
		return payChn;
	}
	/**
	 * 设置：发送核心的流水号
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：发送核心的流水号
	 */
	public String getSeqNo() {
		return seqNo;
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
	 * 设置：发送系统日期
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * 获取：发送系统日期
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 * 设置：发送时间
	 */
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	/**
	 * 获取：发送时间
	 */
	public String getToTime() {
		return toTime;
	}
	/**
	 * 设置：交易码
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	/**
	 * 获取：交易码
	 */
	public String getTransCode() {
		return transCode;
	}
	/**
	 * 设置：业务日期
	 */
	public void setBuzDt(String buzDt) {
		this.buzDt = buzDt;
	}
	/**
	 * 获取：业务日期
	 */
	public String getBuzDt() {
		return buzDt;
	}
	/**
	 * 设置：交易金额
	 */
	public void setTxAmt(String txAmt) {
		this.txAmt = txAmt;
	}
	/**
	 * 获取：交易金额
	 */
	public String getTxAmt() {
		return txAmt;
	}
	/**
	 * 设置：证件类型编码
	 */
	public void setAcctIdTyp(String acctIdTyp) {
		this.acctIdTyp = acctIdTyp;
	}
	/**
	 * 获取：证件类型编码
	 */
	public String getAcctIdTyp() {
		return acctIdTyp;
	}
	/**
	 * 设置：证件号码
	 */
	public void setAcctIdNo(String acctIdNo) {
		this.acctIdNo = acctIdNo;
	}
	/**
	 * 获取：证件号码
	 */
	public String getAcctIdNo() {
		return acctIdNo;
	}
	/**
	 * 设置：操作员
	 */
	public void setOpNm(String opNm) {
		this.opNm = opNm;
	}
	/**
	 * 获取：操作员
	 */
	public String getOpNm() {
		return opNm;
	}
	/**
	 * 设置：币种
	 */
	public void setCcyCde(String ccyCde) {
		this.ccyCde = ccyCde;
	}
	/**
	 * 获取：币种
	 */
	public String getCcyCde() {
		return ccyCde;
	}
	/**
	 * 设置：支付类型
	 */
	public void setPaySty(String paySty) {
		this.paySty = paySty;
	}
	/**
	 * 获取：支付类型
	 */
	public String getPaySty() {
		return paySty;
	}
	/**
	 * 设置：包处理状态
	 */
	public void setPkgSts(String pkgSts) {
		this.pkgSts = pkgSts;
	}
	/**
	 * 获取：包处理状态
	 */
	public String getPkgSts() {
		return pkgSts;
	}
	/**
	 * 设置：批量流水号
	 */
	public void setBatTxSeq(Integer batTxSeq) {
		this.batTxSeq = batTxSeq;
	}
	/**
	 * 获取：批量流水号
	 */
	public Integer getBatTxSeq() {
		return batTxSeq;
	}
	/**
	 * 设置：分页标识
	 */
	public void setPrcsPageDtInd(String prcsPageDtInd) {
		this.prcsPageDtInd = prcsPageDtInd;
	}
	/**
	 * 获取：分页标识
	 */
	public String getPrcsPageDtInd() {
		return prcsPageDtInd;
	}
	/**
	 * 设置：银行账户
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	/**
	 * 获取：银行账户
	 */
	public String getBankAcctNo() {
		return bankAcctNo;
	}
	/**
	 * 设置：银行名称
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
	}
	/**
	 * 获取：银行名称
	 */
	public String getBankAcctNm() {
		return bankAcctNm;
	}
	/**
	 * 设置：帐户名
	 */
	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
	}
	/**
	 * 获取：帐户名
	 */
	public String getAcctNm() {
		return acctNm;
	}
	/**
	 * 设置：账号
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取：账号
	 */
	public String getAcctNo() {
		return acctNo;
	}
	/**
	 * 设置：有效标志
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}
	/**
	 * 获取：有效标志
	 */
	public String getValid() {
		return valid;
	}
	/**
	 * 设置：备注
	 */
	public void setPayMemo(String payMemo) {
		this.payMemo = payMemo;
	}
	/**
	 * 获取：备注
	 */
	public String getPayMemo() {
		return payMemo;
	}
	/**
	 * 设置：交易类型
	 */
	public void setTransTyp(String transTyp) {
		this.transTyp = transTyp;
	}
	/**
	 * 获取：交易类型
	 */
	public String getTransTyp() {
		return transTyp;
	}
	/**
	 * 设置：未乘100的扣款金额
	 */
	public void setRawTxAmt(BigDecimal rawTxAmt) {
		this.rawTxAmt = rawTxAmt;
	}
	/**
	 * 获取：未乘100的扣款金额
	 */
	public BigDecimal getRawTxAmt() {
		return rawTxAmt;
	}
	/**
	 * 设置：地区码
	 */
	public void setDistrictCoding(String districtCoding) {
		this.districtCoding = districtCoding;
	}
	/**
	 * 获取：地区码
	 */
	public String getDistrictCoding() {
		return districtCoding;
	}
	/**
	 * 设置：业务单位
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	/**
	 * 获取：业务单位
	 */
	public String getBusinessUnit() {
		return businessUnit;
	}
	/**
	 * 设置：业务种类
	 */
	public void setBusinessClass(String businessClass) {
		this.businessClass = businessClass;
	}
	/**
	 * 获取：业务种类
	 */
	public String getBusinessClass() {
		return businessClass;
	}
	/**
	 * 设置：核心交易码
	 */
	public void setCoreTransCode(String coreTransCode) {
		this.coreTransCode = coreTransCode;
	}
	/**
	 * 获取：核心交易码
	 */
	public String getCoreTransCode() {
		return coreTransCode;
	}
	/**
	 * 设置：序号
	 */
	public void setStdseqno(String stdseqno) {
		this.stdseqno = stdseqno;
	}
	/**
	 * 获取：序号
	 */
	public String getStdseqno() {
		return stdseqno;
	}
	/**
	 * 设置：被撤销的交易流水
	 */
	public void setStdorefnum(String stdorefnum) {
		this.stdorefnum = stdorefnum;
	}
	/**
	 * 获取：被撤销的交易流水
	 */
	public String getStdorefnum() {
		return stdorefnum;
	}
	/**
	 * 设置：被撤销的交易流水的业务日期
	 */
	public void setIbsolocdt(String ibsolocdt) {
		this.ibsolocdt = ibsolocdt;
	}
	/**
	 * 获取：被撤销的交易流水的业务日期
	 */
	public String getIbsolocdt() {
		return ibsolocdt;
	}
	/**
	 * 设置：VER_ACC_IND
	 */
	public void setVerAccInd(String verAccInd) {
		this.verAccInd = verAccInd;
	}
	/**
	 * 获取：VER_ACC_IND
	 */
	public String getVerAccInd() {
		return verAccInd;
	}
	/**
	 * 设置：银行代码
	 */
	public void setAccBankCde(String accBankCde) {
		this.accBankCde = accBankCde;
	}
	/**
	 * 获取：银行代码
	 */
	public String getAccBankCde() {
		return accBankCde;
	}
	/**
	 * 设置：银行机构名称
	 */
	public void setAccBchNam(String accBchNam) {
		this.accBchNam = accBchNam;
	}
	/**
	 * 获取：银行机构名称
	 */
	public String getAccBchNam() {
		return accBchNam;
	}
	/**
	 * 设置：银行联行行号
	 */
	public void setBankUnionCde(String bankUnionCde) {
		this.bankUnionCde = bankUnionCde;
	}
	/**
	 * 获取：银行联行行号
	 */
	public String getBankUnionCde() {
		return bankUnionCde;
	}
	/**
	 * 设置：操作员编号
	 */
	public void setOpId(String opId) {
		this.opId = opId;
	}
	/**
	 * 获取：操作员编号
	 */
	public String getOpId() {
		return opId;
	}
	/**
	 * 设置：批量流水
	 */
	public void setBachno(String bachno) {
		this.bachno = bachno;
	}
	/**
	 * 获取：批量流水
	 */
	public String getBachno() {
		return bachno;
	}
	/**
	 * 设置：交易流水
	 */
	public void setLttssq(String lttssq) {
		this.lttssq = lttssq;
	}
	/**
	 * 获取：交易流水
	 */
	public String getLttssq() {
		return lttssq;
	}
	/**
	 * 设置：传票序号
	 */
	public void setVchrsq(Integer vchrsq) {
		this.vchrsq = vchrsq;
	}
	/**
	 * 获取：传票序号
	 */
	public Integer getVchrsq() {
		return vchrsq;
	}
	/**
	 * 设置：借贷方向
	 */
	public void setAmntcd(String amntcd) {
		this.amntcd = amntcd;
	}
	/**
	 * 获取：借贷方向
	 */
	public String getAmntcd() {
		return amntcd;
	}
	/**
	 * 设置：发起交易金额
	 */
	public void setSummam(BigDecimal summam) {
		this.summam = summam;
	}
	/**
	 * 获取：发起交易金额
	 */
	public BigDecimal getSummam() {
		return summam;
	}
	/**
	 * 设置：实际交易金额
	 */
	public void setTranam(String tranam) {
		this.tranam = tranam;
	}
	/**
	 * 获取：实际交易金额
	 */
	public String getTranam() {
		return tranam;
	}
	/**
	 * 设置：错误代码
	 */
	public void setErrtcd(String errtcd) {
		this.errtcd = errtcd;
	}
	/**
	 * 获取：错误代码
	 */
	public String getErrtcd() {
		return errtcd;
	}
	/**
	 * 设置：错误描述
	 */
	public void setErrtxt(String errtxt) {
		this.errtxt = errtxt;
	}
	/**
	 * 获取：错误描述
	 */
	public String getErrtxt() {
		return errtxt;
	}
	/**
	 * 设置：子序号
	 */
	public void setSubTxSeq(Integer subTxSeq) {
		this.subTxSeq = subTxSeq;
	}
	/**
	 * 获取：子序号
	 */
	public Integer getSubTxSeq() {
		return subTxSeq;
	}
	/**
	 * 设置：支付标志
	 */
	public void setPayInd(String payInd) {
		this.payInd = payInd;
	}
	/**
	 * 获取：支付标志
	 */
	public String getPayInd() {
		return payInd;
	}
	/**
	 * 设置：发往核心的记账机构
	 */
	public void setAccBchCde(String accBchCde) {
		this.accBchCde = accBchCde;
	}
	/**
	 * 获取：发往核心的记账机构
	 */
	public String getAccBchCde() {
		return accBchCde;
	}
	/**
	 * 设置：线程编号
	 */
	public void setBchCde(String bchCde) {
		this.bchCde = bchCde;
	}
	/**
	 * 获取：线程编号
	 */
	public String getBchCde() {
		return bchCde;
	}
	/**
	 * 设置：短信处理标志
	 */
	public void setPaySucc(String paySucc) {
		this.paySucc = paySucc;
	}
	/**
	 * 获取：短信处理标志
	 */
	public String getPaySucc() {
		return paySucc;
	}
	/**
	 * 设置：短信次数
	 */
	public void setPayTol(Integer payTol) {
		this.payTol = payTol;
	}
	/**
	 * 获取：短信次数
	 */
	public Integer getPayTol() {
		return payTol;
	}
	/**
	 * 设置：短信内容
	 */
	public void setMsgNotify(String msgNotify) {
		this.msgNotify = msgNotify;
	}
	/**
	 * 获取：短信内容
	 */
	public String getMsgNotify() {
		return msgNotify;
	}
	/**
	 * 设置：机构编号
	 */
	public void setThdCnt(String thdCnt) {
		this.thdCnt = thdCnt;
	}
	/**
	 * 获取：机构编号
	 */
	public String getThdCnt() {
		return thdCnt;
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
	 * 设置：文件系号
	 */
	public void setFileSeq(Integer fileSeq) {
		this.fileSeq = fileSeq;
	}
	/**
	 * 获取：文件系号
	 */
	public Integer getFileSeq() {
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

	private String bindMobile; //预留手机号

	public String getBindMobile() {
		return bindMobile;
	}

	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}
}
