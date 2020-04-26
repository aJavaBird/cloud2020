package com.cd.zhc.springcloud.cloud2020.consumer.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cd.zhc.springcloud.api.commons.entities.CommonResult;
import com.cd.zhc.springcloud.api.commons.entities.Payment;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderPaymentController {

    @Value("${payment.url}")
    private String PAYMENT_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/order/create")
    public CommonResult create(Payment payment) {
        String url = PAYMENT_URL + "/payment/createRest";
        log.info("create payment: " + payment);
        return restTemplate.postForObject(url, payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/order/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        String url = PAYMENT_URL + "/payment/get/" + id;
        log.info("query payment : id=" + id);
        return restTemplate.getForObject(url, CommonResult.class);
    }

}
