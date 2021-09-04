package com.atguigu.test.Service.Impl;


import com.atguigu.test.Mapper.TeacherMapper;
import com.atguigu.test.Service.EduService;
import com.atguigu.test.entry.EduTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements EduService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public EduTeacher selectOne() {
       EduTeacher eduTeacher= teacherMapper.selectOne();
        return eduTeacher;
    }
}
