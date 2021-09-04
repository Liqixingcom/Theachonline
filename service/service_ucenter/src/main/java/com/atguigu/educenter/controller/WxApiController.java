package com.atguigu.educenter.controller;

import com.atguigu.educenter.utils.ConsantWxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@CrossOrigin//跨域
@Controller//只是请求地址，不需要返回数据，所以redirect重定向无法生效
@RequestMapping("/api/ucenter/wx")
public class WxApiController {
//    生成微信扫描二维码
    @GetMapping("login")
    public String getexCode(){
        //重定向请求二维码微信地址 %s相当于问号占位符
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
        "?appid=%s" +
        "&redirect_uri=%s" +
        "&response_type=code" +
        "&scope=snsapi_login" +
        "&state=%s" +
        "#wechat_redirect";

        //对redirectUrl进行UrlEncoder编码
        String redirectUrl=ConsantWxUtils.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl=URLEncoder.encode(redirectUrl,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        String类中的占位符替换
        String url = String.format(
                baseUrl,
                ConsantWxUtils.WX_OPEN_APP_ID,
               redirectUrl,
                "atguigu"
        );

        return "redirect:"+url;
    }
}
