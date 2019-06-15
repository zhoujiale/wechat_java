package com.zjl.wechat_java.error;

import lombok.Getter;

@Getter
public enum AesErrorEnum {
    VALIDATE_SIGNATURE_ERROR(4001,"签名验证错误"),
    PARSE_XML_ERROR(4002,"xml解析失败"),
    COMPUTE_SIGNATURE_ERROR(4003,"sha加密生成签名失败"),
    ILLEGAL_AES_KEY(4004,"SymmetricKey非法"),
    VALIDATE_APPID_ERROR(4005,"appid校验失败"),
    ENCRYPT_AES_ERROR(4006,"aes加密失败"),
    DECRYPT_AES_ERROR(4007,"aes解密失败"),
    ILLEGAL_BUFFER(4008,"解密后得到的buffer非法");

    private Integer errorCode;
    private String errorMsg;

    AesErrorEnum(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
