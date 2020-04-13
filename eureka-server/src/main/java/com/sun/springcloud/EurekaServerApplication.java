/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: eurekaServerApplication
 * Author:   sun
 * Date:     2020/4/12 17:26
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 17:26           v1.0.0
 */
package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/12
 * @since v1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}