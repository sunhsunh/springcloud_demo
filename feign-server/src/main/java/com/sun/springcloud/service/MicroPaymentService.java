/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: PaymentService
 * Author:   sun
 * Date:     2020/4/12 20:46
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 20:46           v1.0.0
 */
package com.sun.springcloud.service;

import com.sun.springcloud.vo.PayVo;
import com.sun.springcloud.vo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/12
 * @since v1.0.0
 */
@Component
@FeignClient(value = "MICRO-PAYMENT-SERVICE")   //对应微服务的servername
public interface MicroPaymentService {
    @PostMapping(value = "/payment/createPaymentLog")   //对应微服务的controller方法和请求地址
    ResponseResult createPaymentLog(@RequestBody PayVo vo);
}