package com.wyq.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDubbo
@SpringBootApplication
//开启服务熔断
@EnableHystrix
// @EnableHystrixDashboard
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
