package com.caxs.minos.aeskey;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
/**
 * @ClassName: SSLFactory
 * @Description: 客户端
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class SSLFactory {
    /** String name of keystore location path property. */
    public static final String KEYSTORE_PROPERTY = "jetty.ssl.keystore";

    /** String name of keystore type property */
    public static final String KEYSTORE_TYPE_PROPERTY = "jetty.ssl.keystore.type";

    /** Default keystore type */
    public static final String DEFAULT_KEYSTORE_TYPE = System.getProperty(KEYSTORE_TYPE_PROPERTY, KeyStore.getDefaultType());

    /** String name of keystore provider name property */
    public static final String KEYSTORE_PROVIDER_NAME_PROPERTY = "jetty.ssl.keystore.provider.name";

    /** String name of keystore provider class property */
    public static final String KEYSTORE_PROVIDER_CLASS_PROPERTY = "jetty.ssl.keystore.provider.class";

    /** Default value for keystore provider class. null = use default */
    public static final String DEFAULT_KEYSTORE_PROVIDER_CLASS = System.getProperty(KEYSTORE_PROVIDER_CLASS_PROPERTY);

    /** Default value for the keystore location path. */
    //public static final String DEFAULT_KEYSTORE = System.getProperty("user.home") + File.separator + ".keystore";

    /** Default value for keystore provider name. null = use default */
    public static final String DEFAULT_KEYSTORE_PROVIDER_NAME = System.getProperty(KEYSTORE_PROVIDER_NAME_PROPERTY);

    /** String name of keystore password property. */
    public static final String PASSWORD_PROPERTY = "jetty.ssl.password";

    /** String name of key password property. */
    public static final String KEYPASSWORD_PROPERTY = "jetty.ssl.keypassword";

    private boolean isSun;

    /** 安全套接字协议(SSL、SSLv3、TLS、TLSv1.0、TLSV1.1、TLSv1.2) */
    private String sslContextAlgorithm = "SSLv3";

    /** 密钥库类型 (JKS、JCEKS)PKCS12、BKS、UBER */
    private String keyStoreAlgorithm = "JKS";

    /** 密钥管理器算法(SunX509) */
    private String trustManagerAlgorithm = "SunX509";

    public Socket createSocket(String host, int port, int timeout) throws Exception {
        SSLSocketFactory clientSocketFactory = buildClientFactory();
        Socket socket = clientSocketFactory.createSocket(host, port);
        socket.setKeepAlive(true);
        socket.setSoTimeout(timeout);
        return socket;
    }


    public SSLSocketFactory buildClientFactory(String clientKeyStoreFile, String clientKeyStorePwd,
                                               String clientTrustKeyStoreFile, String clientTrustKeyStorePwd, String foxclientKeyPwd) throws Exception {
        // 生成指定密钥库类型的KeyStore对象
        KeyStore clientKeyStore = KeyStore.getInstance(keyStoreAlgorithm);
        InputStream ksInputStream = new FileInputStream(clientKeyStoreFile);
        try {
            // 加载密钥库
            clientKeyStore.load(ksInputStream, clientKeyStorePwd.toCharArray());
        } finally {
            ksInputStream.close();
        }
        // 生成实现指定密钥管理算法的 KeyManagerFactory对象
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(trustManagerAlgorithm);
        // 初始化密钥管理器工厂
        kmf.init(clientKeyStore, foxclientKeyPwd.toCharArray());
        // 生成指定密钥库类型的KeyStore对象
        KeyStore clientTrustKeyStore = KeyStore.getInstance(keyStoreAlgorithm);
        InputStream tsInputStream = new FileInputStream(clientTrustKeyStoreFile);
        try {
            // 加载信任密钥库
            clientTrustKeyStore.load(tsInputStream, clientTrustKeyStorePwd.toCharArray());
        } finally {
            tsInputStream.close();
        }
        // 生成充当信任管理器工厂的 TrustManagerFactory对象
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(trustManagerAlgorithm);
        // 初始化信任管理器工厂
        tmf.init(clientTrustKeyStore);
        // 生成实现指定安全套接字协议的 SSLContext对象
        SSLContext ctx = SSLContext.getInstance(sslContextAlgorithm);
        // 初始化SSL上下文对象
        ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        return ctx.getSocketFactory();
    }

    public synchronized SSLSocketFactory buildClientFactory(String clientKeyStore, String clientKey) throws Exception {
        KeyStore keystore = KeyStore.getInstance(keyStoreAlgorithm); // 创建一个keystore来管理密钥库
        keystore.load(new FileInputStream(clientKeyStore),clientKey.toCharArray());
        // 创建jkd密钥访问库
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(trustManagerAlgorithm);
        tmf.init(keystore); // 验证数据，可以不传入key密码
        // //创建TrustManagerFactory,管理授权证书
        SSLContext sc = SSLContext.getInstance(sslContextAlgorithm);
        // 构造SSL环境，指定SSL版本为3.0，也可以使用TLSv1，但是SSLv3更加常用。
        sc.init(null, tmf.getTrustManagers(), null);
        return sc.getSocketFactory();
    }

    public synchronized SSLSocketFactory buildClientFactory() throws Exception {
        // BouncyCastleProvider prvd = new BouncyCastleProvider();
        SSLContext sc = SSLContext.getInstance(sslContextAlgorithm);
        SSLHandler simpleVerifier = new SSLHandler();
        sc.init(null, new TrustManager[] { simpleVerifier }, null);
        return sc.getSocketFactory();
    }

    /**
     * @return 返回字段isSun的值.
     */
    public boolean isSun() {
        return isSun;
    }

    /**
     * @param isSun
     *            用以设置字段isSun的值.
     */
    public void setSun(boolean isSun) {
        this.isSun = isSun;
    }

    private static class SSLHandler implements X509TrustManager, HostnameVerifier {
        private SSLHandler() {
        }

        public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean verify(String arg0, SSLSession arg1) {
            return true;
        }
    }
}
