package com.zjl.wechat_java.error;

import lombok.Getter;

@Getter
public enum AesErrorEnum {
    ValidateSignatureError(4001,"签名验证错误"),
    ParseXmlError(4002,"xml解析失败"),
    ComputeSignatureError(4003,"sha加密生成签名失败"),
    IllegalAesKey(4004,"SymmetricKey非法"),
    ValidateAppIdError(4005,"appid校验失败"),
    EncryptAESError(4006,"aes加密失败"),
    DecryptAESError(4007,"aes解密失败"),
    IllegalBuffer(4008,"解密后得到的buffer非法");

    private Integer errorCode;
    private String errorMsg;

    AesErrorEnum(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
