package com.atguigu.msmservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan
@ComponentScan("com.atguigu")
public class MsmApplication {
}
