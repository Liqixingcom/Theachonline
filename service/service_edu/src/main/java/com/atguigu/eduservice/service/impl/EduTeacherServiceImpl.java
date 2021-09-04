package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-02-24
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {



    @Override
    public HashMap<String,Object> getPageTeacher(long page,long limit) {
        Page<EduTeacher> page1=new Page<>(page,limit);

        baseMapper.selectPage(page1,null);
        HashMap<String,Object> map=new HashMap<>();
        map.put("total",page1.getTotal());
        map.put("Current",page1.getCurrent());
        map.put("hastnext",page1.hasNext());
        map.put("haspreVious",page1.hasPrevious());
        map.put("size",page1.getSize());
        map.put("pages",page1.getPages());//boolen 判断是否有上一页
        map.put("list",page1.getRecords());//boolen 判断是否有下一页
        return map;
    }

    @Override
    public EduTeacher getTeacherById(String id) {
        EduTeacher eduTeacher=baseMapper.getTeacherByid(id);
        return eduTeacher;
    }

    @Override
    public int deletelist(List<String> list) {
        int result=0;
        result=baseMapper.delelelist(list);
        return result;
    }

    @Override
    public List<EduTeacher> searchTeacherbyid(List<String> list) {
        List<EduTeacher> list1=baseMapper.searchTeacherById(list);
        return null;
    }
}
