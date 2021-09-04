package com.atguigu.eduscms.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduscms.entity.CrmBanner;
import com.atguigu.eduscms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-07-28
 */
@Api(description="Banner顾艳丽")
@RestController
@RequestMapping("/eduscms/banneradmin")
public class BanneradminController {
    @Autowired
    private CrmBannerService crmBannerService;

        //查询全部
    //将数据添加到redis缓存
    @PostMapping("pageBnner/{page}/{limit}")
    public R pageBanner(@PathVariable Long page,@PathVariable Long limit){
        Page<CrmBanner> cpage=new Page<>(page,limit);
        crmBannerService.page(cpage,null);
        List<CrmBanner> items=cpage.getRecords();
        Long total=cpage.getTotal();
        return R.ok().data("items",items).data("total",total);
    }

    @PostMapping("addBnner")
    public  R addBanner(@RequestBody CrmBanner crmBanner){
        boolean flag = crmBannerService.save(crmBanner);
        if (flag==true){
            return R.ok();
        }else {
            return R.error();
        }

    }
    @PostMapping("updateBnanner")
    public  R updateBnanner(@RequestBody CrmBanner crmBanner){
        boolean flag = crmBannerService.updateById(crmBanner);
        if (flag==true){
            return R.ok();
        }else {
            return R.error();
        }
    }
    @PostMapping("deletebanner/{id}")
    public  R deletebanner(@PathVariable String id){
        boolean flag = crmBannerService.deleteBanner(id);
        if (flag==true){
            return R.ok();
        }else {
            return R.error();
        }

    }
}

