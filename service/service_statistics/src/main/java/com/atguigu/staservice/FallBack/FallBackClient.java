package com.atguigu.staservice.FallBack;

import com.atguigu.staservice.entity.StatisticsDaily;
import feign.hystrix.FallbackFactory;

public class FallBackClient implements FallbackFactory<StatisticsDaily> {
    @Override
    public StatisticsDaily create(Throwable throwable) {
        return null;
    }
}
