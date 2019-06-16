package com.wyq.consumer.interfaces.dubbo;

import com.wyq.service.api.HelloService;

/**
 * 本地存根
 */

public class HelloServiceStau implements HelloService {

    private final HelloService helloService;

    public HelloServiceStau(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello() {
        System.out.println("本地存根被调用了");
        return helloService.sayHello();
    }
}
