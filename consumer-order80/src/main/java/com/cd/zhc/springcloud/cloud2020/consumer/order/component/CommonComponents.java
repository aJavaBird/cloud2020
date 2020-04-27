package com.cd.zhc.springcloud.cloud2020.consumer.order.component;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonComponents {

    //    @Bean
    //    public RestTemplate getRestTemplate() {
    //        return new RestTemplate();
    //    }    
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
