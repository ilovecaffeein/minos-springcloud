package com.caxs.minos.enums;

import com.caxs.minos.exception.MinosException;

/***
 * @ClassName(类名) : BranchLevelEnum
 * @Description(描述) : 机构分类
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/19 17:25
 */
public enum BranchLevelEnum {
    HEAD/*一级*/, BRANCH/*二级*/, SUBBRANCH/*三级*/;
    //获取分支级别对应的字符
    public String getCodeInDb() {
        switch (values()[ordinal()]) {
            case HEAD:
                return "1";
            case BRANCH:
                return "2";
            case SUBBRANCH:
                return "3";
        }
        throw new RuntimeException("not found enum");
    }
    //获取分支级别对应的枚举值
    public static BranchLevelEnum  getEnum(int branchLevel) {
        switch (branchLevel) {
            case 1:
                return HEAD;
            case 2:
                return BRANCH;
            case 3:
                return SUBBRANCH;
        }
        throw new MinosException("没有找到的Enum:" + branchLevel);
    }
}
