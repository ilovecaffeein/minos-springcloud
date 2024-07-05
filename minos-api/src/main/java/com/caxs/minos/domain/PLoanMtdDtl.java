package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 用于定义实际的还款方式，包括本息偿还方式、利率等
MTD_DTL_RPYM_OPT:用于选择是只还利息，还是本息＋利息
MTD_DTL_TYP:用于选择使用等额本金、还是使用等额本息方法
MTD_DTL_MODE:用于选择是使用固定利率，还是使用浮动利率方式
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class PLoanMtdDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 */
	private Integer mtdDtlSeq;
	/**
	 * 还款方式代码
	 */
	private String mtdCde;
	/**
	 * 执行期数
	 */
	private Integer mtdInstl;
	/**
	 * 本金比例
	 */
	private BigDecimal mtdPrcpRatio;
	/**
	 * 计算期限
	 */
	private Integer mtdCalcTnr;
	/**
	 * 还款方式
	 */
	private String mtdRpymOpt;
	/**
	 * 还款类型
	 */
	private String mtdSetlTyp;
	/**
	 * 利息计算基础
	 */
	private String mtdIntBase;
	/**
	 * 是否允许修改
	 */
	private String mtdModiInd;
	/**
	 * 利率类型
	 */
	private String mtdRateTyp;
	/**
	 * 利率计算基础
	 */
	private String mtdRatBase;
	/**
	 * 最新变更时间
	 */
	private String lastChgDt;
	/**
	 * 最新变更用户
	 */
	private String lastChgUsr;

	/**
	 * 设置：序号
	 */
	public void setMtdDtlSeq(Integer mtdDtlSeq) {
		this.mtdDtlSeq = mtdDtlSeq;
	}
	/**
	 * 获取：序号
	 */
	public Integer getMtdDtlSeq() {
		return mtdDtlSeq;
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
	 * 设置：执行期数
	 */
	public void setMtdInstl(Integer mtdInstl) {
		this.mtdInstl = mtdInstl;
	}
	/**
	 * 获取：执行期数
	 */
	public Integer getMtdInstl() {
		return mtdInstl;
	}
	/**
	 * 设置：本金比例
	 */
	public void setMtdPrcpRatio(BigDecimal mtdPrcpRatio) {
		this.mtdPrcpRatio = mtdPrcpRatio;
	}
	/**
	 * 获取：本金比例
	 */
	public BigDecimal getMtdPrcpRatio() {
		return mtdPrcpRatio;
	}
	/**
	 * 设置：计算期限
	 */
	public void setMtdCalcTnr(Integer mtdCalcTnr) {
		this.mtdCalcTnr = mtdCalcTnr;
	}
	/**
	 * 获取：计算期限
	 */
	public Integer getMtdCalcTnr() {
		return mtdCalcTnr;
	}
	/**
	 * 设置：还款方式
	 */
	public void setMtdRpymOpt(String mtdRpymOpt) {
		this.mtdRpymOpt = mtdRpymOpt;
	}
	/**
	 * 获取：还款方式
	 */
	public String getMtdRpymOpt() {
		return mtdRpymOpt;
	}
	/**
	 * 设置：还款类型
	 */
	public void setMtdSetlTyp(String mtdSetlTyp) {
		this.mtdSetlTyp = mtdSetlTyp;
	}
	/**
	 * 获取：还款类型
	 */
	public String getMtdSetlTyp() {
		return mtdSetlTyp;
	}
	/**
	 * 设置：利息计算基础
	 */
	public void setMtdIntBase(String mtdIntBase) {
		this.mtdIntBase = mtdIntBase;
	}
	/**
	 * 获取：利息计算基础
	 */
	public String getMtdIntBase() {
		return mtdIntBase;
	}
	/**
	 * 设置：是否允许修改
	 */
	public void setMtdModiInd(String mtdModiInd) {
		this.mtdModiInd = mtdModiInd;
	}
	/**
	 * 获取：是否允许修改
	 */
	public String getMtdModiInd() {
		return mtdModiInd;
	}
	/**
	 * 设置：利率类型
	 */
	public void setMtdRateTyp(String mtdRateTyp) {
		this.mtdRateTyp = mtdRateTyp;
	}
	/**
	 * 获取：利率类型
	 */
	public String getMtdRateTyp() {
		return mtdRateTyp;
	}
	/**
	 * 设置：利率计算基础
	 */
	public void setMtdRatBase(String mtdRatBase) {
		this.mtdRatBase = mtdRatBase;
	}
	/**
	 * 获取：利率计算基础
	 */
	public String getMtdRatBase() {
		return mtdRatBase;
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

	public PLoanMtdDtl(){
	}
	public PLoanMtdDtl(String mtdCde){
         this.mtdCde = mtdCde;
	}
}
