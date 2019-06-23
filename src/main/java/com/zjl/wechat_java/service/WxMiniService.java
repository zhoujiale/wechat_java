package com.zjl.wechat_java.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @className: WxMiniService
 * @author: zhou
 * @description: 微信小程序接口
 * @datetime: 2019/6/23 13:59
 */
public interface WxMiniService {
    /**
     * @description 获取登录授权凭证
     * @author zhou
     * @param code 预授权码
     * @return codeSession
     * @date 2019/6/23
     */
    JSONObject getCodeSession(String code);

    /**
     * @description 通过opendid从缓存中获取codeSession
     * @author zhou
     * @param openid
     * @return codeSession
     * @date 2019/6/23
     */
    JSONObject getCodeSessionByOpenid(String openid);
}
