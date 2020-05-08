/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongoDBClient
 * Author:   sun
 * Date:     2020/4/24 10:41
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 10:41           v1.0.0
 */
package com.sun.mongo.config;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * MongoDB客户端
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
@Component
public class MongoDBClient {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 获取MongoTemplate
     * @return
     */
    public MongoTemplate returnTemplate(){
        return mongoTemplate;
    }

    /**
     * 创建集合 并返回是否创建成功  -2：已存在 / null：创建失败 / 1：创建成功
     * @param collectionName
     * @return
     */
    public Integer createCollection(String collectionName) {
        // 先判断集合是否存在
        if (mongoTemplate.collectionExists(collectionName)) {
            return -2;
        } else {
            // 创建一个集合
            mongoTemplate.createCollection(collectionName);
            // 判断集合是否存在
            if (mongoTemplate.collectionExists(collectionName)) {
                return 1;
            } else {
                return null;
            }
        }
    }

    /**
     * 根据对象在指定集合中保存数据
     * @param object
     * @param collectionName
     * @param <T>
     * @return
     */
    public <T> T save(T object, String collectionName) {
        return mongoTemplate.save(object, collectionName);
    }

    /**
     * 在指定集合中批量添加数据
     * @param batchToSave
     * @param collectionName
     */
    public void add(Collection<?> batchToSave, String collectionName) {
        mongoTemplate.insert(batchToSave, collectionName);
    }

    /**
     * 根据条件和集合名称查询数据
     * @param query
     * @param object
     * @param collectionName
     * @return
     */
    public List<?> getByConditionAndCollectionName(Query query, Object object, String collectionName) {
        return mongoTemplate.find(query, object.getClass(), collectionName);
    }

    /**
     * 根据条件和指定集合删除数据
     * @param query
     * @param obj
     * @param collectionName
     */
    public DeleteResult delete(Query query, Object obj, String collectionName) {
        return mongoTemplate.remove(query, obj.getClass(), collectionName);
    }

    /**
     * 根据条件更新数据
     * @param query
     * @param update
     * @param obj
     * @param collectionName
     * @return
     */
    public UpdateResult update(Query query, Update update, Object obj, String collectionName) {
        return mongoTemplate.updateMulti(query, update, obj.getClass(), collectionName);
    }

    /**
     * 获取指定集合下的全部数据
     * @param obj
     * @param collectionName
     * @return
     */
    public List<?> getAllByCollectionName(Object obj, String collectionName) {
        return mongoTemplate.findAll(obj.getClass(), collectionName);
    }

    /**
     * 根据条件获取总素
     * @param query
     * @param object
     * @param collectionName
     * @return
     */
    public Long count(Query query, Object object, String collectionName) {
        long tolal = mongoTemplate.count(query, object.getClass(), collectionName);
        return tolal;
    }

    /**
     * 根据id查询
     * @param query
     * @param object
     * @param collectionName
     * @return
     */
    public Object findOne(Query query, Object object, String collectionName) {
        return mongoTemplate.findOne(query, object.getClass(), collectionName);
    }

    /**
     * 根据id更新数据
     * @param id
     * @param collectionName
     * @param info
     * @param userId
     * @param <T>
     * @throws IllegalAccessException
     */
    public <T> void updateById(String id, String collectionName, T info,Integer userId) throws IllegalAccessException {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        Class cls = info.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);
            if(!f.getName().equals("id")) {
                update.set(f.getName(), f.get(info));
            }
        }
        update.set("cUser",userId);
        update.set("cTime",new Date());
        mongoTemplate.updateMulti(query, update, info.getClass(), collectionName);
    }
}