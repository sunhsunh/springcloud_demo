/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: OrderControlelr
 * Author:   sun
 * Date:     2020/4/12 19:29
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 19:29           v1.0.0
 */
package com.sun.springcloud.controller;

import com.sun.springcloud.vo.PayVo;
import com.sun.springcloud.vo.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/12
 * @since v1.0.0
 */
@RestController
public class OrderControlelr {

    @PostMapping(value = "/order/createOrder")
    public ResponseResult createOrder(@RequestBody PayVo vo){
        return new ResponseResult("200","SUCCESS");
    }
}