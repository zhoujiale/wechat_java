package com.zjl.wechat_java.error;

import lombok.Getter;

@Getter
public enum WeChatOaErrorEnum {
    NOT_FROM_WECHAT(4020,"非微信的非法请求"),
    GET_ACCESS_TOKEN_ERROR(4021,"获取accessToken异常"),
    AUTH_LOGIN_ERROR(4022,"公众号授权登陆失败");
    private Integer errorCode;
    private String errorMsg;

    WeChatOaErrorEnum(Integer errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
