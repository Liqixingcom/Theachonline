package com.atguigu.eduservice.Shule;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public class Shule {
    @Autowired
    private EduTeacherService eduTeacher;
    @Scheduled(cron = "0/5 * * * * ?")
    public void enable(){
        List<EduTeacher> list = eduTeacher.list(null);
        System.out.println(list);
    }
}
