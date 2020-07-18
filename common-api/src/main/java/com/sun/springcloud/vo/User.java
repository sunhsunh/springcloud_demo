/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: User
 * Author:   sun
 * Date:     2020/4/24 10:35
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 10:35           v1.0.0
 */
package com.sun.springcloud.vo;

import java.io.Serializable;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
public class User implements Serializable {

    private String id;
    private String name;
    private Integer age;
    private Integer sex;
    private String province;
    private String city;
    private String address;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}