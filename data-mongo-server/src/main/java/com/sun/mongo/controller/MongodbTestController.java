/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongodbTestController
 * Author:   sun
 * Date:     2020/4/24 10:31
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 10:31           v1.0.0
 */
package com.sun.mongo.controller;

import com.sun.mongo.service.MongodbService;
import com.sun.springcloud.param.UserParam;
import com.sun.springcloud.util.PageInfo;
import com.sun.springcloud.vo.ResponseResult;
import com.sun.springcloud.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
@RestController
@RequestMapping(value = "/mongodb")
public class MongodbTestController {

    @Autowired
    private MongodbService mongodbService;

    @RequestMapping(value = "/saveOrUpdate")
    public ResponseResult saveOrUpdate(@RequestBody User user){
        User u = mongodbService.saveOrUpdate(user);
        return new ResponseResult("200","SUCCESS",u);
    }

    @RequestMapping(value = "/delete")
    public ResponseResult delete(@RequestBody User user){
        Integer num = mongodbService.delete(user);
        return new ResponseResult("200","SUCCESS",num);
    }

    @RequestMapping(value = "/queryWithCondition")
    public ResponseResult queryWithCondition(@RequestBody UserParam param){
        List<User> list = mongodbService.queryWithCondition(param);
        return new ResponseResult("200","SUCCESS",list);
    }

    @RequestMapping(value = "/queryWithPageByCondition")
    public ResponseResult queryWithPageByCondition(@RequestBody UserParam param){
        PageInfo<User> page = mongodbService.queryWithPageByCondition(param);
        return new ResponseResult("200","SUCCESS",page);
    }

    @RequestMapping(value = "/queryById")
    public ResponseResult queryById(@RequestBody User user){
        List<User> list = mongodbService.queryById(user);
        return new ResponseResult("200","SUCCESS",list);
    }
}