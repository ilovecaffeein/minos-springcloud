package com.caxs.minos.dao;

import com.caxs.minos.domain.TxLogNoNextValDual;
import org.apache.ibatis.annotations.Mapper;

/***
 * @ClassName(类名) : TxLogNoNextValDualDao
 * @Description(描述) : TODD
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/14 15:42
 */
@Mapper
public interface TxLogNoNextValDualDao {

    /**查询流水号
     * @param txLogNoNextValDualDomain
     * @return
     */
    TxLogNoNextValDual findDual(TxLogNoNextValDual txLogNoNextValDualDomain);
    /**查询流水号
     * @param
     * @return
     */
     String  findNextSeqNo();
    /**查询流水号
     * @param
     * @return
     */
     String  findPayPkgSeq();
}
