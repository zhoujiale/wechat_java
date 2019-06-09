package com.zjl.wechat_java.service;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.util.WebResponse;

public interface WxOfficialAccountService {

    /**
     * @description 刷新accessToken
     * @author zhou
     * @param
     * @return string
     * @date 2019/6/8
     */
    String refreshAccessToken();

    /**
     * @description 获取网页授权的accessToken
     * @author zhou
     * @param code 预授权码
     * @return jsonObject
     * @date 2019/6/8
     */
    JSONObject getWebAccessToken(String code);

    /**
     * @description 登录
     * @author zhou
     * @param tokenObject 网页授权token信息
     * @return webResponse
     * @date 2019/6/9
     */
    WebResponse loginInfo(JSONObject tokenObject);
}
