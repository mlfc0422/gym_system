package com.mlfc.service.Impl;

import com.mlfc.entity.User;
import com.mlfc.mapper.UserMapper;
import com.mlfc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
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

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public void delete(long[] ids) {
        userMapper.delete(ids);
    }
}
