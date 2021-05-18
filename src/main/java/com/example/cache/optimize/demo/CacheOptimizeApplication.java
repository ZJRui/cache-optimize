package com.example.cache.optimize.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//proxyTargetClass是否使用类代理
//@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = false)

public class CacheOptimizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheOptimizeApplication.class, args);
    }

}
