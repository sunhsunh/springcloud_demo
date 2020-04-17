/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongoDbFactoryDependentConfiguration
 * Author:   sun
 * Date:     2020/4/17 17:13
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/17 17:13           v1.0.0
 */
package com.sun.mongo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * MappingMongoConverter可以自定义mongo转换器，主要自定义存取mongo数据时的一些操作，例如 mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null)) 方法会将mongo数据中的_class字段去掉。
 *
 * 最后通过 new SimpleMongoDbFactory(mongoClient, properties.getDatabase())方法配置了一个MongoDbFactory交由Spring管理，Springboot会拿这个MongoDbFactory工厂bean来new一个MongoTemplate，在MongoDbFactoryDependentConfiguration类下可以看到SpringBoot帮你做得事：
 *
 * @author sun
 * @create 2020/4/17
 * @since v1.0.0
 */
@Configuration
@ConditionalOnBean(MongoDbFactory.class)
class MongoDbFactoryDependentConfiguration {

    private final MongoProperties properties;

    public MongoDbFactoryDependentConfiguration(MongoProperties properties) {
        this.properties = properties;
    }

    //SpringBoot创建MongoTemplate实例
    @Bean
    @ConditionalOnMissingBean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoConverter converter) {
        return new MongoTemplate(mongoDbFactory, converter);
    }

    @Bean
    @ConditionalOnMissingBean(MongoConverter.class)
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context,
                                                       MongoCustomConversions conversions) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        mappingConverter.setCustomConversions(conversions);
        return mappingConverter;
    }
}