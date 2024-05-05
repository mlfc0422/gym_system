package com.mlfc.service;

import com.mlfc.entity.User;

public interface LoginService {
    void userRegister(User user);

    User userLogin(String username, String password);
}
