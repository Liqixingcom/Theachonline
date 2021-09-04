package com.atguigu.eduscms.service;

import com.atguigu.eduscms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-07-28
 */
public interface CrmBannerService extends IService<CrmBanner> {
 boolean deleteBanner(String id);

    List<CrmBanner> selectAll();
}
