package com.caxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/***
 * @ClassName(类名) : MinosOutsideServiceApplication
 * @Description(描述) : minos-outside-service-核算应用服务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/16 14:45
 */
@SpringBootApplication
public class MinosOutsideServiceApplication {
    public static void main( String[] args ) {
        SpringApplication.run(MinosOutsideServiceApplication.class, args);
        System.out.println( "*********** minos-outside-service-核算应用服务开启! ***********" );
    }
}