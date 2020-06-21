package com.zjl.wechat_java.exception;

import lombok.Data;

/**
 * @name: SelfDefinedException
 * @description: 自定义异常
 * @author: zhou
 * @create: 2020-06-21 11:31
 */
@Data
public class SelfDefinedException extends RuntimeException{

    private Integer code;

    private String msg;

    public SelfDefinedException(String msg){
        this.code = -1;
        this.msg = msg;
    }
}
