package com.mlfc.service.Impl;

import com.mlfc.entity.Message;
import com.mlfc.entity.Root;
import com.mlfc.entity.User;
import com.mlfc.mapper.MessageMapper;
import com.mlfc.mapper.RootMapper;
import com.mlfc.mapper.UserMapper;
import com.mlfc.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RootMapper rootMapper;

    @Override
    public List<Message> userList() {
        return messageMapper.userList();
    }

    @Override
    public void addUserMessage(Integer userId, Message message) {
        User user = userMapper.findById(userId);
        message.setCreateTime(LocalDateTime.now());
        message.setName(user.getUsername());
        message.setIdentity(0);
        log.info("发送消息:{}",message);
        messageMapper.addMessage(message);
    }

    @Override
    public List<Message> rootList() {
        return messageMapper.rootList();
    }

    @Override
    public Message announcement() {
        return messageMapper.announcement();
    }

    @Override
    public void deleteRootMessage(Integer id) {
        messageMapper.deleteMessage(id);
    }

    @Override
    public void addRootMessage(Message message, Integer root_id) {
        Root root = rootMapper.findById(root_id);
        message.setName(root.getUsername());
        message.setCreateTime(LocalDateTime.now());
        message.setIdentity(1);
        messageMapper.addMessage(message);
    }

    @Override
    public void deleteUserMessage(Integer id) {
        messageMapper.deleteMessage(id);
    }
}
