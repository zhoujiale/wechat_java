package com.zjl.wechat_java.domain.vo;

import lombok.Data;

/**
 * @className: MiniUserVO
 * @author: zhou
 * @description:
 * @datetime: 2019/6/23 15:52
 */
@Data
public class MiniUserVO {
    private Long userId;
    private String openid;
    private String avatar;
    private String nickName;
    private Short gender;
}
