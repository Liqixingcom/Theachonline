package com.atguigu.eduscms.mapper;

import com.atguigu.eduscms.entity.CrmBanner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 首页banner表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-07-28
 */
public interface CrmBannerMapper extends BaseMapper<CrmBanner> {
    //删除
    boolean deleteBnner(String id);
}
