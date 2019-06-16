package com.wyq.consumer.interfaces.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyq.service.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("HelloController.hello");
        return helloService.sayHello();
    }
}
