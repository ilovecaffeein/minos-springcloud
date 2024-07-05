package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.SCtrlDao;
import com.caxs.minos.domain.SCtrl;
import com.caxs.minos.serv.db.ISystemInitService;
import com.caxs.minos.utils.DateOperation;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/***
 * @ClassName(类名) : SystemInitService
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/25 14:33
 */
@Component
@Service
public class SystemInitService implements ISystemInitService {
    @Reference
    private SCtrlDao sCtrlDao;

    /**
     * 在这里初始化
     */
    @Override
    public void findInit() {

    }

    /**
     * 返回业务时间
     *
     * @return
     */
    @Override
    public String findBuzDate() {
        return sCtrlDao.selectListByObject(new SCtrl()).get(0).getCurPrcsDt();
    }

    /**
     * 返回业务时间
     *
     * @return
     */
    @Override
    public String findSysTemDate() {
        return DateOperation.getDateStringToDb();
    }
}
