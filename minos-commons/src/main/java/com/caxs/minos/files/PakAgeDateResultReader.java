package com.caxs.minos.files;

import com.caxs.minos.domain.PkgTypDtl;
import com.caxs.minos.domain.trans.PakAgeDataTrans;
import com.caxs.minos.domain.trans.PkgInfoTrans;
import com.caxs.minos.exception.MinosException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.UnsupportedEncodingException;
/**
 * @ClassName: BaseFileReader
 * @Description: 文件解析工具类
 * @Author: coffee
 * @Date: 2020/8/13 15:10
 * @Version: v1.0 文件初始创建
 */
public class PakAgeDateResultReader extends BaseFileReader<Object> {
    private Log log = LogFactory.getLog(this.getClass());
    private static final String ENCODING = "GBK";
    private PkgInfoTrans pkgInfo;// 扣款数据包信息
    private PakAgeDataWriterContentWraper piwc;// 构造文件报文内容

    /**
     * 还款结果读取构造方法
     * @param directory
     * @param fileName
     * @param pkgInfo
     * @param piwc
     * @return
     */
    public PakAgeDateResultReader(String directory, String fileName, PkgInfoTrans pkgInfo,
                                  PakAgeDataWriterContentWraper piwc) {
        super(directory, fileName, pkgInfo.getFdDel());
        this.pkgInfo = pkgInfo;
        this.piwc = piwc;
    }

    /**
     * 组装返回的还款结果读取对象
     * @param columnsData
     * @return
     */
    @Override
    protected Object fillBean(String[] columnsData) {
        if (log.isDebugEnabled())
            log.debug("要处理的行内容是：" + columnsData[0]);
        // 分隔符组装
        if ("FGF".equals(pkgInfo.getPkgTyp())) {
            for (int i = 0; i < columnsData.length; i++) {
                columnsData[i] = columnsData[i].replaceAll(pkgInfo.getFdChr(),"");
            }
            return this.buildRespContPakAgeObject(columnsData);
        }

        // 定长组装
        if ("DC".equals(pkgInfo.getPkgTyp())) {
            PkgTypDtl[] pkgTypDtls = pkgInfo.getTypeDtls();

            String str = columnsData[0];// edited by renee@20150107
            // 为避免对中文处理异常，采用byte[]进行
            byte[] data = null;
            try {
                data = str.getBytes(ENCODING);
            } catch (UnsupportedEncodingException e) {
                log.error(e.getMessage());
            }

            if (!"".equals(pkgInfo.getFdChr())) {
                throw new MinosException("定长不支持此格式");
            } else {
                int i = 0;
                String[] resultArr = new String[pkgTypDtls.length];
                int beginIndex = 0;
                int fieldLength = 0;
                byte[] field;
                for (PkgTypDtl ptd : pkgTypDtls) {
                    fieldLength = ptd.getFldLen().intValue();
                    field = new byte[fieldLength];
                    System.arraycopy(data, beginIndex, field, 0, fieldLength);
                    try {
                        resultArr[i] = new String(field, ENCODING);
                    } catch (UnsupportedEncodingException e) {
                        log.error(e.getMessage());
                    }
                    resultArr[i] = StringUtils.trim(resultArr[i]);
                    beginIndex = beginIndex + ptd.getFldLen().intValue();
                    i++;
                }
                return piwc.buildRespContentObject(resultArr);
            }
        }
        throw new MinosException("not supported pkg typ");
    }

    /**
     * 构造返回对象
     * @param returnArr
     * @return
     */
    public Object buildRespContPakAgeObject(String[] returnArr) {
        PakAgeDataTrans tpi = new PakAgeDataTrans();
        tpi.setTxseq(Integer.parseInt(returnArr[0]));/** 序号*/
        tpi.setMerId(returnArr[1]);/**商户号 */
        tpi.setPayType(returnArr[2]);/**接口类型 */
        tpi.setTransType(returnArr[3]);/**交易类型 */
        tpi.setOrderNumber(returnArr[4]);/** 订单号 */
        tpi.setOrderAmount(returnArr[5]);/** 订单金额(分) */
        tpi.setOrderCurrency(returnArr[6]);/** 交易币种 */
        tpi.setAccName(returnArr[7]); /**姓名*/
        tpi.setAccNo(returnArr[8]);/** 银行卡号 */
        tpi.setBankNo(returnArr[9]); /** 开户行联行号*/
        tpi.setProtocolNo(returnArr[10]); /** 协议号 */
        tpi.setAgentAmount(returnArr[11]); /** 交易拆分 */
        tpi.setLoanNo(returnArr[12]);/** 备注 */
        tpi.setMtime(returnArr[13]); /** 时间*/
        tpi.setSuccflag(returnArr[14]); /** 交易状态*/
        tpi.setSubtxseq(returnArr[15]); /** 清算平台流水号*/
        tpi.setTxMemo(returnArr[16]); /** 交易摘要*/
        tpi.setPchCde(returnArr[17]); /** 扣款渠道*/
        return tpi;
    }

}
