package com.atguigu.staservice.controller;


import com.atguigu.commonutils.R;

import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.staservice.Client.UCenterClient;
import com.atguigu.staservice.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-01
 */
@RestController
@RequestMapping("/staservice/statistics-daily")
public class StatisticsDailyController {
@Autowired
    private StatisticsDailyService staservice;
@Autowired
    private UCenterClient uCenterClient;

//统计某一天注册的人数生成统计数据
    @PostMapping("register/{day}")
    public R register(@PathVariable String day){
       staservice.registerCount(day);
        return R.ok();
    }

    @PostMapping("/ser/{day}")
    public R cont(@PathVariable String day){
        R r = uCenterClient.countRegister(day);
        if (r.getCode()==20001){
            throw new GuliException(20001,"查询报错，服务未启动");
        }
        return R.ok();
    }
}

