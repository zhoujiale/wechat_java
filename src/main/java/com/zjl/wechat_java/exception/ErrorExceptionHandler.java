package com.zjl.wechat_java.exception;

import com.zjl.wechat_java.util.WebResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: ExceptionHandler
 * @author: zhou
 * @description: 全局异常处理
 * @datetime: 2019/6/1 22:17
 */
@ResponseBody
@ControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(AesException.class)
    public WebResponse aesExceptionHandler(AesException e){
        return WebResponse.fail(e.getAesErrorEnum().getErrorCode(),
                e.getAesErrorEnum().getErrorMsg());
    }

    @ExceptionHandler(WeChatOaException.class)
    public WebResponse weChatExceptionHandler(WeChatOaException e){
        return WebResponse.fail(e.getWeChatOaErrorEnum().getErrorCode(),
                e.getWeChatOaErrorEnum().getErrorMsg());
    }

    @ExceptionHandler(WxErrorException.class)
    public WebResponse wxExceptionHandler(WxErrorException e){
        return WebResponse.fail(e.getErrCode(),e.getErrMsg());
    }
}
