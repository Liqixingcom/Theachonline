package com.atguigu.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.atguigu.test.Mapper")
@ComponentScan(basePackages = {"com.atguigu"})
public class EduAppliction1 {
    public static void main(String[] args) {
        SpringApplication.run(EduAppliction1.class,args);
    }
}
