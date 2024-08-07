package com.caxs.minos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/***
 * @ClassName(类名) : EurekaServerApplication
 * @Description(描述) : minos-eureka-service-注册中心
 * @author(作者) ： coffee
 * @date (开发日期) ： 2024/6/16 14:45
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main( String[] args ){
        SpringApplication.run(EurekaServerApplication.class, args);
        System.out.println( "*********** MINOS-EUREKA-SERVICE-注册中心服务端开启! ***********" );
        System.out.println( "*********** 启动默认地址：http://localhost:8090/  ***********" );
    }
}
