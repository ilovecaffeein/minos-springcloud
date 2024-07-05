package com.caxs.minos.domain.trans;

/**
 * PayRstTrans entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PayRstTrans implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private String loanNo;			//借据号
	private String appAmt;			//申请金额
	private String actAmt;		//实际金额
	private String acctNo;			//账号
	private String errCde;		//错误码
	private String errMsg;		//错误信息
	private String sucInd;			//成功标志
	private String seqNo;		//序列号
	private Integer subSeqNo;		//子序列号
	private Long batTxSeq;		//批量流水号

	// Constructors

	/** default constructor */
	public PayRstTrans() {
	}

	/** minimal constructor */
	public PayRstTrans(String loanNo, String appAmt,
					   String actAmt, String acctNo, String errCde, String sucInd) {
		this.loanNo = loanNo;
		this.appAmt = appAmt;
		this.actAmt = actAmt;
		this.acctNo = acctNo;
		this.errCde = errCde;
		this.sucInd = sucInd;
	}

	/** full constructor */
	

	// Property accessors
	public PayRstTrans( String loanNo, String appAmt,
					   String actAmt, String acctNo, String errCde, String errMsg,
					   String sucInd) {
		this.loanNo = loanNo;
		this.appAmt = appAmt;
		this.actAmt = actAmt;
		this.acctNo = acctNo;
		this.errCde = errCde;
		this.errMsg = errMsg;
		this.sucInd = sucInd;
	}
	/**
	 * 序列号
	 * @return
	 */
	public String getSeqNo() {
		return seqNo;
	}
	//序列号
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 子序列号
	 * @return
	 */
	public Integer getSubSeqNo() {
		return subSeqNo;
	}
	/**
	 * 子序列号
	 * @param subSeqNo
	 */
	public void setSubSeqNo(Integer subSeqNo) {
		this.subSeqNo = subSeqNo;
	}
	//批量流水号
	public Long getBatTxSeq() {
		return batTxSeq;
	}
	//批量流水号
	public void setBatTxSeq(Long batTxSeq) {
		this.batTxSeq = batTxSeq;
	}

	/**
	 * 获取借据号
	 * @return
	 */
	public String getLoanNo() {
		return this.loanNo;
	}
	/**
	 * 设置借据号
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	/**
	 * 获取申请金额
	 * @return
	 */
	public String getAppAmt() {
		return this.appAmt;
	}
	/**
	 * 设置申请金额
	 * @param appAmt
	 */
	public void setAppAmt(String appAmt) {
		this.appAmt = appAmt;
	}
	/**
	 * 获取实际金额
	 * @return
	 */
	public String getActAmt() {
		return this.actAmt;
	}
	/**
	 * 设置实际金额
	 * @param actAmt
	 */
	public void setActAmt(String actAmt) {
		this.actAmt = actAmt;
	}
	/**
	 * 获取账号
	 * @return
	 */
	public String getAcctNo() {
		return this.acctNo;
	}
	/**
	 * 设置账号
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取错误码
	 * @return
	 */
	public String getErrCde() {
		return this.errCde;
	}
	/**
	 * 设置错误码
	 * @param errCde
	 */
	public void setErrCde(String errCde) {
		this.errCde = errCde;
	}
	/**
	 * 获取错误信息
	 * @return
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	/**
	 * 设置错误信息
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * 获取成功标志
	 * @return
	 */
	public String getSucInd() {
		return this.sucInd;
	}
	/**
	 * 设置成功标志
	 * @param sucInd
	 */
	public void setSucInd(String sucInd) {
		this.sucInd = sucInd;
	}
}