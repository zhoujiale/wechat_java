package com.zjl.wechat_java.util;

import lombok.Data;

/**
 * @className: WebResponse
 * @author: zhou
 * @description: 统一响应
 * @datetime: 2019/6/1 22:27
 */
@Data
public class WebResponse {

    /**状态码*/
    private Integer code;
    /**信息*/
    private String msg;
    /**数据*/
    private Object data;

    public static WebResponse success(Object data){
        return new WebResponse(200,"success",data);
    }

    public static WebResponse fail(Integer code,String msg){
        return new WebResponse(code,msg,null);
    }

    public WebResponse(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public WebResponse(){

    }
}
