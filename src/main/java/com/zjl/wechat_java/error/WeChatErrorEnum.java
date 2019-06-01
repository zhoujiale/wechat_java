package com.zjl.wechat_java.error;

import lombok.Getter;

@Getter
public enum WeChatErrorEnum {
    NOT_FROM_WECHAT("40020","非微信的非法请求");
    private String errorCode;
    private String errorMsg;

    WeChatErrorEnum(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
