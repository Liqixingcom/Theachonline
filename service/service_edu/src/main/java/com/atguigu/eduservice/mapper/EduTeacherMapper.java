package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-02-24
 */
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {
    EduTeacher getTeacherByid(String id);

    int delelelist(List<String> list);

    List<EduTeacher> searchTeacherById(List<String> list);
}
