package com.caxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @ClassName(类名) : EurekaServerApplication
 * @Description(描述) : glycloans-eureka-service-注册中心
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/16 14:45
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    public static void main( String[] args ){
        SpringApplication.run(EurekaServerApplication.class, args);
        System.out.println( "*********** glycloans-eureka-service-注册中心服务端开启! ***********" );
    }
}
