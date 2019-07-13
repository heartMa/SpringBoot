package com.w3cjava.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @class  User
 * @version TODO
 * @author cos
 * @date   2019年7月13日
 * @desc   @Data、@NoArgsConstructor、@AllArgsConstructor是lombok简化代码的注解，主要用于生成get、set以及构造函数
 * 
 * 	<User>
		<name>aaaa</name>
		<age>10</age>
	</User>
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JacksonXmlRootElement、@JacksonXmlProperty注解是用来维护对象属性在xml中的对应关系
@JacksonXmlRootElement(localName = "User")
public class User {
	@JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "age")
    private Integer age;
    
}
