package com.caxs.minos.utils;

import org.apache.commons.lang3.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;
public class AppUtils {
  public static final String SIGNMETHOD = "MD5";

  public static String URLEncode(String src, String charset) {
    String srcEncode = "";
    if (StringUtils.isBlank(src))
      srcEncode = src;
    else
      try
      {
        srcEncode = URLEncoder.encode(src, charset);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
    return srcEncode;
  }

  public static String URLDecode(String src, String charset) {
    String srcEncode = "";
    if (StringUtils.isBlank(src))
      srcEncode = src;
    else
      try
      {
        srcEncode = URLDecoder.decode(src, charset);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
    return srcEncode;
  }

  public static String restMapToStr(Map<String, String> map) {
    String retStr = "";
    if (map.size() > 0) {
      StringBuilder sbd = new StringBuilder();
      for (String keyVal : map.keySet()) {
        sbd.append(keyVal).append("=").append((String)map.get(keyVal)).append("&");
      }
      retStr = StringUtils.substringBeforeLast(sbd.toString(), "&");
    }
    return retStr;
  }

  public static String signDictionary(Map<String, String> dataMap, String[] baseDataKey, String[] dataKeyPlus, String signKey, String charset) {
    String mac = "";
    String md5Str = "";
    try {
      md5Str = CryptoUtils.GetMessageDigest(signKey, "MD5", charset);
    }
    catch (Exception e) {
      return mac;
    }
    StringBuffer buf = new StringBuffer("");
    for (String item : baseDataKey) {
      if (dataMap.get(item) != null) {
        buf.append(item).append("=").append((String)dataMap.get(item)).append("&");
      }
    }
    for (String item : dataKeyPlus) {
      if (dataMap.get(item) != null) {
        buf.append(item).append("=").append((String)dataMap.get(item)).append("&");
      }
    }
    buf.append(md5Str);
    mac = CryptoUtils.GetMessageDigest(buf.toString(), "MD5", charset);
    return mac;
  }

  public static String signDictionary(Map<String, String> dataMap, String signKey, String charset) {
    String mac = "";
    String md5Str = "";
    try {
      md5Str = CryptoUtils.GetMessageDigest(signKey, "MD5", charset);
    }
    catch (Exception e) {
      return mac;
    }
    StringBuffer buf = new StringBuffer("");
    buf.append(coverMap2String(dataMap));
    buf.append("&").append(md5Str);

    mac = CryptoUtils.GetMessageDigest(buf.toString(), "MD5", charset);

    return mac;
  }

  public static String coverMap2String(Map<String, String> data) {
    TreeMap tree = new TreeMap();
    Iterator it = data.entrySet().iterator();
    while (it.hasNext()) {
      Entry en = (Entry)it.next();
      if ("sign".equals(((String)en.getKey()).trim())) {
        continue;
      }
      tree.put((String)en.getKey(), (String)en.getValue());
    }
    it = tree.entrySet().iterator();
    StringBuffer sf = new StringBuffer();
    while (it.hasNext()) {
      Entry en = (Entry)it.next();
      sf.append((String)en.getKey() + "=" + (String)en.getValue() + "&");
    }
    return sf.substring(0, sf.length() - 1);
  }

  public static void convertRetToMap(String res, Map<String, String> map) {
    if (StringUtils.isNotBlank(res)) {
      String[] resArray = res.split("&");
      if (resArray.length != 0)
        for (String arrayStr : resArray) {
          if (arrayStr == null)
            continue;
          if ("".equals(arrayStr.trim())) {
            continue;
          }
          int index = arrayStr.indexOf("=");
          if (-1 == index) {
            continue;
          }
          map.put(arrayStr.substring(0, index), arrayStr.substring(index + 1));
        }
    }
  }

  public static boolean validate(String res, String signKey, String charset) {
	if (StringUtils.isBlank(res)) {
      return false;
    }
	boolean ret = false;
    //Map paraMap = resMap.newHashMap();
    Map<String, String> resMap = new HashMap<>();
    convertRetToMap(res, resMap);
    String signSrc = coverMap2String(resMap);

    String md5Str = "";
    try {
      md5Str = CryptoUtils.GetMessageDigest(signKey, "MD5", charset);
    }
    catch (Exception e) {
      return ret;
    }
    signSrc = signSrc + "&" + md5Str;

    String newSign = CryptoUtils.GetMessageDigest(signSrc, "MD5", charset);

    String sign = (String)resMap.get("sign");
    if ((sign != null) && (sign.equalsIgnoreCase(newSign))) {
      ret = true;
    }
    return ret;
  }

  public static boolean validate(Map<String, String> resMap, String signKey, String charset) {
    boolean ret = false;

    String signSrc = coverMap2String(resMap);

    String md5Str = "";
    try {
      md5Str = CryptoUtils.GetMessageDigest(signKey, "MD5", charset);
    }
    catch (Exception e) {
      return ret;
    }
    signSrc = signSrc + "&" + md5Str;

    String newSign = CryptoUtils.GetMessageDigest(signSrc, "MD5", charset);

    String sign = (String)resMap.get("sign");
    if (sign.equalsIgnoreCase(newSign)) {
      ret = true;
    }
    return ret;
  }

  public static Map<String, String> prepareDataMap(Map<String, String> dataMap, String[] dataKey) {
    //Map paraMap = Maps.newHashMap();
    Map<String, String> paraMap = new HashMap<>();
    List kList = Arrays.asList(dataKey);

    for (String item : dataMap.keySet()) {
      //if ((kList.contains(item)) && (StringUtils.isNotBlank(dataMap.get(item))) && (!"null".equalsIgnoreCase((String)dataMap.get(item)))) {
        paraMap.put(item, (String)dataMap.get(item));
      //}
    }
    return paraMap;
  }
  
  public static Map<String, String> prepareToDataMap(Map<String, String> dataMap, String[] dataKey) {
    //Map paraMap = Maps.newHashMap();
    Map<String, String> paraMap = new HashMap<>();
    List kList = Arrays.asList(dataKey);

    for (String item : dataMap.keySet()) {
      if (kList.contains(item)) {
        paraMap.put(item, dataMap.get(item) == null ? "" : (String)dataMap.get(item));
      }
    }
    return paraMap;
  }

  public static final String praseString(String inStr, String charset) {
    int i = 0;
    try {
      if (StringUtils.isBlank(inStr)) {
        return "";
      }

      for (i = 0; i < inStr.codePointCount(0, inStr.length()); i++) {
        if (inStr.codePointAt(i) > 255) {
          return inStr;
        }
      }
      byte[] b = inStr.getBytes("ISO8859-1");
      String inStrGB = new String(b, "GBK");
      String inStrUTF = new String(b, "UTF-8");
      if (StringUtils.isBlank(charset))
        return praseString(inStr);
      if ((StringUtils.trimToEmpty(charset).equalsIgnoreCase("gb2312")) || 
        (StringUtils.trimToEmpty(charset).equalsIgnoreCase("GBK"))) {
        return inStrGB;
      }
      return inStrUTF;
    } catch (Exception e) {
    }
    return inStr;
  }

  public static final String praseString(String inStr) {
    int i = 0;
    try {
      if (StringUtils.isBlank(inStr)) {
        return "";
      }

      for (i = 0; i < inStr.codePointCount(0, inStr.length()); i++) {
        if (inStr.codePointAt(i) > 255) {
          return inStr;
        }
      }
      byte[] b = inStr.getBytes("ISO8859-1");
      String inStrGB = new String(b, "GBK");
      String inStrUTF = new String(b, "UTF-8");
      String inStrGB_UTF = new String(inStrGB.getBytes("GBK"), "UTF-8");
      if (inStrGB_UTF.equals(inStrUTF)) {
        return inStrGB;
      }
      return inStrUTF;
    } catch (Exception e) {
    	
    }
    return inStr;
  }
}