package com.w3cjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @class  SpringBootSecurity
 * @version TODO
 * @author cos
 * @date   2019年7月13日
 * @desc   /hello页面进行权限控制，必须是授权用户才能访问。当没有权限的用户访问后，跳转到登录页面
 * 访问http://localhost:8080/，可以正常访问。
 * 但是访问http://localhost:8080/hello的时候被重定向到了http://localhost:8080/login页面，因为没有登录，用户没有访问权限，
 * 通过输入用户名user和密码password进行登录后，跳转到了Hello World页面，
 * 再也通过访问http://localhost:8080/login?logout，就可以完成注销操作。
 *
 */
@SpringBootApplication
public class SpringBootSecurity {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurity.class, args);
	}
}
