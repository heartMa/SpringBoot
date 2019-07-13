package com.w3cjava.exception;
/**
 * 
 * @class  MyException
 * @version TODO
 * @author cos
 * @date   2019年7月13日
 * @desc   创建一个自定义异常，用来实验捕获该异常，并返回json
 *
 */
public class MyException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
        super(message);
    }
    
}