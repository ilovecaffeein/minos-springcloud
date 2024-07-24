package com.caxs.minos.enums;

import com.caxs.minos.def.CoreConst;
import com.caxs.minos.exception.MinosException;
/**
 * @ClassName: BatcherCode
 * @Description: 日终作业函数
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum BatcherCodeEnum {
    LNAM, // 日终初始化
    LNAO, // 核算内部信息更新
    LN12, // 贷款展期
    STARNDARD, NULL,
    LNAF, // 贷款自动扣款
    LNLF, // 贷款滞纳金结记
    LPKK, // 日终单笔批量扣款
    LNBS, // 日终单笔批量扣款查询
    LNCQ, // 贷款自动入账
    LNAN, // 超过90天形态转移
    LNJS, // 滚积数
    LNAE, // 正常利息计提
    LNBX, // 逾期利息计提
    LNTX, // 金额摊销
    LNHZ, // 合并日间总账
    LNA2, // 日终机构总账内部合并
    KKTZ, // 每日扣款统计短信通知
    LNAT, // 核算系统换日(该步骤序号不可调整)
    LNAB, // 贷款结息 -正常利息结息
    LNAA, // 贷款结息- 罚息及复利结息
    BEND; // 日始完成
    /**
     * 返回字符串编码
     * @return
     */
    public String getCode() {
        switch (values()[ordinal()]) {
            case LNAM:
                return "LNAM";
            case LNAO:
                return "LNAO";
            case LN12:
                return "LN12";
            case LNAF:
                return "LNAF";
            case LPKK:
                return "LPKK";
            case LNBS:
                return "LNBS";
            case LNCQ:
                return "LNCQ";
            case LNLF:
                return "LNLF";
            case LNAN:
                return "LNAN";
            case LNJS:
                return "LNJS";
            case LNAE:
                return "LNAE";
            case LNBX:
                return "LNBX";
            case LNTX:
                return "LNTX";
            case LNHZ:
                return "LNHZ";
            case LNA2:
                return "LNA2";
            case KKTZ:
                return "KKTZ";
            case LNAT:
                return "LNAT";
            case LNAB:
                return "LNAB";
            case LNAA:
                return "LNAA";
            case BEND:
                return "BEND";
        }
        throw new MinosException("not found");
    }

    /**
     * 获取对应交易处理类路径
     * @return
     */
    public String getWholePath(String key) {
        String head = "com.caxs.minos.batch.";
        if ("LNAM".equals(key)) {
            return head + CoreConst.LNAM;
        }
        if ("LNAO".equals(key)) {
            return head + CoreConst.LNAO;
        }
        if ("LN12".equals(key)) {
            return head + CoreConst.LN12;
        }
        if ("LNAF".equals(key)) {
            return head + CoreConst.LNAF;
        }
        if ("LPKK".equals(key)) {
            return head + CoreConst.LPKK;
        }
        if ("LNBS".equals(key)) {
            return head + CoreConst.LNBS;
        }
        if ("LNCQ".equals(key)) {
            return head + CoreConst.LNCQ;
        }
        if ("LNLF".equals(key)) {
            return head + CoreConst.LNLF;
        }
        if ("LNAN".equals(key)) {
            return head + CoreConst.LNAN;
        }
        if ("LNJS".equals(key)) {
            return head + CoreConst.LNJS;
        }
        if ("LNAE".equals(key)) {
            return head + CoreConst.LNAE;
        }
        if ("LNBX".equals(key)) {
            return head + CoreConst.LNBX;
        }
        if ("LNTX".equals(key)) {
            return head + CoreConst.LNTX;
        }
        if ("LNHZ".equals(key)) {
            return head + CoreConst.LNHZ;
        }
        if ("LNA2".equals(key)) {
            return head + CoreConst.LNA2;
        }
        if ("KKTZ".equals(key)) {
            return head + CoreConst.KKTZ;
        }
        if ("LNAT".equals(key)) {
            return head + CoreConst.LNAT;
        }
        if ("LNAB".equals(key)) {
            return head + CoreConst.LNAB;
        }
        if ("LNAA".equals(key)) {
            return head + CoreConst.LNAA;
        }
        if ("BEND".equals(key)) {
            return head + CoreConst.BEND;
        }
        throw new MinosException("not found");
    }
}
