package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.FtpConfigTrans;

/***
 * @ClassName(类名) : IFileSourceService
 * @Description(描述) : ftp文件链接
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 11:25
 */
public interface IFileSourceService {
    /**
     * 设置参数
     * @return
     */
    void setFtpConfig(FtpConfigTrans ftpConfig);
    /**
     * 拷贝文件到目录
     * @param remoteFileName
     * @param remoteFileDir
     * @param localFileName
     * @param localFileDir
     * @return
     */
    public abstract boolean copyFileTo(String remoteFileName,String remoteFileDir,
                                       String localFileName,String localFileDir);

    /**
     * 拷贝远程文件到目录。
     * @param remoteFileName
     * @param remoteFileDir
     * @param localFileName
     * @param localFileDir
     * @return
     */
    public abstract boolean copyFileFrom(String remoteFileName,String remoteFileDir,
                                         String localFileName,String localFileDir);
}
