package com.zjl.wechat_java.exception;

import com.zjl.wechat_java.utils.WebResponse;
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
    public WebResponse AesExceptionHandler(AesException e){
        return WebResponse.fail(e.getAesErrorEnum().getErrorCode(),
                e.getAesErrorEnum().getErrorMsg());
    }

    @ExceptionHandler(WeChatException.class)
    public WebResponse WeChatExceptionHandler(WeChatException e){
        return WebResponse.fail(e.getWeChatErrorEnum().getErrorCode(),
                e.getWeChatErrorEnum().getErrorMsg());
    }
}
