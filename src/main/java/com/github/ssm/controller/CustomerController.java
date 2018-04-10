package com.github.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.github.ssm.entity.Customer;
import com.github.ssm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiaoping
 * @date 2018-04-01 21:37
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Customer customer, Model model){
        PageInfo<Customer> list = customerService.list(customer);
//        model.addAttribute("customers",customerService.selectWithPageInfo(customer));
        model.addAttribute("customers",list);
        return "customer/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id){
        customerService.deleteByPrimaryKey(id);
        return "redirect:list";
    }
}
