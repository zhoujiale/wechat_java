package com.zjl.wechat_java.config;

/**
 * @className: WxOaUrlConfig
 * @author: zhou
 * @description: 微信公众号请求地址参数配置
 * @datetime: 2019/6/8 9:52
 */
public class WxOaUrlConfig {
    /**公众号获取accessToken(参数:appid,appsecret)*/
    public static final String  API_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
}
