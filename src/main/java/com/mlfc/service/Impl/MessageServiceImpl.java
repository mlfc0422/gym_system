package com.mlfc.service.Impl;

import com.mlfc.entity.Message;
import com.mlfc.entity.User;
import com.mlfc.mapper.MessageMapper;
import com.mlfc.mapper.UserMapper;
import com.mlfc.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Message> list() {
        return messageMapper.list();
    }

    @Override
    public void addMessage(Integer userId, Message message) {
        User user = userMapper.findById(userId);
        message.setCreateTime(LocalDateTime.now());
        message.setName(user.getUsername());
        log.info("发送消息:{}",message);
        messageMapper.addMessage(message);
    }
}