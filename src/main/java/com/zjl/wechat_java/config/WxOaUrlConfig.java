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
    /**公众号用来获得授权code*/
    public static final String API_PRE_AUTH = "https://open.weixin.qq.com/connect/oauth2/authorize?";
    /**公众号网页授权accessToken*/
    public static final String API_WEB_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?";
    /**公众号网页登录获取用户信息*/
    public static final String API_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?";
}
