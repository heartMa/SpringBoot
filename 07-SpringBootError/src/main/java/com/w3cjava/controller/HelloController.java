package com.w3cjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.w3cjava.exception.MyException;


@Controller
@RequestMapping(value="")    
public class HelloController {
	@RequestMapping("/hello")
	public String hello() throws Exception {
	    throw new Exception("发生错误");
	}
	
	
	 @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
