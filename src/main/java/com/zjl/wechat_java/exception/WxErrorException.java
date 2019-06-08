package com.zjl.wechat_java.exception;

import lombok.Data;

/**
 * @className: WxErrorException
 * @author: zhou
 * @description: 微信系统的异常
 * @datetime: 2019/6/8 10:11
 */
@Data
public class WxErrorException extends RuntimeException{

    private Integer errCode;
    private String errMsg;

   public WxErrorException(Integer errCode,String errMsg){
       this.errCode = errCode;
       this.errMsg = errMsg;
   }

}
