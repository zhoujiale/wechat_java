package com.zjl.wechat_java.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.service.WxMiniService;
import com.zjl.wechat_java.util.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @className: WxMiniController
 * @author: zhou
 * @description: 微信小程序
 * @datetime: 2019/6/23 13:30
 */
@Slf4j
@RestController
@RequestMapping("mini")
public class WxMiniController {

    @Autowired
    private WxMiniService wxMiniService;
    
    /**
     * @description
     * @author zhou
     * @param code 预授权码  （前端先通过登录态校验再决定是否传code）
     * @param rawData 原始非明杠信息
     * @param encryptedData 加密敏感信息
     * @param signature  签名
     * @param iv 向量
     * @return 小程序登录
     * @date 2019/6/23 
     */
    @GetMapping(value = "/login")
    public WebResponse miniLogin(@RequestParam(value = "code",required = false) String code,
                                 @RequestParam(value = "rawData") String rawData,
                                 @RequestParam(value = "signature") String signature,
                                 @RequestParam(value = "encryptedData")String encryptedData,
                                 @RequestParam(value = "iv")String iv,
                                 HttpServletRequest request){
        JSONObject codeSession = new JSONObject();
        if(StringUtils.isEmpty(code)){
            //获取codeSession
             codeSession = wxMiniService.getCodeSession(code);
        }else {
            String openid = (String) request.getSession().getAttribute("openid");
            //从缓存中获取
             codeSession = wxMiniService.getCodeSessionByOpenid(openid);
        }
        return null;
    }
}
