package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * LmLoanCont对应交互类 --合同
 * Created by lenovo on 2020/9/4.
 */
public class LmLoanContTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    private String loanContNo; // 合同号
    private String bankCde; // 银行编号
    private String bchCde; // 机构编号
    private String loanTyp; // 贷款品种
    private String idType; // 证件类型
    private String idNo; // 证件号码
    private String issCtry; // 发证国家
    private String custName; // 客户姓名
    private String loanGraceTyp; // 宽限期类型
    private Long loanOdGrace; // 宽限期天数
    private String loanRepayMthd; // 扣款方式
    private String loanFixOdIntInd; // 是否采用固定罚息利率
    private Double loanOdRateAdjPct; // 罚息调整比例
    private String loanOdCat; // 罚息利率类
    private String loanOdCpdInd; // 是否计算复利
    private String nextRepcOpt; // 下一次利率调整选项
    private Byte nextRepcNum; // 下一次利率调整间隔
    private String nextRepcUnit; // 下一次利率调整间隔单位
    private String loanActvBchCde; // 发放机构编号
    private String custId; // 客户号
    private Double loanOdIntRate; // 罚息执行利率
    private Double loanOdIntRate1; // 罚息执行利率
    private Double loanOdRateAdjPct1; // 罚息调整比例
    private String loanOdCommPart; // 计算罚息部分
    private String typGrp;// 贷款组
    private Long typVer;		    	//贷款品种版本号

    private String loanProm;		    //营销专案
    private Long loanOdIntGrace;		//利息宽限期
    private String loanOdGraceInd;		//是否计算逾期利息：Y: 计算逾期利息 ，N:不计算逾期利息
    private String loanOdIntGraceInd;   //是否计算复利：Y: 计算复利 ，N:不计算复利

    public String getLoanOdGraceInd() {
        return loanOdGraceInd;
    }
    public void setLoanOdGraceInd(String loanOdGraceInd) {
        this.loanOdGraceInd = loanOdGraceInd;
    }

    public String getLoanOdIntGraceInd() {
        return loanOdIntGraceInd;
    }
    public void setLoanOdIntGraceInd(String loanOdIntGraceInd) {
        this.loanOdIntGraceInd = loanOdIntGraceInd;
    }
    public Long getTypVer() {
        return typVer;
    }

    public void setTypVer(Long typVer) {
        this.typVer = typVer;
    }

    public String getLoanProm() {
        return loanProm;
    }

    public void setLoanProm(String loanProm) {
        this.loanProm = loanProm;
    }


    public String getLoanOdCat() {
        return loanOdCat;
    }

    public void setLoanOdCat(String loanOdCat) {
        this.loanOdCat = loanOdCat;
    }


    public String getTypGrp() {
        return typGrp;
    }

    public void setTypGrp(String typGrp) {
        this.typGrp = typGrp;
    }

    /** default constructor */
    public LmLoanContTrans() {
    }

    /** minimal constructor */
    public LmLoanContTrans(String loanContNo) {
        this.loanContNo = loanContNo;
    }

    /** full constructor */
    public LmLoanContTrans(String loanContNo, String bankCde, String loanTyp,
                           String idType, String idNo, String issCtry, String custName,
                           String loanGraceTyp, Long loanOdGrace, String loanRepayMthd,
                           String loanFixOdIntInd, Double loanOdRateAdjPct,
                           String loanOdCpdInd, String nextRepcOpt, Byte nextRepcNum,
                           String nextRepcUnit, String loanActvBchCde, String custId,
                           Double loanOdIntRate, Double loanOdIntRate1,
                           Double loanOdRateAdjPct1, String loanOdCommPart,Long loanOdIntGrace,
                           String loanOdIntGraceInd,String loanOdGraceInd) {
        this.loanContNo = loanContNo;
        this.bankCde = bankCde;
        this.loanTyp = loanTyp;
        this.idType = idType;
        this.idNo = idNo;
        this.issCtry = issCtry;
        this.custName = custName;
        this.loanGraceTyp = loanGraceTyp;
        this.loanOdGrace = loanOdGrace;
        this.loanRepayMthd = loanRepayMthd;
        this.loanFixOdIntInd = loanFixOdIntInd;
        this.loanOdRateAdjPct = loanOdRateAdjPct;
        this.loanOdCpdInd = loanOdCpdInd;
        this.nextRepcOpt = nextRepcOpt;
        this.nextRepcNum = nextRepcNum;
        this.nextRepcUnit = nextRepcUnit;
        this.loanActvBchCde = loanActvBchCde;
        this.custId = custId;
        this.loanOdIntRate = loanOdIntRate;
        this.loanOdIntRate1 = loanOdIntRate1;
        this.loanOdRateAdjPct1 = loanOdRateAdjPct1;
        this.loanOdCommPart = loanOdCommPart;
        this.loanOdIntGrace = loanOdIntGrace;
        this.loanOdIntGraceInd = loanOdIntGraceInd;
        this.loanOdGraceInd = loanOdGraceInd;
    }

    // Property accessors
    /**
     * 获取合同号
     *
     * @return
     */
    public String getLoanContNo() {
        return this.loanContNo;
    }

    /**
     * 获取计算罚息部分
     *
     * @return
     */
    public String getLoanOdCommPart() {
        return loanOdCommPart;
    }

    /**
     * 设置计算罚息部分
     *
     * @param loanOdCommPart
     */
    public void setLoanOdCommPart(String loanOdCommPart) {
        this.loanOdCommPart = loanOdCommPart;
    }

    /**
     * 设置合同号
     *
     * @param loanContNo
     */
    public void setLoanContNo(String loanContNo) {
        this.loanContNo = loanContNo;
    }

    /**
     * 获取银行编号
     *
     * @return
     */
    public String getBankCde() {
        return this.bankCde;
    }

    /**
     * 设置银行编号
     *
     * @param bankCde
     */
    public void setBankCde(String bankCde) {
        this.bankCde = bankCde;
    }

    /**
     * 获取贷款品种
     *
     * @return
     */
    public String getLoanTyp() {
        return this.loanTyp;
    }

    /**
     * 设置贷款品种
     *
     * @param loanTyp
     */
    public void setLoanTyp(String loanTyp) {
        this.loanTyp = loanTyp;
    }

    /**
     * 获取证件类型
     *
     * @return
     */
    public String getIdType() {
        return this.idType;
    }

    /**
     * 设置证件类型
     *
     * @param idType
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * 获取证件号码
     *
     * @return
     */
    public String getIdNo() {
        return this.idNo;
    }

    /**
     * 设置证件号码
     *
     * @param idNo
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取发证国家
     *
     * @return
     */
    public String getIssCtry() {
        return this.issCtry;
    }

    /**
     * 设置发证国家
     *
     * @param issCtry
     */
    public void setIssCtry(String issCtry) {
        this.issCtry = issCtry;
    }

    /**
     * 获取客户姓名
     *
     * @return
     */
    public String getCustName() {
        return this.custName;
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
     * 获取宽限期类型
     *
     * @return
     */
    public String getLoanGraceTyp() {
        return this.loanGraceTyp;
    }

    /**
     * 设置宽限期类型
     *
     * @param loanGraceTyp
     */
    public void setLoanGraceTyp(String loanGraceTyp) {
        this.loanGraceTyp = loanGraceTyp;
    }

    /**
     * 获取宽限期天数
     *
     * @return
     */
    public Long getLoanOdGrace() {
        return this.loanOdGrace;
    }

    /**
     * 设置宽限期天数
     *
     * @param loanOdGrace
     */
    public void setLoanOdGrace(Long loanOdGrace) {
        this.loanOdGrace = loanOdGrace;
    }

    /**
     * 获取还款方式
     *
     * @return
     */
    public String getLoanRepayMthd() {
        return this.loanRepayMthd;
    }

    /**
     * 设置还款方式
     *
     * @param loanRepayMthd
     */
    public void setLoanRepayMthd(String loanRepayMthd) {
        this.loanRepayMthd = loanRepayMthd;
    }

    /**
     * 获取是否采用固定罚息利率
     *
     * @return
     */
    public String getLoanFixOdIntInd() {
        return this.loanFixOdIntInd;
    }

    /**
     * 设置是否采用固定罚息利率
     *
     * @param loanFixOdIntInd
     */
    public void setLoanFixOdIntInd(String loanFixOdIntInd) {
        this.loanFixOdIntInd = loanFixOdIntInd;
    }

    /**
     * 获取罚息调整比例
     *
     * @return
     */
    public Double getLoanOdRateAdjPct() {
        return this.loanOdRateAdjPct;
    }

    /**
     * 设置罚息调整比例
     *
     * @param loanOdRateAdjPct
     */
    public void setLoanOdRateAdjPct(Double loanOdRateAdjPct) {
        this.loanOdRateAdjPct = loanOdRateAdjPct;
    }

    /**
     * 获取是否计算复利
     *
     * @return
     */
    public String getLoanOdCpdInd() {
        return this.loanOdCpdInd;
    }

    /**
     * 设置是否计算复利
     *
     * @param loanOdCpdInd
     */
    public void setLoanOdCpdInd(String loanOdCpdInd) {
        this.loanOdCpdInd = loanOdCpdInd;
    }

    /**
     * 获取下一次利率调整选项
     *
     * @return
     */
    public String getNextRepcOpt() {
        return this.nextRepcOpt;
    }

    /**
     * 设置下一次利率调整选项
     *
     * @param nextRepcOpt
     */
    public void setNextRepcOpt(String nextRepcOpt) {
        this.nextRepcOpt = nextRepcOpt;
    }

    /**
     * 获取下一次利率调整间隔
     *
     * @return
     */
    public Byte getNextRepcNum() {
        return this.nextRepcNum;
    }

    /**
     * 设置下一次利率调整间隔
     *
     * @param nextRepcNum
     */
    public void setNextRepcNum(Byte nextRepcNum) {
        this.nextRepcNum = nextRepcNum;
    }

    /**
     * 获取下一次利率调整间隔单位
     *
     * @return
     */
    public String getNextRepcUnit() {
        return this.nextRepcUnit;
    }

    /**
     * 设置下一次利率调整间隔单位
     *
     * @param nextRepcUnit
     */
    public void setNextRepcUnit(String nextRepcUnit) {
        this.nextRepcUnit = nextRepcUnit;
    }

    /**
     * 获取机构号
     *
     * @return
     */
    public String getBchCde() {
        return bchCde;
    }

    /**
     * 设置机构号
     *
     * @param bchCde
     */
    public void setBchCde(String bchCde) {
        this.bchCde = bchCde;
    }

    /**
     * 获取发放机构编号
     *
     * @return
     */
    public String getLoanActvBchCde() {
        return loanActvBchCde;
    }

    /**
     * 设置发放机构编号
     *
     * @param loanActvBchCde
     */
    public void setLoanActvBchCde(String loanActvBchCde) {
        this.loanActvBchCde = loanActvBchCde;
    }

    /**
     * 获取客户号
     *
     * @return
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 设置客户号
     *
     * @param custId
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * 获取罚息利率
     *
     * @return
     */
    public Double getLoanOdIntRate() {
        return loanOdIntRate;
    }

    /**
     * 设置罚息利率
     *
     * @param loanOdIntRate
     */
    public void setLoanOdIntRate(Double loanOdIntRate) {
        this.loanOdIntRate = loanOdIntRate;
    }

    /**
     * 获取罚息利率
     *
     * @return
     */
    public Double getLoanOdIntRate1() {
        return loanOdIntRate1;
    }

    /**
     * 设置罚息利率
     *
     * @param loanOdIntRate1
     */
    public void setLoanOdIntRate1(Double loanOdIntRate1) {
        this.loanOdIntRate1 = loanOdIntRate1;
    }

    /**
     * 获取罚息调整比例
     *
     * @return
     */
    public Double getLoanOdRateAdjPct1() {
        return loanOdRateAdjPct1;
    }

    /**
     * 设置罚息调整比例
     *
     * @param loanOdRateAdjPct1
     */
    public void setLoanOdRateAdjPct1(Double loanOdRateAdjPct1) {
        this.loanOdRateAdjPct1 = loanOdRateAdjPct1;
    }

    public Long getLoanOdIntGrace() {
        return loanOdIntGrace;
    }

    public void setLoanOdIntGrace( Long loanOdIntGrace) {
        this.loanOdIntGrace = loanOdIntGrace;
    }

}
