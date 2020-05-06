package com.cd.zhc.springcloud.cloud2020.consumer.order.rules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MyRibbonRules {

    @Bean
    public IRule getRandomRule() {
        return new RandomRule();
    }
}
