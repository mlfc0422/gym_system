package com.mlfc.service;


import com.mlfc.entity.User;

import java.util.List;

public interface UserService {

    void userUpdate(User user);

    User userGet(int id);

    List<User> list();

    void delete(long[] ids);
}
