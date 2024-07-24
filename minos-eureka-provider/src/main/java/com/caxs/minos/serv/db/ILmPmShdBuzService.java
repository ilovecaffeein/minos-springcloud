package com.caxs.minos.serv.db;

import java.util.List;
import com.yuchengtech.ycloans.buz.domain.ShdMtd;
import com.yuchengtech.ycloans.buz.payment.shd.GenShdInfoQuery;
import com.yuchengtech.ycloans.buz.payment.shd.Shd;
public interface ILmPmShdBuzService {
	/**
	 * 还款计划试算
	 * 增加参数
	 * @param genShdInfo
	 * @param shdMtdList
	 * @return
	 */
	public List<Shd> shdPreview(GenShdInfoQuery genShdInfo, List<ShdMtd> shdMtdList);
}