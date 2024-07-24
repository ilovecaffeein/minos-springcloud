package com.caxs.minos.serv.db;

/**
 * @ClassName: CopyAdjustTablesToHis
 * 拷贝历史相关的表导历史表
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public interface ICopyAdjustTablesToHisService {
    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void toHis(String loanNo,  long sequence) ;
    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void copyLmLoanToHis(String loanNo, long sequence);
    /**
     * @ClassName: ToLmLoan
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void copyHisToLmLoan(String loanNo, long sequence);
    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void copyLmPmShdToHis(String loanNo, long sequence);
    /**
     * @ClassName: ToLmPmShd
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void copyHisToLmPmShd(String loanNo, long sequence);
    /**
     * @ClassName: toHis
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void copyLmLnShdMtdToHis(String loanNo, long sequence);
    /**
     * @ClassName: ToLmLnShdMtd
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void copyHisToLmLnShdMtd(String loanNo, long sequence);
    /**
     * @ClassName: ToLmLnShdMtd
     * 拷贝历史相关的表导历史表
     * @Author: coffee
     * @Date: 2020/7/29 10:40
     * @Version: v1.0 文件初始创建
     */
    void copyLmHoldShdToHis(String loanNo, long sequence);
}
