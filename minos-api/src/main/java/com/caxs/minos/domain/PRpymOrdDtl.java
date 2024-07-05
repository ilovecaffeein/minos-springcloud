package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * RPYM_ORD_TYP:当期本金、当期利息、逾期利息、逾期本金、表外罚息、表内罚息、费用
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class PRpymOrdDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 还款顺序序号
	 */
	private Integer rpymOrdSeqNo;
	/**
	 * 优先级
	 */
	private Integer rpymOrdPriority;
	/**
	 * 还款类型
	 */
	private String rpymOrdTyp;

	/**
	 * 设置：还款顺序序号
	 */
	public void setRpymOrdSeqNo(Integer rpymOrdSeqNo) {
		this.rpymOrdSeqNo = rpymOrdSeqNo;
	}
	/**
	 * 获取：还款顺序序号
	 */
	public Integer getRpymOrdSeqNo() {
		return rpymOrdSeqNo;
	}
	/**
	 * 设置：优先级
	 */
	public void setRpymOrdPriority(Integer rpymOrdPriority) {
		this.rpymOrdPriority = rpymOrdPriority;
	}
	/**
	 * 获取：优先级
	 */
	public Integer getRpymOrdPriority() {
		return rpymOrdPriority;
	}
	/**
	 * 设置：还款类型
	 */
	public void setRpymOrdTyp(String rpymOrdTyp) {
		this.rpymOrdTyp = rpymOrdTyp;
	}
	/**
	 * 获取：还款类型
	 */
	public String getRpymOrdTyp() {
		return rpymOrdTyp;
	}
}
