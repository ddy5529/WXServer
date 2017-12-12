package com.ddy.wxServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableTransactionManagement  //开启事务管理
@SpringBootApplication
@EnableScheduling // 这里，启用定时任务
public class WXApplication {
	public static void main(String[] args) {
		SpringApplication.run(WXApplication.class, args);
	}
}
