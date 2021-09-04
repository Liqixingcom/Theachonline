package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/eduservice/from")
@CrossOrigin
public class TeacherFromController {
    @Autowired
    EduTeacherService teacherService;
    @Autowired
    EduCourseService courseService;
@ApiOperation(value = "前端老师分页")
    @PostMapping("pageTeachersinfo/{page}/{limit}")
    public R getTeacherFrontlist(@PathVariable long page,@PathVariable long limit){
        HashMap<String,Object> map=teacherService.getPageTeacher(page,limit);

        return R.ok().data(map);
    }

    @PostMapping("getTeacherById/{id}")
    public R getTeacherBuId(@PathVariable String id){
        //查讲师信息
        EduTeacher eduTeacher=teacherService.getTeacherById(id);
//        EduTeacher byId = teacherService.getById(id);
        //查讲师所讲课程信息
        QueryWrapper<EduCourse> wrapper=new QueryWrapper<>();
        wrapper.eq("teacher_id",id);
        List<EduCourse> list = courseService.list(wrapper);
        return R.ok().data("teacher",eduTeacher).data("couseList",list);
    }
}
