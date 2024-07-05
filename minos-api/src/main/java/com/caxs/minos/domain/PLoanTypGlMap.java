package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * 该表定义信贷系统的品种与核算中定义的品种的对应关系
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class PLoanTypGlMap implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 贷款品种代码
取值为P_LOAN_TYP.TYP_CDE
	 */
	private String typCde;
	/**
	 * 核算类型
核算类型，取值为s_com_cde.com_typ='GL_LOAN_TYP'
	 */
	private String acctRoleCde;
	/**
	 * 核算类型描述
核算类型，取值为s_com_cde.com_typ='GL_LOAN_TYP'对应的描述
	 */
	private String acctRoleDesc;
	/**
	 * 核算规则代码
取值为P_LOAN_TYP_GL.TYP_GL
	 */
	private String typGl;
	/**
	 * 最新变更时间
	 */
	private String lastChgDt;
	/**
	 * 最新变更用户
	 */
	private String lastChgUsr;

	/**
	 * 设置：贷款品种代码
取值为P_LOAN_TYP.TYP_CDE
	 */
	public void setTypCde(String typCde) {
		this.typCde = typCde;
	}
	/**
	 * 获取：贷款品种代码
取值为P_LOAN_TYP.TYP_CDE
	 */
	public String getTypCde() {
		return typCde;
	}
	/**
	 * 设置：核算类型
核算类型，取值为s_com_cde.com_typ='GL_LOAN_TYP'
	 */
	public void setAcctRoleCde(String acctRoleCde) {
		this.acctRoleCde = acctRoleCde;
	}
	/**
	 * 获取：核算类型
核算类型，取值为s_com_cde.com_typ='GL_LOAN_TYP'
	 */
	public String getAcctRoleCde() {
		return acctRoleCde;
	}
	/**
	 * 设置：核算类型描述
核算类型，取值为s_com_cde.com_typ='GL_LOAN_TYP'对应的描述
	 */
	public void setAcctRoleDesc(String acctRoleDesc) {
		this.acctRoleDesc = acctRoleDesc;
	}
	/**
	 * 获取：核算类型描述
核算类型，取值为s_com_cde.com_typ='GL_LOAN_TYP'对应的描述
	 */
	public String getAcctRoleDesc() {
		return acctRoleDesc;
	}
	/**
	 * 设置：核算规则代码
取值为P_LOAN_TYP_GL.TYP_GL
	 */
	public void setTypGl(String typGl) {
		this.typGl = typGl;
	}
	/**
	 * 获取：核算规则代码
取值为P_LOAN_TYP_GL.TYP_GL
	 */
	public String getTypGl() {
		return typGl;
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
}
