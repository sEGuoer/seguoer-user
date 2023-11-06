package com.seguo.service;

import com.seguo.entity.User;

public interface UserService {
    int addNewUser(String name, String email, String password);
    User findUserByEmail(String email);
}
