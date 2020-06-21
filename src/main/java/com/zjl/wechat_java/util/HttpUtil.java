package com.zjl.wechat_java.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @className: HttpUtil
 * @author: zhou
 * @description: http请求类
 * @datetime: 2019/6/7 23:45
 */
@Component
@Slf4j
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

    /**
     * @description 发送post请求
     * @author zhou
     * @created  2019/3/8 17:32
     * @param jsonObject 请求体
     * @param url 地址
     * @return
     */
    public JSONObject dePostJson(JSONObject jsonObject, String url) {
        JSONObject jsonResponse = null;
        HttpPost httpPost = new HttpPost(url);
        try{
            HttpClient httpClient = HttpClientBuilder.create().build();
            //设置超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                    .setSocketTimeout(5000).build();
            httpPost.setConfig(requestConfig);
            //构造消息头
            httpPost.setHeader("Content-type","application/json;charset=utf-8");
            httpPost.setHeader("Connection","Keep-Alive");
            //构造消息体
            StringEntity entity = new StringEntity(jsonObject.toJSONString(), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            //发送json格式的数据请求
            entity.setContentType("application/json");
            httpPost.setEntity(entity);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String resultToString = EntityUtils.toString(httpResponse.getEntity());
                log.debug(resultToString);
                return JSON.parseObject(resultToString);
            }
            return (JSONObject) httpResponse;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    public void getImage(HttpServletResponse response,String url){
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            InputStream inputStream = conn.getInputStream();
            byte[] bytes = readInputStream(inputStream);
            inputStream.close();
            response.setContentType("image/jpg");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }
        inputStream.close();
        return outputStream.toByteArray();
    }
}
