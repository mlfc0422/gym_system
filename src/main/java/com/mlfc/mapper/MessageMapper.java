package com.mlfc.mapper;

import com.mlfc.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {


    @Select("select * from message where identity=0")
    List<Message> userList();

    @Insert("insert into message (name, content, create_time) values (#{name}, #{content}, #{createTime})")
    void addMessage(Message message);

    @Select("select * from message where identity=1")
    List<Message> rootList();

    @Select("select * from message where identity=1 order by create_time desc limit 1")
    Message announcement();
}
