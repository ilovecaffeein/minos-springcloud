package com.caxs.minos.def;

/***
 * @ClassName(类名) : PUBConstant
 * @Description(描述) : 此类的作用是为方便应用中常量的管理，提供更加有效的常量存储机制，方便应用系统中类的调用，避免 程序中过多的出现硬编码
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/8/24 10:07
 */
public class PUBConstant {
    /**
     * Operation 中doExecute方法返回值
     */
    public static final String ALL = "ALL";// 会计分录中使用的，标示通用
    public static final String ALL_DESC = "通用";// 会计分录中使用的，标示通用

    public static final String RESETPWD = "a123456";
    public static final String SUCCESS = "success"; // 成功
    public static final String FAIL = "fail"; // 失败

    public static final String YES = "1"; // 是
    public static final String NO = "0"; // 否

    public static final String Y = "Y"; // 是(准备替换YES_NO)
    public static final String N = "N"; // 否(准备替换YES_NO)
    public static final String W = "W"; // 等待中。。。。。

    public static final String USE = "1"; // 有效
    public static final String UNUSE = "2"; // 无效

    public static final String ACCT_STS_USE = "0"; // 失效
    public static final String ACCT_STS_UNUSE = "1"; // 生效
    public static final String ACCT_STS_WAIT = "2"; // 待生效
    public static final String ACCT_STS_SUBMIT = "3"; // 待提交

    public static final String ACCT_CHECK_SUCCESS = "1"; // 成功
    public static final String ACCT_CHECK_FAIL = "2"; // 失败
    public static final String ACCT_CHECK_WAIT = "3"; // 未检查

    public static final String ADD = "add"; // 操作-新增 (列表维护操作有使用)
    public static final String NONE = "none"; // 操作-无操作 (列表维护操作有使用)
    public static final String DELETE = "del"; // 操作-删除 (列表维护操作有使用)
    public static final String MODIFY = "update"; // 操作-修改

    public static final String PROM_Z100005 = "Z100005"; // Z100005-应急贷3-12期

    public static final String NOMAL = "01"; // 传统方式
    public static final String LSBQ = "02"; // 利随本清
    public static final String BTJG = "03"; // 不同间隔
    public static final String BJDZDJ = "04"; // 本金递增递减
    public static final String TXHK = "05"; // 弹性还款
    public static final String QQD = "06"; // 气球贷

    public static final String DATE_TYP_WEEK = "W"; // 周
    public static final String DATE_TYP_MONTH = "M"; // 月
    public static final String DATE_TYP_SEASON = "Q"; // 季
    public static final String DATE_TYP_YEAR = "Y"; // 年

    public static final String RPYM_OPT_IP = "IP"; // 还款方式-本金和利息
    public static final String RPYM_OPT_IO = "IO"; // 还款方式-仅利息
    public static final String RPYM_OPT_NN = "NN"; // 还款方式-不还

    public static final String SETL_TYP_BX = "T"; // 还款类型-等额本息
    public static final String SETL_TYP_BJ = "P"; // 还款类型-等额本金

    public static final String LOAN_PROP = "1"; // 本金比例单位-贷款本金
    public static final String BUY_AMT = "2"; // 本金比例单位-购买总价

    public static final String COLL_STS_NORMAL = "01"; // 抵押品状态-正常
    public static final String COLL_STS_DEAL = "02"; // 抵押品状态-已处置

    public static final String CUSCOM = "1"; // 客户类型-企业客户
    public static final String CUSPER = "2"; // 客户类型-个人客户
    public static final String CUSCOMMON = "3"; // 客户类型-通用客户

    // 授信协议状态
    public static final String CREDIT_INVALID = "100"; // 授信协议状态-未生效
    public static final String CREDIT_NOMAL = "200"; // 授信协议状态-生效
    public static final String CREDIT_FREEZE = "300"; // 授信协议状态-冻结
    public static final String CREDIT_CANCEL = "999"; // 授信协议状态-终止

    /** 讀者類別 */
    public static final String READER_TYP_USER = "00"; // 00用户
    public static final String READER_TYP_DUTY = "01"; // 01岗位
    public static final String READER_TYP_BCH = "02"; // 02机构

    /**
     * 机构级别
     */
    public static final String BCH_LEVEL1 = "1";// 级别1
    public static final String BCH_LEVEL2 = "2";// 级别2
    public static final String BCH_LEVEL3 = "3";// 级别3
    public static final String BCH_LEVEL4 = "4";// 级别4
    public static final String BCH_LEVEL5 = "5";// 级别5

    /**
     * 贷款组 ------其他999
     */
    public static final String LOAN_GRP_OTH = "999";// 其他

    /**
     * 使用合同类型
     */
    public static final String CONT_TYP_LOAN = "LOAN"; // 贷款合同
    public static final String CONT_TYP_CREDIT = "CREDIT"; // 授信协议
    public static final String CONT_TYP_GUAR = "GUAR"; // 担保合同
    public static final String BIZ_MARKET = "marketInfo"; // 客户营销
    /**
     * 主动还款-还款模式
     */
    public static final String SETL_MODE_NORMAL = "NM"; // 还欠款
    public static final String SETL_MODE_ADVANCE = "ER"; // 提前还款
    public static final String SETL_MODE_ALL = "FS"; // 全部还款

    /**
     * 业务类型(可用于流程、判断数据来源等)
     */
    public static final String BIZ_LOAN_APP = "loanApp"; // 贷款申请
    public static final String BIZ_LOAN_EXT = "loanExtend"; // 贷款展期
    public static final String BIZ_CREDIT_APP = "creditApp"; // 授信申请
    public static final String BIZ_CREDIT_MODI = "creditModify"; // 授信变更
    public static final String BIZ_PROJ_MODI = "projModify"; // 项目变更
    public static final String BIZ_COLL_MODI = "collModify"; // 贷后担保品变更
    public static final String BIZ_COLL_CONT_MODI = "collContModify"; // 贷后担保合同变更
    public static final String BIZ_LM_CHECK = "lmCheck"; // 贷后检查

    /**
     * 审查审批结论
     */
    public static final String WFI_SCSPJL_AGREE = "10"; // 同意
    public static final String WFI_SCSPJL_DISAGREE = "20"; // 否决
    public static final String WFI_SCSPJL_CALLBACK = "30"; // 打回
    public static final String WFI_SCSPJL_RETURNBACK = "40"; // 退回
    public static final String WFI_SCSPJL_JUMP = "50"; // 跳转
    public static final String WFI_SCSPJL_AGAIN = "60"; // 拿回
    public static final String WFI_SCSPJL_CANCEL = "70"; // 取消

    /**
     * 流程扩展属性名称
     */
    public static final String WFI_EXT_WFITYPE = "wfitype"; // 所属分类

    /**
     * 业务用流程编码与流程标志之间对应的开头标识 只要以此开头便是业务用流程编码!!!!!!!!!!!
     */
    public static final String WFI_WFCODE = "WFCODE_"; // 业务用流程编码开头符

    /**
     * 默认的导入数据用户
     */
    public static final String WFI_IMPORT_USR = "999999"; // 导入用户

    /**
     * 定时导入贷款申请时,默认的流程分类
     */
    public static final String WFI_LOAN_TYPE = "01";

    /**
     * 错误信息定义
     */
    public static final String INDEXERR = "该数据已经存在，重复数据！";// 索引重复时报错使用

    public static final String DELERR = "删除数据失败！";// 索引重复时报错使用

    public static final String MODIERR = "修改数据失败！";// 索引重复时报错使用

    public static final String SUBINDEXERR = "子表主键重复！";// 子表主键重复报错使用

    public static final String RATEERR = "没有此期限对应的利率，请检查利率表配置是否正确！";// 根据利率类型取基准利率时

    public static final String RATEVALUEERR = "利率表该项对应的利率为null，请检查利率表！";// 根据利率类型取基准利率时

    public static final String RATTYPERR = "利率类型设置支持最大、最小期限的值相互之间有冲突，请检查！";// 利率类型设置

    public static final String RESTRICTERR = "没有对该记录进行操作的权限！";// 记录集权限错误西捏

    public static final String MOVEBACKERR = "档案退回失败！";// 入库界面，点击退回时报错使用

    /**
     *权限模板
     */
    public static final String SELFQUERY = "com.yucheng.cmis.permission.data.MySelfQueryTemplate";
    public static final String SELFUPDATE = "com.yucheng.cmis.permission.data.MySelfUpdateTemplate";
    public static final String SELFDELETE = "com.yucheng.cmis.permission.data.MySelfDeleteTemplate";
    public static final String ORGQUERY = "com.yucheng.cmis.permission.data.MyOrgQueryTemplate";
    public static final String ORGUPDATE = "com.yucheng.cmis.permission.data.MyOrgUpdateTemplate";
    public static final String ORGDELETE = "com.yucheng.cmis.permission.data.MyOrgDeletelate";
    public static final String BRANCHQUERY = "com.yucheng.cmis.permission.data.MyOrgAndBranchQueryTemplate";

    /**
     *文件路径
     */

    public static String COMPONENT_CONFIG_FILM_DIR = "D:\\svnspace\\CMIS\\src\\com\\yucheng\\cmis\\config\\";

    /* 当前营业日期 */
    public final static String OPENDAY = "OPENDAY";

    /* 上一营业日期 */
    public final static String LAST_OPENDAY = "LAST_OPENDAY";

    /* 最后操作时间 */
    public final static String CHGDT = "last_chg_dt";
    /* 最后操作用户 */
    public final static String CHGUSR = "last_chg_usr";

    /**
     *记录集权限类型
     *
     **/
    public static final String READ = "READ"; // 只读
    public static final String WRITE = "WRITE"; // 可写

    /**
     * 风除拦截场景(标注不需要执行的场景)
     */
    public static final String NO_EXE_SCENE = "9";

    /**
     * 出帐状态
     */

    public static final String CHAGEOFF_STATUS1 = "1";// 未授权
    public static final String CHAGEOFF_STATUS2 = "2";// 已出账
    public static final String CHAGEOFF_STATUS4 = "3";// 授权被核心拒绝
    public static final String CHAGEOFF_STATUS8 = "8";// 授权已撤销
    public static final String CHAGEOFF_STATUS9 = "9";// 出账已冲正

    /**
     * 分页查询默认每页行数
     */
    public static final int MAXLINE = 15;

    /**
     * SqlOperator对像反回结果的名称
     */
    public static final String RESULT_SET = "resultSet";

    /** 节点参与者类别——组 */
    public static final String WF_NODEUSER_PERFIX_GROUP = "G";
    /** 节点参与者类别——角色 */
    public static final String WF_NODEUSER_PERFIX_ROLE = "R";

    public static final String EMP_KIND_A = "A"; // 工资单位性质-国有单位
    public static final String EMP_KIND_B = "B"; // 工资单位性质-集体单位
    public static final String EMP_KIND_C = "C"; // 工资单位性质-其他单位

    public static final String CAL_BASIS_RATIO = "01"; // 计算基础-比例
    public static final String CAL_BASIS_AMT = "01"; // 计算基础-金额

    // 贷款还款日选项
    public static final String DUE_DAY_OPT_DD = "DD";// 放款日
    public static final String DUE_DAY_OPT_OT = "OT";// 申请时自定义

    // 罚息利率种类DEF_INT_RATE_TYP
    public static final String DEF_INT_RATE_TYP_L = "L";// 贷款执行利率
    public static final String DEF_INT_RATE_TYP_O = "O";// 其它利率

    // 贷款状态
    public static final String LOAN_STS_NBAP = "NBAP";// NBAP: 未放款
    public static final String LOAN_STS_ACTV = "ACTV";// ACTV: 已发放
    public static final String LOAN_STS_SETL = "SETL";// SETL: 已结清

    // P_PYCL_TYP(定义收付参数) 收付代码
    public static final String PYCL_PAYM_OUT = "";// 贷款发放支付
    public static final String PYCL_PAYM_REPAY = "";// 贷款归还(同业清算款项)

    /**
     * 机构存贷款信息
     */
    public static final String ORGFUNDINFO = "OrgFundinfo"; // 只读

    /**
     * 配置业务对应的功能代码
     */
    public static final String FUNC_ID_APPL = "LNAP";// 贷款申请
    public static final String FUNC_ID_DN = "LNC3";// 贷款发放
    public static final String FUNC_ID_REPAY = "LNC4";// 主动还款
    public static final String FUNC_ID_MTD = "LNSC";// 还款计划表调整
    public static final String FUNC_ID_CS = "LNCS";// 催收
    public static final String FUNC_ID_ACCT = "LNAC";// 还款账号变更
    public static final String FUNC_ID_FX = "LNFX";// 待收费实时扣款

    /**
     * 费用计算类型
     */
    public static final String FEE_ACTION_TYP_NOAMT = "NOAMT";// 自定义费用
    public static final String FEE_ACTION_TYP_DEFAMT = "DEFAMT";// 缺省费用
    public static final String FEE_ACTION_TYP_PCTAMT = "PCTAMT";// 按比例收费
    public static final String FEE_ACTION_TYP_FORMULA = "FORMULA";// 按规则收费

    /**
     * 费用按比例收费对应的基础参数
     */
    public static final String PARA_FEE_CURR_INT = "CURR_INT"; // 当期利息
    public static final String PARA_FEE_LOAN_PRCP = "LOAN_PRCP"; // 贷款金额
    public static final String PARA_FEE_OS_PRCP = "OS_PRCP"; // 剩余本金
    public static final String PARA_FEE_RPYM_INSTL = "RPYM_INSTL"; // 还款本息
    public static final String PARA_FEE_RPYM_PRCP = "RPYM_PRCP"; // 还款本金
    public static final String PAEA_FEE_NO_INSTL = "NO_INSTL"; // 未付本金
    /**
     * 费用收付标志
     */
    public static final String RECV_PAY_IND_R = "R"; // 收
    public static final String RECV_PAY_IND_P = "P"; // 付

    /**
     * 放款月数标志
     */
    public static final String FEE_LOAN_MTH = "M"; // 标示计算费用时使用了放款月数
    public static final String FEE_LOAN_TMTH = "TM"; // 标示计算费用时使用了提前还款月数
    /**
     * 表单类型
     */
    public static final String FORMLCAPPL = "LcAppl";// 标示耐用消费品贷款
    public static final String FORMLCAPPLNOR = "LcApplNor";// 标示一般消费品贷款

    /**
     * 文件操作结果类型
     */
    public static final String FILE_SUCCESS = "200";// 成功
    public static final String FILE_NOT_EXIST = "201";// 文件已不存在
    public static final String FILE_FAIL = "500";// 失败

    /**
     * 规则结果表
     */
    public static final String LCRISKRESU = "LcRiskResu";

    /**
     * 费用按期限收取类型
     */
    public static final String FEETNRTYPE_ONLY = "01";// 一次性收取
    public static final String FEETNRTYPE_SUB = "02";// 分期收取
    public static final String FEETNRTYPE_ALL = "03";// 按贷款周期收取

    /**
     * 审查审批结论
     */
    public static final String WFI_RESUTL_AGREE = "10"; // 同意
    public static final String WFI_RESUTL_DISAGREE = "20"; // 否决
    public static final String WFI_RESUTL_CALLBACK = "30"; // 打回
    public static final String WFI_RESUTL_RETURNBACK = "40"; // 退回
    public static final String WFI_RESUTL_JUMP = "50"; // 跳转
    public static final String WFI_RESUTL_AGAIN = "60"; // 拿回
    public static final String WFI_RESUTL_CANCEL = "70"; // 取消
    public static final String WFI_RESUTL_APP = "00"; // 审批中
    /**
     * 流程审批状态
     */
    public static final String WFI_STATE_INIT = "000"; // 待发起
    public static final String WFI_STATE_APPROVE = "111"; // 审批中
    public static final String WFI_STATE_CANCEL = "990"; // 取消
    public static final String WFI_STATE_RECOVER = "991"; // 追回
    public static final String WFI_STATE_REGAIN = "992"; // 打回
    public static final String WFI_STATE_PASS = "997"; // 通过
    public static final String WFI_STATE_DENIAL = "998"; // 否决(不同意)

    /**
     * 流程应用扩展状态
     */
    public static final String WFI_APPSIGN_ING = "0"; // 审批中
    public static final String WFI_APPSIGN_END = "1"; // 终审
    public static final String WFI_APPSIGN_CANCEL = "2"; // 取消
    public static final String WFI_APPSIGN_NO = "3"; // 拒绝

    // 待发起的审批状态串
    public static final String WFI_STATE_NOSEND = WFI_STATE_INIT + ","
            + WFI_STATE_RECOVER + "," + WFI_STATE_REGAIN;

    /**
     * 流程扩展属性名称
     */
    public static final String WFI_EXT_SCENE = "scene"; // 场景
    public static final String WFI_EXT_SHOWTYPE = "showtype"; // 展示风格
    public static final String WFI_EXT_APPLTYPE = "appltype"; // 所属分类
    public static final String WFI_EXT_OPINTAB = "opintab"; // 审批记录表
    public static final String WFI_EXT_APPLURL = "applurl"; // 申请明细URL
    public static final String WFI_EXT_BIZ_PAGE = "includeBizPage"; // 业务数据区页面URL
    public static final String WFI_EXT_OPINGUIDE_PAGE = "opinGuidePage";// 审批意见书写向导URL

    public static final String WFI_EXT_DATA_HIS_PAGE = "bizDataHisPage"; // 业务数据区页面URL
    public static final String WFI_EXT_ADVICE_HIS_PAGE = "adviceHisPage";// 审批意见书写向导URL

    public static final String WFI_EXT_IS_PROCESS = "isHandleBizLogic";// 是否处理业务逻辑

    public static final String WFI_EXT_APPROVE_PAGE_TYPE = "approvePageType";// 审批页面类型

    public static final String WFI_EXT_APPROVE_RESULT = "approveResult";// 审批结论下拉

    public static final String WFI_EXT_APPROVEURL = "approveUrl";// 自定义审批页面

    public static final String WFI_EXT_APPROVE_PAGE_TYPE_QXZ = "0";

    public static final String WFI_EXT_APPROVE_PAGE_TYPE_TYYM = "1";

    public static final String WFI_EXT_APPROVE_PAGE_TYPE_ZDYYM = "2";

    public static final String WFI_EXT_APPLY_POLICY = "applyPolicy";

    public static final String WFI_APPLY_POLICY_YPFJ = "1";// 会签策略：一票否决

    public static final String WFI_APPLY_POLICY_BSTG = "2";// 会签策略：半数通过

    public static final String WFI_APPLY_POLICY_SFZETG = "3";// 会签策略：三分之二通过

    public static final String WFI_APPLY_POLICY_RESULT_TG = "10";// 会签结论：通过

    public static final String WFI_APPLY_POLICY_RESULT_FJ = "20";// 会签结论：否决

    /** 消息处理状态 初始尚未处理 */
    public static final String WFI_MSG_OPSTATUS_INIT = "00";
    /** 消息处理状态 处理中 */
    public static final String WFI_MSG_OPSTATUS_DOING = "01";
    /** 消息处理状态 异常 */
    public static final String WFI_MSG_OPSTATUS_ERROR = "90";
    /** 消息处理状态 处理完毕 */
    public static final String WFI_MSG_OPSTATUS_END = "99";

    /** 风险拦截检查结果 ———— 通过 */
    public static final String WFI_RISKINSPECT_RESULT_PASS = "1";

    /** 风险拦截检查结果 ———— 不通过 */
    public static final String WFI_RISKINSPECT_RESULT_DENY = "2";

    /** 风险拦截检查结果 ———— 忽略 */
    public static final String WFI_RISKINSPECT_RESULT_CANCEL = "3";

    // 档案状态
    public static final String DOC_UN_CHECKIN = "1"; // 未入库
    public static final String DOC_WAIT_CHECKIN = "2"; // 待入库
    public static final String DOC_HAS_CHECKIN = "3"; // 已入库
    public static final String DOC_WAIT_CHECKOUT = "4"; // 待出库
    public static final String DOC_HAS_CHECKOUT = "5"; // 已出库
    public static final String DOC_WAIT_LOAN = "6"; // 待借出
    public static final String DOC_HAS_LOAN = "7"; // 已借出
    public static final String DOC_WAIT_RETURN = "8"; // 待归还

    // 报表用Component
    public static final String RPTCOMPONENT = "RptComponent";
    // 报表用Agent
    public static final String RPTAGENT = "RptAgent";

    // 贷款全流程全节点标识
    public static final String CALL_VERIFY = "elecVerify"; // 电核
    public static final String APPROVE = "approve"; // 审批
    public static final String FACE_SIGN = "faceSign"; // 面签
    public static final String ASSIGN = "assign"; // 家访分配
    public static final String INTERVIEW = "interview"; // 家访
    public static final String VERIFY = "verify"; // 审核
    public static final String TO_FACE = "TO_FACE"; // 驳回面签
    public static final String TO_VISIT = "TO_VISIT"; // 驳回家访
    public static final String DAWDN_APP = "DAWDN_APP"; // 放款审查
    public static final String DO_GRAND = "doGrand"; // 放款
    public static final String PROBLEM_MANAGE = "PRB_MAG"; // 问题处理
    public static final String CANCEL = "cancel"; // 申请取消
    public static final String REJECT = "reject"; // 申请否决
    public static final String CHEAT_JUDGE = "cheatJudge"; // 欺诈认定
    public static final String SUB_CENTER_MANAGER = "subCenMan"; // 分中心客户经理
    public static final String SUB_CENTER_T_MANAGER = "subCenTMan"; // 分中心总经理
    public static final String RISK_MANAGER = "riskMan"; // 风险部

    // 还款方式
    public static final String LOAN_MTD_BTJG = "LM005"; // 本息不同间隔
    public static final String LOAN_MTD_QQD = "LM008"; // 气球贷
    public static final String LOAN_MTD_QT = "LM010"; // 其他
    public static final String LOAN_MTD_LSBQ = "LM003"; // 利随本清
    public static final String LOAN_MTD_DEBX = "LM001"; // 等额本息
    public static final String LOAN_MTD_TXHK12 = "LM006"; // 12期弹性还款
    public static final String LOAN_MTD_TXHK36 = "LM012"; // 36期弹性还款
    public static final String LOAN_MTD_CHGCOMM = "LM000"; // 贷后贷款变更通用还款方式
    public static final String LOAN_MTD_AQJX = "LM004"; // 按期还息到期还本
    public static final String LOAN_MTD_DZDJ = "LM009"; // 本金递增递减
    public static final String LOAN_MTD_TXHK24 = "LM007"; // 24期弹性还款
    public static final String LOAN_MTD_TXHK48 = "LM013"; // 48期弹性还款
    public static final String LOAN_MTD_DEBJ = "LM002"; // 等额本金

    // 还款方式类型
    public static final String LOAN_PAYM_TYP_ZYHK = "00"; // 00 自由还款法（不确定还款日）
    public static final String LOAN_PAYM_TYP_DEBX = "01"; // 01 等额本息
    public static final String LOAN_PAYM_TYP_BTJG = "02"; // 02 本息不同间隔
    public static final String LOAN_PAYM_TYP_DEBJ = "03"; // 03 等额本金
    public static final String LOAN_PAYM_TYP_AQJX = "04"; // 04 按期结息
    public static final String LOAN_PAYM_TYP_LSBQ = "05"; // 05 利随本清
    public static final String LOAN_PAYM_TYP_DZDJ = "06"; // 06 本金递增递减
    public static final String LOAN_PAYM_TYP_TXHK = "07"; // 07 弹性还款（分阶段）
    public static final String LOAN_PAYM_TYP_QQD = "08"; // 08 气球贷

    // 宽限期类型
    public static final String LOAN_GRACE_TYP_E = "E"; // 逾期宽限期
    public static final String LOAN_GRACE_TYP_P = "P"; // 罚息宽限期

    // 利率计算基础
    public static final String RATE_BASE_YEAR = "Y"; // 年利率
    public static final String RATE_BASE_MONTH = "M"; // 月利率
    public static final String RATE_BASE_DAY = "D"; // 日利率

    // 资产卖出/买入类型
    public static final String OPR_TYPE_SALE = "SALE"; // 卖出
    public static final String OPR_TYPE_BUY = "BUY"; // 买入
    // 垫款核算规则
    public static final String ACCP_TYP_GL = "001";

    // 状态
    public static final String STATUS_A = "A"; // 有效
    public static final String STATUS_I = "I"; // 无效

    // 核心处理状态
    public static final String CORE_STATUS_FZ = "FZ";// 已处理
    public static final String CORE_STATUS_SU = "SU";// 未发送
    public static final String CORE_STATUS_SP = "SP";// 处理中
    public static final String CORE_STATUS_CP = "CP";// 已处理
    public static final String CORE_STATUS_NR = "NR";// NR: 待资金清算系统处理
    public static final String CORE_STATUS_FL = "FL";// FL: 清算处理失败

    // 撤销类型
    public static final String REVS_TYP_ALL = "00"; // 资金清算及会计分录都撤销
    public static final String REVS_TYP_CORE = "01"; // 仅撤销资金清算
    public static final String REVS_TYP_LOAN = "02"; // 仅撤销会计分录

    // 支付类型
    public static final String PAY_TYP_SELF = "SELF";// 自主支付
    public static final String PAY_TYP_TRUS = "TRUS";// 受托支付

    // 贷款展期调整类型
    public static final String ADJ_TYP_NM = "NM";// 正常展期
    public static final String ADJ_TYP_OD = "OD";// 逾期展期

    /** added by yangjinhua 扣款日期字典项:DUE_DAY**/
    public static String DUE_DAY = "DUE_DAY";
    /** added by yangjinhua 金额类型:P01-本金**/
    public static String AMT_TYP_P01 = "P01";

    //处理类型
    public static final String OPT_TYP_AUTO = "AUTO";// 自动处理
    public static final String OPT_TYP_MANUAL = "MANUAL";// 手工处理

    //手工形态转移处理标志
    public static final String ADJ_ALL_IND_ALL = "ALL";// 全部转移
    public static final String ADJ_ALL_IND_PERD = "PERD";// 按期数转移

    public static final String CORE_STATUS_PAY = "00";  //支付扣款状态
    public static final String CORE_STATUS_0 = "0";  //支付扣款待处理
    public static final String CORE_STATUS_1 = "1";  //支付扣款成功
    public static final String CORE_STATUS_2 = "2";  //支付扣款失败

    public static final String ZJYRETC = "ZJY0000";  //支付扣款状态
    public static final String ZJY0009 = "9";  //支付扣款状态
    public static final String ZJY0000 = "0";  //支付扣款待处理
    public static final String ZJY0001 = "1";  //支付扣款成功
    public static final String ZYYH = "zyyh";  //支付扣款成功
}

