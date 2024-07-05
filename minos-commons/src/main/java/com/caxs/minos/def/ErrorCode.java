package com.caxs.minos.def;

/***
 * @ClassName(类名) : ErrorCode
 * @Description(描述) : 业务型的日志及异常错误码
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/3 11:02
 */
public class ErrorCode {
    public final static String SUC_CODE = "00000";// 成功代码
    public final static String TIMEOUT_CODE_MSG_KEY_ID = "Time out";// 成功代码
    public final static String TIMEOUT_CODE = "50001";// 成功代码
    public final static String ERROR1001 = "10001";// 账号不存在
    public final static String ERROR1002 = "10002";// 没有找到账户信息。
    public final static String ERROR10003 = "10003";// 保存银承借据错误
    public final static String ERROR10004 = "10004";// 自动扣款保存借据错误
    public final static String ERROR10104 = "10104";// 自动扣款核心入账失败。
    public final static String ERROR10005 = "10005";// 冻结账号出错
    public final static String ERROR10006 = "10006";// 保存收付失败

    public final static String ERROR00006 = "00006";// 没有找到修约方法
    public final static String ERROR00007 = "00007";// 无还款顺序信息主表
    public final static String ERROR00008 = "00008";// 无还款计划数据
    public final static String ERROR00009 = "00009";// 日终结息异常
    public final static String ERROR00019 = "00010";// 要处理的对象为空
    public final static String ERROR00020 = "00011";// 保存核心记账数据错误
    public final static String ERROR00021 = "00012";// 没有找到借据的浮动利率或浮动比例
    public final static String ERROR00022 = "00013";// 生成临时还款方法表错误
    public final static String ERROR00023 = "00014";// 记账无返回数据
    public final static String ERROR00024 = "00015";// 滚积数处理异常
    public final static String ERROR10025 = "10025";// 发核心过程错误

    public final static String ERROR10007 = "10007";// 系统内贴现异常
    public final static String ERROR10008 = "10008";// 系统外贴现异常
    public final static String ERROR10009 = "10009";// 贴现转垫款处理异常
    public final static String ERROR10010 = "10010";// 再贴现处理异常
    public final static String ERROR10011 = "10011";// 银承手续费分摊异常
    public final static String ERROR10012 = "10012";// 银承转垫款异常
    public final static String ERROR10013 = "10013";// 利息计提批量处理失败
    public final static String ERROR10021 = "10021";// 逾期利息计提失败
    public final static String ERROR10023 = "10023";// 计提1分钱误差
    public final static String ERROR10014 = "10014";// 保函手续费分摊异常
    public final static String ERROR10015 = "10015";// 保函结清处理异常
    public final static String ERROR10016 = "10016";// 系统内回购式转贴现到期异常
    public final static String ERROR10017 = "10017";// 保函自动结清处理异常
    public final static String ERROR10018 = "10018";// 利率下载处理异常
    public final static String ERROR10019 = "10019";// 形态转移错误
    public final static String ERROR10022 = "10022";// 行名行号下载错误

    public final static String ERROR10050 = "10050";// 处理批量减值数据异常
    public final static String ERROR10051 = "10051";// 减值贷款帐务处理异常
    public final static String ERROR10052 = "10052";// 处理贷款减值计提异常
    public final static String ERROR10053 = "10053";// 利率调整异常
    public final static String ERROR10054 = "10054";// 预约利率调整
    public final static String ERROR10055 = "10055";// 摊余成本积数处理异常

    public final static String ERROR10020 = "10020";// 贷款展期处理异常

    public final static String ERROR10031 = "10031";// 信贷证明手续费分摊异常
    public final static String ERROR10032 = "10032";// 信贷证明结清处理异常
    public final static String ERROR10033 = "10033";// 贷款承诺手续费分摊异常
    public final static String ERROR10034 = "10034";// 贷款承诺结清处理异常

    public final static String ERROR10041 = "10041";// 法人账户透支核算出账处理异常
    public final static String ERROR10042 = "10042";// 法人账户透支核算冻结处理异常
    public final static String ERROR10043 = "10043";// 法人账户透支核算额度恢复处理异常
    public final static String ERROR10124 = "10124";// 发核心过程错误
    public final static String ERROR10125 = "10125";// 对账失败
    public final static String ERROR10126 = "10126";// 主动还款日终处理出错
    public final static String ERROR10070 = "10070";// 发送网银代扣款交易失败
    public final static String ERROR10071 = "10071";// 为查询到扣款结果
    public final static String ERROR10072 = "10072";// 佣金摊销失败
    public final static String ERROR10073 = "10073";// 五级分类批处理失败
    public final static String ERROR10074 = "10074";// 佣金确认失败
    public final static String ERROR10075 = "10075";// 佣金确认失败
    public final static String ERROR10076 = "10076";// 存量贷款发放失败
    public final static String ERROR10077 = "10077";// 批量还款测算
    public final static String ERROR10078 = "10078";// 发送总账系统失败
    public final static String ERROR10130 = "10130";// 滞纳金结记出错
    public final static String ERROR10131 = "10131";// 利率文件下载出错
    public static final String ERROR30001 = "20006";// 通讯异常

    // 核心交易状态
    public static final String ERRORCORE_FAIL = "0000";// 失败（代表账务处理失败）
    public static final String ERRORCORE_SUCCESS = "0001";// 成功（代表账务处理成功）
    public static final String ERRORCORE_WAIT = "0002";// 处理中（代表处理中间状态）
    public static final String ERRORCORE_NOORDER = "0003";// 查无此订单

    // 通讯 编码相关异常
    public static final String ERROR20001 = "20001";// 编码异常
    public static final String ERROR20002 = "20002";// 获取或设置字段值异常
    public static final String ERROR20003 = "20003";// 非法报文格式配置
    public static final String ERROR20004 = "20004";// 报文ID未定义
    public static final String ERROR20005 = "20005";// 映射字段未定义
    public static final String ERROR20006 = "20006";// 通讯异常
}
