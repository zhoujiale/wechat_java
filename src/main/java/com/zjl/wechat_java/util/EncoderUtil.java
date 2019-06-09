package com.zjl.wechat_java.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @className: EncoderUtil
 * @author: zhou
 * @description: 编码工具
 * @datetime: 2019/6/8 12:29
 */
public class EncoderUtil {

    /**
     * @description url编码
     * @author zhou
     * @param url 地址
     * @return string
     * @date 2019/6/8
     */
    public static String UrlEncode(String url){
        String str = null;
        try {
            str = URLEncoder.encode(url,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
