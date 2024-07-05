package com.caxs.minos.enums;

/**
 * @ClassName: ATPYExpStateEnum
 * @Description: 扣款任务完成
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public enum ATPYExpStateEnum {

	STR/*开始*/, FILEEND/*结束*/, ERROR/*错误*/;
	//扣款处理状态对应字符串
	public String getCodeInDb() {
		switch (values()[ordinal()]) {
		case STR:
			return "STR";
		case FILEEND:
			return "FIN";
		case ERROR:
			return "ERR";
		}
		throw new RuntimeException("not found enum");
	}
}
