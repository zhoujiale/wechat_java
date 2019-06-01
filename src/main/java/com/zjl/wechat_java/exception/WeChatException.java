package com.zjl.wechat_java.exception;

import com.zjl.wechat_java.error.WeChatErrorEnum;
import lombok.Getter;

/**
 * @className: WeChatException
 * @author: zhou
 * @description:
 * @datetime: 2019/6/1 21:34
 */
@Getter
public class WeChatException extends Exception {

    private WeChatErrorEnum weChatErrorEnum;

    public WeChatException(WeChatErrorEnum weChatErrorEnum) {
        this.weChatErrorEnum = weChatErrorEnum;
    }

}
