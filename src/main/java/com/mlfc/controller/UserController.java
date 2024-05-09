package com.mlfc.controller;

import com.mlfc.common.Rest;
import com.mlfc.entity.User;
import com.mlfc.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public Rest<String> userUpdate(@RequestBody User user) {
        userService.userUpdate(user);
        return Rest.success("修改成功");
    }

    @GetMapping
    public Rest<User> userGet(HttpServletRequest request) {
        int id = (int) request.getSession().getAttribute("user");
        log.info("用户查询:{}",id);
        User user = userService.userGet(id);
        log.info("用户查询结果:{}",user);
        return Rest.success(user);
    }
}
