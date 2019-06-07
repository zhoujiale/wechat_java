package com.zjl.wechat_java.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @className: WxMiniProgramConfiguration
 * @author: zhou
 * @description: 微信小程序配置参数
 * @datetime: 2019/6/7 16:23
 */
@Component
@ConfigurationProperties(prefix = "wx.mini-program")
public class WxMiniProgramConfiguration {
    /**微信小程序appid*/
    private String appid;
    /**微信小程序密钥*/
    private String appsecret;
}
