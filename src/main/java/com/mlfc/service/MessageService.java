package com.mlfc.service;

import com.mlfc.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> userList();

    void addMessage(Integer userId, Message message);

    List<Message> rootList();

    Message announcement();
}
