/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: UserParam
 * Author:   sun
 * Date:     2020/4/24 11:18
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 11:18           v1.0.0
 */
package com.sun.springcloud.param;

import com.sun.springcloud.vo.User;
import lombok.Data;

import java.io.Serializable;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
@Data
public class UserParam extends User implements Serializable {


    //页数
    private Integer pageNum = 1;
    //页面条数
    private Integer pageSize = 10;
}