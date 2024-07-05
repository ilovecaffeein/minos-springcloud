package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 主要用于存放与合同相关的信息，包括期限、放款日期、生效日期、到期日、以及利率类型、利息罚息计算规则等等。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class LmLoanCont implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 贷款合同号
	 */
	private String loanContNo;
	/**
	 * 银行代码
	 */
	private String bankCde;
	/**
	 * 贷款品种代码
	 */
	private String loanTyp;
	/**
	 * 借款人证件类型
	 */
	private String idType;
	/**
	 * 借款人证件号
	 */
	private String idNo;
	/**
	 * 借款人发证国家
	 */
	private String issCtry;
	/**
	 * 客户编号
	 */
	private String custId;
	/**
	 * 借款人姓名
	 */
	private String custName;
	/**
	 * 宽限期类型
	 */
	private String loanGraceTyp;
	/**
	 * 宽限期天数
	 */
	private Integer loanOdGrace;
	/**
	 * 扣款方式
	 */
	private String loanRepayMthd;
	/**
	 * 是否采用固定罚息利率
	 */
	private String loanFixOdIntInd;
	/**
	 * 罚息利率种类
	 */
	private String loanOdCat;
	/**
	 * 挪用利率浮动比例
	 */
	private BigDecimal loanDiverAdjPct;
	/**
	 * 计算罚息部分
	 */
	private String loanOdCommPart;
	/**
	 * 是否计算逾期利息和复利：Y: 计算逾期利息和复利 ，N:不计算逾期利息和复利
	 */
	private String loanOdCpdInd;
	/**
	 * 下一次利率调整选项
	 */
	private String nextRepcOpt;
	/**
	 * 下一次利率调整间隔
	 */
	private Integer nextRepcNum;
	/**
	 * 下一次利率调整间隔单位
	 */
	private String nextRepcUnit;
	/**
	 * 利率调整选项
	 */
	private String ratChgOpt;
	/**
	 * 逾期利率
	 */
	private BigDecimal loanOdIntRate1;
	/**
	 * 逾期利率浮动比
	 */
	private BigDecimal loanOdRateAdjPct1;
	/**
	 * 罚息利率
	 */
	private BigDecimal loanOdIntRate;
	/**
	 * 罚息利率浮动比
	 */
	private BigDecimal loanOdRateAdjPct;
	/**
	 * 信贷合同号
	 */
	private String cmisLoanContNo;
	/**
	 * 贷款组
	 */
	private String typGrp;
	/**
	 * 贷款品种版本号
	 */
	private Integer typVer;
	/**
	 * 营销专案
	 */
	private String loanProm;
	/**
	 * 利息宽限期
	 */
	private Integer loanOdIntGrace;
	/**
	 * 是否计算逾期利息：Y: 计算逾期利息 ，N:不计算逾期利息
	 */
	private String loanOdGraceInd;
	/**
	 * 是否计算复利：Y: 计算复利 ，N:不计算复利
	 */
	private String loanOdIntGraceInd;

	/**
	 * 设置：贷款合同号
	 */
	public void setLoanContNo(String loanContNo) {
		this.loanContNo = loanContNo;
	}
	/**
	 * 获取：贷款合同号
	 */
	public String getLoanContNo() {
		return loanContNo;
	}
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
	 * 设置：贷款品种代码
	 */
	public void setLoanTyp(String loanTyp) {
		this.loanTyp = loanTyp;
	}
	/**
	 * 获取：贷款品种代码
	 */
	public String getLoanTyp() {
		return loanTyp;
	}
	/**
	 * 设置：借款人证件类型
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：借款人证件类型
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置：借款人证件号
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：借款人证件号
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：借款人发证国家
	 */
	public void setIssCtry(String issCtry) {
		this.issCtry = issCtry;
	}
	/**
	 * 获取：借款人发证国家
	 */
	public String getIssCtry() {
		return issCtry;
	}
	/**
	 * 设置：客户编号
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * 获取：客户编号
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * 设置：借款人姓名
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * 获取：借款人姓名
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * 设置：宽限期类型
	 */
	public void setLoanGraceTyp(String loanGraceTyp) {
		this.loanGraceTyp = loanGraceTyp;
	}
	/**
	 * 获取：宽限期类型
	 */
	public String getLoanGraceTyp() {
		return loanGraceTyp;
	}
	/**
	 * 设置：宽限期天数
	 */
	public void setLoanOdGrace(Integer loanOdGrace) {
		this.loanOdGrace = loanOdGrace;
	}
	/**
	 * 获取：宽限期天数
	 */
	public Integer getLoanOdGrace() {
		return loanOdGrace;
	}
	/**
	 * 设置：扣款方式
	 */
	public void setLoanRepayMthd(String loanRepayMthd) {
		this.loanRepayMthd = loanRepayMthd;
	}
	/**
	 * 获取：扣款方式
	 */
	public String getLoanRepayMthd() {
		return loanRepayMthd;
	}
	/**
	 * 设置：是否采用固定罚息利率
	 */
	public void setLoanFixOdIntInd(String loanFixOdIntInd) {
		this.loanFixOdIntInd = loanFixOdIntInd;
	}
	/**
	 * 获取：是否采用固定罚息利率
	 */
	public String getLoanFixOdIntInd() {
		return loanFixOdIntInd;
	}
	/**
	 * 设置：罚息利率种类
	 */
	public void setLoanOdCat(String loanOdCat) {
		this.loanOdCat = loanOdCat;
	}
	/**
	 * 获取：罚息利率种类
	 */
	public String getLoanOdCat() {
		return loanOdCat;
	}
	/**
	 * 设置：挪用利率浮动比例
	 */
	public void setLoanDiverAdjPct(BigDecimal loanDiverAdjPct) {
		this.loanDiverAdjPct = loanDiverAdjPct;
	}
	/**
	 * 获取：挪用利率浮动比例
	 */
	public BigDecimal getLoanDiverAdjPct() {
		return loanDiverAdjPct;
	}
	/**
	 * 设置：计算罚息部分
	 */
	public void setLoanOdCommPart(String loanOdCommPart) {
		this.loanOdCommPart = loanOdCommPart;
	}
	/**
	 * 获取：计算罚息部分
	 */
	public String getLoanOdCommPart() {
		return loanOdCommPart;
	}
	/**
	 * 设置：是否计算逾期利息和复利：Y: 计算逾期利息和复利 ，N:不计算逾期利息和复利
	 */
	public void setLoanOdCpdInd(String loanOdCpdInd) {
		this.loanOdCpdInd = loanOdCpdInd;
	}
	/**
	 * 获取：是否计算逾期利息和复利：Y: 计算逾期利息和复利 ，N:不计算逾期利息和复利
	 */
	public String getLoanOdCpdInd() {
		return loanOdCpdInd;
	}
	/**
	 * 设置：下一次利率调整选项
	 */
	public void setNextRepcOpt(String nextRepcOpt) {
		this.nextRepcOpt = nextRepcOpt;
	}
	/**
	 * 获取：下一次利率调整选项
	 */
	public String getNextRepcOpt() {
		return nextRepcOpt;
	}
	/**
	 * 设置：下一次利率调整间隔
	 */
	public void setNextRepcNum(Integer nextRepcNum) {
		this.nextRepcNum = nextRepcNum;
	}
	/**
	 * 获取：下一次利率调整间隔
	 */
	public Integer getNextRepcNum() {
		return nextRepcNum;
	}
	/**
	 * 设置：下一次利率调整间隔单位
	 */
	public void setNextRepcUnit(String nextRepcUnit) {
		this.nextRepcUnit = nextRepcUnit;
	}
	/**
	 * 获取：下一次利率调整间隔单位
	 */
	public String getNextRepcUnit() {
		return nextRepcUnit;
	}
	/**
	 * 设置：利率调整选项
	 */
	public void setRatChgOpt(String ratChgOpt) {
		this.ratChgOpt = ratChgOpt;
	}
	/**
	 * 获取：利率调整选项
	 */
	public String getRatChgOpt() {
		return ratChgOpt;
	}
	/**
	 * 设置：逾期利率
	 */
	public void setLoanOdIntRate1(BigDecimal loanOdIntRate1) {
		this.loanOdIntRate1 = loanOdIntRate1;
	}
	/**
	 * 获取：逾期利率
	 */
	public BigDecimal getLoanOdIntRate1() {
		return loanOdIntRate1;
	}
	/**
	 * 设置：逾期利率浮动比
	 */
	public void setLoanOdRateAdjPct1(BigDecimal loanOdRateAdjPct1) {
		this.loanOdRateAdjPct1 = loanOdRateAdjPct1;
	}
	/**
	 * 获取：逾期利率浮动比
	 */
	public BigDecimal getLoanOdRateAdjPct1() {
		return loanOdRateAdjPct1;
	}
	/**
	 * 设置：罚息利率
	 */
	public void setLoanOdIntRate(BigDecimal loanOdIntRate) {
		this.loanOdIntRate = loanOdIntRate;
	}
	/**
	 * 获取：罚息利率
	 */
	public BigDecimal getLoanOdIntRate() {
		return loanOdIntRate;
	}
	/**
	 * 设置：罚息利率浮动比
	 */
	public void setLoanOdRateAdjPct(BigDecimal loanOdRateAdjPct) {
		this.loanOdRateAdjPct = loanOdRateAdjPct;
	}
	/**
	 * 获取：罚息利率浮动比
	 */
	public BigDecimal getLoanOdRateAdjPct() {
		return loanOdRateAdjPct;
	}
	/**
	 * 设置：信贷合同号
	 */
	public void setCmisLoanContNo(String cmisLoanContNo) {
		this.cmisLoanContNo = cmisLoanContNo;
	}
	/**
	 * 获取：信贷合同号
	 */
	public String getCmisLoanContNo() {
		return cmisLoanContNo;
	}
	/**
	 * 设置：贷款组
	 */
	public void setTypGrp(String typGrp) {
		this.typGrp = typGrp;
	}
	/**
	 * 获取：贷款组
	 */
	public String getTypGrp() {
		return typGrp;
	}
	/**
	 * 设置：贷款品种版本号
	 */
	public void setTypVer(Integer typVer) {
		this.typVer = typVer;
	}
	/**
	 * 获取：贷款品种版本号
	 */
	public Integer getTypVer() {
		return typVer;
	}
	/**
	 * 设置：营销专案
	 */
	public void setLoanProm(String loanProm) {
		this.loanProm = loanProm;
	}
	/**
	 * 获取：营销专案
	 */
	public String getLoanProm() {
		return loanProm;
	}
	/**
	 * 设置：利息宽限期
	 */
	public void setLoanOdIntGrace(Integer loanOdIntGrace) {
		this.loanOdIntGrace = loanOdIntGrace;
	}
	/**
	 * 获取：利息宽限期
	 */
	public Integer getLoanOdIntGrace() {
		return loanOdIntGrace;
	}
	/**
	 * 设置：是否计算逾期利息：Y: 计算逾期利息 ，N:不计算逾期利息
	 */
	public void setLoanOdGraceInd(String loanOdGraceInd) {
		this.loanOdGraceInd = loanOdGraceInd;
	}
	/**
	 * 获取：是否计算逾期利息：Y: 计算逾期利息 ，N:不计算逾期利息
	 */
	public String getLoanOdGraceInd() {
		return loanOdGraceInd;
	}
	/**
	 * 设置：是否计算复利：Y: 计算复利 ，N:不计算复利
	 */
	public void setLoanOdIntGraceInd(String loanOdIntGraceInd) {
		this.loanOdIntGraceInd = loanOdIntGraceInd;
	}
	/**
	 * 获取：是否计算复利：Y: 计算复利 ，N:不计算复利
	 */
	public String getLoanOdIntGraceInd() {
		return loanOdIntGraceInd;
	}
}
