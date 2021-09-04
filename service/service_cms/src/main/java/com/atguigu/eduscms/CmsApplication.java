package com.atguigu.eduscms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.atguigu.eduscms.mapper")
@ComponentScan({"com.atguigu"})
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}

