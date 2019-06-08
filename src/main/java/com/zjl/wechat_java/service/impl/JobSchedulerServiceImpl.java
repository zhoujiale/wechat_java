package com.zjl.wechat_java.service.impl;

import com.zjl.wechat_java.config.CacheParam;
import com.zjl.wechat_java.error.WeChatOaErrorEnum;
import com.zjl.wechat_java.exception.WeChatOaException;
import com.zjl.wechat_java.service.JobSchedulerService;
import com.zjl.wechat_java.service.WxOfficialAccountService;
import com.zjl.wechat_java.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: JobSchedulerServiceImpl
 * @author: zhou
 * @description: 定时任务实现类
 * @datetime: 2019/6/8 9:43
 */
@Slf4j
@Service
public class JobSchedulerServiceImpl implements JobSchedulerService{

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private WxOfficialAccountService wxOfficialAccountService;

    /**
     * @description 刷新公众号的accessToken
     * @author zhou
     * @param
     * @return
     * @date 2019/6/8
     */
    @Override
    public void refreshOaAccessToken() {
         String accessToken = wxOfficialAccountService.refreshAccessToken();
         if(null == accessToken){
             log.error("公众号获取accessToken异常");
             throw new WeChatOaException(WeChatOaErrorEnum.GET_ACCESS_TOKEN_ERROR);
         }
         //存入redis
         redisUtil.set(CacheParam.OA_ACCESS_TOKEN,accessToken, (long) 7000);
    }
}
