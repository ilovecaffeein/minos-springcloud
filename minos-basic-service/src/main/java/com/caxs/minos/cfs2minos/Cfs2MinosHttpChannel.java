package com.caxs.minos.cfs2minos;

import com.caxs.minos.controller.Serv10000100027Buz;
import com.caxs.minos.controller.Serv10000100040Buz;
import com.caxs.minos.domain.param.XmlResponseMsg;
import com.caxs.minos.enums.ServBuzCodeEnum;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.xml.XmlTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.Serializable;
/***
 * @ClassName(类名) : Cfs2MinosHttpChannel
 * @Description(描述) : 信贷系统请求核算系统请求统一入口
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/7/31 15:36
 */
@Controller
@RequestMapping("/minos")
public class Cfs2MinosHttpChannel {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass().getName());

    @Resource
    Serv10000100027Buz serv10000100027Buz ;

    @Resource
    Serv10000100040Buz serv10000100040Buz ;

    @RequestMapping("/Cfs2MinosHttpChannel")
    @ResponseBody
    public Object Cmis2YcloansHttpChannel(HttpServletRequest request, HttpServletResponse response){
        XmlResponseMsg xmlResponseMsg  =new XmlResponseMsg();
        String reqBody = null;
        String serviceId = null;

        // 服务接口
        try {
            servletRequest(request);
            serviceId = ((String) request.getAttribute("serviceId"));
            reqBody = ((String) request.getAttribute("reqBody"));

            // 服务接口
            try {
                Class<? extends Serializable> destClass  = (Class<? extends Serializable>) Class.forName(
                        ServBuzCodeEnum.NULL.getWholePath(serviceId));
                log.debug("日终批处理类：" + destClass);
                if ( destClass.newInstance() instanceof Serv10000100027Buz)
                    return  serv10000100027Buz.execute(reqBody); //放款试算
                else if( destClass.newInstance() instanceof Serv10000100040Buz)
                    return  serv10000100040Buz.execute(reqBody); //主动还款试算
                else
                    throw new MinosException("无效的交易码！");
            } catch ( NoSuchBeanDefinitionException ne) {
                throw new Cfs2MinosException(MinosException.ERROR99999);
            } catch ( Cfs2MinosException e) {
                xmlResponseMsg.setErrorCode(e.getCode());
                xmlResponseMsg.setErrorMsg(e.getMsg());
                log.debug("返回报文：" + generaResponse(xmlResponseMsg));
                return generaResponse(xmlResponseMsg);
            }
        }catch ( Cfs2MinosException e) {
            log.error(e);
        } catch ( Exception e) {
            log.error(e);
        }
        return null;
    }

    /***
     * @ClassName(类名) : servletRequest
     * @Description(描述) : 获取服务名称
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/7/31 15:36
     */
    public void servletRequest(HttpServletRequest request) throws Exception {
        String reqBoday;
        InputStream in = request.getInputStream();
        int len = request.getContentLength();
        if (len <= 0) {
            len = 2048;
        }
        byte[] tmp = new byte[2048];
        byte[] buffer = new byte[len];
        int totalLen = 0;
        while (true) {
            int readLen = in.read(tmp, 0, 2048);
            if (readLen <= 0) {
                break;
            }
            if (readLen + totalLen > len) {
                len = len + readLen + 2048;
                byte[] aa = new byte[len];
                System.arraycopy(buffer, 0, aa, 0, totalLen);
                buffer = aa;
            }
            System.arraycopy(tmp, 0, buffer, totalLen, readLen);
            totalLen += readLen;
        }

        String encoding = request.getCharacterEncoding();
        if (encoding == null)
            reqBoday = new String(buffer, 0, totalLen,"GBK");
        else {
            reqBoday = new String(buffer, 0, totalLen, "GBK");
        }

        //获取报文头：XXXXX;serv10000100041;
        int b = reqBoday.indexOf("<?xml", 0);
        byte[] bufferSer = new byte[b];
        System.arraycopy(buffer, 0, bufferSer, 0, b);
        String service = new String(bufferSer, 0, b, encoding);
        String[] serviceId = service.split(";");

        //获取<?xml之后的数据
        reqBoday = reqBoday.substring(b);
        //赋值操作
        request.setAttribute("serviceId", serviceId[1]);
        request.setAttribute("reqBody", reqBoday);
        log.info("::::交易报文： " + reqBoday);
    }

    /**
     * @Description: 构造系统发生错误时的返回报文
     * @param xmlResponse 返回错误内容
     * @Date: 2020/8/17 11:42
     * @Author: zhuruilong
     * @Return java.lang.String
     * @Throws
     */
    public static String generaResponse(XmlResponseMsg xmlResponse) {
        try {
            // 组装返回报文
            return XmlTool.buildXmlOfJaxb(xmlResponse, XmlResponseMsg.class);
        }catch(Exception e){
            return "";
        }
    }

}
