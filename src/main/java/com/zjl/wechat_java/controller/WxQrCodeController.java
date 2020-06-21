package com.zjl.wechat_java.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.exception.SelfDefinedException;
import com.zjl.wechat_java.service.WxQrCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
        if (null != sceneId && (sceneId < 0 || sceneId > 100000)){
            log.warn("场景值id不合法");
            throw new SelfDefinedException("场景值id不合法");
        }
        if (StringUtils.isNotBlank(sceneStr) && sceneStr.length() > 64){
            log.warn("场景值字符串不合法");
            throw new SelfDefinedException("场景值字符串不合法");
        }
        if (0 != state && 1 != state){
            log.warn("类型不合法");
            throw new SelfDefinedException("类型不合法");
        }
        JSONObject ticketJson = wxQrCodeService.QrCodeOfficialTicket(sceneId, sceneStr, state);
        wxQrCodeService.generateQrCodeOfficial(ticketJson,response);
    }
}
