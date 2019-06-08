package com.zjl.wechat_java.exception;

import com.zjl.wechat_java.error.WeChatOaErrorEnum;
import lombok.Data;

/**
 * @className: WeChatOaException
 * @author: zhou
 * @description:
 * @datetime: 2019/6/1 21:34
 */
@Data
public class WeChatOaException extends RuntimeException {

    private WeChatOaErrorEnum weChatOaErrorEnum;

    public WeChatOaException(WeChatOaErrorEnum weChatOaErrorEnum) {
        this.weChatOaErrorEnum = weChatOaErrorEnum;
    }

}
