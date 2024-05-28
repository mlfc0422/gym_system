package com.mlfc.mapper;

import com.mlfc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username, password, name, phone, height, weight, age, create_time, update_time) values (#{username}, #{password}, #{name}, #{phone}, #{height}, #{weight}, #{age}, #{createTime}, #{updateTime})")
    void register(User user);

    @Select("select id,username,password from user where username = #{username}")
    User findByUsername(String username);

    @Update("update user set name = #{name}, phone = #{phone}, height = #{height}, weight = #{weight}, age = #{age}, update_time = #{updateTime} where username = #{username}")
    void update(User user);

    @Select("select username, name, phone, height, weight, age from user where id = #{id}")
    User findById(int id);

    @Select("select id, username, name, phone, height, weight, age, create_time from user")
    List<User> list();

    void delete(@Param("ids") long[] ids);

}
