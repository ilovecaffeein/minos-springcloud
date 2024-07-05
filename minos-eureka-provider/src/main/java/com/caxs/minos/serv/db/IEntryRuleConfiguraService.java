package com.caxs.minos.serv.db;

import com.caxs.minos.domain.PLoanMtd;
import com.caxs.minos.domain.PLoanMtdDtl;
import com.caxs.minos.domain.PLoanTypGl;
import com.caxs.minos.domain.PRpymOrdDtl;

import java.util.List;
/***
 * @ClassName(类名) : IEntryRuleConfiguraService
 * @Description(描述) :
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:56
 */
public interface IEntryRuleConfiguraService {
    /**
     * @ClassName:
     * @Description:
     * @Author: zhuruilong
     * @Date: 2020/7/29 16:28
     * @Version: v1.0 文件初始创建
     */
    List<PRpymOrdDtl> findAll(String rpymOrdSeqNo);
    /**
     * @ClassName:
     * @Description:
     * @Author: zhuruilong
     * @Date: 2020/7/29 16:28
     * @Version: v1.0 文件初始创建
     */
     PLoanTypGl findBytypGlId(String bankCde,String typCde);
    /**
     * @ClassName:
     * @Description:
     * @Author: zhuruilong
     * @Date: 2020/7/29 16:28
     * @Version: v1.0 文件初始创建
     */
     List<PLoanMtdDtl> selectAllPloanMtdDtl(PLoanMtd ploanMtd);
    /**
     * @ClassName:
     * @Description:
     * @Author: zhuruilong
     * @Date: 2020/7/29 16:28
     * @Version: v1.0 文件初始创建
     */
    PLoanMtd  selectAllPLoanMtd(PLoanMtd ploanMtd);
}

