package com.caxs.minos.enums;

/**
 * 还款计划表调整选项
 * 
 * @author hb
 * 
 */
public enum PmShdAdjOptionEnum {
	INTRATE/* 调整利息 */, PAY_DAY/* 调整扣款日 */, INTRATE_AND_PAYDAY/* 调整利息和扣款日 */,NULL;
	public String getCodeInDb() {
		switch (values()[ordinal()]) {
		case INTRATE:
			return "I";
		case PAY_DAY:
			return "D";
		case INTRATE_AND_PAYDAY:
			return "ID";
		}
		throw new RuntimeException("not found enum");
	}
}
