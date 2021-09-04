package com.atguigu.staservice.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component//将这个类交给Spring去进行管理
public class ScheuleTask {
//    0/5****?指的是每个五秒钟执行这个方法
    @Scheduled(cron = "0/5 * * * * ?")
    public void Task1(){
        System.out.println("*********Task1*******执行了");
    }
}
