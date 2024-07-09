package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.domain.LmPmShd;
import java.math.BigDecimal;
/**
 * @ClassName: ILoanRelateInterestCalcService
 * @Description: 当前剩余本金利息计算器
 * @Author: coffee
 * @Date: 2020/8/4 15:46
 * @Version: v1.0 文件初始创建
 */
public interface ILoanRelateInterestCalcService {
    /**
     * @ClassName:
     * @Description: 当前剩余本金利息计算器构造方法
     * @Author: coffee
     * @Date: 2020/7/29 16:28
     * @Version: v1.0 文件初始创建
     */
     void getLoanRelateInterestCalc(LmLoanCont lmLoanCont, LmLoan lmloan, LmPmShd interestShd,
                                LmPmShd curDueShd, String buzDate,boolean hasLastDateInterest);
     /**
     * @ClassName:
     * @Description: 计算利息
     * @Author: coffee
     * @Date: 2020/7/29 16:28
     * @Version: v1.0 文件初始创建
     */
     BigDecimal cal();
}
