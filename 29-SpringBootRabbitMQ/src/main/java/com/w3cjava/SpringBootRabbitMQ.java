package com.w3cjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @class  SpringBootRabbitMQ
 * @version TODO
 * @author cos 
 * @desc   http://localhost:15672 用户guest登录，密码也为guest
 *
 */
@SpringBootApplication
public class SpringBootRabbitMQ {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMQ.class, args);
	}
}
