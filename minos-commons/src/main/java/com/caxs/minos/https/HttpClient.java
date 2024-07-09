package com.caxs.minos.https;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.HttpURLConnection;
import java.io.*;
import java.net.URL;
/**
 * @ClassName: HttpClient
 * @Description: http 请求
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class HttpClient{
    /**
     * @Author(作者): coffee
     * @Description(方法描述): https POST方法
     * @Date(创建日期): Create in 15:59 2017/10/16
     * @Company: 【长安新生（深圳）金融投资有限公司】
     */
    public static String sendHttpPost(String urlPath, String param) {
        String responseMsg = "";
        PostMethod postMethod=new PostMethod(urlPath);
        org.apache.commons.httpclient.HttpClient httpClient=new org.apache.commons.httpclient.HttpClient();
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
        postMethod.setParameter("data",param);

        try {
            httpClient.executeMethod(postMethod);
            responseMsg = postMethod.getResponseBodyAsString().trim();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    }

    /**
     * @Author(作者): coffee
     * @Description(方法描述): http POST方法
     * @Date(创建日期): Create in 15:59 2017/10/16
     * @Company: 【长安新生（深圳）金融投资有限公司】
     */
    public static String senJsonPost(String url, String param){
        URL sendUrl;
        HttpURLConnection connect;
        //创建具有指定文件和字符集且不带自动刷行新的新 PrintWriter
        PrintWriter writer = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try{
            //取得url对象
            sendUrl = new URL(url);
            //获得打开url链接资源的 URLConnection对象
            connect = (HttpURLConnection) sendUrl.openConnection();
            //设置请求属性
            connect.setRequestProperty("accept", "*/*");
            //设置长连接
            connect.setRequestProperty("connection", "Keep-Alive");
            //设置本次发送的文本格式
            connect.setRequestProperty("Content-Type","application/json");
            //设置为POST
            connect.setRequestMethod("POST");
            //允许写入
            connect.setDoOutput(true);
            //允许输出
            connect.setDoInput(true);
            //设置连接超时，读取超时
            connect.setConnectTimeout(1000*120);
            connect.setReadTimeout(1000*120);
            //不使用缓存
            connect.setUseCaches(false);
            //设置本次链接可以重定向
            connect.setInstanceFollowRedirects(true);
            //打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）
            connect.connect();

            //创建输出流 通过UTF-8编码之后的connect的输出流
            writer = new PrintWriter(new OutputStreamWriter(connect.getOutputStream(),"UTF-8"));
            writer.write(param);
            //强制把缓冲区的数据写入到文件并清空缓冲区
            writer.flush();

            //定义缓冲区输入流获得url的相应信息 从URL连接中用输入流获取
            in = new BufferedReader(new InputStreamReader(connect.getInputStream(),"UTF-8"));
            String line;
            //从缓冲输入流中读取数据
            while((line = in.readLine())!=null){
                result.append(line);
            }
        }catch (Exception e){
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("post请求出现错误！"+e);
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
