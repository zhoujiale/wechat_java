package com.zjl.wechat_java.error;

import lombok.Getter;

@Getter
public enum AesErrorEnum {
    ValidateSignatureError("40001","签名验证错误"),
    ParseXmlError("40002","xml解析失败"),
    ComputeSignatureError("40003","sha加密生成签名失败"),
    IllegalAesKey("40004","SymmetricKey非法"),
    ValidateAppidError("40005","appid校验失败"),
    EncryptAESError("40006","aes加密失败"),
    DecryptAESError("40007","aes解密失败"),
    IllegalBuffer("40008","解密后得到的buffer非法");

    private String errorCode;
    private String errorMsg;

    AesErrorEnum(String errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
