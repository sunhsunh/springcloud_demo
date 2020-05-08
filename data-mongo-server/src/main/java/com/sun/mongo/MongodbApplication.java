/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongodbApplication
 * Author:   sun
 * Date:     2020/4/24 14:02
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 14:02           v1.0.0
 */
package com.sun.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }
}