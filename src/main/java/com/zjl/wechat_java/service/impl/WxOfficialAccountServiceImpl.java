package com.zjl.wechat_java.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.config.WxOaUrlConfig;
import com.zjl.wechat_java.config.WxOfficialsAccountConfiguration;
import com.zjl.wechat_java.exception.WxErrorException;
import com.zjl.wechat_java.service.WxOfficialAccountService;
import com.zjl.wechat_java.util.HttpUtil;
import com.zjl.wechat_java.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @className: WxOfficialAccountServiceImpl
 * @author: zhou
 * @description: 微信公众号实现类
 * @datetime: 2019/6/7 19:04
 */
@Slf4j
@Service
public class WxOfficialAccountServiceImpl implements WxOfficialAccountService{
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private HttpUtil httpUtil;
    @Autowired
    private WxOfficialsAccountConfiguration wxOfficialsAccountConfiguration;

    /**
     * @description: 获取公众号的accessToken
     * @author: zhou
     * @param:
     * @return:
     * @date: 2019/6/7
     */
    @Override
    public String refreshAccessToken() {
        //拼装请求地址
        StringBuilder sb = new StringBuilder(WxOaUrlConfig.API_ACCESS_TOKEN);
        sb.append("&")
          .append("appid=").append(wxOfficialsAccountConfiguration.getAppid())
          .append("&").append("appsecret=").append(wxOfficialsAccountConfiguration.getAppsecret());
        String url = sb.toString();
        //请求微信api
        try {
            JSONObject jsonObject = httpUtil.doGetJson(url);
            if(jsonObject.containsKey("access_token")){
                return jsonObject.get("access_token").toString();
            }else {
                log.error(jsonObject.toJSONString());
                throw new WxErrorException(jsonObject.getInteger("errcode"),jsonObject.get("errmsg").toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
