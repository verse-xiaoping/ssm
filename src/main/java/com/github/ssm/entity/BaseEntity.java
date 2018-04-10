package com.github.ssm.entity;

import javax.persistence.Transient;

/**
 * 基类：分页信息
 * 说明：abstract的意思是不支持实例化
 * @author xiaoping
 * @date 2018-04-01 22:47
 */
public abstract class BaseEntity {
    /**
     * 每页多少条数据
     */
    @Transient
    private Integer pageSize = 5;
    /**
     * 第几页
     */
    @Transient
    private Integer pageNum = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
