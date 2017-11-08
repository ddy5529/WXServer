package com.ddy.wxServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableTransactionManagement  //开启事务管理
@SpringBootApplication
public class WXApplication {
	public static void main(String[] args) {
		SpringApplication.run(WXApplication.class, args);

	}
}
