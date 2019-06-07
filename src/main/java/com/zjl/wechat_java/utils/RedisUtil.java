package com.zjl.wechat_java.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @className: RedisUtil
 * @author: zhou
 * @description: redis工具类
 * @datetime: 2019/6/7 19:46
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;
}
