package com.seguo.service;

import com.seguo.dto.UserDto;
import com.seguo.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    int addNewUser(String name, String email, String password);
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    void updatePassword(User user);
    Page<User> findAll(int pageNumber, int pageSize);
}
