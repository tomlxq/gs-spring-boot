package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.*;
@Mapper
public interface UserDao {
    //通过Options获取主键
    @Insert("INSERT INTO user(name,age) VALUES (#{name}, #{age}) ")
    @Options(useGeneratedKeys= true, keyProperty="id")
    int insert(User user);


    @Delete("DELETE FROM user WHERE id　= #{id}")
    int delete(@Param("id") Integer id);

    @Update("UPDATE user SET name = #{name}, age = #{age} WHERE id = #{id}")
    int update(User user);

    @Select("SELECT id, name, age FROM user WHERE id = #{id}")
    User findById(Integer id);
}
