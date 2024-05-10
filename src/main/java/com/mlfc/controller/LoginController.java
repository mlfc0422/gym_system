package com.mlfc.controller;

import com.mlfc.common.MyCustomException;
import com.mlfc.common.Rest;
import com.mlfc.entity.Root;
import com.mlfc.entity.User;
import com.mlfc.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/userRegister")
    public Rest<String> userRegister(@RequestBody User user) throws MyCustomException {
        log.info("用户注册:{}",user);
        loginService.userRegister(user);
        return Rest.success("注册成功");
    }

    @PostMapping("/userLogin")
    public Rest<String> userLogin(@RequestBody User user, HttpServletRequest request) {
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User user1 = loginService.userLogin(user.getUsername());
        log.info("用户登录:{}",user1);
        if (user1 == null) {
            return Rest.error("用户不存在");
        }else if (!user1.getPassword().equals(password)) {
            return Rest.error("密码错误");
        }
        System.out.println(user1.getId());
        request.getSession().setAttribute("user",user1.getId());
        return Rest.success("登录成功");
    }

    @PostMapping("/userLogout")
    public Rest<String> userLogout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return Rest.success("登出成功");
    }


    @PostMapping("/rootLogin")
    public Rest<String> rootLogin(@RequestBody Root root, HttpServletRequest request) {
        Root root1 = loginService.rootLogin(root.getUsername());
        if (root1 == null) {
            return Rest.error("用户不存在");
        }else if (!root1.getPassword().equals(root.getPassword())) {
            return Rest.error("密码错误");
        }
        System.out.println(root1.getId());
        request.getSession().setAttribute("root",root1.getId());
        return Rest.success("登录成功");
    }

    @PostMapping("/rootLogout")
    public Rest<String> rootLogout(HttpServletRequest request){
        request.getSession().removeAttribute("root");
        return Rest.success("登出成功");
    }
}
