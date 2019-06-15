package com.zjl.wechat_java.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: OaUserVO
 * @author: zhou
 * @description:
 * @datetime: 2019/6/11 23:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OaUserVO {

    private Long userId;

    private String openid;

    private String nickname;

    private String avatar;

}
