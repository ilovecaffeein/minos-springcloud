package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/9/30.
 */
public class FtpConfigTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    private String user; //用户名
    private String password;	//密码
    private Integer port;	//端口
    private String ipAddr;	//ip地址
    private Integer mailBox;	//
    private Integer grpId;


    public Integer getGrpId() {
        return grpId;
    }

    public void setGrpId(Integer grpId) {
        this.grpId = grpId;
    }

    public Integer getMailBox() {
        return mailBox;
    }

    public void setMailBox(Integer mailBox) {
        this.mailBox = mailBox;
    }

    /**
     * ftp虚拟目录
     */
    private String directory;
    //获取用户名
    public String getUser() {
        return user;
    }
    //设置用户名
    public void setUser(String user) {
        this.user = user;
    }
    //获取密码
    public String getPassword() {
        return password;
    }
    //设置密码
    public void setPassword(String password) {
        this.password = password;
    }
    //获取端口
    public Integer getPort() {
        return port;
    }
    //设置端口
    public void setPort(Integer port) {
        this.port = port;
    }
    //获取ip地址
    public String getIpAddr() {
        return ipAddr;
    }
    //设置ip地址
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
    //获取ftp虚拟目录
    public String getDirectory() {
        return directory;
    }
    //设置ftp虚拟目录
    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
