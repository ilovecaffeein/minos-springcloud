package com.caxs.minos.aeskey;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/**
 * @ClassName: CAXS2ZYBankData
 * @Description: 客户端
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class SocketClientUtil {
    // 打印日志属性
    private Log log = LogFactory.getLog(getClass());

    //数据转换为字符编码
    private static String encoding;
    private static String hostname;
    private static int port;
    private static int portssl;

    private static String clientkeystore;
    private static String clientPass;
    private static String clienttrustkeystore;
    private static String clienttrustPass;
    private static String foxclientKeyPwd;

    private static String issendssl;


    public SocketClientUtil(){
        encoding = "UTF-8";
        hostname = CAXS2ZYBankData.hostname;
        port = CAXS2ZYBankData.port;
        portssl = CAXS2ZYBankData.portssl;
        //keystore
        clientkeystore = CAXS2ZYBankData.clientkeystore;
        clientPass = CAXS2ZYBankData.clientPass;
        clienttrustkeystore = CAXS2ZYBankData.clienttrustkeystore;
        clienttrustPass = CAXS2ZYBankData.clienttrustPass;
        foxclientKeyPwd = CAXS2ZYBankData.foxclientKeyPwd;
        issendssl = CAXS2ZYBankData.issendssl;
    }

    /**
     * 判断是否使用SSL
     * @param str
     * @return
     * @throws Exception
     */
    public String socketSendData(String str) throws Exception{
        String resulStr="";
        if("yes".equals(issendssl)){
            resulStr = this.socketSendDataSSL(str);
        }else{
            resulStr = this.socketSendDataNIO(str);
        }
        return resulStr;
    }

    /**
     * 客户端发送数据请求
     * @param str 数据处理接口
     * @throws IOException
     * @return 处理结果
     */
    public String socketSendDataNIO(String str) throws IOException,Exception{
        long start = System.currentTimeMillis();

        SocketChannel channel = null;
        String dataStr = "";//请求报文
        String responseDataStr = "";//反馈报文
        try {
            //连接
            channel = SocketChannel.open();
            SocketAddress address = new InetSocketAddress(hostname, port);
            channel.connect(address);

            //设置超时时间
            channel.socket().setSoTimeout(60000);
            //组装数据，请求数据处理
            //dataStr = operateDataImpl.opClientRequestdata();
            String reqXMLStr =getMessageLong(str) + str;
            log.info("****发送到中原银行报文噢噢： \n" + reqXMLStr);
            //发送数据
            byte[] bytesin = reqXMLStr.getBytes(encoding);
            ByteBuffer bufferin = ByteBuffer.wrap(bytesin);
            channel.write(bufferin);
            channel.socket().shutdownOutput();
            //接收数据
            responseDataStr = this.receiveData(channel);
            log.info("****接收到中原银行报文噢噢： \n" + responseDataStr);
        } catch (Exception e) {
            //保存交易记录，错误
            e.printStackTrace();
            throw new Exception(e);
        } finally{
            if(channel!=null){
                channel.close();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Socket调用处理时间："+(end-start)+"ms.");
        return responseDataStr;
    }

    /**
     * 客户端发送SSL数据请求，带安全证书连接
     * @param str 数据处理接口
     * @throws IOException
     * @return 处理结果
     */
    public String socketSendDataSSL(String str) throws Exception{
        long start = System.currentTimeMillis();

        SSLFactory sslFactory = null;
        SSLSocketFactory clientSocketFactory = null;
        String responseDataStr = "";//反馈报文
        Socket socket = null;
        try {
            sslFactory = new SSLFactory();
            //组装数据，请求数据处理
            //dataStr = operateDataImpl.opClientRequestdata();
            String reqXMLStr =getMessageLong(str) + str;
            log.info("####发送到中原银行报文噢噢： \n" + reqXMLStr);
            clientSocketFactory = sslFactory.buildClientFactory(clientkeystore,clientPass,
                    clienttrustkeystore,clienttrustPass,foxclientKeyPwd);
            //"1.192.127.106", 9000
            socket = clientSocketFactory.createSocket(hostname, portssl);

            //设置超时时间
            socket.setSoTimeout(60000);

            byte[] bytesin = reqXMLStr.getBytes(encoding);
            OutputStream os = socket.getOutputStream();
            os.write(bytesin);
            //socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            responseDataStr = new String(readStream(is),encoding);
            log.info("####接收到中原银行报文噢噢： \n" + responseDataStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }finally{
            if(socket!=null){
                socket.close();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Socket调用处理时间："+(end-start)+"ms.");
        return responseDataStr;
    }

    /**
     * 返回字符串的长度，如不足6位，前面补0
     * @param message
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getMessageLong(String message) throws UnsupportedEncodingException{
        String messageLong = "000000";
        if(message==null){
            return messageLong;
        }
        //字符串长度
        byte[] mb = message.getBytes("UTF-8");
        //int ml = message.length();//不准确
        int ml = mb.length;//已流的长度计算（二进制数组的长度）
        //补0
        if(ml < 10){
            messageLong = "00000"+ml;
        }else if(ml>=10 && ml<100){
            messageLong = "0000"+ml;
        }else if(ml>=100 && ml<1000){
            messageLong = "000"+ml;
        }else if(ml>=1000 && ml<10000){
            messageLong = "00"+ml;
        }else if(ml>=10000 && ml<100000){
            messageLong = "0"+ml;
        }else{
            messageLong = ""+ml;
        }
        return messageLong;
    }

    /**
     * 接收数据
     * @param socketChannel
     * @return
     * @throws IOException
     */
    private String receiveData(SocketChannel socketChannel)throws IOException {
        String resultstr = "failed";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            byte[] bytes;
            int count = 0;
            while ((count = socketChannel.read(buffer)) >= 0) {
                buffer.flip();
                bytes = new byte[count];
                buffer.get(bytes);
                baos.write(bytes);
                buffer.clear();
            }
            bytes = baos.toByteArray();
            resultstr = new String(bytes, encoding);//接收的数据
            socketChannel.socket().shutdownInput();
        } finally {
            try {
                baos.close();
            } catch (Exception ex) {
            }
        }
        return resultstr;
    }

    /**
     * 接收数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        byte[] resultbyte = null;
        ByteArrayOutputStream outSteam = null;
        try {
            outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            resultbyte = outSteam.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally{
            if(outSteam!=null){
                outSteam.close();
            }
        }
        return resultbyte;
    }

}
