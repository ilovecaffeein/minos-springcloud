package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;

import java.util.List;
import java.util.Map;
/**
 * @Description:  计算宽限期
 * @Author: coffee
 * @Date: 2020/7/28 14:24
 * @Version: v1.0 文件初始创建
 */
public interface IPunishCalorService {
    /**
     * 对所有期数的利息求和
     *
     * @param map
     *            可以通过函数Map<Integer, PunishIntFields> execute(LoanRateMode lrm,
     *            int dayCountYearly) 获取map
     * @return
     */
     PunishIntFieldsTrans sumAllInt(Map<Integer, PunishIntFieldsTrans> map);
    /**
     * 根据本类的execute 返回的 map数据来计算
     *
     * @param map
     * @return
     *
     */
     PunishIntFieldsTrans sumAllIntByMap(Map<Integer, PunishIntFieldsTrans> map);
    /**
     * 计算罚息 这个是执行的主方法。
     *
     *  利率模式，是Y/M/D
     * @param dayCountYearly
     * @param isCalInterest
     *            是否计算利息，如果仅需要积数，isCalInterest=false 否则=true
     * @return Map<Integer, PunishIntFields> integer是期号，PunishIntFields是计算的利息
     */
    Map<Integer, PunishIntFieldsTrans> execute(int dayCountYearly, boolean isCalInterest);
    /**
     * 计算罚息 这个是执行的主方法。
     *
     * @param newDaylyRate
     *            利率模式，是Y/M/D
     * @param dayCountYearly
     * @param isCalInterest
     *            是否计算利息，如果仅需要积数，isCalInterest=false 否则=true
     * @return Map<Integer, PunishIntFields> integer是期号，PunishIntFields是计算的利息
     */
    /**
     * 计算罚息信息
     * @param shdList
     * @param buzDate
     * @param checkGraceDay
     * @param isToPay
     * @param isToPay
     */
    Map<Integer, PunishIntFieldsTrans> execute(List<LmPmShd> shdList,
                                               String buzDate, boolean checkGraceDay, boolean isToPay,boolean isCalInterest);
}
