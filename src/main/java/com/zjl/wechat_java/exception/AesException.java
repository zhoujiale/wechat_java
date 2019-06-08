package com.zjl.wechat_java.exception;

import com.zjl.wechat_java.error.AesErrorEnum;
import lombok.Getter;

/**
 * @className: AesException
 * @author: zhou
 * @description:
 * @datetime: 2019/6/1 21:45
 */
@Getter
public class AesException extends RuntimeException{
    private AesErrorEnum aesErrorEnum;

    public AesException(AesErrorEnum aesErrorEnum){
        this.aesErrorEnum = aesErrorEnum;
    }
}
