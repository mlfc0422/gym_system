package com.mlfc.service.Impl;

import com.mlfc.common.Rest;
import com.mlfc.entity.User;
import com.mlfc.mapper.UserMapper;
import com.mlfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.register(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        return user;
    }


}
