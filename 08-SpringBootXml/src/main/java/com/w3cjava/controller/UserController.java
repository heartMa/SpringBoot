package com.w3cjava.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.w3cjava.entity.User;

@Controller 
public class UserController {
	@RequestMapping(value = "/user", 
	consumes = MediaType.APPLICATION_XML_VALUE, 
	produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public User create(@RequestBody User user) {
	    user.setName("www.w3cjava.com : " + user.getName());
	    user.setAge(user.getAge() + 100);
	    return user;
	} 
}
