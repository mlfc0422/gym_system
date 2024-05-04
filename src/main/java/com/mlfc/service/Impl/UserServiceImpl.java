package com.mlfc.service.Impl;

import com.mlfc.entity.User;
import com.mlfc.mapper.UserMapper;
import com.mlfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.addUser(user);
    }

    @Override
    public void selectUser(User user) {
        userMapper.selectUser(user);
    }
}
