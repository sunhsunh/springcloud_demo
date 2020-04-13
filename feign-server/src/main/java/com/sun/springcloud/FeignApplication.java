/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: FeignApplication
 * Author:   sun
 * Date:     2020/4/12 20:40
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 20:40           v1.0.0
 */
package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/12
 * @since v1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class,args);
    }
}