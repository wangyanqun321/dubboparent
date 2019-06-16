package com.wyq.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyq.service.api.HelloService;


@Service(version = "1.0.2")
public class HelloServiceImpl2 implements HelloService {
    @Override
    @HystrixCommand
    public String sayHello() {
        System.out.println("HelloServiceImpl.sayHello ...2");
        return "hello dubbo";
    }
}
