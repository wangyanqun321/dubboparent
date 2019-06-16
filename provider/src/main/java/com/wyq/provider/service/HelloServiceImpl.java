package com.wyq.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyq.service.api.HelloService;


@Service
public class HelloServiceImpl implements HelloService {
    @Override
    @HystrixCommand
    public String sayHello() {
        System.out.println("HelloServiceImpl.sayHello");
        int i = 1 / 0;
        return "hello dubbo";
    }
}
