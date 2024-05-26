package com.mlfc.controller;


import com.mlfc.common.Rest;
import com.mlfc.entity.Message;
import com.mlfc.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {



    @Autowired
    private MessageService messageService;

    private String basePath = "D:\\JAVA\\IntelliJ IDEA 2023.2\\code\\gym_vue\\src\\assets\\messageImg\\";

    @PostMapping("/user")
    public Rest<String> addUserMessage(HttpServletRequest request, @RequestBody Message message) {
        log.info("发送消息:{}",message);
        Integer user_id = (Integer) request.getSession().getAttribute("user");
        messageService.addUserMessage(user_id,message);
        return Rest.success("发送成功");
    }

    @PostMapping("/root")
    public Rest<String> addRootMessage(@RequestBody Message message,HttpServletRequest request) {
        Integer root_id = (Integer) request.getSession().getAttribute("root");
        messageService.addRootMessage(message,root_id);
        return Rest.success("发送成功");
    }

    @GetMapping("/userList")
    public Rest<List<Message>> userList() {
        List<Message> list = messageService.userList();
        return Rest.success(list);
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

    @DeleteMapping("/root/{id}")
    public Rest<String> deleteRootMessage(@PathVariable("id") Integer id) {
        messageService.deleteRootMessage(id);
        return Rest.success("删除成功");
    }

    @DeleteMapping("/user/{id}")
    public Rest<String> deleteUserMessage(@PathVariable("id") Integer id) {
        messageService.deleteUserMessage(id);
        return Rest.success("删除成功");
    }

    @PostMapping("/image")
    public Rest<String> upload(@RequestParam("image") MultipartFile file) {
        log.info("上传文件");
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID() + substring;
        log.info("文件名:{}",fileName);
        File fileDir = new File(basePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Rest.success(fileName);
    }
}
