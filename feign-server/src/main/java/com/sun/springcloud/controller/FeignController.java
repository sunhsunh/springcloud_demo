/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: FeignController
 * Author:   sun
 * Date:     2020/4/12 20:42
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 20:42           v1.0.0
 */
package com.sun.springcloud.controller;

import com.sun.springcloud.service.MicroOrderService;
import com.sun.springcloud.service.MicroPaymentService;
import com.sun.springcloud.service.MicroProductService;
import com.sun.springcloud.vo.PayVo;
import com.sun.springcloud.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/12
 * @since v1.0.0
 */
@RestController
public class FeignController {

    @Autowired
    private MicroPaymentService paymentService;

    @Autowired
    private MicroOrderService orderService;

    @Autowired
    private MicroProductService productService;

    @RequestMapping(value = "/feign/pay")
    public void pay(@RequestBody PayVo payVo){
        ResponseResult paymentResult = paymentService.createPaymentLog(payVo);
        ResponseResult orderResult = orderService.createOrder(payVo);
        ResponseResult productResult = productService.deductionGoods(payVo);
        System.out.println("paymentResult: " + paymentResult);
        System.out.println("orderResult: " + orderResult);
        System.out.println("productResult: " + productResult);
    }
}