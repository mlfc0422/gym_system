package com.mlfc.controller;


import com.mlfc.common.Rest;
import com.mlfc.entity.Message;
import com.mlfc.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/userList")
    public Rest<List<Message>> userList() {
        List<Message> list = messageService.userList();
        return Rest.success(list);
    }


    @PostMapping("/user")
    public Rest<String> addMessage(HttpServletRequest request,@RequestBody Message message) {
        log.info("发送消息:{}",message);
        Integer user_id = (Integer) request.getSession().getAttribute("user");
        messageService.addMessage(user_id,message);
        return Rest.success("发送成功");
    }

    @GetMapping("/rootList")
    public Rest<List<Message>> rootList() {
        List<Message> list = messageService.rootList();
        return Rest.success(list);
    }

    @GetMapping("/announcement")
    public Rest<Message> announcement() {
        Message message = messageService.announcement();
        return Rest.success(message);
    }
}
