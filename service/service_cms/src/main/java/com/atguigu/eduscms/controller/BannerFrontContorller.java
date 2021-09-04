package com.atguigu.eduscms.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduscms.entity.CrmBanner;
import com.atguigu.eduscms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bannerfront")
public class BannerFrontContorller {
    @Autowired
    private CrmBannerService crmBannerService;
    //查询所有的banner
    @GetMapping("GetAllBanner")
    public R getAllBanner(){
        List<CrmBanner> list=crmBannerService.selectAll();
        return R.ok().data("list",list);
    }
}
