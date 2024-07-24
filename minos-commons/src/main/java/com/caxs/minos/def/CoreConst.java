package com.caxs.minos.def;

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
    /*
     * 日终单笔批量扣款
     */
    public static final String LPKK = "LoanTopayIrSingleBatcher";
    /*
     * 日终单笔批量扣款查询
     */
    public static final String LNBS = "LoanTopayIrSingleResultBatcher";
    /*
     * 贷款自动入账
     */
    public static final String LNCQ = "LoanPaymentBatcher";
    /*
     * 贷款滞纳金结记
     */
    public static final String LNLF = "LoanCalculateLateFeeBatcher";
    /*
     * 超过90天形态转移
     */
    public static final String LNAN = "LoanTransChgStatBatcher";
    /*
     * 滚积数
     */
    public static final String LNJS = "LoanNumberOfRollingBatcher";
    /*
     * 正常利息计提
     */
    public static final String LNAE = "LoanNormIntAccrualBatcher";
    /*
     * 逾期利息计提
     */
    public static final String LNBX = "LoanOverdueIntAccrualBatcher";
    /*
     * 金额摊销
     */
    public static final String LNTX = "LoanAmountAccBatcher";
    /*
     * 合并日间总账
     */
    public static final String LNHZ = "LoanAccountingFacadeBatcher";
    /*
     * 日终机构总账内部合并
     */
    public static final String LNA2 = "LoanAccountingFacadeOsBatcher";
    /*
     * 每日扣款统计短信通知
     */
    public static final String KKTZ = "LoanDailyDeductionNotifiBatcher";
    /*
     * 核算系统换日(该步骤序号不可调整)
     */
    public static final String LNAT = "LoanSystemChangeDateBatcher";
    /*
     * 贷款结息 -正常利息结息
     */
    public static final String LNAB = "LoanInterestEverydayBatcher";
    /*
     * 贷款结息- 罚息及复利结息
     */
    public static final String LNAA = "LoanAccrualEverydayBatcher";
    /*
     * 日始完成
     */
    public static final String BEND = "LoanBFinishBatcher";
}
