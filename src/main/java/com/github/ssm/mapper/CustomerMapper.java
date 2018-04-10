package com.github.ssm.mapper;

import com.github.pagehelper.PageInfo;
import com.github.ssm.entity.Customer;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CustomerMapper extends Mapper<Customer> {
    /**
     * 不用mapper的列表查询
     */
    public List<Customer> list(Customer customer);
}
