package com.mlfc.service;

import com.mlfc.common.Rest;
import com.mlfc.entity.User;

public interface UserService {
    void register(User user);

    User login(String username, String password);
}
