package com.zjl.wechat_java.error;

import lombok.Getter;

/**
 * @className: WeChatMiniErrorEnum
 * @author: zhou
 * @description: 微信小程序
 * @datetime: 2019/6/23 16:04
 */
@Getter
public enum WeChatMiniErrorEnum {
    CODE_SESSION_ERROR(4101,"微信小程序获取code_session异常");
    private Integer errorCode;
    private String errorMsg;

    WeChatMiniErrorEnum(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
