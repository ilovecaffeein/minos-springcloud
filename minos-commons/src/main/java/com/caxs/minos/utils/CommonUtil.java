package com.caxs.minos.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @ClassName: CommonUtil
 * @Description:
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class CommonUtil {
    //打印日志属性
    private Log log = LogFactory.getLog(getClass());

    public final static int LEFT = 0;

    public final static int RIGHT = 1;

    public final static int ALL = 2;

    /**
     * 用特定字符填充字符串
     *
     * @param sSrc
     *            要填充的字符串
     * @param ch
     *            用于填充的特定字符
     * @param nLen
     *            要填充到的长度
     * @param bLeft
     *            要填充的方向：true:左边；false:右边
     * @return 填充好的字符串
     */
    public static String fill(String sSrc, char ch, int nLen, boolean bLeft) {
        byte[] bTmp = trimnull(sSrc.getBytes());
        sSrc = new String(bTmp);
        if (sSrc == null || sSrc.equals("")) {
            StringBuffer sbRet = new StringBuffer();
            for (int i = 0; i < nLen; i++)
                sbRet.append(ch);

            return sbRet.toString();
        }
        byte[] bySrc = sSrc.getBytes();
        int nSrcLen = bySrc.length;
        if (nSrcLen >= nLen) {
            return sSrc;
        }
        byte[] byRet = new byte[nLen];
        if (bLeft) {
            for (int i = 0, n = nLen - nSrcLen; i < n; i++)
                byRet[i] = (byte) ch;
            for (int i = nLen - nSrcLen, n = nLen; i < n; i++)
                byRet[i] = bySrc[i - nLen + nSrcLen];
        } else {
            for (int i = 0, n = nSrcLen; i < n; i++)
                byRet[i] = bySrc[i];
            for (int i = nSrcLen, n = nLen; i < n; i++)
                byRet[i] = (byte) ch;
        }
        return new String(byRet);
    }

    /**
     * 去掉字符串两头的空值
     *
     * @param byRet
     *            要去除的字符串
     * @return 去除好的字符串
     */

    public static byte[] trimnull(byte[] byRet) {
        int startPos = 0;
        int endPos = byRet.length - 1;
        for (int i = 0; i < byRet.length; i++) {
            if (byRet[i] != 0) {
                startPos = i;
                break;
            }
            if (i == (byRet.length - 1) && byRet[i] == 0) {
                return null;
            }
        }
        for (int i = byRet.length - 1; i >= 0; i--) {
            if (byRet[i] != 0) {
                endPos = i;
                break;
            }
        }
        byte[] byTmp = new byte[endPos - startPos + 1];
        System.arraycopy(byRet, startPos, byTmp, 0, endPos - startPos + 1);
        return byTmp;
    }

    /**
     * 去除字符串中指定方向上的指定字符
     *
     * @param sSrc
     *            要去除的字符串
     * @param ch
     *            去除的特定字符
     * @param nPos
     *            去除的方向：LEFT:左边 0；RIGTH:右边 1；ALL：全部 2
     * @return 去除好的字符串
     */
    public static String trim(String sSrc, char ch, int nPos) {
        if (sSrc == null || sSrc.equals(""))
            return sSrc;
        byte[] bySrc = sSrc.getBytes();
        int nLen = bySrc.length;
        byte[] byRet = new byte[nLen];
        if (nPos == LEFT) {
            int i = 0;
            for (; i < nLen; i++) {
                if (bySrc[i] != (byte) ch)
                    break;
            }
            for (int j = i; j < nLen; j++)
                byRet[j - i] = bySrc[j];
        } else if (nPos == RIGHT) {
            int i = nLen - 1;
            for (; i >= 0; i--) {
                if (bySrc[i] != (byte) ch)
                    break;
            }
            int nRight = i + 1;
            // for (int j = 0; j < nRight; j++)
            // byRet[j] = bySrc[j];
            System.arraycopy(bySrc, 0, byRet, 0, nRight);
        } else if (nPos == ALL) {
            int i = nLen - 1;
            for (; i >= 0; i--) {
                if (bySrc[i] != (byte) ch)
                    break;
            }
            int nRight = i + 1;
            for (i = 0; i < nLen; i++) {
                if (bySrc[i] != (byte) ch)
                    break;
            }
            int nLeft = i;
            for (int j = nLeft; j < nRight; j++)
                byRet[j - nLeft] = bySrc[j];
        }
        return new String(byRet).trim();
    }

    public static void main(String[] args) {

        String str = "123456.12";
        int index = str.indexOf(".");
        if(index!=-1){//有小数
            str = str.substring(0, index)+str.substring(index+1);
        }else{//无小数
            str=str.concat("00");
        }
        str=CommonUtil.fill(str, '0', 10, true);

        System.out.println(str);

    }


    /** 获取xml格式的msg报文里field对应的值，field格式为<值> */
    public static  String  HgetFieldValue(String field, String msg) {
        int beginIndex = msg.indexOf(field);
        if (beginIndex == -1) {
            return "";
        }
        int endIndex = msg.indexOf("</" + field.substring(1, field.length()));
        String fieldStr = msg.substring(beginIndex + field.length(), endIndex);
        return fieldStr;
    }
}
