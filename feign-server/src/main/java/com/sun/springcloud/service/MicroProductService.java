/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: ProductService
 * Author:   sun
 * Date:     2020/4/12 20:48
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 20:48           v1.0.0
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
@FeignClient(value = "MICRO-PRODUCT-SERVICE")   //对应微服务的servername
public interface MicroProductService {

    @PostMapping(value = "/goods/deductionGoods")   //对应微服务的controller方法和请求地址
    ResponseResult deductionGoods(@RequestBody PayVo vo);
}