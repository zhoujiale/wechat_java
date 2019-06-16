package com.zjl.wechat_java.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;

/**
 * @className: WxQrCodeService
 * @author: zhou
 * @description: 二维码
 * @datetime: 2019/6/15 21:11
 */
public interface WxQrCodeService {
    /**
     * @description 公众号二维码ticket
     * @author zhou
     * @param sceneId 场景值id
     * @param sceneStr 场景值字符串
     * @param state 类型（临时/永久 0/1）
     * @return ticketJson
     * @date 2019/6/15
     */
    JSONObject QrCodeOfficialTicket(Integer sceneId, String sceneStr, Integer state);

    /**
     * @description
     * @author zhou
     * @param ticketJson ticket数据
     * @param response
     * @return
     * @date 2019/6/16
     */
    void generateQrCodeOfficial(JSONObject ticketJson, HttpServletResponse response);
}
