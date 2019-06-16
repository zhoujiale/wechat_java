package com.zjl.wechat_java.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjl.wechat_java.config.CacheParam;
import com.zjl.wechat_java.config.WxOaUrlConfig;
import com.zjl.wechat_java.service.WxQrCodeService;
import com.zjl.wechat_java.util.HttpUtil;
import com.zjl.wechat_java.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @className: WxQrCodeServiceImpl
 * @author: zhou
 * @description: 微信二维码
 * @datetime: 2019/6/15 21:12
 */
@Slf4j
@Service
public class WxQrCodeServiceImpl implements WxQrCodeService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private HttpUtil httpUtil;
    /**
     * @description 公众号二维码ticket
     * @author zhou
     * @param sceneId 场景值id
     * @param sceneStr 场景值字符串
     * @param state 类型（临时/永久 0/1）
     * @return ticketJson
     * @date 2019/6/15
     */
    @Override
    public JSONObject QrCodeOfficialTicket(Integer sceneId, String sceneStr, Integer state) {
        //拼装url
        StringBuilder sb = new StringBuilder(WxOaUrlConfig.API_CREATE_QR_CODE);
        sb.append("access_token=").append(redisUtil.get(CacheParam.OA_ACCESS_TOKEN));
        String url = sb.toString();
        JSONObject jsonObject = new JSONObject();
        generateOfficialQrCodeJson(jsonObject,sceneId,sceneStr,state);
        JSONObject resultJson = httpUtil.dePostJson(jsonObject, url);
        if(resultJson.containsKey("ticket")){
            return resultJson;
        }else {
            return null;
        }
    }

    /**
     * @description
     * @author zhou
     * @param jsonObject json
     * @param sceneId 整型数值
     * @param sceneStr 字符串数值
     * @param state 类型
     * @return
     * @date 2019/6/16
     */
    private void generateOfficialQrCodeJson(JSONObject jsonObject, Integer sceneId, String sceneStr, Integer state) {
        if(0 == state){
            //二维码有效时间，单位秒，不设置默认30s
            jsonObject.put("expire_seconds",7200);
            if(null != sceneId){
                jsonObject.put("action_name","QR_SCENE");
                JSONObject scene = new JSONObject();
                scene.put("scene_id",sceneId);
                JSONObject actionInfo = new JSONObject();
                actionInfo.put("scene",scene);
                jsonObject.put("action_info",actionInfo);
            }else{
                jsonObject.put("action_name","QR_STR_SCENE");
                JSONObject scene = new JSONObject();
                scene.put("scene_str",sceneStr);
                JSONObject actionInfo = new JSONObject();
                actionInfo.put("scene",scene);
                jsonObject.put("action_info",actionInfo);
            }
        }else if(1 == state){
            //永久二维码
            if(null != sceneId){
                jsonObject.put("action_name","QR_LIMIT_SCENE");
                JSONObject scene = new JSONObject();
                scene.put("scene_id",sceneId);
                JSONObject actionInfo = new JSONObject();
                actionInfo.put("scene",scene);
                jsonObject.put("action_info",actionInfo);
            }else {
                jsonObject.put("action_name","QR_LIMIT_STR_SCENE");
                JSONObject scene = new JSONObject();
                scene.put("scene_str",sceneStr);
                JSONObject actionInfo = new JSONObject();
                actionInfo.put("scene",scene);
                jsonObject.put("action_info",actionInfo);
            }
        }
    }

    /**
     * @description
     * @author zhou
     * @param ticketJson ticket数据
     * @param response
     * @return
     * @date 2019/6/16
     */
    @Override
    public void generateQrCodeOfficial(JSONObject ticketJson, HttpServletResponse response) {
        StringBuilder sb = new StringBuilder(WxOaUrlConfig.API_SHOW_QR_CODE);
        try {
            sb.append("ticket=").append(URLEncoder.encode(ticketJson.getString("ticket"),"utf-8"));
            String url =sb.toString();
            httpUtil.getImage(response,url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
