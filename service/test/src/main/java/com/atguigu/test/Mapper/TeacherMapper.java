package com.atguigu.test.Mapper;

import com.atguigu.test.entry.EduTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface TeacherMapper {


    EduTeacher selectOne();
}
