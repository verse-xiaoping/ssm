package com.github.ssm.service;

import com.github.pagehelper.PageInfo;
import com.github.ssm.entity.Customer;

import java.util.List;

/**
 * service：用戶
 * @author xiaoping
 * @date 2018-03-31 21:42
 */

public interface CustomerService extends  BaseService<Customer>{

    /**
     * 不用mapper的列表查询
     */
    public PageInfo<Customer> list(Customer customer);
    /**
     * 登陆用户验证
     */
    public Customer validateCustomer(Customer customer);
}
