package com.mlfc.service;


import com.mlfc.entity.User;

public interface UserService {

    void userUpdate(User user);

    User userGet(int id);
}
