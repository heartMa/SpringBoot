package com.w3cjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * 
 * @class  SpringBootEhcache
 * @version TODO
 * @author cos
 * @desc   Ehcache
 *
 */
@EnableCaching//@EnableCaching注解开启缓存功能
@SpringBootApplication
public class SpringBootEhcache {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEhcache.class, args);
	}
}
