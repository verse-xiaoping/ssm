package com.github.ssm.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.ssm.entity.Customer;
import com.github.ssm.mapper.CustomerMapper;
import com.github.ssm.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author xiaoping
 * @date 2018-03-31 21:50
 */
@RunWith(SpringJUnit4ClassRunner.class) //spring-test框架
@ContextConfiguration(locations = "classpath:beans.xml")
public class CustomerMapperTest {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private CustomerService customerService;

    @Test
    public void select() {
        Customer customer = new Customer();
        customer.setId(1);
        this.customerMapper.select(customer);
        System.out.println("===========================" + this.customerMapper.selectByPrimaryKey(1));
    }

    @Test
    public void list() {
        System.out.println("===========================" + this.customerMapper.selectAll().size());
    }

    @Test
    public void delete() {
        this.customerMapper.deleteByPrimaryKey(3);
    }

    @Test
    public void add() {
        Customer customer = new Customer();
        for (int i = 0; i < 100; i++) {
            customer.setName("test" + i);
            customer.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
            customer.setAge(25);
            this.customerMapper.insert(customer);
        }
    }

    @Test
    public void update() {
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
        this.customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Test
    public void validateCustomer() {
        Customer customer = new Customer();
        customer.setName("test01");
        customer.setPassword("123");
        System.out.println("=============================" + customerService.validateCustomer(customer));
    }

    @Test
    public void selectAll() {
        System.out.println("=============" + customerService.selectAll());
    }

    @Test
    public void pageHelper() {
        Customer customer = new Customer();
        customer.setPageNum(2);
        //第一步：设置分页
//        PageInfo<Customer> customers =  customerService.selectWithPageInfo(customer);
        PageInfo<Customer> customers = customerService.list(customer);
        System.out.println("==================="+customers);
    }
}
