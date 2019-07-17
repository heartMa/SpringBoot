package com.w3cjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @class  SpringBootBanner
 * @version 1.0.0
 * @author cos
 * @desc   自定义banner
 * 	${AnsiColor.BRIGHT_RED}：设置控制台中输出内容的颜色
	${application.version}：用来获取MANIFEST.MF文件中的版本号
	${application.formatted-version}：格式化后的${application.version}版本信息
	${spring-boot.version}：Spring Boot的版本号
	${spring-boot.formatted-version}：格式化后的${spring-boot.version}版本信息
	生成工具
	http://patorjk.com/software/taag
	http://www.network-science.de/ascii/
	http://www.degraeve.com/img2txt.php
 *
 */
@SpringBootApplication
public class SpringBootBanner {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBanner.class, args);
	}
}
