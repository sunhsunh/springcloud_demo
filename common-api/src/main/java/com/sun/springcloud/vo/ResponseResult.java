/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: result
 * Author:   sun
 * Date:     2020/4/12 20:04
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/12 20:04           v1.0.0
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
public class ResponseResult<T> implements Serializable {
    private String status;
    private String message;
    private T result;

    public ResponseResult() {
    }

    public ResponseResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseResult(String status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}