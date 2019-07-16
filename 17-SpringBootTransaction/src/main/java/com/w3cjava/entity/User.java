package com.w3cjava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
    @GeneratedValue
    private Long id;

	//通过定义User的name属性长度为5，这样通过创建时User实体的name属性超长就可以触发异常产生
    //@Column(nullable = false)
    @Column(nullable = false, length = 5)
    private String name;

    @Column(nullable = false)
    private Integer age;

	public User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
    
    
    
}
