package com.wyq.consumer.interfaces.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyq.service.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(retries = 3, timeout = 3000, version = "1.0.2",
            stub = "com.wyq.consumer.interfaces.dubbo.HelloServiceStau")
    private HelloService helloService;

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "hystrixMethod")
    public String hello()  {
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
