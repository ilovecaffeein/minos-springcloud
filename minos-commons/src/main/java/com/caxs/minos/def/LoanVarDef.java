package com.caxs.minos.def;

/**
 * 常量定义
 *
 * @author renee
 * @date 2014-11-12 下午03:07:23
 * @Copyright yuchengtech
 * @version 2.0
 */
public class LoanVarDef {
    /**
     * B 扣款日前一天 C扣款日结息
     */
    public final static String calcOdTimeTyp = "C";

    /** 插入操作类型 */
    public final static String OP_TYP_INSERT = "INSERT";

    /** 更新操作类型 */
    public final static String OP_TYP_UPDATE = "UPDATE";

    /** 删除操作类型 */
    public final static String OP_TYP_DELETE = "DELETE";

    /** 还款计划扣款日调整 */
    public static final String ADJ_TYP_1 = "1";

    /** 还款计划利率调整 */
    public static final String ADJ_TYP_2 = "2";

    /** 还款计划期数调整 */
    public static final String ADJ_TYP_3 = "3";
    /** 还款计划还款方式调整 */
    public static final String ADJ_TYP_4 = "4";
    /** 还款计划还款方式调整 */
    public static final String ADJ_TYP_5 = "5";
    /** 系统参数加载-核算规则 */
    public static final String OPT_GL_RULE = "GL_RULE";
    /** 系统参数加载-核算产品规则映射 */
    public static final String OPT_GL_MAP = "GL_MAP";
    /** 系统参数加载-还款顺序 */
    public static final String OPT_PAYM_ORD = "PAYM_ORD";
    /** 系统参数加载-会计科目 */
    public static final String OPT_GL_ACCT = "GL_ACCT";
    /** 系统参数加载-会计分录 */
    public static final String OPT_GL_SETUP = "GL_SETUP";

    /** ------ 交易码常量定义------ */

    final public static String QCCX = "QCCX";

    final public static String PKCX = "PKCX";

    /** 抵质押品入库记账 */
    final public static String LNC1 = "LNC1";

    /** 抵质押品出库销账 */
    final public static String LNC2 = "LNC2";

    /** 贷款发放 */
    final public static String LNC3 = "LNC3";

    /** 贷款还款 */
    final public static String LNC4 = "LNC4";

    /** 中原银行主动扣款 */
    final public static String LNZY = "LNZY";

    /** 中原银行提前结清金额查询 */
    final public static String ZYCH = "ZYCH";

    /** 中原银行提前结清 */
    final public static String ZYFS = "ZYFS";

    /** 中原银行代收付资金清算*/
    final public static String ZYSF = "ZYSF";

    /** 九江银行银行提前结清*/
    final public static String JJFS = "JJFS";

    /** 九江银行代收付资金清算*/
    final public static String JJSF = "JJSF";

    /** 百信银行代收付资金清算*/
    final public static String BXSF = "BXSF";

    /** 百信银行主动还款金额*/
    final public static String BXFS = "BXFS";

    /** 中原银行自动扣款数据生成 */
    final public static String LAZY = "LAZY";

    /** 中原贷款自动扣款入账 */
    final public static String LAZH = "LAZH";

    /** 日间贷款自动扣款（针对日间还款日跑扣款） */
    final public static String RJAF = "RJAF";

    /** 日间贷款自动扣款入账（针对日间还款日跑扣款） */
    final public static String RJRZ = "RJRZ";

    /** 解析批扣结果文件 */
    final public static String LPXZ = "LPXZ";

    /** 贷款呆账核销 */
    final public static String LNC5 = "LNC5";

    /** 已核销贷款收回 */
    final public static String LNC6 = "LNC6";

    /** 贷款平移 */
    final public static String LNC7 = "LNC7";

    /** 贷款利息调整 */
    final public static String LNC8 = "LNC8";

    /** 贴现发放 */
    final public static String LNC9 = "LNC9";

    /** 贴现收回 */
    final public static String LNCA = "LNCA";

    /** 系统内买断式转贴现 */
    final public static String LNCB = "LNCB";

    /** 系统内回购式转贴现 */
    final public static String LNCC = "LNCC";

    /** 系统外买断式转贴现转入 */
    final public static String LNCD = "LNCD";

    /** 系统外买断式转贴现转出 */
    final public static String LNCE = "LNCE";

    /** 再贴现 */
    final public static String LNCF = "LNCF";

    /** 卖断式卖出 */
    final public static String LNCG = "LNCG";

    /** 买断式买入 */
    final public static String LNCH = "LNCH";

    /** 银行承兑汇票出票 */
    final public static String LNCI = "LNCI";

    /** 银行承兑汇票注销 */
    final public static String LNCJ = "LNCJ";

    /** 银行承兑汇票未用退回 */
    final public static String LNCK = "LNCK";

    /** 银行承兑汇票付款 */
    final public static String LNCL = "LNCL";

    /** 开出保函 */
    final public static String LNCM = "LNCM";

    /** 保函还款 */
    final public static String LNCN = "LNCN";

    /** 保函结清 */
    final public static String LNCO = "LNCO";

    /** 减值贷款月末计提 */
    final public static String LNCP = "LNCP";

    /** 贷款自动扣款入账 */
    final public static String LNCQ = "LNCQ";

    /** 日初贷款自动扣款入账 */
    final public static String LNDQ = "LNDQ";

    /** 承兑到期自动扣款入账 */
    final public static String LNCR = "LNCR";

    /** 贴现到期自动转垫款 */
    final public static String LNCS = "LNCS";

    /** 再贴现到期15天自动结清 */
    final public static String LNCT = "LNCT";

    /** 系统内回购式转贴现到期处理 */
    final public static String LNCU = "LNCU";

    /** 贷款到期转逾期处理 */
    final public static String LNCV = "LNCV";

    /** 表内应收利息满90天转表外 */
    final public static String LNCW = "LNCW";

    /** 季末贷款批量减值确认 */
    final public static String LNCX = "LNCX";

    /** 收益、支出分摊 */
    final public static String LNCY = "LNCY";

    /** 保函自动结清帐务处理 */
    final public static String LNCZ = "LNCZ";

    /** 贷款批量结息 */
    final public static String LNAA = "LNAA";

    /** 滚积数处理 */
    final public static String LNJS = "LNJS";

    /** 到期到期贷款结息入账 */
    final public static String LNAB = "LNAB";

    /** 贷款减值状态变化处理 */
    final public static String LNAC = "LNAC";

    /** 季末贷款单项减值确认 */
    final public static String LNAD = "LNAD";

    /** 正常利息计提 */
    final public static String LNAE = "LNAE";

    /** 利率调整带记账 */
    final public static String LNDB = "LNDB";

    /** 展期 */
    final public static String LNDC = "LNDC";

    /** 逾期利息计提 */
    final public static String LNBX = "LNBX";

    /** 贷款自动扣款冻结 */
    final public static String LNAF = "LNAF";

    /** 银承自动扣款冻结 */
    final public static String LNAH = "LNAH";

    /** 银承汇票重打 */
    final public static String LNAL = "LNAL";

    final public static String LNAK = "LNAK";

    /** 日终初始化 */
    final public static String LNAM = "LNAM";

    /** 形态转移 */
    final public static String LNAN = "LNAN";

    /** 核算内部信息更新 */
    final public static String LNAO = "LNAO";

    /** 再贴现当月确认的利息支出 */
    final public static String LNAP = "LNAP";

    /** 贷款系统与核心系统对帐 */
    final public static String HXDZ = "HXDZ";

    /** 核心利率下载 */
    final public static String LLXZ = "LLXZ";

    /** 银承手续费分摊 */
    final public static String LNAQ = "LNAQ";

    /** 保函手续费分摊 */
    final public static String LNAR = "LNAR";

    /** 利率调整 */
    final public static String LLTZ = "LLTZ";

    /** 预约利率调整 */
    final public static String LNAS = "LNAS";

    /** 核算系统换日 */
    final public static String LNAT = "LNAT";

    /** 查询核心日期 */
    final public static String LNAU = "LNAU";

    /** 回购以后系统内转贴现递延收益分摊 */
    final public static String LNAJ = "LNAJ";

    /** 系统内转贴现利息收入分摊 */
    final public static String LNAI = "LNAI";

    /** 保证金额度使用，自己定义的交易码 */
    final public static String LNAZ = "LNAZ";

    /** 保证金释放使用，自定义的交易码 */
    final public static String LNBZ = "LNBZ";

    /** 通知核心系统换日 */
    final public static String LNAV = "LNAV";

    /** 交易撤销 */
    final public static String LNAX = "LNAX";

    /** 抵押品平移 */
    final public static String LNAY = "LNAY";

    /** 品种变更 */
    final public static String LNAW = "LNAW";

    /** 开出信贷证明 */
    final public static String LNBA = "LNBA";

    /** 信贷证明柜台结清 */
    final public static String LNBB = "LNBB";

    /** 信贷证明日终自动结清 */
    final public static String LNBC = "LNBC";

    /** 开出贷款承诺 */
    final public static String LNBD = "LNBD";

    /** 贷款承诺柜台结清 */
    final public static String LNBE = "LNBE";

    /** 贷款承诺日终自动结清 */
    final public static String LNBF = "LNBF";

    /** 信贷证明手续费递延收益分摊 */
    final public static String LNBG = "LNBG";

    /** 贷款承诺手续费递延收益分摊 */
    final public static String LNBH = "LNBH";

    /** 系统对账（明细） */
    final public static String LNBJ = "LNBJ";

    /** 逾期应收利息冲回逾期已计提利息 */
    final public static String LNBI = "LNBI";

    /** 法人账户透支冻结批处理 */
    final public static String LNBK = "LNBK";

    /** 法人账户透支发放批处理 */
    final public static String LNBL = "LNBL";

    /** 法人账户透支自动恢复批处理 */
    final public static String LNBM = "LNBM";

    /** 贴现垫款利息免收 */
    final public static String LNBN = "LNBN";

    /** 特殊利息处理 */
    final public static String LNBO = "LNBO";

    /** 特殊本金处理 */
    final public static String LNBQ = "LNBQ";

    /** 摊余成本积数处理 */
    final public static String LNBP = "LNBP";

    /** 系统外回购式转贴现转入 */
    final public static String LNBR = "LNBR";

    /** 系统外回购式转贴现转入利息收入递延分摊 */
    final public static String LNBS = "LNBS";

    /** 系统外回购式转贴现转入到期日回购 */
    final public static String LNBT = "LNBT";

    /** 系统外回购式转贴现转出 */
    final public static String LNBU = "LNBU";

    /** 系统外回购式转贴现转出利息支出递延分摊 */
    final public static String LNBV = "LNBV";

    /** 系统外回购式转贴现转出到期日回购 */
    final public static String LNBW = "LNBW";

    /** 南昌临时用的 */
    final public static String TMP1 = "TMP1";

    /** 转换频率 */
    final public static String LNPL = "LNPL";

    /** 银承付款交易撤销 */
    final public static String LNAX2 = "LNAX2";

    /** 日初初始化 */
    final public static String LNBY = "LNBY";

    /** 核心行名行号下载 */
    final public static String LNDA = "LNDA";

    /** 日终结束 */
    final public static String PEND = "PEND";

    /** 日初结束 */
    final public static String BEND = "BEND";

    /** 通用记账 */
    final public static String TYJZ = "TYJZ";

    /** 凭证销号 */
    final public static String PZXH = "PZXH";

    /** 银承重打 */
    final public static String YCCD = "YCCD";

    /** 冻结撤销 */
    final public static String DJCX = "DJCX";

    /** 减值损失准备处理 */
    final public static String LND4 = "LND4";

    /** 贴现销表外帐 */
    final public static String XBWZ = "XBWZ";

    /** 电票买入赎回 */
    final public static String LNDE = "LNDE";

    /** 电票卖出赎回 */
    final public static String LNDD = "LNDD";

    /** 旧帐数据利率模式处理 */
    final public static String LNFX = "LNFX";

    /** 单项减值确认 */
    final public static String LR01 = "LR01";

    /** 贷款过渡后的形态转移 */
    final public static String LNA1 = "LNA1";

    /** 年终转结 */
    final public static String LNZ1 = "LNZ1";

    /** 批量还款测算 */
    final public static String PLCS = "PLCS";
    /** 银承转垫款 */
    public static final String LNCRS = "LNCRS";
    /** 还款计划调整 */
    final public static String LNSC = "LNSC";
    /** 收费交易 */
    public static final String LNF1 = "LNF1";
    /** 保证金交易 */
    public static final String BZJ1 = "BZJ1";
    /** 扣款账户签解约交易 */
    public static final String LNJY = "LNJY";
    /** 账户变更 */
    public static final String LNDG = "LNDG";
    /** 贴息放款交易 */
    public static final String LTX1 = "LTX1";
    /** 贷款置换 */
    public static final String LNDP = "LNDP";
    /** 资产证券化卖出/赎回 */
    public static final String LNABS = "LNABS";
    /** 资产卖出 */
    public static final String LNK1 = "LNK1";
    /** 资产买入 */
    public static final String LNK2 = "LNK2";
    /** 减值保证金计算 */
    public static final String LNRC = "LNRC";
    /** 滞纳金结记 */
    public static final String LNLF = "LNLF";
    /** 合并日间总账 */
    public static final String LNHZ = "LNHZ";
    /** 本金转逾期形态转移 */
    public static final String LNPC = "LNPC";
    /** 发送清算的放款撤销交易码 */
    public static final String LNC3X = "LNC3X";
    /** 发送清算的还款撤销交易码 */
    public static final String LNC4X = "LNC4X";
    /** 贷款停息 */
    public static final String LN12 = "LN12";
    /** 贷款信息变更*/
    public static final String LNMC = "LNMC";

    /** 放款本金调整 */
    public static final String LNTZ = "LNTZ";
    /** 手工形态转移*/
    public static final String LNSM = "LNSM";

    /** 微众银行自扣结果回传文对账*/
    public static final String LNWB = "LNWB";
    /** ------ 交易码常量定义结束------ */

    /** 还款计划查询类型常量定义 start */
    /** 查询完整还款计划 */
    public static final String FIND_ALL = "ALL";
    /** 当前日期前所有还款计划 */
    public static final String FIND_OD_ALL = "OD_ALL";
    /** 当前日期前仅有欠款的还款计划 */
    public static final String FIND_OD_ONLY = "OD_ONLY";
    /** 还款计划查询类型常量定义 end */

    /** 费用计算基准start */
    /** 01-贷款金额 */
    public static final String FEE_PCT_BASE_01 = "01";
    /** 02-剩余本金 */
    public static final String FEE_PCT_BASE_02 = "02";
    /** 03-还款本金 */
    public static final String FEE_PCT_BASE_03 = "03";
    /** 04-还款本息 */
    public static final String FEE_PCT_BASE_04 = "04";
    /** 05-欠款金额 */
    public static final String FEE_PCT_BASE_05 = "05";
    /** 费用计算基准end */
    /** 费用类型start */
    /** 滞纳金 */
    public static final String FEE_TYP_02 = "02";
    /** 贴息费用 */
    public static final String FEE_TYP_120 = "120";
    /** 费用类型end */
    /** 记账金额类型 */
    public static final String TX_AMT_TYP_F06 = "F06";
    public static final String TX_AMT_TYP_F02 = "F02";
    public static final String TX_AMT_TYP_F01 = "F01";
    public static final String TX_AMT_TYP_F03 = "F03";
    public static final String TX_AMT_TYP_F04 = "F04";
    public static final String TX_AMT_TYP_F07 = "F07";
    public static final String TX_AMT_TYP_F09 = "F09";
    /** 委托贷款本金中转 */
    public static final String TX_AMT_TYP_Z01 = "Z01";
    /** 委托贷款利息中转 */
    public static final String TX_AMT_TYP_Z02 = "Z02";
    /** 委托贷款本金归集 */
    public static final String TX_AMT_TYP_W01 = "W01";
    /** 委托贷款利息归集 */
    public static final String TX_AMT_TYP_W02 = "W02";
    /** 收款科目 */
    public static final String TX_AMT_TYP_S02 = "S02";
    /** 虚拟放款科目 */
    public static final String TX_AMT_TYP_S01 = "S01";

    /** 分隔符报文类型 */
    public static final String FGF_MESSAGE = "FGF";

    /** 定长报文类型 */
    public static final String DC_MESSAGE = "DC";
    /** 费用计算类型 start*/
    /** 按比例计算费用 */
    public static final String FEE_CALC_TYP_PCT = "PCT";
    /** 按固定金额计算费用 */
    public static final String FEE_CALC_TYP_AMT = "AMT";
    /** 费用计算类型 end*/

    /** 响应读取器名称 */
    public static final String RESP_READER = "resp_reader";
    /** 委托贷款资金转移账户类型 start */
    /** 委托本金账号 */
    public static final String ACCT_TYP_TURE_P = "TURE_P";
    /** 委托利息账号 */
    public static final String ACCT_TYP_TURE_I = "TURE_I";
    /** 委托贷款资金转移账户类型 end */
    /**平台默认日期格式*/
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**平台默认时间格式*/
    public static final String TIME_FORMAT = "HH:mm:ss";

    /** 自定义报文 */
    public static final String CUSTOM_PKG_TYP = "自定义";

    /** 代发代扣编号本行 */
    public static final String BILL_CODE_BH = "313295";

    /** 代发代扣编号他行 */
    public static final String BILL_CODE_TH = "100000";

    /** 用途编号本行 */
    public static final String USEOF_CODE_BH = "00000005";

    /** 用途编号他行 */
    public static final String USEOF_CODE_TH = "99999998";

    /** 密码 */
    public static final String PASSWORD = "111111";

    /** 还款方式类型 等额本息 */
    public static final String MTD_TYP_01 = "01";
    /** 还款方式类型 等额本金 */
    public static final String MTD_TYP_03 = "03";

    /** 收付标志 01付 */
    public static final String PYCL_PAY = "01";
    /** 收付标志02收 */
    public static final String PYCL_REC = "02";

    /** 盛京银行资金清算*/
    final public static String SJSF = "SJSF";
    /** 盛京银行提前还款*/
    final public static String SJFS = "SJFS";
    /** 微众标识*/
    final public static String WEBANK = "WeBank";
    /** 信托计划对应支付接口版本编号*/
    final public static String VERSION = "VERSION1.0";
    /** 日终手续费扣款*/
    public static final String LNDS = "LNDS";
    /** 日终手续费扣款异步查询 */
    public static final String LDFC = "LDFC";
    /** 日终手续费扣款入账 */
    public static final String LDSV = "LDSV";
    /** 还款方式类型 等额本息 */
    public static final String LOAN_RAYM_MTD_01 = "RP01";
    /** 还款方式类型 等额本金 */
    public static final String LOAN_RAYM_MTD_02 = "RP02";
    /** 日间文件 */
    public static final String RJWJ = "RJWJ";
    /** 红塔银行资金清算*/
    final public static String HTSF = "HTSF";
    /** 红塔银行提前还款*/
    final public static String HTFS = "HTFS";
    /** 融资差额*/
    public static final String LMRZ = "LMRZ";
    /** 民生银行 */
    final public static String CMBC = "CMBC";
    /** 邮储独资标识*/
    final public static String PSBC_DZ = "PSBC-DZ";
    /** 中原独资标识*/
    final public static String ZZYB_DZ = "ZYYH-DZ";
    /**锡商银行*/
    final public static String WXBC = "WXBC";
    /**新生*/
    final public static String CA = "CA";
    /**中原银行*/
    final public static String ZYYH = "ZYYH";
    /**公共代付接口*/
    final public static String PUBK = "PUBK";
}
