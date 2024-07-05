package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 还款方式定义主表
LOAN_MTD_TYP: 包括是否为气球贷、是否为利随本清、是否为弹性还款、本息不同间隔、本金递增递减等。
LOAN_MTD_BY_RATIO:表示是否按阶段期数比例更新贷款申请的还款方式
MTD_PRCP_PCT 和MTD_PRCP_AMT 不能同时有值
MTD_PROP_UNIT:用于弹性还款法，表示从表中的本金比例是按照贷款金额，还是按照购买房产/车辆总金额
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class PLoanMtd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 还款方式代码
	 */
	private String mtdCde;
	/**
	 * 还款方式描述
	 */
	private String mtdDesc;
	/**
	 * 还款方式种类
	 */
	private String mtdTyp;
	/**
	 * 支持最小期限(月)
	 */
	private Integer mtdMinTnr;
	/**
	 * 支持最大期限(月)
	 */
	private Integer mtdMaxTnr;
	/**
	 * 递增递减基础
	 */
	private String mtdPrcpBase;
	/**
	 * 本金间隔
	 */
	private String mtdPropFreq;
	/**
	 * 本息不同间隔之本金间隔
	 */
	private String mtdPrcpFreq;
	/**
	 * 本金递增递减比例
	 */
	private BigDecimal mtdPropPct;
	/**
	 * 还款间隔
	 */
	private String mtdFreq;
	/**
	 * 按比例设定阶段期数
	 */
	private String mtdByRatio;
	/**
	 * 本金比例单位
	 */
	private String mtdPropUnit;
	/**
	 * 首付比例
	 */
	private BigDecimal mtdFstPct;
	/**
	 * 尾付比例
	 */
	private BigDecimal mtdEndPct;
	/**
	 * 参数使用状态
	 */
	private String mtdSts;
	/**
	 * 最新变更时间
	 */
	private String lastChgDt;
	/**
	 * 最新变更用户
	 */
	private String lastChgUsr;
	/**
	 * 是否期供类
	 */
	private String instInd;
	/**
	 * ${column.comments}
	 */
	private BigDecimal mtdPropAmt;

	public PLoanMtd (){

	}
	public PLoanMtd (String mtdCde){
		this.mtdCde = mtdCde;
	}

	public PLoanMtd (String  mtdCde,String mtdTyp ){
		this.mtdCde = mtdCde;
		this.mtdTyp = mtdTyp;
	}

	/**
	 * 设置：还款方式代码
	 */
	public void setMtdCde(String mtdCde) {
		this.mtdCde = mtdCde;
	}
	/**
	 * 获取：还款方式代码
	 */
	public String getMtdCde() {
		return mtdCde;
	}
	/**
	 * 设置：还款方式描述
	 */
	public void setMtdDesc(String mtdDesc) {
		this.mtdDesc = mtdDesc;
	}
	/**
	 * 获取：还款方式描述
	 */
	public String getMtdDesc() {
		return mtdDesc;
	}
	/**
	 * 设置：还款方式种类
	 */
	public void setMtdTyp(String mtdTyp) {
		this.mtdTyp = mtdTyp;
	}
	/**
	 * 获取：还款方式种类
	 */
	public String getMtdTyp() {
		return mtdTyp;
	}
	/**
	 * 设置：支持最小期限(月)
	 */
	public void setMtdMinTnr(Integer mtdMinTnr) {
		this.mtdMinTnr = mtdMinTnr;
	}
	/**
	 * 获取：支持最小期限(月)
	 */
	public Integer getMtdMinTnr() {
		return mtdMinTnr;
	}
	/**
	 * 设置：支持最大期限(月)
	 */
	public void setMtdMaxTnr(Integer mtdMaxTnr) {
		this.mtdMaxTnr = mtdMaxTnr;
	}
	/**
	 * 获取：支持最大期限(月)
	 */
	public Integer getMtdMaxTnr() {
		return mtdMaxTnr;
	}
	/**
	 * 设置：递增递减基础
	 */
	public void setMtdPrcpBase(String mtdPrcpBase) {
		this.mtdPrcpBase = mtdPrcpBase;
	}
	/**
	 * 获取：递增递减基础
	 */
	public String getMtdPrcpBase() {
		return mtdPrcpBase;
	}
	/**
	 * 设置：本金间隔
	 */
	public void setMtdPropFreq(String mtdPropFreq) {
		this.mtdPropFreq = mtdPropFreq;
	}
	/**
	 * 获取：本金间隔
	 */
	public String getMtdPropFreq() {
		return mtdPropFreq;
	}
	/**
	 * 设置：本息不同间隔之本金间隔
	 */
	public void setMtdPrcpFreq(String mtdPrcpFreq) {
		this.mtdPrcpFreq = mtdPrcpFreq;
	}
	/**
	 * 获取：本息不同间隔之本金间隔
	 */
	public String getMtdPrcpFreq() {
		return mtdPrcpFreq;
	}
	/**
	 * 设置：本金递增递减比例
	 */
	public void setMtdPropPct(BigDecimal mtdPropPct) {
		this.mtdPropPct = mtdPropPct;
	}
	/**
	 * 获取：本金递增递减比例
	 */
	public BigDecimal getMtdPropPct() {
		return mtdPropPct;
	}
	/**
	 * 设置：还款间隔
	 */
	public void setMtdFreq(String mtdFreq) {
		this.mtdFreq = mtdFreq;
	}
	/**
	 * 获取：还款间隔
	 */
	public String getMtdFreq() {
		return mtdFreq;
	}
	/**
	 * 设置：按比例设定阶段期数
	 */
	public void setMtdByRatio(String mtdByRatio) {
		this.mtdByRatio = mtdByRatio;
	}
	/**
	 * 获取：按比例设定阶段期数
	 */
	public String getMtdByRatio() {
		return mtdByRatio;
	}
	/**
	 * 设置：本金比例单位
	 */
	public void setMtdPropUnit(String mtdPropUnit) {
		this.mtdPropUnit = mtdPropUnit;
	}
	/**
	 * 获取：本金比例单位
	 */
	public String getMtdPropUnit() {
		return mtdPropUnit;
	}
	/**
	 * 设置：首付比例
	 */
	public void setMtdFstPct(BigDecimal mtdFstPct) {
		this.mtdFstPct = mtdFstPct;
	}
	/**
	 * 获取：首付比例
	 */
	public BigDecimal getMtdFstPct() {
		return mtdFstPct;
	}
	/**
	 * 设置：尾付比例
	 */
	public void setMtdEndPct(BigDecimal mtdEndPct) {
		this.mtdEndPct = mtdEndPct;
	}
	/**
	 * 获取：尾付比例
	 */
	public BigDecimal getMtdEndPct() {
		return mtdEndPct;
	}
	/**
	 * 设置：参数使用状态
	 */
	public void setMtdSts(String mtdSts) {
		this.mtdSts = mtdSts;
	}
	/**
	 * 获取：参数使用状态
	 */
	public String getMtdSts() {
		return mtdSts;
	}
	/**
	 * 设置：最新变更时间
	 */
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	/**
	 * 获取：最新变更时间
	 */
	public String getLastChgDt() {
		return lastChgDt;
	}
	/**
	 * 设置：最新变更用户
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}
	/**
	 * 获取：最新变更用户
	 */
	public String getLastChgUsr() {
		return lastChgUsr;
	}
	/**
	 * 设置：是否期供类
	 */
	public void setInstInd(String instInd) {
		this.instInd = instInd;
	}
	/**
	 * 获取：是否期供类
	 */
	public String getInstInd() {
		return instInd;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setMtdPropAmt(BigDecimal mtdPropAmt) {
		this.mtdPropAmt = mtdPropAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getMtdPropAmt() {
		return mtdPropAmt;
	}
}
