package com.wyq.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyq.service.api.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        System.out.println("HelloServiceImpl.sayHello");
        return "hello dubbo";
    }
}
