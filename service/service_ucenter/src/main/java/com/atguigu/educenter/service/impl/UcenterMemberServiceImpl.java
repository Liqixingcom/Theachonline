package com.atguigu.educenter.service.impl;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.MD5;
import com.atguigu.educenter.entity.RegisterVo;
import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.mapper.UcenterMemberMapper;
import com.atguigu.educenter.service.UcenterMemberService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-07-29
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {
//登录返回token
    @Override
    public String login(UcenterMember ucenterMember) {
        //获取登录的手机号以及密码
        String mobile=ucenterMember.getMobile();
        String password=ucenterMember.getPassword();
        //手机号和密码非空判断
        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            throw  new GuliException(2001,"登录失败");
        }
        //判断手机号是否存在表中
        QueryWrapper<UcenterMember> wrapper=new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);
//        判断查出来的对象是否非空
        if(mobileMember==null){
            throw  new GuliException(2001,"手机号不存在");
        }
//        在数据库中密码进行了加密，
//        所以说要对输入的密码加密，然后再对数据库中的密码进行比较
        //加密方式MD5  （MD5只能加密，不能解密）
        if (!MD5.encrypt(password).equals(mobileMember.getPassword())){
            throw  new GuliException(2001,"密码不存在");
        }
//        判断用户是否被禁用
        if (mobileMember.getIsDisabled()){
            throw  new GuliException(2001,"用户被禁用");
        }
//        登录成功，按照jwt工具类生成token
        String jwtToken = JwtUtils.getJwtToken(ucenterMember.getId(), ucenterMember.getNickname());
        return jwtToken;


    }

    @Override
    public void register(RegisterVo registerVo) {
        //获取注册的数据
        String code=registerVo.getCode();
        String mobile=registerVo.getMobile();
        String nickname=registerVo.getNickname();
        String password=registerVo.getPassword();
        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)
            ||StringUtils.isEmpty(nickname)||StringUtils.isEmpty(code)){
            throw  new GuliException(2001,"登录失败");
        }

        //判断手机验证码
//        将数据添加到数据库中、
        UcenterMember member=new UcenterMember();
        member.setMobile(mobile);
        member.setNickname(nickname);
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
       baseMapper.insert(member);
    }
//查询某一天注册的人数
    @Override
    public Integer countRegisterDay(String day) {
        return baseMapper.countRegisterDay(day);
    }
}
