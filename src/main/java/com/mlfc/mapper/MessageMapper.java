package com.mlfc.mapper;

import com.mlfc.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {


    @Select("select * from message")
    List<Message> list();

    @Insert("insert into message (name, content, create_time) values (#{name}, #{content}, #{createTime})")
    void addMessage(Message message);
}
