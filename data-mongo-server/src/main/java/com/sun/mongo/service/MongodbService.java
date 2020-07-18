/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongodbService
 * Author:   sun
 * Date:     2020/4/24 10:32
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 10:32           v1.0.0
 */
package com.sun.mongo.service;

import com.sun.springcloud.param.UserParam;
import com.sun.springcloud.util.PageInfo;
import com.sun.springcloud.vo.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
public interface MongodbService {
    User saveOrUpdate(User user);

    Integer delete(User user);

    List<User> queryWithCondition(UserParam param);

    PageInfo<User> queryWithPageByCondition(UserParam param);

    List<User> queryById( User user);

    User save(User user);
}