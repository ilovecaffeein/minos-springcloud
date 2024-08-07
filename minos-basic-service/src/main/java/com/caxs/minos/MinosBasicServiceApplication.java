package com.caxs.minos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/***
 * @ClassName(类名) : MinosBasicServiceApplication
 * @Description(描述) : minos-basic-service-核算应用服务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/16 14:45
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MinosBasicServiceApplication {

    public static void main( String[] args ) {
        SpringApplication.run(MinosBasicServiceApplication.class, args);
        System.out.println( "*********** MINOS-BASIC-SERVICE-核算应用服务开启! ***********" );
    }
}
