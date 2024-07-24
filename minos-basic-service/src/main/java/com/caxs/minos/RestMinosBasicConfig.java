package com.caxs.minos;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
/***
 * @ClassName(类名) : RestConfig
 * @Description(描述) : minos-basic-service-核算应用服务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/16 14:45
 */
@Configuration
public class RestMinosBasicConfig {

    @Bean
    public HttpHeaders getHeader(){ //要进行一个http头信息配置
        HttpHeaders headers = new HttpHeaders(); //定义一个HTTP头信息
        return headers;
    }

    @Bean
    @LoadBalanced
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }
}
