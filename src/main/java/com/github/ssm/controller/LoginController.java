package com.github.ssm.controller;

import com.github.ssm.entity.Customer;
import com.github.ssm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiaoping
 * @date 2018-04-01 21:09
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String login(Customer customer, HttpSession session, Model model) {
        Customer loginCustomer = customerService.validateCustomer(customer);
        if (loginCustomer == null) {
            return "login";
        } else {
            //存session
            session.setAttribute("loginCustomer",loginCustomer);
            return "redirect:/customer/list";
        }
    }
}
