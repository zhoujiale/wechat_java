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
    @Column(name = "user_id",nullable = false,columnDefinition = "bigint(20) unsigned comment '用户id'")
    private Long userId;
    /**openid*/
    @Column(name = "openid",unique = true,nullable = false,columnDefinition = "varchar(45) comment 'openid'")
    private String openid;
    /**昵称*/
    @Column(name = "nick_name",nullable = false,columnDefinition = "varchar(45) comment '昵称'")
    private String nickName;
    /**性别*/
    @Column(name = "sex",nullable = false,columnDefinition = "smallint(6) default 0 comment '值为1时是男性，值为2时是女性，值为0时是未知'")
    private Short sex;
    /**省*/
    @Column(name = "province",nullable = false,columnDefinition = "varchar(45) comment '省'")
    private String province;
    /**市*/
    @Column(name = "city",nullable = false,columnDefinition = "varchar(45) comment '市'")
    private String city;
    /**头像*/
    @Column(name = "avatar",nullable = false,columnDefinition = "varchar(255) comment '头像'")
    private String avatar;
    /**国家*/
    @Column(name = "country",nullable = false,columnDefinition = "varchar(45) comment '国家'")
    private String country;
    /**uid*/
    @Column(name = "unionid",columnDefinition = "varchar(45) comment 'uid用户微信唯一标识'")
    private String unionid;
    /**刷新令牌*/
    @Column(name = "refresh_token",nullable = false,columnDefinition = "varchar(255) comment '刷新令牌'")
    private String refreshToken;
    /**刷新时间*/
    @Column(name = "refresh_time",nullable = false,columnDefinition = "datetime comment '令牌过期时间'")
    private LocalDateTime refreshTime;
    /**创建时间*/
    @CreatedDate
    @Column(name = "create_time",nullable = false,columnDefinition = "datetime comment '创建时间'")
    private LocalDateTime createTime;
    /**更新时间*/
    @LastModifiedDate
    @Column(name = "update_time",nullable = false,columnDefinition = "datetime comment '修改时间'")
    private LocalDateTime updateTime;
    /**逻辑删除*/
    @Column(name = "is_deleted",nullable = false,columnDefinition = "tinyint(1) default 0 comment '逻辑删除'")
    private Boolean deleted;
    /**特权*/
    @Column(name = "privilege",nullable = false,columnDefinition = "varchar(255) comment '特权'")
    private String privilege;

}
