package com.mlfc.controller;

import com.mlfc.entity.Result;
import com.mlfc.entity.User;
import com.mlfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        userService.addUser(user);
        return Result.success("添加成功");
    }

    @PostMapping("/login")
    public Result selectUser(@RequestBody User user) {
        userService.selectUser(user);
        return Result.success("登录成功");
    }

}
