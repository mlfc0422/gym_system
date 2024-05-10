package com.mlfc.service.Impl;

import com.mlfc.common.MyCustomException;
import com.mlfc.common.Rest;
import com.mlfc.entity.Root;
import com.mlfc.entity.User;
import com.mlfc.mapper.RootMapper;
import com.mlfc.mapper.UserMapper;
import com.mlfc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RootMapper rootMapper;

    @Override
    public void userRegister(User user) throws MyCustomException {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        if (userMapper.findByUsername(user.getUsername()) != null) {
            throw new MyCustomException("用户名已存在");
        }
        userMapper.register(user);
    }

    @Override
    public User userLogin(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public Root rootLogin(String username) {
        Root root = rootMapper.findByUsername(username);
        return root;
    }
}
