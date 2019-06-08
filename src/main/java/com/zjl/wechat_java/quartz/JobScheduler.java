package com.zjl.wechat_java.quartz;

import com.zjl.wechat_java.service.JobSchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @className: JobScheduler
 * @author: zhou
 * @description: 定时任务
 * @datetime: 2019/6/7 18:54
 */
@Component
@Slf4j
public class JobScheduler {

    @Autowired
    private JobSchedulerService jobSchedulerService;

    /**公众号access_token刷新时间*/
    private final Integer OA_ACCESS_TOKEN = 1000 * 7200;

    /**
     * @description: 定时刷新公众号access_token
     * @author: zhou
     * @param:
     * @return:
     * @date: 2019/6/7
     */
    @Scheduled(fixedDelay = OA_ACCESS_TOKEN)
    public void refreshOaAccessToken(){
        log.info("刷新公众号accessToken");
        jobSchedulerService.refreshOaAccessToken();
    }
}
