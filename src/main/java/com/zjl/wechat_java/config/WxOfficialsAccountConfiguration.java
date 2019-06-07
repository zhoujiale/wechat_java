package com.zjl.wechat_java.config;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 微信配置相关参数
 * @author: zhou
 * @param:
 * @return:
 * @date: 2019/6/1
 */
@Getter
@Component
@ConfigurationProperties(prefix = "wx.official-account")
public class WxOfficialsAccountConfiguration {
    /**微信公众号appid*/
    private String appid;
    /**微信公众号密钥*/
    private String appsecret;
    /**微信公众号token*/
    private String token;
}
