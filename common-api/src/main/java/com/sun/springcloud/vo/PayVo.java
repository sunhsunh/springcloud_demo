/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: PayVo
 * Author:   sun
 * Date:     2020/4/12 20:43
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 20:43           v1.0.0
 */
package com.sun.springcloud.vo;

import java.io.Serializable;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/12
 * @since v1.0.0
 */
public class PayVo implements Serializable {

    private String name;
    private Integer goodId;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}