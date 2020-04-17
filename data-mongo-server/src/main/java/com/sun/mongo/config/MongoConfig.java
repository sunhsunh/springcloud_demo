/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongoConfig
 * Author:   sun
 * Date:     2020/4/17 17:09
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/17 17:09           v1.0.0
 */
package com.sun.mongo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/17
 * @since v1.0.0
 */

@Configuration
public class MongoConfig {

    /**
     * monogo 转换器
     *
     * @return
     */
    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory,
                                                       MongoMappingContext context, BeanFactory beanFactory, MongoCustomConversions conversions) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        // 删除 _class field
//    mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        mappingConverter.setCustomConversions(conversions);
        return mappingConverter;
    }

    /**
     * 自定义mongo连接池
     *
     * @param properties
     * @return
     */
    @Bean
    public MongoDbFactory mongoDbFactory(MongoClientOptionProperties properties) {
        //创建客户端参数
        MongoClientOptions options = mongoClientOptions(properties);

        //创建客户端和Factory
        List<ServerAddress> serverAddresses = new ArrayList<>();
        for (String address : properties.getAddress()) {
            String[] hostAndPort = address.split(":");
            String host = hostAndPort[0];
            Integer port = Integer.parseInt(hostAndPort[1]);
            ServerAddress serverAddress = new ServerAddress(host, port);
            serverAddresses.add(serverAddress);
        }

        //创建认证客户端
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(properties.getUsername(),
                properties.getAuthenticationDatabase() != null ? properties.getAuthenticationDatabase() : properties.getDatabase(),
                properties.getPassword().toCharArray());

        MongoClient mongoClient = new MongoClient(serverAddresses, mongoCredential, options);

        /** ps: 创建非认证客户端*/
        //MongoClient mongoClient = new MongoClient(serverAddresses, mongoClientOptions);
        return new SimpleMongoDbFactory(mongoClient, properties.getDatabase());
    }

    /**
     * mongo客户端参数配置
     *
     * @return
     */
    @Bean
    public MongoClientOptions mongoClientOptions(MongoClientOptionProperties properties) {
        return MongoClientOptions.builder()
                .connectTimeout(properties.getConnectionTimeoutMs())
                .socketTimeout(properties.getReadTimeoutMs()).applicationName(properties.getClientName())
                .heartbeatConnectTimeout(properties.getHeartbeatConnectionTimeoutMs())
                .heartbeatSocketTimeout(properties.getHeartbeatReadTimeoutMs())
                .heartbeatFrequency(properties.getHeartbeatFrequencyMs())
                .minHeartbeatFrequency(properties.getMinHeartbeatFrequencyMs())
                .maxConnectionIdleTime(properties.getConnectionMaxIdleTimeMs())
                .maxConnectionLifeTime(properties.getConnectionMaxLifeTimeMs())
                .maxWaitTime(properties.getPoolMaxWaitTimeMs())
                .connectionsPerHost(properties.getConnectionsPerHost())
                .threadsAllowedToBlockForConnectionMultiplier(
                        properties.getThreadsAllowedToBlockForConnectionMultiplier())
                .minConnectionsPerHost(properties.getMinConnectionsPerHost()).build();
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "mongodb")
    public MongoClientOptionProperties mongoClientOptionProperties() {
        return new MongoClientOptionProperties();
    }

}


