package com.atguigu.Controller;


import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class getCom {


    @PostMapping("getse")
    public R getinfo(){

        return R.ok();
    }
}
