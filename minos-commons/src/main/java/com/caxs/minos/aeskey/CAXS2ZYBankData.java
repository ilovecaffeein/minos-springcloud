package com.caxs.minos.aeskey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName: CAXS2ZYBankData
 * @Description: 中原银行秘钥
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class CAXS2ZYBankData {
    private static final Logger logger = LoggerFactory.getLogger(CAXS2ZYBankData.class);

    public static String encoding = "UTF-8";
    public static String hostname;
    public static int port;
    public static int portssl;
    public static String hostIP;

    public static String clientkeystore;
    public static String clientPass;
    public static String clienttrustkeystore;
    public static String clienttrustPass;
    public static String foxclientKeyPwd;

    public static String issendssl;


    static{
/*
        ApolloConfigUtils apolloConfigUtils = new ApolloConfigUtils();
        String zybank_hostname = apolloConfigUtils.getConfigStr("zybank_hostname");
        String zybank_port = apolloConfigUtils.getConfigStr("zybank_port");
        String zybank_port_ssl = apolloConfigUtils.getConfigStr("zybank_port_ssl");
        String client_keystore = apolloConfigUtils.getConfigStr("client_keystore");
        String clientPass = apolloConfigUtils.getConfigStr("clientPass");
        String clienttrust_keystore = apolloConfigUtils.getConfigStr("clienttrust_keystore");
        String clienttrustPass = apolloConfigUtils.getConfigStr("clienttrustPass");
        String foxclientKeyPwd = apolloConfigUtils.getConfigStr("foxclientKeyPwd");
        String is_send_ssl = apolloConfigUtils.getConfigStr("is_send_ssl");

        hostIP = "10.10.8.73";
        hostname = zybank_hostname;
        if(hostname==null || hostname.equals("")){
            throw new RuntimeException("没有配置中原银行接口地址！");
        }
        try {
            port = Integer.valueOf(zybank_port);
            portssl = Integer.valueOf(zybank_port_ssl);
        } catch (NumberFormatException e) {
            throw new RuntimeException("配置中原银行接口地址端口错误！");
        }

        clientkeystore = client_keystore;
        clientPass = clientPass;
        clienttrustkeystore =clienttrust_keystore;
        clienttrustPass = clienttrustPass;
        foxclientKeyPwd =foxclientKeyPwd;
        //是否使用SSL//yes使用，否则不使用
        issendssl = is_send_ssl;
*/
    }

    public CAXS2ZYBankData(){

    }
}
