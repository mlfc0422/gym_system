package com.mlfc.service;

import com.mlfc.common.Rest;
import com.mlfc.entity.Root;
import com.mlfc.entity.User;

public interface LoginService {
    void userRegister(User user);

    User userLogin(String username);

    Root rootLogin(String username);
}
