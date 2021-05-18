package com.example.cache.optimize.demo.service.impl;

import com.example.cache.optimize.demo.service.HelloService;
import com.example.cache.optimize.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    HelloService helloService;
    @Override
    public String sayTo(String name) {
        helloService.hello();
        return " hello," + name;
    }
}
