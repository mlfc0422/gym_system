package com.mlfc.controller;

import com.mlfc.common.Rest;
import com.mlfc.entity.User;
import com.mlfc.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/list")
    public Rest<List<User>> list() {
        List<User> list = userService.list();
        log.info("用户列表查询结果:{}", list);
        return Rest.success(list);
    }

    @DeleteMapping
    public Rest<String> userDelete(@RequestBody long[] ids) {
        log.info("删除用户:{}", Arrays.toString(ids));
        userService.delete(ids);
        return Rest.success("删除成功");
    }
}
