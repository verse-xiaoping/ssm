package com.github.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.ssm.entity.Customer;
import com.github.ssm.mapper.CustomerMapper;
import com.github.ssm.service.BaseService;
import com.github.ssm.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用戶实现类
 * @author xiaoping
 * @date 2018-04-01 19:44
 */
@Service("customerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService{

    @Resource
    private CustomerMapper customerMapper; //由于继承base的时候已经继承了Mapper了，所以这种方式不行

    @Resource(name = "customerMapper")
    @Override
    public void setMapper(Mapper<Customer> mapper) {
        super.setMapper(mapper);
    }

    @Override
    public Customer validateCustomer(Customer customer) {
        //条件对象
        Example example = new Example(Customer.class);
        //设置查询条件
        example.createCriteria().andCondition("name=", customer.getName())
                .andCondition("password=", DigestUtils.md5DigestAsHex(customer.getPassword().getBytes()));
        List<Customer> customers = selectList(example);
        return customers != null && customers.size() > 0 ? customers.get(0) : null;
    }

    @Override
    public PageInfo<Customer> list(Customer customer) {
        //第一步：设置分页
        PageHelper.startPage(customer.getPageNum(),customer.getPageSize());
        //第二步：查询数据
        List<Customer> list = customerMapper.list(customer);
        //第三步：使用PageInfo包装数据
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
