package com.caxs.minos.aeskey;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Method;
import java.security.Key;
/**
 * @ClassName: CryptAES
 * @Description: 加密
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class CryptAES {
    private static final String AESTYPE ="AES/ECB/PKCS5Padding";

    /**
     * 加密
     * @param keyStr 需要加密的内容
     * @param plainText  加密密码
     * @return
     */
    public static String AES_Encrypt(String keyStr, String plainText) {
        byte[] encrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(plainText.getBytes());
            System.out.println(encrypt.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(encrypt));
    }

    /**解密
     * @param keyStr  待解密内容
     * @param encryptData 解密密钥
     * @return
     */
    public static String AES_Decrypt(String keyStr, String encryptData) {
        byte[] decrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            System.out.println(Base64.decodeBase64(encryptData.getBytes()));
            decrypt = cipher.doFinal(Base64.decodeBase64(encryptData.getBytes()));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(decrypt).trim();
    }

    /**获取KEY值
     * @param key  待解密内容
     * @return
     */
    private static Key generateKey(String key)throws Exception{
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /***
     * decode by Base64
     */
    @SuppressWarnings("unchecked")
    public static byte[] decodeBase64(String input) throws Exception{
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod= clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
        Object retObj=mainMethod.invoke(null, input);
        return (byte[])retObj;
    }


    public static void main(String[] args) {
        String keyStr = "UITN25LMUQC436IM";
        String plainText = "this is a string will be AES_Encrypt";
        String encText = AES_Encrypt(keyStr, plainText);
        String decString = AES_Decrypt(keyStr, encText);
        System.out.println(encText);
        System.out.println(decString);
    }
}
