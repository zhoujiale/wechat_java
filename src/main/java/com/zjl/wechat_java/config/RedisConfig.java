package com.zjl.wechat_java.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * @className: RedisConfig
 * @author: zhou
 * @description: redis配置
 * @datetime: 2019/6/7 16:36
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuffer sb = new StringBuffer();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for(Object obj:objects){
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    /**
     * @description: redisTemplate
     * @author: zhou
     * @param: redisConnectionFactory
     * @return:
     * @date: 2019/6/7
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> template = new RedisTemplate<String,Object>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
