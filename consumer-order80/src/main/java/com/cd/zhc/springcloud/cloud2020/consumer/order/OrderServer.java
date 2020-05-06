package com.cd.zhc.springcloud.cloud2020.consumer.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.cd.zhc.springcloud.cloud2020.consumer.order.rules.MyRibbonRules;

@SpringBootApplication
// ribbon 配置负载均衡，必须把 负载的规则类排除在外，或者类路径需要改到 ....cloud2020.consumer.xxx 路径（不能是 cloud2020.consumer.order 路径及其子路径）
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { MyRibbonRules.class }) })
// @RibbonClient 指定的规则类，不能被自动扫描，需要配合 @ComponentScan 的 excludeFilters 使用
@RibbonClient(name = "${payment.application.name}", configuration = MyRibbonRules.class)
// 如果 不使用 @RibbonClient，则可以把 @ComponentScan 这一行也去掉（当然也可以不去），因为 @SpringBootApplication 中本来就包含了 @ComponentScan 的
// 如果 不使用 @RibbonClient，则默认的是轮询规则
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableEurekaClient
public class OrderServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class, args);
    }
}
