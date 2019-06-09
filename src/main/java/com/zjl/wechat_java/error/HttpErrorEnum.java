package com.zjl.wechat_java.error;

import lombok.Getter;

/**
 * @className: HttpErrorEnum
 * @author: zhou
 * @description:
 * @datetime: 2019/6/8 12:40
 */
@Getter
public enum HttpErrorEnum {
    REQUEST_ERROR(4041,"请求异常");
    private Integer errorCode;
    private String errorMsg;

    HttpErrorEnum(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
