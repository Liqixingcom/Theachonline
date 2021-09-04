package com.atguigu.eduscms.service.impl;

import com.atguigu.eduscms.entity.CrmBanner;
import com.atguigu.eduscms.mapper.CrmBannerMapper;
import com.atguigu.eduscms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-07-28
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {


    @Override
    public boolean deleteBanner(String id) {
        return baseMapper.deleteBnner(id);
    }
@Cacheable(value = "banner",key ="'selectList'" )
    @Override
    public List<CrmBanner> selectAll() {
        return baseMapper.selectList(null);
    }
}
