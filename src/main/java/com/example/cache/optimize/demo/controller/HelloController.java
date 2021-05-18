package com.example.cache.optimize.demo.controller;

import com.example.cache.optimize.demo.service.BankService;
import com.example.cache.optimize.demo.service.HelloService;
import com.example.cache.optimize.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @Autowired
    HelloService helloService;
    @Autowired
    BankService bankService;
    @RequestMapping("/hello")
    public String hello() {
        bankService.createBankAccount();
        return "yes hello";
    }
}
