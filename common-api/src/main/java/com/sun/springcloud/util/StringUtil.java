/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: StringUtil
 * Author:   sun
 * Date:     2020/4/24 11:02
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/24 11:02           v1.0.0
 */
package com.sun.springcloud.util;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/24
 * @since v1.0.0
 */
public class StringUtil {
    public static boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }

    /**
     * 判断字符串是否为非空
     *
     * @param str
     * @return
     */
    public static boolean notEmpty(String str) {
        return str != null && !str.equals("");
    }
}