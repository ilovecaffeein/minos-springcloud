package com.caxs.minos.domain;

import java.io.Serializable;

/***
 * @ClassName(类名) : LmPmShdId
 * @Description(描述) : TODD
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/14 12:51
 */
public class LmPmShdId  implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Fields

    private String loanNo;			//借据号
    private Integer psPerdNo;			//期号

    // Constructors

    /** default constructor */
    public LmPmShdId() {
    }

    /** full constructor */
    public LmPmShdId(Integer psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    /** full constructor */
    public LmPmShdId(String loanNo, Integer psPerdNo) {
        this.loanNo = loanNo;
        this.psPerdNo = psPerdNo;
    }

    // Property accessors
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
     * 获取期号
     * @return
     */
    public Integer getPsPerdNo() {
        return this.psPerdNo;
    }
    /**
     * 设置期号
     * @param psPerdNo
     */
    public void setPsPerdNo(Integer psPerdNo) {
        this.psPerdNo = psPerdNo;
    }
    /**
     * 判断是否相等
     */
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof LmPmShdId))
            return false;
        LmPmShdId castOther = (LmPmShdId) other;

        return ((this.getLoanNo() == castOther.getLoanNo()) || (this
                .getLoanNo() != null
                && castOther.getLoanNo() != null && this.getLoanNo().equals(
                castOther.getLoanNo())))
                && ((this.getPsPerdNo() == castOther.getPsPerdNo()) || (this
                .getPsPerdNo() != null
                && castOther.getPsPerdNo() != null && this
                .getPsPerdNo().equals(castOther.getPsPerdNo())));
    }
    /**
     * 哈希值
     */
    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getLoanNo() == null ? 0 : this.getLoanNo().hashCode());
        result = 37 * result
                + (getPsPerdNo() == null ? 0 : this.getPsPerdNo().hashCode());
        return result;
    }
}
