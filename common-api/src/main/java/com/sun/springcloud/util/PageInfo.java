/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: PageInfo
 * Author:   sun
 * Date:     2020/4/23 16:23
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/23 16:23           v1.0.0
 */
package com.sun.springcloud.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 *
 * @author sun
 * @create 2020/4/23
 * @since v1.0.0
 */
@Data
public class PageInfo<T> implements Serializable {

    /**
     * 总记录数
     */
    private Long total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 页记录数
     */
    private int pageSize;

    /**
     * 是否第一页
     */
    private boolean isFirstPage;
    /**
     * 是否最后一页
     */
    private boolean isLastPage;
    /**
     * 有上一页
     */
    private boolean hasPreviousPage;
    /**
     * 有下一页
     */
    private boolean hasNextPage;

    /**
     * 当前页面第一个元素在数据库中的行号
     */
    private Long startRow;
    /**
     * 当前页面最后一个元素在数据库中的行号
     */
    private Long endRow;
    /**
     * 当前页的数量
     */
    private int size;

    private int navigatePages;    //导航页码数
    private int[] navigatepageNums; //所有导航页号

    private int firstPage;  //第一页
    private int prePage;    //前一页
    private int nextPage;   //后一页
    private int lastPage;   //最后一页
    /*private String orderBy; //排序
    */

    /**
     * 分页后的数据
     */
    private List<T> list;


    public PageInfo(Long total, Integer pageNum,
                    Integer pageSize, List<T> list) {
        this.isFirstPage = false;
        this.isLastPage = false;
        this.hasPreviousPage = false;
        this.hasNextPage = false;
        this.total = total;
        this.pages = (int)(total - 1) / pageSize + 1;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.list = list;
        this.navigatePages = 8;


        this.size = list.size();
        this.startRow = 0l;
        this.endRow = total > 0 ? total - 1 : 0;

        //计算导航页
        calcNavigatepageNums();
        //计算前后页，第一页，最后一页
        calcPage();
        //判断页面边界
        judgePageBoudary();
    }

    /**
     * 计算导航页
     */
    private void calcNavigatepageNums() {
        int i;
        if (this.pages <= this.navigatePages) {
            this.navigatepageNums = new int[this.pages];

            for(i = 0; i < this.pages; ++i) {
                this.navigatepageNums[i] = i + 1;
            }
        } else {
            this.navigatepageNums = new int[this.navigatePages];
            i = this.pageNum - this.navigatePages / 2;
            int endNum = this.pageNum + this.navigatePages / 2;
            if (i < 1) {
                for(i = 0; i < this.navigatePages; ++i) {
                    this.navigatepageNums[i] = i++;
                }
            } else if (endNum > this.pages) {
                endNum = this.pages;

                for(i = this.navigatePages - 1; i >= 0; --i) {
                    this.navigatepageNums[i] = endNum--;
                }
            } else {
                for(i = 0; i < this.navigatePages; ++i) {
                    this.navigatepageNums[i] = i++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPage() {
        if (this.navigatepageNums != null && this.navigatepageNums.length > 0) {
            this.firstPage = this.navigatepageNums[0];
            this.lastPage = this.navigatepageNums[this.navigatepageNums.length - 1];
            if (this.pageNum > 1) {
                this.prePage = this.pageNum - 1;
            }

            if (this.pageNum < this.pages) {
                this.nextPage = this.pageNum + 1;
            }
        }

    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        this.isFirstPage = this.pageNum == 1;
        this.isLastPage = this.pageNum == this.pages;
        this.hasPreviousPage = this.pageNum > 1;
        this.hasNextPage = this.pageNum < this.pages;
    }
}