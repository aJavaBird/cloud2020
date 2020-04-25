package com.cd.zhc.springcloud.cloud2020.payment.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cd.zhc.springcloud.api.commons.entities.Payment;
import com.cd.zhc.springcloud.cloud2020.payment.dao.PaymentDao;
import com.cd.zhc.springcloud.cloud2020.payment.service.PaymentService;

/**
 * @auther zzyy
 * @create 2020-02-18 10:40
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
