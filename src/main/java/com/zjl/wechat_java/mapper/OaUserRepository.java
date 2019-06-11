package com.zjl.wechat_java.mapper;

import com.zjl.wechat_java.entity.OaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: OaUserRepository
 * @author: zhou
 * @description:
 * @datetime: 2019/6/11 22:56
 */
@Repository
public interface OaUserRepository extends JpaRepository<OaUser,Long>{
}
