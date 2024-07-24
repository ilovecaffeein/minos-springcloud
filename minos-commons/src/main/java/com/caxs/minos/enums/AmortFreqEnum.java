package com.caxs.minos.enums;

/**
 * 摊销平率
 * 
 * @author hb
 * 
 */
public enum AmortFreqEnum {
	DAY/*按天*/, MONTH_START/*每月开始*/, MONTH_END/*每月结束*/, QUART_START/*每季开始*/, QUART_END/*每季结束*/, YEAR_START/*每年开始*/, YEAR_END/*每年结束*/;
	//获取摊销频率对应的字符串
	public String getCodeInDb() {
		switch (values()[ordinal()]) {
		case DAY:
			return "D";
		case MONTH_START:
			return "MS";
		case MONTH_END:
			return "ME";
		case QUART_END:
			return "QE";
		case QUART_START:
			return "QS";
		case YEAR_START:
			return "YS";
		case YEAR_END:
			return "YE";
		}
		throw new RuntimeException("not found enum");
	}
	//获取摊销频率对应的交易码
	public static AmortFreqEnum getEnum(String AmortFreq) {
		if ("D".equals(AmortFreq)) {
			return DAY;
		}
		if ("ME".equals(AmortFreq)) {
			return MONTH_END;
		}
		if ("MS".equals(AmortFreq)) {
			return MONTH_START;
		}
		if ("QS".equals(AmortFreq)) {
			return QUART_START;
		}
		if ("QE".equals(AmortFreq)) {
			return QUART_END;
		}
		if ("YS".equals(AmortFreq)) {
			return YEAR_START;
		}
		if ("YE".equals(AmortFreq)) {
			return YEAR_END;
		}

		throw new RuntimeException("not found enum");
	}
	//转化为字符串
	@Override
	public String toString() {
		switch (values()[ordinal()]) {
		case DAY:
			return "EVERY DAY";
		case MONTH_START:
			return "MONTH_START";
		case MONTH_END:
			return "MONTH_END";
		case QUART_END:
			return "QUART_END";
		case QUART_START:
			return "QUART_START";
		case YEAR_START:
			return "YEAR_START";
		case YEAR_END:
			return "YEAR_END";
		}
		return "not found";
	}

}
