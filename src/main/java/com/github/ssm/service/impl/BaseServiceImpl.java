package com.github.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.ssm.entity.BaseEntity;
import com.github.ssm.service.BaseService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * 基类：基础实现类
 * 说明：1、abstract的意思是不支持实例化
 *       2、创建了限制条件，T必须是BaseEntity的子类, 如果是用supper关键字，是指必须是对方的父类，也就是上边界和下边界
 * @author xiaoping
 * @date 2018-04-01 20:22
 */
@Transactional(readOnly = true)
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T>{

    private Mapper<T> mapper;

    public void setMapper(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public T selectOne(Serializable id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectList(Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Transactional(readOnly = false)
    @Override
    public void save(T t) {
        mapper.insert(t);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(T t) {
        mapper.updateByPrimaryKey(t);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteByPrimaryKey(Serializable id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<T> selectWithPageInfo(T t) {
        //第一步：设置分页
        PageHelper.startPage(t.getPageNum(),t.getPageSize());
        //第二步：查询数据
        List<T> list = mapper.select(t);
        //第三步：使用PageInfo包装数据
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
