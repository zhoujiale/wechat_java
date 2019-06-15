package com.zjl.wechat_java.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @className: OaUser
 * @author: zhou
 * @description: 微信公众号用户
 * @datetime: 2019/6/9 19:31
 */
@Data
@Builder
@Entity
@Table(name = "oa_user")
public class OaUser {
    /**主键*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private Long userId;
    /**openid*/
    @Column(name = "openid",unique = true,nullable = false)
    private String openid;
    /**昵称*/
    @Column(name = "nick_name",nullable = false)
    private String nickName;
    /**性别*/
    @Column(name = "sex",nullable = false)
    private Short sex;
    /**省*/
    @Column(name = "province",nullable = false)
    private String province;
    /**市*/
    @Column(name = "city",nullable = false)
    private String city;
    /**头像*/
    @Column(name = "avatar",nullable = false)
    private String avatar;
    /**国家*/
    @Column(name = "country",nullable = false)
    private String country;
    /**uid*/
    @Column(name = "unionid")
    private String unionid;
    /**刷新令牌*/
    @Column(name = "refresh_token",nullable = false)
    private String refreshToken;
    /**刷新时间*/
    @Column(name = "refresh_time",nullable = false)
    private LocalDateTime refreshTime;
    /**创建时间*/
    @CreatedDate
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;
    /**更新时间*/
    @LastModifiedDate
    @Column(name = "update_time",nullable = false)
    private LocalDateTime updateTime;
    /**逻辑删除*/
    @Column(name = "deleted",nullable = false)
    private Boolean deleted;
    /**特权*/
    @Column(name = "privilege",nullable = false)
    private String privilege;

}
