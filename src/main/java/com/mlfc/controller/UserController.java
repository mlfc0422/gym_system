package com.mlfc.controller;

import com.mlfc.common.Rest;
import com.mlfc.entity.User;
import com.mlfc.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Rest<String> register(@RequestBody User user) {
        userService.register(user);
        return Rest.success("注册成功");
    }

    @PostMapping("/login")
    public Rest<String> login(@RequestBody User user, HttpServletRequest request) {
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User user1 = userService.login(user.getUsername(), password);
        if (user1 == null) {
            return Rest.error("用户不存在");
        }else if (!user1.getPassword().equals(password)) {
            return Rest.error("密码错误");
        }
        System.out.println(user1.getId());
        request.getSession().setAttribute("user",user1.getId());
        return Rest.success("登录成功");
    }

    @PostMapping("/logout")
    public Rest<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return Rest.success("登出成功");
    }
}
