package com.sun.springcloud;/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: com.sun.springcloud.MicroPaymentServer
 * Author:   sun
 * Date:     2020/4/12 18:24
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 18:24           v1.0.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/12
 * @since v1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroPaymentServer {

    public static void main(String[] args) {
        SpringApplication.run(MicroPaymentServer.class, args);
    }
}