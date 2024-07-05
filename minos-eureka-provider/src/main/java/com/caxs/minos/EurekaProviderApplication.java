package com.caxs.minos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/***
 * @ClassName(类名) : EurekaProviderApplication
 * @Description(描述) : minos-eureka-provider-注册中心客户端
 * @author(作者) ： coffee
 * @date (开发日期) ： 2025/5/20 14:45
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class EurekaProviderApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaProviderApplication.class, args);
        System.out.println( "*********** minos-eureka-provider-注册中心客户端开启! ***********" );
    }
}
