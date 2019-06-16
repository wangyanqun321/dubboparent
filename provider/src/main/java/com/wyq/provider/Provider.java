package com.wyq.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDubbo
@SpringBootApplication
@EnableHystrix
public class Provider {
    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}
