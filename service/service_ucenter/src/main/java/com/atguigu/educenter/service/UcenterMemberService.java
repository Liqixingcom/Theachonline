package com.atguigu.educenter.service;

import com.atguigu.educenter.entity.RegisterVo;
import com.atguigu.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-07-29
 */
public interface UcenterMemberService extends IService<UcenterMember> {
//登录的方法
    String login(UcenterMember ucenterMember);
//注册
    void register(RegisterVo registerVo);

    Integer countRegisterDay(String day);
}
