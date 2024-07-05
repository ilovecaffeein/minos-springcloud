package com.caxs.minos;

import org.apache.http.util.TextUtils;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Unit test for simple App.
 */
public class MinosBasicServiceApplicationTest  {

    public static void main(String[] args) {
        try {

            final String str = "http://localhost:4444/minos-basic-service/Cfs2MinosHttpChannel";

            String reqMsg = "XXXXX;serv10000100040;";
            String filepath = "C://glycloans-xml/040.xml";

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File(filepath)), "GBK"));
            while (br.ready()) {
                reqMsg += br.readLine();
            }
            System.out.println("[==repMsg==]" + reqMsg.toString());
            br.close();
            sendPostHttl(str,reqMsg);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author(作者): coffee
     * @Description(方法描述): http POST方法
     * @Date(创建日期): Create in 15:59 2017/10/16
     * @Company: 【长安新生（深圳）金融投资有限公司】
     */
    public static  String sendPostHttl(String urlPath, String param) {
        // HttpClient 6.0被抛弃了
        String result = "";
        BufferedReader reader = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            // 设置文件类型:
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            // 设置接收类型否则返回415错误
            //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
            conn.setRequestProperty("accept", "application/json");

            // 往服务器里面发送数据
            if (param != null && !TextUtils.isEmpty(param)) {
                byte[] writebytes = param.getBytes();
                // 设置文件长度
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(param.getBytes());
                outwritestream.flush();
                outwritestream.close();
            }
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                result = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
