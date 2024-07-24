package com.caxs.minos.cfs2minos;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.utils.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.math.BigDecimal;
/***
 * @ClassName(类名) : check
 * @Description(描述) : 业务处理
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class Cfs2MinosBuzCheck {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    /**
     * 返回金额
     */
    public double getDeAmt(BigDecimal str) throws Cfs2MinosException {
        try {
            return SystemUtils
                    .getDoubleWhenEvenUp(str.doubleValue());

        } catch (Exception e) {
            throw new Cfs2MinosException(Cfs2MinosException.ERROR99999,
                    "将String 类型的值[" + str + "]转换成double失败，请检查程序"
                            + e.getMessage());
        }
    }

    /**
     * 返回金额
     */
    public double getAmt(Object str) throws Cfs2MinosException {
        try {
            return SystemUtils
                    .getDoubleWhenEvenUp(Double.valueOf((String) str));

        } catch (Exception e) {
            throw new Cfs2MinosException(Cfs2MinosException.ERROR99999,
                    "将String 类型的值[" + str + "]转换成double失败，请检查程序"
                            + e.getMessage());
        }
    }

    /** 返回利率 */
    public double getRate(Object rate) throws Cfs2MinosException {
        return SystemUtils.getBigDecimal(Double.valueOf(String.valueOf(rate)),
                MinosConst.DEFAULT_INT_RATE_DIGTIAL_COUNT + 1).doubleValue();
    }

}
