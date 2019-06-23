package com.zjl.wechat_java.exception;

import com.zjl.wechat_java.error.WeChatMiniErrorEnum;
import lombok.Getter;

/**
 * @className: WeChatMiniException
 * @author: zhou
 * @description: 微信小程序异常
 * @datetime: 2019/6/23 16:10
 */
@Getter
public class WeChatMiniException extends RuntimeException{

    private Integer errCode;
    private String errMsg;

    public WeChatMiniException(WeChatMiniErrorEnum weChatMiniErrorEnum){
        this.errCode = weChatMiniErrorEnum.getErrorCode();
        this.errMsg = weChatMiniErrorEnum.getErrorMsg();
    }
}
