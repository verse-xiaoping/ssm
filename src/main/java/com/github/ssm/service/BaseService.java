package com.github.ssm.service;

import com.github.pagehelper.PageInfo;
import com.github.ssm.entity.BaseEntity;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * 基类：CRUD
 * 说明：(创建了限制条件，T必须是BaseEntity的子类, 如果是用supper关键字，是指必须是对方的父类，也就是上边界和下边界)
 * @author xiaoping
 * @date 2018-03-31 21:42
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 查询单个对象
     */
    public T selectOne(Serializable id);

    /**
     * 根据条件查询多个对象
     */
    public List<T> selectList(Example example);

    /**
     * 查询所有对象
     */
    public List<T> selectAll();

    /**
     * 新增对象
     */
    public void save(T t);

    /**
     * 修改对象
     */
    public void update(T t);

    /**
     * 删除对象
     */
    public void deleteByPrimaryKey(Serializable id);

    /**
     * 分页查询
     */
    public PageInfo<T> selectWithPageInfo(T t);
}
