package com.mlfc.mapper;

import com.mlfc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username, password, name, phone, height, weight, age, create_time, update_time) values (#{username}, #{password}, #{name}, #{phone}, #{height}, #{weight}, #{age}, #{createTime}, #{updateTime})")
    void register(User user);

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);
}
