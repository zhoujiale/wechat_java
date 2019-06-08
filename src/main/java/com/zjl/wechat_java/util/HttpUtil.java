package com.zjl.wechat_java.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.URL;

/**
 * @className: HttpUtil
 * @author: zhou
 * @description: http请求类
 * @datetime: 2019/6/7 23:45
 */
@Component
public class HttpUtil {

    /**
     * @description get请求
     * @author zhou
     * @created  2019/3/8 14:18
     * @param  url 请求地址
     * @return jsonObject
     */
    public JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        //首先初始化HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URL u = new URL(url);
        HttpGet httpGet = new HttpGet(String.valueOf(u));
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                jsonObject = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return jsonObject;
    }
}
