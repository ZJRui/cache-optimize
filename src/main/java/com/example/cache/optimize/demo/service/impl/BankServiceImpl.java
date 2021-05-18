package com.example.cache.optimize.demo.service.impl;

import com.example.cache.optimize.demo.service.BankService;
import com.example.cache.optimize.demo.service.HelloService;
import com.example.cache.optimize.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    UserService userService;

    UserService userServiceTwo;
    @Override
    public String createBankAccount() {
        if (userServiceTwo == null) {
            UserService userService = new UserServiceImpl();
            UserService o = (UserService)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{UserService.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return  method.invoke(userService, args);
                }
            });
            userServiceTwo = o;
        }
        userService.sayTo("zhang");
        return "this is a new BancAccount";
    }
}
