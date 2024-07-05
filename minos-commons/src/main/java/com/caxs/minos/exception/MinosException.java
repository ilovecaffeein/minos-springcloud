package com.caxs.minos.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MinosException
 * @Description:
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class MinosException extends RuntimeException {
    private static final Log log = LogFactory.getLog(MinosException.class); //打印日志属性

    //表示服务调用成功
    public static final String ERROR00000 = "00000";
    //表示调用没有注册的服务
    public static final String ERROR10001 = "10001";
    //表示调用服务所对应的渠道不正确
    public static final String ERROR10002 = "10002";
    //表示调用服务所对应的渠道报文保存异常
    public static final String ERROR20001 = "20001";
    //表示调用服务所对应的渠道不正确
    public static final String ERROR10003 = "10003";
    //表示调用服务所对应的其它
    public static final String ERROR90000 = "90000";
    //表示核算系统内部错误
    public static final String ERROR99999 = "99999";
    //表示数据验证错误
    public static final String ERROR90001 = "90001";
    //表示数据验证错误
    public static final String ERROR90002 = "90002";
    //表示日终状态禁止交易
    public static final String ERROR90003 = "90003";
    //表示空数据错误
    public static final String ERROR90004 = "90004";

    private String errCode; // 错误码

    //错误信息map
    private static Map<String, String> errs = null;

    static {
        errs = new HashMap<String, String>();
        errs.put(ERROR00000, "服务调用成功");
        errs.put(ERROR10001, "调用没有注册的服务");
        errs.put(ERROR10002, "调用服务所对应的渠道不正确");
        errs.put(ERROR20001, "调用服务所对应的渠道报文保存异常");
        errs.put(ERROR10003, "调用服务所对应的渠道不正确");
        errs.put(ERROR90000, "调用服务所对应的其它");
        errs.put(ERROR99999, "核算系统内部错误");
        errs.put(ERROR90001, "数据验证错误");
        errs.put(ERROR90003, "系统状态禁止交易");
        errs.put(ERROR90004, "查询无数据");

    }

    //错误码
    private String code;
    //错误信息
    private String msg;
    //获取错误码
    public String getCode() {
        return code;
    }
    //赋值错误码
    public void setCode(String code) {
        this.code = code;
    }
    //获取错误信息
    public String getMsg() {
        return msg;
    }
    //设置错误信息
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取错误码
     *
     * @return
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * 设置错误码
     *
     * @param errCode
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * 序列号
     */
    private static final long serialVersionUID = -2332975704789408379L;

    /**
     * 系统异常构造函数
     *
     * @param message
     * @param cause
     * @param errCode
     */
    public MinosException(String message, Throwable cause, String errCode) {
        super(message, cause);
        this.setCode(errCode);
        log.error(message, cause);
    }

    /**
     * 系统异常构造函数
     *
     * @param message
     * @param errCode
     */
    public MinosException(String message, String errCode) {
        super(message);
        log.error(message);
    }

    /**
     * 系统异常构造函数
     *
     * @param message
     * @param cause
     */
    public MinosException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    /**
     * 系统异常构造函数
     *
     * @param message
     * @param cause
     */
    public MinosException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.setCode(errorCode);
        log.error(message, cause);
    }

    /**
     * 系统异常构造函数
     *
     * @param message
     */
    public MinosException(String message) {
        super(message);
        log.error(message);
    }

    /**
     * 系统异常构造函数
     *
     * @param cause
     */
    public MinosException(Throwable cause) {
        super(cause);
        log.error(cause);
    }
}
