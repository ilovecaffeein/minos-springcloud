package com.caxs.minos.exception;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName: Cfs2MinosException
 * @Description: 接口请求异常类
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class Cfs2MinosException extends Exception {
	//序列号
	private static final long serialVersionUID = 1L;
	
	//接口请求异常构造函数
	public Cfs2MinosException(String errCode) {
		String msg = StringUtils.isEmpty(errs.get(errCode)) ? errs.get("99999")
				: errs.get(errCode);
		this.setCode(errCode);
		this.setMsg(msg);
	}
	//接口请求异常构造函数
	public Cfs2MinosException(String errCode, String msg) {
		this.setCode(errCode);
		this.setMsg(msg);
	}
	
	public Cfs2MinosException(String errCode, String msg, Throwable e) {
		super(msg,e);
		this.setCode(errCode);
		this.setMsg(msg);
	}
	//错误信息map
	private static Map<String, String> errs = null;
	//表示服务调用成功
	public final static String ERROR0000 = "0000";
	//表示服务调用成功
	public final static String ERROR00000 = "00000";
	//表示服务调用成功
	public final static String ERROR000000 = "000000";
	//表示调用没有注册的服务
	public final static String ERROR10001 = "10001";
	//表示调用服务所对应的渠道不正确
	public final static String ERROR10002 = "10002";
	//表示调用服务所对应的渠道报文保存异常
	public final static String ERROR20001 = "20001";
	//表示调用服务所对应的渠道不正确
	public final static String ERROR10003 = "10003";
	//表示调用服务所对应的其它
	public final static String ERROR90000 = "90000";
	//表示核算系统内部错误
	public final static String ERROR99999 = "99999";
	//表示数据验证错误
	public final static String ERROR90001 = "90001";
	public final static String ERROR90002 = "90002";
	
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
}
