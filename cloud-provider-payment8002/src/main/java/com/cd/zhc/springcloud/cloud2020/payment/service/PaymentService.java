package com.cd.zhc.springcloud.cloud2020.payment.service;

import org.apache.ibatis.annotations.Param;

import com.cd.zhc.springcloud.api.commons.entities.Payment;

/**
 * @auther zzyy
 * @create 2020-02-18 10:40
 */
public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
