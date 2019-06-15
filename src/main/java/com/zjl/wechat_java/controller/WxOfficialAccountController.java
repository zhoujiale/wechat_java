package com.zjl.wechat_java.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.config.WxOaUrlConfig;
import com.zjl.wechat_java.config.WxOfficialsAccountConfiguration;
import com.zjl.wechat_java.error.HttpErrorEnum;
import com.zjl.wechat_java.exception.HttpException;
import com.zjl.wechat_java.exception.WxErrorException;
import com.zjl.wechat_java.service.WxOfficialAccountService;
import com.zjl.wechat_java.util.EncoderUtil;
import com.zjl.wechat_java.util.HttpUtil;
import com.zjl.wechat_java.util.RedisUtil;
import com.zjl.wechat_java.util.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: WxOfficialAccountController
 * @author: zhou
 * @description: 微信公众号类
 * @datetime: 2019/6/7 18:50
 */
@Slf4j
@RestController
@RequestMapping("/oa")
public class WxOfficialAccountController {

    @Autowired
    private WxOfficialAccountService wxOfficialAccountService;
    @Autowired
    private WxOfficialsAccountConfiguration wxOfficialsAccountConfiguration;
    @Autowired
    private HttpUtil httpUtil;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * @description 获取回调中的code(这个可以让前端直接去请求这个url,而不是让后端做重定向)
     * @author zhou
     * @param
     * @return
     * @date 2019/6/8
     */
    @GetMapping(value = "/preAuth")
    public void preAuth(HttpServletResponse response)  {
        //拼接请求地址
        StringBuilder sb = new StringBuilder(WxOaUrlConfig.API_PRE_AUTH);
        sb.append("appid=").append(wxOfficialsAccountConfiguration.getAppid())
           .append("&").append("redirect_uri=").append(EncoderUtil
                .UrlEncode(wxOfficialsAccountConfiguration.getRedirectUrl()))
           .append("&").append("response_type=code")
                //获取用户信息
           .append("&").append("scope=snsapi_userinfo")
           .append("&").append("state=4959a8b50e8e41ad")
           .append("#wechat_redirect");
        String url = sb.toString();
        try {
            //httpUtil.doGetJson(url);
            response.sendRedirect(url);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new HttpException(HttpErrorEnum.REQUEST_ERROR);
        }
    }

    /**
     * @description 授权回调
     * @author zhou
     * @param
     * @return
     * @date 2019/6/8
     */
    @GetMapping(value = "/authCallback")
    public WebResponse authCallBack(HttpServletRequest request){
        String code = request.getParameter("code");
        //获取网页授权的accessToken
        JSONObject tokenObject = wxOfficialAccountService.getWebAccessToken(code);
        if(!tokenObject.containsKey("access_token")){
            log.error(tokenObject.getString("errmsg"));
            throw new WxErrorException(tokenObject.getInteger("errcode"),tokenObject.get("errMsg").toString());
        }
        WebResponse webResponse = wxOfficialAccountService.loginInfo(tokenObject);
        return webResponse;
    }
}
