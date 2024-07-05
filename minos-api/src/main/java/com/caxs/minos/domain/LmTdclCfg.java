package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * 交易撤销配置LM_TDCL_CFG
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmTdclCfg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * TRANS_CODE
	 */
	private String transCode;
	/**
	 * TABLE_NAME
	 */
	private String tableName;
	/**
	 * HIST_TABLE_NAME
	 */
	private String histTableName;
	/**
	 * CL_TYP
	 */
	private String clTyp;
	/**
	 * CL_FD
	 */
	private String clFd;
	/**
	 * IS_LIST
	 */
	private String isList;
	/**
	 * ID_CLASS
	 */
	private String idClass;
	/**
	 * SRC_ID_CLASS
	 */
	private String srcIdClass;
	/**
	 * SRC_KEY_FD
	 */
	private String srcKeyFd;
	/**
	 * HIST_TX_SEQ_FD
	 */
	private String histTxSeqFd;
	/**
	 * TO_HIST_IND
	 */
	private String toHistInd;
	/**
	 * RE_COVER_IND
	 */
	private String reCoverInd;

	/**
	 * 设置：TRANS_CODE
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	/**
	 * 获取：TRANS_CODE
	 */
	public String getTransCode() {
		return transCode;
	}
	/**
	 * 设置：TABLE_NAME
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 获取：TABLE_NAME
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 设置：HIST_TABLE_NAME
	 */
	public void setHistTableName(String histTableName) {
		this.histTableName = histTableName;
	}
	/**
	 * 获取：HIST_TABLE_NAME
	 */
	public String getHistTableName() {
		return histTableName;
	}
	/**
	 * 设置：CL_TYP
	 */
	public void setClTyp(String clTyp) {
		this.clTyp = clTyp;
	}
	/**
	 * 获取：CL_TYP
	 */
	public String getClTyp() {
		return clTyp;
	}
	/**
	 * 设置：CL_FD
	 */
	public void setClFd(String clFd) {
		this.clFd = clFd;
	}
	/**
	 * 获取：CL_FD
	 */
	public String getClFd() {
		return clFd;
	}
	/**
	 * 设置：IS_LIST
	 */
	public void setIsList(String isList) {
		this.isList = isList;
	}
	/**
	 * 获取：IS_LIST
	 */
	public String getIsList() {
		return isList;
	}
	/**
	 * 设置：ID_CLASS
	 */
	public void setIdClass(String idClass) {
		this.idClass = idClass;
	}
	/**
	 * 获取：ID_CLASS
	 */
	public String getIdClass() {
		return idClass;
	}
	/**
	 * 设置：SRC_ID_CLASS
	 */
	public void setSrcIdClass(String srcIdClass) {
		this.srcIdClass = srcIdClass;
	}
	/**
	 * 获取：SRC_ID_CLASS
	 */
	public String getSrcIdClass() {
		return srcIdClass;
	}
	/**
	 * 设置：SRC_KEY_FD
	 */
	public void setSrcKeyFd(String srcKeyFd) {
		this.srcKeyFd = srcKeyFd;
	}
	/**
	 * 获取：SRC_KEY_FD
	 */
	public String getSrcKeyFd() {
		return srcKeyFd;
	}
	/**
	 * 设置：HIST_TX_SEQ_FD
	 */
	public void setHistTxSeqFd(String histTxSeqFd) {
		this.histTxSeqFd = histTxSeqFd;
	}
	/**
	 * 获取：HIST_TX_SEQ_FD
	 */
	public String getHistTxSeqFd() {
		return histTxSeqFd;
	}
	/**
	 * 设置：TO_HIST_IND
	 */
	public void setToHistInd(String toHistInd) {
		this.toHistInd = toHistInd;
	}
	/**
	 * 获取：TO_HIST_IND
	 */
	public String getToHistInd() {
		return toHistInd;
	}
	/**
	 * 设置：RE_COVER_IND
	 */
	public void setReCoverInd(String reCoverInd) {
		this.reCoverInd = reCoverInd;
	}
	/**
	 * 获取：RE_COVER_IND
	 */
	public String getReCoverInd() {
		return reCoverInd;
	}
}
