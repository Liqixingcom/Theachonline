package com.atguigu.staservice.Client;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="service-ucenter",fallback = UCenterClientimpl.class)
@Component

public interface UCenterClient {

    //查询某一天注册人数
//    @GetMapping("/educenter/ucentermember/countRegister/{day}")
//    public  R
//   public R countRegister(@PathVariable("day") String day);
    @GetMapping("/educenter/ucentermember/countRegister/{day}")
    public  R countRegister(@PathVariable("day") String day);
}
