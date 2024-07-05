package com.caxs.minos.domain.trans;

/**
 * 交易撤销配置
 * 
 * @author hb
 * 
 */

import java.io.Serializable;

/**
 * @author hb
 * 
 */
public class TradeCancelCfgTrans  implements Serializable {
	private static final long serialVersionUID = 7607704161124404623L;

	public enum CancelType {
		DELETE, MODIFY, RECOVER;
		public static CancelType getEnum(String cancelType) {
			if ("D".equals(cancelType)) {
				return DELETE;
			}
			if ("R".equals(cancelType)) {
				return RECOVER;
			}
			if ("M".equals(cancelType)) {
				return MODIFY;
			}
			return DELETE;

		}
	};

	/**
	 * 是否备份
	 */
	private boolean isToHist = true;
	/**
	 * 是否还原
	 */
	private boolean isRecover = true;

	public boolean isToHist() {
		return isToHist;
	}

	public void setToHist(boolean isToHist) {
		this.isToHist = isToHist;
	}

	public boolean isRecover() {
		return isRecover;
	}

	public void setRecover(boolean isRecover) {
		this.isRecover = isRecover;
	}

	/**
	 *撤销表名
	 */
	private String tableName;
	/**
	 * 历史表名
	 */
	private String histTableName;
	/**
	 * 撤销类型
	 */
	private CancelType cancelTyp;
	/**
	 * 撤销字段
	 */
	private String cancelFieldName;
	/**
	 * id类名例如: LmPmShdId
	 */
	private String idClassName;
	/**
	 *历史表流水字段
	 */
	private String histTxSeqLogFieldName;

	public String getHistTxSeqLogFieldName() {
		return histTxSeqLogFieldName;
	}

	public void setHistTxSeqLogFieldName(String histTxSeqLogFieldName) {
		this.histTxSeqLogFieldName = histTxSeqLogFieldName;
	}

	public String getIdClassName() {
		return idClassName;
	}

	/**
	 *原表类名
	 */
	public String srcIdClassName;

	public String getSrcIdClassName() {
		return srcIdClassName;
	}

	public void setSrcIdClassName(String srcIdClassName) {
		this.srcIdClassName = srcIdClassName;
	}

	public void setIdClassName(String idClassName) {
		this.idClassName = idClassName;
	}

	/**
	 *是否列表
	 */
	private String isList;

	public String getIsList() {
		return isList;
	}

	public void setIsList(String isList) {
		this.isList = isList;
	}

	/**
	 * 主关键字，一般是LOAN_NO
	 */
	private String KeyField = "loanNo";

	/**
	 * 业务流水字段
	 */
	private String txLogSeqFieldName = "txLogSeq";

	public String getTxLogSeqFieldName() {
		return txLogSeqFieldName;
	}

	public void setTxLogSeqFieldName(String txLogSeqFieldName) {
		this.txLogSeqFieldName = txLogSeqFieldName;
	}

	/**
	 * 结果是否列表
	 */
	private boolean resultIsList = false;

	public String getKeyField() {
		return KeyField;
	}

	public void setKeyField(String keyField) {
		KeyField = keyField;
	}

	public boolean isResultIsList() {
		return resultIsList;
	}

	public void setResultIsList(boolean resultIsList) {
		this.resultIsList = resultIsList;
	}

	public String getCancelFieldName() {
		return cancelFieldName;
	}

	public void setCancelFieldName(String cancelFieldName) {
		this.cancelFieldName = cancelFieldName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getHistTableName() {
		return histTableName;
	}

	public void setHistTableName(String histTableName) {
		this.histTableName = histTableName;
	}

	public CancelType getCancelTyp() {
		return cancelTyp;
	}

	public void setCancelTyp(CancelType cancelTyp) {
		this.cancelTyp = cancelTyp;
	}

	@Override
	public String toString() {
		return "TradeCancelCfgTrans [cancelFieldName=" + cancelFieldName
				+ ", cancelTyp=" + cancelTyp + ", histTableName="
				+ histTableName + ", tableName=" + tableName + "]";
	}

}
