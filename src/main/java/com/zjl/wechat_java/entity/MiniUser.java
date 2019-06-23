package com.zjl.wechat_java.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @className: MiniUser
 * @author: zhou
 * @description: 小程序用户
 * @datetime: 2019/6/23 10:24
 */
@Data
@Builder
@Entity
@Table(name = "mini_user")
public class MiniUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false,columnDefinition = "bigint(20) unsigned comment '用户id'")
    private Long userId;
    @Column(name = "openid",unique = true,nullable = false,columnDefinition = "varchar(45) comment 'openid'")
    private String openid;
    @Column(name = "nick_name",nullable = false,columnDefinition = "varchar(45) comment '昵称'")
    private String nickName;
    @Column(name = "gender",nullable = false,columnDefinition = "smallint(6) unsigned default 0 comment '性别 0未知 1男 2女'")
    private Short gender;
    @Column(name = "avatar",nullable = false,columnDefinition = "varchar(45) comment '头像'")
    private String avatar;
    @Column(name = "country",nullable = false,columnDefinition = "varchar(45) comment '国家'")
    private String country;
    @Column(name = "province",nullable = false,columnDefinition = "varchar(45) comment '省'")
    private String province;
    @Column(name = "city",nullable = false,columnDefinition = "varchar(45) comment '市'")
    private String city;
    @CreatedDate
    @Column(name = "create_date",nullable = false,columnDefinition = "datetime comment '创建时间'")
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(name = "update_date",nullable = false,columnDefinition = "datetime comment '更新时间'")
    private LocalDateTime updateDate;
    @Column(name = "is_deleted",nullable = false,columnDefinition = "tinyint(1) default 0 comment '逻辑删除'")
    private Boolean deleted;
}
