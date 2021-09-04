package com.atguigu.staservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.atguigu.staservice.mapper")
@ComponentScan(basePackages = {"com.atguigu"})
@EnableDiscoveryClient//使用nacos注册中心
@EnableFeignClients//远程调用其他接口
@EnableScheduling//开启自动任务
public class StaApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaApplication.class, args);
    }

}
