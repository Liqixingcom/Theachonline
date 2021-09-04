package com.atguigu.educenter.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.educenter.entity.RegisterVo;
import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-07-29
 */
@RestController
@RequestMapping("/educenter/ucentermember")
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService ucenterMemberService;


    //登录
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember ucenterMember){
//        使用Jwt获取token
        String token=ucenterMemberService.login(ucenterMember);
        return R.ok().data("token",token);
        }
//注册
    @PostMapping("register")
    public R register(@RequestBody RegisterVo registerVo){
            ucenterMemberService.register(registerVo);
        return R.ok();
    }

    //根据token获取用户信息
    @GetMapping("getMemberInfo")
    public  R getMemberInfo(HttpServletRequest request){
        //调用gwt工具类根据request对象的头信息获取ID
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据用户id获取信息
        UcenterMember member = ucenterMemberService.getById(memberId);
        return R.ok().data("userinfo",member);
    }

    //查询某一天注册人数
    @GetMapping("countRegister/{day}")
    public  R countRegister(@PathVariable String day){
        Integer cout=ucenterMemberService.countRegisterDay(day);
        return R.ok().data("count",cout);
    }
}


