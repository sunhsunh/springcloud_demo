/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongodbServiceImpl
 * Author:   sun
 * Date:     2020/4/24 10:32
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 10:32           v1.0.0
 */
package com.sun.mongo.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.sun.mongo.config.MongoDBClient;
import com.sun.mongo.service.MongodbService;
import com.sun.springcloud.param.UserParam;
import com.sun.springcloud.util.PageInfo;
import com.sun.springcloud.util.StringUtil;
import com.sun.springcloud.vo.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
@Service
public class MongodbServiceImpl implements MongodbService {

    @Autowired
    private MongoDBClient mongoDBClient;

    @Override
    public User saveOrUpdate(User user) {
        if(user.getId() != null && !"".equals(user.getId())){
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(user.getId()));
            Document doc = new Document();
            mongoDBClient.returnTemplate().getConverter().write(user, doc);
            Update update = Update.fromDocument(doc);
            UpdateResult result = mongoDBClient.update(query,update,user,"user");
            if(result.getMatchedCount() > 0 && result.getModifiedCount() > 0){
                return user;
            }
            throw new RuntimeException();
        }else{
            User u = mongoDBClient.save(user,"user");
            return u;
        }
    }

    @Override
    public Integer delete(User user) {
        Query query = Query.query(Criteria.where("_id").is(user.getId()));
        DeleteResult result = mongoDBClient.delete(query,user,"user");
        return (int)result.getDeletedCount();
    }

    @Override
    public List<User> queryWithCondition(UserParam param) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if(StringUtil.notEmpty(param.getId())){
            criteria.andOperator(Criteria.where("_id").is(param.getId()));
        }
        if(StringUtil.notEmpty(param.getName())){
            /*//完全匹配
            Pattern pattern = Pattern.compile("^张$", Pattern.CASE_INSENSITIVE);
            //右匹配
            Pattern pattern = Pattern.compile("^.*张$", Pattern.CASE_INSENSITIVE);
            //左匹配
            Pattern pattern = Pattern.compile("^张.*$", Pattern.CASE_INSENSITIVE);
            //模糊匹配
            Pattern pattern = Pattern.compile("^.*张.*$", Pattern.CASE_INSENSITIVE);*/

            /*Pattern pattern = Pattern.compile("^.*" + user.getName() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.andOperator(Criteria.where("name").regex(pattern));*/

            query.addCriteria(criteria.where("name").regex(".*?"+param.getName()+".*"));
        }
        if(StringUtil.notEmpty(param.getPhone())){
            criteria.andOperator(Criteria.where("phone").regex(".*?"+param.getPhone()+".*"));
        }
        if(param.getSex() != null){
            criteria.andOperator(Criteria.where("sex").is(param.getSex()));
        }

        return (List<User>)mongoDBClient.getByConditionAndCollectionName(query,new User(),"user");
    }

    @Override
    public PageInfo<User> queryWithPageByCondition(UserParam param) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        /*Sort sort = Sort.by(
                Sort.Order.asc("a"),
                Sort.Order.desc("b"));*/
        //分页参数
//        Pageable pageable = PageRequest.of(param.getPageNum() - 1, param.getPageSize(), sort);
        Pageable pageable = PageRequest.of(param.getPageNum() - 1, param.getPageSize());

        if(StringUtil.notEmpty(param.getId())){
            criteria.andOperator(Criteria.where("_id").is(param.getId()));
        }
        if(StringUtil.notEmpty(param.getName())){
            /*//完全匹配
            Pattern pattern = Pattern.compile("^张$", Pattern.CASE_INSENSITIVE);
            //右匹配
            Pattern pattern = Pattern.compile("^.*张$", Pattern.CASE_INSENSITIVE);
            //左匹配
            Pattern pattern = Pattern.compile("^张.*$", Pattern.CASE_INSENSITIVE);
            //模糊匹配
            Pattern pattern = Pattern.compile("^.*张.*$", Pattern.CASE_INSENSITIVE);*/

            /*Pattern pattern = Pattern.compile("^.*" + user.getName() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.andOperator(Criteria.where("name").regex(pattern));*/

            query.addCriteria(criteria.where("name").regex(".*?"+param.getName()+".*"));
        }
        if(StringUtil.notEmpty(param.getPhone())){
            criteria.andOperator(Criteria.where("phone").is(param.getPhone()));
        }
        if(param.getSex() != null){
            criteria.andOperator(Criteria.where("sex").is(param.getSex()));
        }

        //计算总数
        long total = mongoDBClient.count(query, new User(),"user");
        query.with(pageable);

        //查询结果集
        List<User> list = (List<User>)mongoDBClient.getByConditionAndCollectionName(query, new User(),"user");
        PageInfo<User> page = new PageInfo(total, param.getPageNum(),
                param.getPageSize(), list);
        return page;
    }

    @Override
    public List<User> queryById(User user) {
        Query query = Query.query(Criteria.where("_id").is(user.getId()));
        return (List<User>)mongoDBClient.getByConditionAndCollectionName(query,user,"user");
    }

    @Override
    public User save(User user) {
        User u = mongoDBClient.save(user,"user");
        return u;
    }
}