package com.zjl.wechat_java.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.error.WeChatOaErrorEnum;
import com.zjl.wechat_java.exception.WeChatOaException;
import com.zjl.wechat_java.service.WxQrCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @className: WxQrCodeController
 * @author: zhou
 * @description: 二维码相关
 * @datetime: 2019/6/15 21:00
 */

@Slf4j
@RestController
@RequestMapping("/qrcode")
public class WxQrCodeController {
    @Autowired
    private WxQrCodeService wxQrCodeService;

    /**
     * @description 公众号生成二维码
     * @author zhou
     * @param sceneId 场景值id
     * @param sceneStr 场景值字符串
     * @param state 类型（临时/永久 0/1）
     * @return
     * @date 2019/6/15
     */
    @GetMapping(value = "/generateQrCodeOfOfficial")
    public void GenerateQrCodeOfOfficial(@RequestParam(value = "sceneId",required = false) Integer sceneId,
                                         @RequestParam(value = "sceneStr",required = false) String sceneStr,
                                         @RequestParam(value = "state",required = false)Integer state,
                                         HttpServletResponse response){
        JSONObject ticketJson = wxQrCodeService.QrCodeOfficialTicket(sceneId, sceneStr, state);
        if(null == ticketJson){
            log.error("获取公众号二维码ticket失败");
            throw new WeChatOaException(WeChatOaErrorEnum.QR_CODE_TICKET_ERROR);
        }
        wxQrCodeService.generateQrCodeOfficial(ticketJson,response);
    }
}
