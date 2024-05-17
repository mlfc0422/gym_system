package com.mlfc.service.Impl;

import com.mlfc.entity.User;
import com.mlfc.mapper.UserMapper;
import com.mlfc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void userUpdate(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public User userGet(int id) {
        return userMapper.findById(id);
    }
}
