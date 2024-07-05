package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * LM_DUEDAY_FEE(扣款日费用记录表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmDuedayFee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 授权号
	 */
	private String genGlNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 创建日期
	 */
	private String createDt;
	/**
	 * 应收费用金额
	 */
	private BigDecimal feeAmt;
	/**
	 * 实收费用金额
	 */
	private BigDecimal feeTxAmt;
	/**
	 * 费用扣款状态：1：未处理，9：处理中，10：处理完成
	 */
	private Integer feeSts;
	/**
	 * 费用代码
	 */
	private String feeCde;
	/**
	 * 费用类型
	 */
	private String feeTyp;
	/**
	 * 费用描述
	 */
	private String feeDesc;
	/**
	 * 币种
	 */
	private String ccyCde;
	/**
	 * 当前扣款日
	 */
	private String curDueDt;
	/**
	 * 下次还扣款日
	 */
	private String nextDueDt;
	/**
	 * 结清款日
	 */
	private String setlDueDt;
	/**
	 * 是否结清：Y：是，N：否
	 */
	private String setlInd;
	/**
	 * 处理分页数据标志
	 */
	private String prcsPageDtInd;
	/**
	 * 线程号
	 */
	private Integer thdCnt;
	/**
	 * 文件批次编号
	 */
	private Integer fileCnt;
	/**
	 * 信托计划
	 */
	private String trstplnNo;
	/**
	 * 信托计划名称
	 */
	private String trstplnName;
	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 设置：授权号
	 */
	public void setGenGlNo(String genGlNo) {
		this.genGlNo = genGlNo;
	}
	/**
	 * 获取：授权号
	 */
	public String getGenGlNo() {
		return genGlNo;
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
	 * 设置：创建日期
	 */
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	/**
	 * 获取：创建日期
	 */
	public String getCreateDt() {
		return createDt;
	}
	/**
	 * 设置：应收费用金额
	 */
	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}
	/**
	 * 获取：应收费用金额
	 */
	public BigDecimal getFeeAmt() {
		return feeAmt;
	}
	/**
	 * 设置：实收费用金额
	 */
	public void setFeeTxAmt(BigDecimal feeTxAmt) {
		this.feeTxAmt = feeTxAmt;
	}
	/**
	 * 获取：实收费用金额
	 */
	public BigDecimal getFeeTxAmt() {
		return feeTxAmt;
	}
	/**
	 * 设置：费用扣款状态：1：未处理，9：处理中，10：处理完成
	 */
	public void setFeeSts(Integer feeSts) {
		this.feeSts = feeSts;
	}
	/**
	 * 获取：费用扣款状态：1：未处理，9：处理中，10：处理完成
	 */
	public Integer getFeeSts() {
		return feeSts;
	}
	/**
	 * 设置：费用代码
	 */
	public void setFeeCde(String feeCde) {
		this.feeCde = feeCde;
	}
	/**
	 * 获取：费用代码
	 */
	public String getFeeCde() {
		return feeCde;
	}
	/**
	 * 设置：费用类型
	 */
	public void setFeeTyp(String feeTyp) {
		this.feeTyp = feeTyp;
	}
	/**
	 * 获取：费用类型
	 */
	public String getFeeTyp() {
		return feeTyp;
	}
	/**
	 * 设置：费用描述
	 */
	public void setFeeDesc(String feeDesc) {
		this.feeDesc = feeDesc;
	}
	/**
	 * 获取：费用描述
	 */
	public String getFeeDesc() {
		return feeDesc;
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
	 * 设置：当前扣款日
	 */
	public void setCurDueDt(String curDueDt) {
		this.curDueDt = curDueDt;
	}
	/**
	 * 获取：当前扣款日
	 */
	public String getCurDueDt() {
		return curDueDt;
	}
	/**
	 * 设置：下次还扣款日
	 */
	public void setNextDueDt(String nextDueDt) {
		this.nextDueDt = nextDueDt;
	}
	/**
	 * 获取：下次还扣款日
	 */
	public String getNextDueDt() {
		return nextDueDt;
	}
	/**
	 * 设置：结清款日
	 */
	public void setSetlDueDt(String setlDueDt) {
		this.setlDueDt = setlDueDt;
	}
	/**
	 * 获取：结清款日
	 */
	public String getSetlDueDt() {
		return setlDueDt;
	}
	/**
	 * 设置：是否结清：Y：是，N：否
	 */
	public void setSetlInd(String setlInd) {
		this.setlInd = setlInd;
	}
	/**
	 * 获取：是否结清：Y：是，N：否
	 */
	public String getSetlInd() {
		return setlInd;
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
	 * 设置：线程号
	 */
	public void setThdCnt(Integer thdCnt) {
		this.thdCnt = thdCnt;
	}
	/**
	 * 获取：线程号
	 */
	public Integer getThdCnt() {
		return thdCnt;
	}
	/**
	 * 设置：文件批次编号
	 */
	public void setFileCnt(Integer fileCnt) {
		this.fileCnt = fileCnt;
	}
	/**
	 * 获取：文件批次编号
	 */
	public Integer getFileCnt() {
		return fileCnt;
	}
	/**
	 * 设置：信托计划
	 */
	public void setTrstplnNo(String trstplnNo) {
		this.trstplnNo = trstplnNo;
	}
	/**
	 * 获取：信托计划
	 */
	public String getTrstplnNo() {
		return trstplnNo;
	}
	/**
	 * 设置：信托计划名称
	 */
	public void setTrstplnName(String trstplnName) {
		this.trstplnName = trstplnName;
	}
	/**
	 * 获取：信托计划名称
	 */
	public String getTrstplnName() {
		return trstplnName;
	}
	/**
	 * 设置：备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注
	 */
	public String getMemo() {
		return memo;
	}
}
