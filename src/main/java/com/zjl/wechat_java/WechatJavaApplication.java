package com.zjl.wechat_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WechatJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WechatJavaApplication.class, args);
	}

}
