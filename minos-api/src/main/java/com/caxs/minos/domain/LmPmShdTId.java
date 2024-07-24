package com.caxs.minos.domain;

/**
 * LmPmShdId entity. @author MyEclipse Persistence Tools
 */

public class LmPmShdTId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String loanNo;			//借据号
	private Short psPerdNo;			//期号

	// Constructors

	/** default constructor */
	public LmPmShdTId() {
	}

	/** full constructor */
	public LmPmShdTId(String loanNo, Short psPerdNo) {
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
	public Short getPsPerdNo() {
		return this.psPerdNo;
	}
	/**
	 * 设置期号
	 * @param psPerdNo
	 */
	public void setPsPerdNo(Short psPerdNo) {
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
		if (!(other instanceof LmPmShdTId))
			return false;
		LmPmShdTId castOther = (LmPmShdTId) other;

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