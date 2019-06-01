package com.zjl.wechat_java.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: WebResponse
 * @author: zhou
 * @description: 统一响应
 * @datetime: 2019/6/1 22:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse {

    /**状态码*/
    private String code;
    /**信息*/
    private String msg;
    /**数据*/
    private Object data;

    public static WebResponse success(Object data){
        return new WebResponse("200","success",data);
    }

    public static WebResponse fail(String code,String msg){
        return new WebResponse(code,msg,null);
    }
}
