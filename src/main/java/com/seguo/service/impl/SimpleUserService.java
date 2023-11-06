package com.seguo.service.impl;

import com.seguo.entity.User;
import com.seguo.repository.UserRepository;
import com.seguo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SimpleUserService implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public int addNewUser(String name, String email, String password) {
        if (userRepository.findFirstByEmail(email).isEmpty()) {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setEnabled(true);
            user.setCreatedAt(LocalDateTime.now());

            userRepository.save(user);
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findFirstByEmail(email).orElse(null);
    }
}
