package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.domain.*;
import com.caxs.minos.serv.db.ICopyAdjustTablesToHisService;
import com.caxs.minos.utils.SystemUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName: CopyAdjustTablesToHisService
 * 历史数据备份
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
@Component
@Service
public class CopyAdjustTablesToHisService implements ICopyAdjustTablesToHisService {
    @Resource
    private LmLnShdMtdHistDao lmLnShdMtdHistDao;
    @Resource
    private LmLnShdMtdDao lmLnShdMtdDao;
    @Resource
    LmLoanDao lmLoanDao;
    @Resource
    LmLoanHistDao lmLoanHistDao;
    @Resource
    LmPmShdHistDao lmPmShdHistDao;
    @Resource
    LmPmShdDao lmPmShdDao;
    @Resource
    LmHoldInfoDao lmHoldInfoDao;
    @Resource
    LmHoldShdDao lmHoldShdDao;
    @Resource
    LmHoldShdHistDao lmHoldShdHistDao;

    //拷贝历史数据构造方法
    public CopyAdjustTablesToHisService(){
    }

    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void toHis(String loanNo,  long sequence) {
        this.copyLmLoanToHis(loanNo,sequence);
        this.copyLmPmShdToHis(loanNo,sequence);
        this.copyLmLnShdMtdToHis(loanNo,sequence);
    }

    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void copyLmLoanToHis(String loanNo, long sequence) {
        LmLoanHist loanHist = new LmLoanHist();

        try {
            LmLoan  lmLoan =lmLoanDao.findByLoanNo(loanNo);
            SystemUtils.copyProperties(lmLoan, loanHist);
            loanHist.setTxLogSeq(sequence);
            lmLoanHistDao.insert(loanHist);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * @ClassName: ToLmLoan
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void copyHisToLmLoan(String loanNo, long sequence) {
        LmLoan loan = new LmLoan();
        try {
            LmLoanHist lmLoanHist =new LmLoanHist();
            lmLoanHist.setTxLogSeq(sequence);
            lmLoanHist.setLoanNo(loanNo);
            lmLoanHist =lmLoanHistDao.selectOneByObject(lmLoanHist);
            SystemUtils.copyProperties(lmLoanHist, loan);
            lmLoanDao.insert(loan);
        } catch (RuntimeException re) {
            throw re;
        }
    }


    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void copyLmPmShdToHis(String loanNo, long sequence) {
        int i = 0;
        LmPmShd  lmPmShdT =new LmPmShd();
        lmPmShdT.setLoanNo(loanNo);
        List<LmPmShd> lmPmShdList =lmPmShdDao.selectListByObject(lmPmShdT);
        for (LmPmShd lmPmShd : lmPmShdList) {
            LmPmShdHist lmPmShdHist = duplicateLmPmShd(lmPmShd, sequence,
                    loanNo, ++i);
            lmPmShdHistDao.insert(lmPmShdHist);
        }
    }

    /**
     * @ClassName: ToLmPmShd
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void copyHisToLmPmShd(String loanNo, long sequence) {
        LmPmShdHist LmPmShdHistT =new LmPmShdHist();
        LmPmShdHistT.setLoanNo(loanNo);
        List<LmPmShdHist> lmPmShdList =lmPmShdHistDao.selectListByObject(LmPmShdHistT);
        List<LmPmShd> LmPmShdList = new ArrayList<LmPmShd>();
        for (LmPmShdHist lmPmShdHist : lmPmShdList) {
            LmPmShd LmPmShd =new LmPmShd();
            SystemUtils.copyProperties(lmPmShdHist, LmPmShd);
            LmPmShdList.add(LmPmShd);
        }
        for (LmPmShd LmPmShd : LmPmShdList) {
            lmPmShdDao.insert(LmPmShd);
        }
    }

    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void copyLmLnShdMtdToHis(String loanNo, long sequence) {
        LmLnShdMtd  lmLnShdMtdT =new LmLnShdMtd();
        lmLnShdMtdT.setLoanNo(loanNo);
        List<LmLnShdMtd> lmLnShdMtdList = lmLnShdMtdDao.selectListByObject(lmLnShdMtdT);
        List<LmLnShdMtdHist> lmLnShdMtdHistList = new ArrayList<LmLnShdMtdHist>();
        for (LmLnShdMtd lmLnShdMtd : lmLnShdMtdList) {
            LmLnShdMtdHist lmLnShdMtdHist = duplicateLmLnShdMtd(lmLnShdMtd,
                    sequence);
            lmLnShdMtdHistList.add(lmLnShdMtdHist);
        }
        for (LmLnShdMtdHist mtd : lmLnShdMtdHistList) {
            lmLnShdMtdHistDao.insert(mtd);
        }
    }

    /**
     * @ClassName: ToLmLnShdMtd
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void copyHisToLmLnShdMtd(String loanNo, long sequence) {
        LmLnShdMtdHist lmLnShdMtdHistT =new LmLnShdMtdHist();
        lmLnShdMtdHistT.setLoanNo(loanNo);
        List<LmLnShdMtdHist> lmLnShdMtdHistList = lmLnShdMtdHistDao.selectListByObject(lmLnShdMtdHistT);
        List<LmLnShdMtd> lmLnShdMtdList = new ArrayList<LmLnShdMtd>();
        for (LmLnShdMtdHist lmLnShdMtdHist : lmLnShdMtdHistList) {
            LmLnShdMtd lmLnShdMtd =new LmLnShdMtd();
            SystemUtils.copyProperties(lmLnShdMtdHist, lmLnShdMtd);
            lmLnShdMtdList.add(lmLnShdMtd);
        }
        for (LmLnShdMtdHist mtd : lmLnShdMtdHistList) {
            lmLnShdMtdHistDao.insert(mtd);
        }
    }

    /**
     * @ClassName: ToHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    @Override
    public void copyLmHoldShdToHis(String loanNo, long sequence) {
        LmHoldShd lmHoldShd =new LmHoldShd();
        lmHoldShd.setLoanNo(loanNo);
        List<LmHoldShd> lmHoldShdList =lmHoldShdDao.selectListByObject(lmHoldShd);
        List<LmHoldShdHist> ShdHistList = new ArrayList<LmHoldShdHist>();
        int i = 0;
        for (LmHoldShd lmShdMtd : lmHoldShdList) {
            LmHoldShdHist lmLnShdMtdHist = this.LmHoldShdToHis(lmShdMtd, sequence,i++);
            ShdHistList.add(lmLnShdMtdHist);
        }
        for (LmHoldShdHist lmHoldShdHist : ShdHistList) {
            lmHoldShdHistDao.insert(lmHoldShdHist);
        }
    }

    /**
     * 将LmPmShd对象复制为LmPmShdHdr对象
     */
    private LmPmShdHist duplicateLmPmShd(LmPmShd obj, Long seq,
                                         String accrueDate, int loop) {
        LmPmShdHist result = new LmPmShdHist();
        try {
            SystemUtils.copyProperties(obj, result);
        } catch (RuntimeException re) {
        }
        result.setSeqNo(Long.valueOf(loop));
        result.setTxNo(seq);
        result.setLoanNo(obj.getLoanNo());
        result.setPsPerdNo(Long.valueOf(obj.getPsPerdNo()));
        return result;
    }

    /**
     * 将LmPmShdHdr对象复制为LmLnShdMtdHist对象
     */
    public LmLnShdMtdHist duplicateLmLnShdMtd(LmLnShdMtd obj, Long seq) {
        LmLnShdMtdHist result = new LmLnShdMtdHist();
        try {
            SystemUtils.copyProperties(obj, result);
            result.setTxlogSeq(seq);
        } catch (RuntimeException re) {
        }
        return result;
    }

    //拷贝借据到历史表
    private LmHoldShdHist LmHoldShdToHis(LmHoldShd lmHoldShd, long sequence,int loop) {
        LmHoldShdHist lmHoldShdHsit = new LmHoldShdHist();
        try {
            SystemUtils.copyProperties(lmHoldShd, lmHoldShdHsit);
        } catch (RuntimeException re) {
        }
        lmHoldShdHsit.setSeqNo(loop);
        lmHoldShdHsit.setTxNo(sequence);
        lmHoldShdHsit.setCustId(lmHoldShd.getCustId());
        lmHoldShdHsit.setLoanNo(lmHoldShd.getLoanNo());
        lmHoldShdHsit.setPsPerdNo(lmHoldShd.getPsPerdNo());
        return lmHoldShdHsit;
    }
}
