package com.zjl.wechat_java.controller;

import com.zjl.wechat_java.config.WxOfficialsAccountConfiguration;
import com.zjl.wechat_java.error.WeChatOaErrorEnum;
import com.zjl.wechat_java.exception.WeChatOaException;
import com.zjl.wechat_java.util.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: officialAccountController
 * @author: zhou
 * @description: 微信公众号
 * @datetime: 2019/6/1 20:53
 */
@Slf4j
@RequestMapping("/wx_oa")
@RestController
public class WxServiceConfigController {

    @Autowired
    private WxOfficialsAccountConfiguration wxOfficialsAccountConfiguration;

    /**
     * @param request
     * @return
     * @description 验证微信的token
     * @author zhou
     * @date 2019/6/1
     */
    @GetMapping("/tokenVerification")
    public void tokenVerification(HttpServletRequest request,
                                  HttpServletResponse response) {
        //微信加密签名
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");
        try {
            //获取sha1加密
            String sha1Result = SHA1.getSHA1(wxOfficialsAccountConfiguration.getToken(),
                    timestamp, nonce);
            //判断和签名是否一致
            if (sha1Result.equals(signature)) {
                response.getWriter().write(echostr);
            }else{
                throw new WeChatOaException(WeChatOaErrorEnum.NOT_FROM_WECHAT);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
