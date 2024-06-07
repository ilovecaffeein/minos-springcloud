package com.caxs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/***
 * @ClassName(类名) : MinosBasicServiceController
 * @Description(描述) : minos-basic-service-核算应用服务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/16 14:45
 */
@RestController
@RefreshScope
public class MinosBasicServiceController {

     @Value("${message}")
     String result;

     @RequestMapping("/configInfo")
     public String getConfig() {
         return   result;
     }
}
