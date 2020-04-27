package com.cd.zhc.springcloud.cloud2020.payment.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cd.zhc.springcloud.api.commons.entities.Payment;

/**
 * @auther zzyy
 * @create 2020-02-18 10:27
 */
@Mapper
public interface PaymentDao {

    @Insert("insert into payment(serial) values (#{serial})")
    public int create(Payment payment);

    @Select("select * from payment where id=#{id}")
    public Payment getPaymentById(@Param("id") Long id);
}
