package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.domain.*;
import com.caxs.minos.serv.db.IEntryRuleConfiguraService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/***
 * @ClassName(类名) : EntryRuleConfiguraService
 * @Description(描述) : TODD
 * @author(作者) ： 得到还款顺序实现类
 * @date (开发日期) ： 2020/8/5 10:56
 */
@Component
@Service
public class EntryRuleConfiguraService implements IEntryRuleConfiguraService {
    @Resource
    PRpymOrdDtlDao pRpymOrdDtlDao;

    @Resource
    private PRpymOrdDao pRpymOrdDao;

    @Resource
    private PLoanTypGlDao pLoanTypGlDao;

    @Resource
    private PLoanTypGlMapDao pLoanTypGlMapDao;

    @Resource
    private PLoanMtdDao ploanMtdDao;

    @Resource
    private PLoanMtdDtlDao ploanMtdDtlDao;


    @Override
    public List<PRpymOrdDtl> findAll(String rpymOrdSeqNo){
        PRpymOrd pRpymOrd =pRpymOrdDao.selectByPrimaryKey(Integer.valueOf(rpymOrdSeqNo));
        if( pRpymOrd !=null ){
            return  pRpymOrdDtlDao.selectPRpymOrdDtl(pRpymOrd.getRpymOrdSeqNo());
        }
        return null;
    }

    @Override
    public PLoanTypGl findBytypGlId(String bankCde,String typCde){
        PLoanTypGlMap pLoanTypGlMap = pLoanTypGlMapDao.selectByPrimaryKey(typCde);
        if ( pLoanTypGlMap !=null){
            PLoanTypGl   PLoanTypGl = pLoanTypGlDao.selectByPrimaryKey(bankCde,pLoanTypGlMap.getTypGl());
            return  PLoanTypGl;
        }
        return null;
    };

    /***
     * @ClassName(类名) : PloanMtdDtlQueryImpService
     * @Description(描述) :还款方式配置信息获取
     * @param ploanMtd
     * @return List<PloanMtdDtl>
     * @author(作者) ： fengdetian
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Override
    public List<PLoanMtdDtl> selectAllPloanMtdDtl(PLoanMtd ploanMtd) {
        PLoanMtd ploanMtdt = ploanMtdDao.selectByPrimaryKey(ploanMtd);
        if (ploanMtdt != null) {
            PLoanMtdDtl ploanMtdDtl = new PLoanMtdDtl();
            ploanMtdDtl.setMtdCde(ploanMtd.getMtdCde());
            return ploanMtdDtlDao.selectAll(ploanMtdDtl);
        }
        return null;
    }

    /***
     * @ClassName(类名) : PloanMtdDtlQueryImpService
     * @Description(描述) :还款方式配置信息获取
     * @param ploanMtd
     * @return List<PloanMtdDtl>
     * @author(作者) ： fengdetian
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Override
    public PLoanMtd  selectAllPLoanMtd(PLoanMtd ploanMtd) {
        return ploanMtdDao.selectByPrimaryKey(ploanMtd);
    }
}
