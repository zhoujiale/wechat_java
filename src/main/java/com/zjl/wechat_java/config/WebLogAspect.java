package com.zjl.wechat_java.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @className: webLogAspect
 * @author: zhou
 * @description: 全局请求日志打印
 * @datetime: 2019/6/1 20:27
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    /**请求开始时间*/
    ThreadLocal<LocalDateTime> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.zjl.wechat_java.controller.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        log.debug("前置通知");
        startTime.set(LocalDateTime.now());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //ip
        log.info("IP:"+request.getRemoteAddr());
        //url
        log.info("URL:"+ request.getRequestURL().toString());
        //method
        log.info("METHOD:"+request.getMethod());
        //className
        log.info("CLASS_NAME:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //params
        log.info("PARAMS:"+ Arrays.toString(joinPoint.getArgs()));
    }
    @After("webLog()")
    public void doAfter(){
        log.debug("后置通知");
    }
    @AfterReturning(pointcut = "webLog()",returning = "object")
    public void doAfterReturning(Object object){
        log.info("RESPONSE:"+object);
        log.info("SPEND_TIME:"+ Duration.between(startTime.get(),LocalDateTime.now()).toMillis());
        startTime.remove();
    }
}
