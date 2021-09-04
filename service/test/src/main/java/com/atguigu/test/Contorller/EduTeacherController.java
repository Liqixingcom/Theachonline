package com.atguigu.test.Contorller;

import com.atguigu.commonutils.R;
import com.atguigu.test.Service.EduService;
import com.atguigu.test.entry.EduTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class EduTeacherController {
    @Autowired
    private EduService eduService;

    @PostMapping("SelectOne")
    public R SelectOne(){
        EduTeacher teacher=new EduTeacher();
        teacher=eduService.selectOne();
        return R.ok().data("teacher",teacher);
    }
}
