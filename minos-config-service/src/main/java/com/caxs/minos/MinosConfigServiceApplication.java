package com.caxs.minos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/***
 * @ClassName(类名) : MinosConfigServiceApplication
 * @Description(描述) : minos-config-service-配置中心服务端
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/16 14:45
 */
@SpringBootApplication
@EnableConfigServer
public class MinosConfigServiceApplication {
    public static void main( String[] args ) {
        SpringApplication.run(MinosConfigServiceApplication.class, args);
        System.out.println( "*********** MINOS-CONFIG-SERVICE-配置中心服务端开启! ***********" );
        System.out.println( "*********** 默认参数地址：http://localhost:8091/main/config-prod.properties  ***********" );
    }
}
