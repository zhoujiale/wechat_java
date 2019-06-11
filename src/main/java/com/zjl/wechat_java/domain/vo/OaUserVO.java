package com.zjl.wechat_java.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @className: OaUserVO
 * @author: zhou
 * @description:
 * @datetime: 2019/6/11 23:21
 */
@Data
@Builder
public class OaUserVO {

    private Long userId;

    private String openid;

    private String nickname;

    private String avatar;

}
