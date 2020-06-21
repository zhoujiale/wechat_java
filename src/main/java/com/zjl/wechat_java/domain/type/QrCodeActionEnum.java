package com.zjl.wechat_java.domain.type;

import lombok.Getter;

/**
 * @Auther: zhou
 * @Date: 2020-06-21 11:21
 * @Description:
 */
@Getter
public enum QrCodeActionEnum {
    /**QR_SCENE为临时的整型参数值，
     * QR_STR_SCENE为临时的字符串参数值，
     * QR_LIMIT_SCENE为永久的整型参数值，
     * QR_LIMIT_STR_SCENE为永久的字符串参数值**/
    QR_SCENE("QR_SCENE"),
    QR_STR_SCENE("QR_STR_SCENE"),
    QR_LIMIT_SCENE("QR_LIMIT_SCENE"),
    QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE")
    ;
    private String name;

    QrCodeActionEnum(String name){
        this.name = name;
    }
}
