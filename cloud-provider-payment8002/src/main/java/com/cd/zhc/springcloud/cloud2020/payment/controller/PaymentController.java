package com.cd.zhc.springcloud.cloud2020.payment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.zhc.springcloud.api.commons.entities.CommonResult;
import com.cd.zhc.springcloud.api.commons.entities.Payment;
import com.cd.zhc.springcloud.cloud2020.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) { // 直接调用
        return CreateCommon(payment);
    }

    @PostMapping(value = "/payment/createRest")
    public CommonResult createRest(@RequestBody Payment payment) { // 使用其他模块调用（RestTemplate）
        return CreateCommon(payment);
    }

    public CommonResult CreateCommon(Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:  " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    @RequestMapping("/payment/discovery")
    public CommonResult<Map> discovery() {
        Map<String, Object> mapObj = new HashMap<>();
        List<Object> serviceList = new ArrayList<>();
        for (String serviceId : discoveryClient.getServices()) {
            serviceList.add(discoveryClient.getInstances(serviceId));
        }
        mapObj.put("services", serviceList);
        return new CommonResult(200, "查询成功,serverPort:  " + serverPort, mapObj);
    }

}
