package com.caxs.minos.aeskey;

import com.sun.crypto.provider.SunJCE;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
public class EnDe3DES {
  private static String DesCharset = "UTF-8";
  private static String Algorithm = "DESede";

  static {
    Security.addProvider(new SunJCE());
  }

  public static byte[] encode(byte[] input, byte[] key) throws Exception {
    SecretKey deskey = new SecretKeySpec(key, Algorithm);
    Cipher c1 = Cipher.getInstance(Algorithm);
    c1.init(1, deskey);
    byte[] cipherByte = c1.doFinal(input);
    return cipherByte;
  }

  public static String byte2hex(byte[] b) {
    String hs = "";
    String stmp = "";
    for (int n = 0; n < b.length; n++) {
      stmp = Integer.toHexString(b[n] & 0xFF);
      if (stmp.length() == 1)
        hs = hs + "0" + stmp;
      else
        hs = hs + stmp;
    }
    return hs.toUpperCase();
  }

  public static String EnycrptDes(String src, String key)
    throws Exception {
    key = getKeyLen(key, 24);
    String ret = "";
    if (!StringUtils.isBlank(src)) {
      ret = byte2hex(encode(src.getBytes(DesCharset), key.getBytes(DesCharset)));
    }
    return ret;
  }

  public static String EnycrptDes(String src, String key, String charSet)
    throws Exception {
    key = getKeyLen(key, 24);
    String ret = "";
    if (!StringUtils.isBlank(src)) {
      ret = byte2hex(encode(src.getBytes(charSet), key.getBytes(charSet)));
    }
    return ret;
  }

  public static String getKeyLen(String key, int len) {
    String keyLen = "";
    if (key.length() >= len)
      keyLen = substring(key, key.length() - len);
    else {
      keyLen = leftPad(key, len, "0");
    }
    return keyLen;
  }

  public static String substring(String str, int start){
    if (str == null) {
      return null;
    }
    if (start < 0) {
      start = str.length() + start;
    }
    if (start < 0) {
      start = 0;
    }
    if (start > str.length()) {
      return "";
    }
    return str.substring(start);
  }


  public static String leftPad(String str, int size, String padStr){
    if (str == null) {
      return null;
    }
    if (StringUtils.isEmpty(padStr)) {
      padStr = " ";
    }
    int padLen = padStr.length();
    int strLen = str.length();
    int pads = size - strLen;
    if (pads <= 0) {
      return str;
    }
    if ((padLen == 1) && (pads <= 8192)) {
      return leftPad(str, size, padStr.charAt(0));
    }

    if (pads == padLen)
      return padStr.concat(str);
    if (pads < padLen) {
      return padStr.substring(0, pads).concat(str);
    }
    char[] padding = new char[pads];
    char[] padChars = padStr.toCharArray();
    for (int i = 0; i < pads; ++i) {
      padding[i] = padChars[(i % padLen)];
    }
    return new String(padding).concat(str);
  }

  public static String leftPad(String str, int size, char padChar) {
    if (str == null) {
      return null;
    }
    int pads = size - str.length();
    if (pads <= 0) {
      return str;
    }
    if (pads > 8192) {
      return leftPad(str, size, String.valueOf(padChar));
    }
    return padding(pads, padChar).concat(str);
  }

  private static String padding(int repeat, char padChar)
          throws IndexOutOfBoundsException {
    if (repeat < 0) {
      throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
    }
    char[] buf = new char[repeat];
    for (int i = 0; i < buf.length; ++i) {
      buf[i] = padChar;
    }
    return new String(buf);
  }

  public static String DeEnycrptDes(String src, String key)throws Exception {
	key = getKeyLen(key, 24);
    String ret = "";
	if (!StringUtils.isBlank(src)) {
     ret = new String(decode(hexStr2ByteArr(src), key.getBytes(DesCharset)), DesCharset);
    }
	return ret;
  }

  public static String DeEnycrptDes(String src, String key, String charSet)throws Exception {
	  key = getKeyLen(key, 24);
	  String ret = "";
	  if (!StringUtils.isBlank(src)) {
		ret = new String(decode(hexStr2ByteArr(src, charSet), key.getBytes(charSet)), charSet);
	  }
	  return ret;
  }
  
  public static byte[] hexStr2ByteArr(String strIn) throws Exception {
    byte[] arrB = strIn.getBytes(DesCharset);
    int iLen = arrB.length;
    byte[] arrOut = new byte[iLen / 2];

    for (int i = 0; i < iLen; i += 2) {
      String strTmp = new String(arrB, i, 2);
      arrOut[(i / 2)] = (byte)Integer.parseInt(strTmp, 16);
    }
    return arrOut;
  }

  public static byte[] hexStr2ByteArr(String strIn, String charSet) throws Exception {
    byte[] arrB = strIn.getBytes(charSet);
    int iLen = arrB.length;
    byte[] arrOut = new byte[iLen / 2];

    for (int i = 0; i < iLen; i += 2) {
      String strTmp = new String(arrB, i, 2);
      arrOut[(i / 2)] = (byte)Integer.parseInt(strTmp, 16);
    }
    return arrOut;
  }
  
  public static byte[] decode(byte[] input, byte[] key) throws Exception {
    SecretKey deskey = new SecretKeySpec(key, Algorithm);
    Cipher c1 = Cipher.getInstance(Algorithm);
    c1.init(2, deskey);
    byte[] clearByte = c1.doFinal(input);
    return clearByte;
  }
}