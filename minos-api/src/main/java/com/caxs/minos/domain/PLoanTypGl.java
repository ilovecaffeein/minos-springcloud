package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class PLoanTypGl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 银行代码
	 */
	private String bankCde;
	/**
	 * 核算设置代码
	 */
	private String typGl;
	/**
	 * 核算设置描述
	 */
	private String glAccDesc;
	/**
	 * 利息计算基础
	 */
	private String glRatBase;
	/**
	 * 贷款还款日选项
	 */
	private String glDueDayOpt;
	/**
	 * 放款扣息选项
	 */
	private String glDrwOptInd;
	/**
	 * 扣款处理方式
	 */
	private String glPaymOpt;
	/**
	 * 利率调整选项
	 */
	private String glRatAdjOpt;
	/**
	 * 利率调整变动类型
	 */
	private String glRatChgCat;
	/**
	 * 贷款到期日假期调整
	 */
	private String glHolidayAdj;
	/**
	 * 是否采用固定罚息利率
	 */
	private String glFixedOdInd;
	/**
	 * 罚息利率
	 */
	private BigDecimal glOdIntRate;
	/**
	 * 计算复利部分
	 */
	private String glOdCommPart;
	/**
	 * 罚息利率种类
	 */
	private String glOdCat;
	/**
	 * 罚息利率代码
	 */
	private String glOdRateTyp;
	/**
	 * 是否计算罚息复利：Y：计算罚息复利,N：不计算罚息复利
	 */
	private String glOdCpdInd;
	/**
	 * 最小罚息金额
	 */
	private BigDecimal glOdMinAmt;
	/**
	 * 罚息尾数保留方式
	 */
	private String glOdAppxTyp;
	/**
	 * 利息尾数保留方式
	 */
	private String glIntAppxTyp;
	/**
	 * 部分提前还款计息基础
	 */
	private String glPpRatBase;
	/**
	 * 部分提前还款利息计算选项
	 */
	private String glPpRatOpt;
	/**
	 * 到期日调整选项
	 */
	private String glRstrDueDay;
	/**
	 * 正常扣款顺序方法
	 */
	private Integer glRpymMtd;
	/**
	 * 逾期扣款顺序方法
	 */
	private Integer glOdRpymMtd;
	/**
	 * 已减值贷款扣款顺序方法
	 */
	private Integer glDeviRpym;
	/**
	 * 贷款到期日选项
	 */
	private String glMatDueDay;
	/**
	 * 部分提前还款要求
	 */
	private String glPpTyp;
	/**
	 * 部分提前还款最小金额
	 */
	private BigDecimal glPpMinVal;
	/**
	 * 是否按合同号管理
	 */
	private String glIsContInd;
	/**
	 * 最新变更时间
	 */
	private String lastChgDt;
	/**
	 * 最新变更用户
	 */
	private String lastChgUsr;
	/**
	 * 是否计算罚息：Y：计算罚息,N：不计算罚息
	 */
	private String glOdGraceInd;
	/**
	 * 是否计算复利：Y：计算复利,N：不计算复利
	 */
	private String glOdIntGraceInd;

	/**
	 * 设置：银行代码
	 */
	public void setBankCde(String bankCde) {
		this.bankCde = bankCde;
	}
	/**
	 * 获取：银行代码
	 */
	public String getBankCde() {
		return bankCde;
	}
	/**
	 * 设置：核算设置代码
	 */
	public void setTypGl(String typGl) {
		this.typGl = typGl;
	}
	/**
	 * 获取：核算设置代码
	 */
	public String getTypGl() {
		return typGl;
	}
	/**
	 * 设置：核算设置描述
	 */
	public void setGlAccDesc(String glAccDesc) {
		this.glAccDesc = glAccDesc;
	}
	/**
	 * 获取：核算设置描述
	 */
	public String getGlAccDesc() {
		return glAccDesc;
	}
	/**
	 * 设置：利息计算基础
	 */
	public void setGlRatBase(String glRatBase) {
		this.glRatBase = glRatBase;
	}
	/**
	 * 获取：利息计算基础
	 */
	public String getGlRatBase() {
		return glRatBase;
	}
	/**
	 * 设置：贷款还款日选项
	 */
	public void setGlDueDayOpt(String glDueDayOpt) {
		this.glDueDayOpt = glDueDayOpt;
	}
	/**
	 * 获取：贷款还款日选项
	 */
	public String getGlDueDayOpt() {
		return glDueDayOpt;
	}
	/**
	 * 设置：放款扣息选项
	 */
	public void setGlDrwOptInd(String glDrwOptInd) {
		this.glDrwOptInd = glDrwOptInd;
	}
	/**
	 * 获取：放款扣息选项
	 */
	public String getGlDrwOptInd() {
		return glDrwOptInd;
	}
	/**
	 * 设置：扣款处理方式
	 */
	public void setGlPaymOpt(String glPaymOpt) {
		this.glPaymOpt = glPaymOpt;
	}
	/**
	 * 获取：扣款处理方式
	 */
	public String getGlPaymOpt() {
		return glPaymOpt;
	}
	/**
	 * 设置：利率调整选项
	 */
	public void setGlRatAdjOpt(String glRatAdjOpt) {
		this.glRatAdjOpt = glRatAdjOpt;
	}
	/**
	 * 获取：利率调整选项
	 */
	public String getGlRatAdjOpt() {
		return glRatAdjOpt;
	}
	/**
	 * 设置：利率调整变动类型
	 */
	public void setGlRatChgCat(String glRatChgCat) {
		this.glRatChgCat = glRatChgCat;
	}
	/**
	 * 获取：利率调整变动类型
	 */
	public String getGlRatChgCat() {
		return glRatChgCat;
	}
	/**
	 * 设置：贷款到期日假期调整
	 */
	public void setGlHolidayAdj(String glHolidayAdj) {
		this.glHolidayAdj = glHolidayAdj;
	}
	/**
	 * 获取：贷款到期日假期调整
	 */
	public String getGlHolidayAdj() {
		return glHolidayAdj;
	}
	/**
	 * 设置：是否采用固定罚息利率
	 */
	public void setGlFixedOdInd(String glFixedOdInd) {
		this.glFixedOdInd = glFixedOdInd;
	}
	/**
	 * 获取：是否采用固定罚息利率
	 */
	public String getGlFixedOdInd() {
		return glFixedOdInd;
	}
	/**
	 * 设置：罚息利率
	 */
	public void setGlOdIntRate(BigDecimal glOdIntRate) {
		this.glOdIntRate = glOdIntRate;
	}
	/**
	 * 获取：罚息利率
	 */
	public BigDecimal getGlOdIntRate() {
		return glOdIntRate;
	}
	/**
	 * 设置：计算复利部分
	 */
	public void setGlOdCommPart(String glOdCommPart) {
		this.glOdCommPart = glOdCommPart;
	}
	/**
	 * 获取：计算复利部分
	 */
	public String getGlOdCommPart() {
		return glOdCommPart;
	}
	/**
	 * 设置：罚息利率种类
	 */
	public void setGlOdCat(String glOdCat) {
		this.glOdCat = glOdCat;
	}
	/**
	 * 获取：罚息利率种类
	 */
	public String getGlOdCat() {
		return glOdCat;
	}
	/**
	 * 设置：罚息利率代码
	 */
	public void setGlOdRateTyp(String glOdRateTyp) {
		this.glOdRateTyp = glOdRateTyp;
	}
	/**
	 * 获取：罚息利率代码
	 */
	public String getGlOdRateTyp() {
		return glOdRateTyp;
	}
	/**
	 * 设置：是否计算罚息复利：Y：计算罚息复利,N：不计算罚息复利
	 */
	public void setGlOdCpdInd(String glOdCpdInd) {
		this.glOdCpdInd = glOdCpdInd;
	}
	/**
	 * 获取：是否计算罚息复利：Y：计算罚息复利,N：不计算罚息复利
	 */
	public String getGlOdCpdInd() {
		return glOdCpdInd;
	}
	/**
	 * 设置：最小罚息金额
	 */
	public void setGlOdMinAmt(BigDecimal glOdMinAmt) {
		this.glOdMinAmt = glOdMinAmt;
	}
	/**
	 * 获取：最小罚息金额
	 */
	public BigDecimal getGlOdMinAmt() {
		return glOdMinAmt;
	}
	/**
	 * 设置：罚息尾数保留方式
	 */
	public void setGlOdAppxTyp(String glOdAppxTyp) {
		this.glOdAppxTyp = glOdAppxTyp;
	}
	/**
	 * 获取：罚息尾数保留方式
	 */
	public String getGlOdAppxTyp() {
		return glOdAppxTyp;
	}
	/**
	 * 设置：利息尾数保留方式
	 */
	public void setGlIntAppxTyp(String glIntAppxTyp) {
		this.glIntAppxTyp = glIntAppxTyp;
	}
	/**
	 * 获取：利息尾数保留方式
	 */
	public String getGlIntAppxTyp() {
		return glIntAppxTyp;
	}
	/**
	 * 设置：部分提前还款计息基础
	 */
	public void setGlPpRatBase(String glPpRatBase) {
		this.glPpRatBase = glPpRatBase;
	}
	/**
	 * 获取：部分提前还款计息基础
	 */
	public String getGlPpRatBase() {
		return glPpRatBase;
	}
	/**
	 * 设置：部分提前还款利息计算选项
	 */
	public void setGlPpRatOpt(String glPpRatOpt) {
		this.glPpRatOpt = glPpRatOpt;
	}
	/**
	 * 获取：部分提前还款利息计算选项
	 */
	public String getGlPpRatOpt() {
		return glPpRatOpt;
	}
	/**
	 * 设置：到期日调整选项
	 */
	public void setGlRstrDueDay(String glRstrDueDay) {
		this.glRstrDueDay = glRstrDueDay;
	}
	/**
	 * 获取：到期日调整选项
	 */
	public String getGlRstrDueDay() {
		return glRstrDueDay;
	}
	/**
	 * 设置：正常扣款顺序方法
	 */
	public void setGlRpymMtd(Integer glRpymMtd) {
		this.glRpymMtd = glRpymMtd;
	}
	/**
	 * 获取：正常扣款顺序方法
	 */
	public Integer getGlRpymMtd() {
		return glRpymMtd;
	}
	/**
	 * 设置：逾期扣款顺序方法
	 */
	public void setGlOdRpymMtd(Integer glOdRpymMtd) {
		this.glOdRpymMtd = glOdRpymMtd;
	}
	/**
	 * 获取：逾期扣款顺序方法
	 */
	public Integer getGlOdRpymMtd() {
		return glOdRpymMtd;
	}
	/**
	 * 设置：已减值贷款扣款顺序方法
	 */
	public void setGlDeviRpym(Integer glDeviRpym) {
		this.glDeviRpym = glDeviRpym;
	}
	/**
	 * 获取：已减值贷款扣款顺序方法
	 */
	public Integer getGlDeviRpym() {
		return glDeviRpym;
	}
	/**
	 * 设置：贷款到期日选项
	 */
	public void setGlMatDueDay(String glMatDueDay) {
		this.glMatDueDay = glMatDueDay;
	}
	/**
	 * 获取：贷款到期日选项
	 */
	public String getGlMatDueDay() {
		return glMatDueDay;
	}
	/**
	 * 设置：部分提前还款要求
	 */
	public void setGlPpTyp(String glPpTyp) {
		this.glPpTyp = glPpTyp;
	}
	/**
	 * 获取：部分提前还款要求
	 */
	public String getGlPpTyp() {
		return glPpTyp;
	}
	/**
	 * 设置：部分提前还款最小金额
	 */
	public void setGlPpMinVal(BigDecimal glPpMinVal) {
		this.glPpMinVal = glPpMinVal;
	}
	/**
	 * 获取：部分提前还款最小金额
	 */
	public BigDecimal getGlPpMinVal() {
		return glPpMinVal;
	}
	/**
	 * 设置：是否按合同号管理
	 */
	public void setGlIsContInd(String glIsContInd) {
		this.glIsContInd = glIsContInd;
	}
	/**
	 * 获取：是否按合同号管理
	 */
	public String getGlIsContInd() {
		return glIsContInd;
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
	 * 设置：是否计算罚息：Y：计算罚息,N：不计算罚息
	 */
	public void setGlOdGraceInd(String glOdGraceInd) {
		this.glOdGraceInd = glOdGraceInd;
	}
	/**
	 * 获取：是否计算罚息：Y：计算罚息,N：不计算罚息
	 */
	public String getGlOdGraceInd() {
		return glOdGraceInd;
	}
	/**
	 * 设置：是否计算复利：Y：计算复利,N：不计算复利
	 */
	public void setGlOdIntGraceInd(String glOdIntGraceInd) {
		this.glOdIntGraceInd = glOdIntGraceInd;
	}
	/**
	 * 获取：是否计算复利：Y：计算复利,N：不计算复利
	 */
	public String getGlOdIntGraceInd() {
		return glOdIntGraceInd;
	}

	public PLoanTypGl() {

	}
	public PLoanTypGl(String bankCde, String typGl) {
        this.typGl = typGl;
		this.bankCde =bankCde;
	}
}
