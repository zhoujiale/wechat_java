package com.zjl.wechat_java.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.config.CacheParam;
import com.zjl.wechat_java.config.WxMiniProgramConfiguration;
import com.zjl.wechat_java.config.WxMiniUrlConfig;
import com.zjl.wechat_java.error.HttpErrorEnum;
import com.zjl.wechat_java.error.WeChatMiniErrorEnum;
import com.zjl.wechat_java.exception.HttpException;
import com.zjl.wechat_java.exception.WeChatMiniException;
import com.zjl.wechat_java.exception.WxErrorException;
import com.zjl.wechat_java.service.WxMiniService;
import com.zjl.wechat_java.util.HttpUtil;
import com.zjl.wechat_java.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @className: WxMiniServiceImpl
 * @author: zhou
 * @description:
 * @datetime: 2019/6/23 14:00
 */
@Slf4j
@Service
public class WxMiniServiceImpl implements WxMiniService{

    @Autowired
    private WxMiniProgramConfiguration wxMiniProgramConfiguration;
    @Autowired
    private HttpUtil httpUtil;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public JSONObject getCodeSession(String code) {
        StringBuilder sb = new StringBuilder(WxMiniUrlConfig.JS_CODE_SESSION);
        sb.append("appid=").append(wxMiniProgramConfiguration.getAppid())
           .append("&").append("secret=").append(wxMiniProgramConfiguration.getAppsecret())
           .append("&").append("js_code=").append(code)
           .append("&grant_type=authorization_code");
        String url = sb.toString();
        JSONObject codeSession = new JSONObject();
        try {
            codeSession = httpUtil.doGetJson(url);
            if(codeSession.containsKey("errcode")){
                log.error("获取codeSession失败");
                throw new WxErrorException(codeSession.getInteger("errcode"),codeSession.getString("errmsg"));
            }
            redisUtil.set(CacheParam.CODE_SESSION + codeSession.getString("openid"),codeSession);
        } catch (IOException e) {
            log.error("请求失败");
            throw new HttpException(HttpErrorEnum.REQUEST_ERROR);
        }
        return codeSession;
    }

    @Override
    public JSONObject getCodeSessionByOpenid(String openid) {
        JSONObject codeSession = (JSONObject) redisUtil.get(CacheParam.CODE_SESSION + openid);
        if(null == codeSession){
            log.error("获取codeSession失败");
            throw new WeChatMiniException(WeChatMiniErrorEnum.CODE_SESSION_ERROR);
        }
        return codeSession;
    }
}
