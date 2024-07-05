package com.caxs.minos.serv.core;

/**
 * Created by lenovo on 2020/9/21.
 */
public class CoreConst {
    /**
     * 文件的列分隔符
     */
    public static final String COLUMN_SEPERATOR = "|";
    /**
     * 核心访问的默认目录,可以通过设置CoreSystemimp来修改。 注意这个没有作为常量处理，不要误解
     */
    public static String FILE_DIRECTORY = "E:\\";
    // 文件字符
    public static final String FILE_CHARSET = "gbk";
    // 文件字符
    public static final String FILE_CHARUTF = "UTF-8";
    // 核心返回结果
    public static final String CORE_RESULT_SUCCESS = "FIN0000";
    // 表外
    public static final String TABLE_EXTERNAL = "2";
    // 表内
    public static final String TABLE_INTERNAL = "1";
    // 保留小数
    public static int DEFAULT_INTEREST_DIGTIAL_COUNT = 2;

    /**
     * 日终任务处理流程
     */
    /***********************************************************************/
    /*
	 * 日终初始化
	 */
    public static final String LNAM = "LoanRunForBeginDayBatcher";
    /*
     * 核算内部信息更新
     */
    public static final String LNAO = "LoanInteriorInfoModifyBatcher";
    /*
     * 贷款停息
     */
    public static final String LN12 = "LoanSuspensionBatcher";
    /*
     * 贷款自动扣款
     */
    public static final String LNAF = "LoanPayReadyBatcher";
}
