package com.zjl.wechat_java.exception;

import com.zjl.wechat_java.error.HttpErrorEnum;
import lombok.Getter;

/**
 * @className: HttpException
 * @author: zhou
 * @description: 请求异常
 * @datetime: 2019/6/8 12:45
 */
@Getter
public class HttpException extends RuntimeException{
    private HttpErrorEnum httpErrorEnum;

    public HttpException(HttpErrorEnum httpErrorEnum){
        this.httpErrorEnum = httpErrorEnum;
    }
}
