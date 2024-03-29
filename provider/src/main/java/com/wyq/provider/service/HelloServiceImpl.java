package com.wyq.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyq.service.api.HelloService;


@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {
    @Override
    @HystrixCommand
    public String sayHello() {
        System.out.println("HelloServiceImpl.sayHello...1");
        return "hello dubbo";
    }
}
