package com.w3cjava.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.w3cjava.entity.User;

@Mapper
public interface UserMapper {

	/**
	 * 
	 * @author cos
	 * @desc 使用@Param传参，@Param中定义的name对应了SQL中的#{name}，age对应了SQL中的#{age}
	 * @param name
	 * @return
	 */
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    /**
     * 
     * @author cos
     * @desc 通过Map<String, Object>对象来作为传递参数的容器
     * @param map
     * @return
     */
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);
    
    /**
     * 
     * @author cos
     * @desc 使用对象
     * @param user
     * @return
     */
    
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(User user);
    
    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
    
    
    /**
     * 
     * @author cos
     * @desc 返回结果的绑定
     * @return
     */
    @Results({
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();
}
