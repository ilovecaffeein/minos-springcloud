package com.caxs.minos.domain;

import java.math.BigDecimal;

/***
 * @ClassName(类名) : TxLogNoNextValDual
 * @Description(描述) : 生成lm_Gl_no_Log表中的tx_log_no流水号字段
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/14 15:43
 */
public class TxLogNoNextValDual {
    private static final long serialVersionUID = 1L;
    private BigDecimal nextVal;

    public BigDecimal getNextVal() {
        return nextVal;
    }
    public void setNextVal(BigDecimal nextVal) {
        this.nextVal = nextVal;
    }
}
