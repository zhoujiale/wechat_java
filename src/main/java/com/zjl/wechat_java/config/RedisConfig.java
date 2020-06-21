package com.zjl.wechat_java.config;

import com.zjl.wechat_java.util.RedisUtil;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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
        return (o, method, objects) -> {
            StringBuffer sb = new StringBuffer();
            sb.append(o.getClass().getName());
            sb.append(method.getName());
            for(Object obj:objects){
                sb.append(obj.toString());
            }
            return sb.toString();
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
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(genericJackson2JsonRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        template.setEnableTransactionSupport(true);
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean(name = "RedisUtil")
    public RedisUtil redisUtil(RedisTemplate<String,Object> redisTemplate){
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate);
        return redisUtil;
    }
}
