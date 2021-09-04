package com.atguigu.staservice.Client;

import com.atguigu.commonutils.R;
import org.springframework.stereotype.Component;

@Component
public class UCenterClientimpl implements UCenterClient {
    //在熔断器中这个方法出错折后才会执行
    @Override
    public R countRegister(String day) {
        return R.error().message("服务器未启动");
    }
}
