package com.caxs.minos.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils {
  private final Log log = LogFactory.getLog(getClass());

  public static String GetMessageDigest(String strSrc, String encName, String charset) {
    String charset_inner = StringUtils.isBlank(charset) ? "UTF-8" : StringUtils.trimToEmpty(charset);
    MessageDigest md = null;
    String strDes = null;
    String ALGO_DEFAULT = "SHA-1";
    try {
      if (StringUtils.isBlank(encName)) {
        encName = "SHA-1";
      }
      md = MessageDigest.getInstance(encName);
      md.update(strSrc.getBytes(charset_inner));
      strDes = bytes2Hex(md.digest());
    } catch (NoSuchAlgorithmException e) {
    } catch (UnsupportedEncodingException e) {
    }
    return strDes;
  }

  public static String bytes2Hex(byte[] bts) {
    String des = "";
    String tmp = null;
    for (int i = 0; i < bts.length; i++) {
      tmp = Integer.toHexString(bts[i] & 0xFF);
      if (tmp.length() == 1) {
        des = des + "0";
      }
      des = des + tmp;
    }
    return des;
  }
}