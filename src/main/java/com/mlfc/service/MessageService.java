package com.mlfc.service;

import com.mlfc.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> list();

    void addMessage(Integer userId, Message message);
}
