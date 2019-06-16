package com.wyq.consumer.interfaces.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyq.service.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "hystrixMethod")
    public String hello(){
        System.out.println("HelloController.hello");
        return helloService.sayHello();
    }

    /**
     *熔断方法
     * @return
     */
    public String hystrixMethod(){
        return "远程调用失败，可能是出异常了";
    }
}
