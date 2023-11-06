package com.seguo.controller;

import com.seguo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {
    @Autowired
    UserService userService;
    @PostMapping("/users")
    @ResponseBody
    String addUser(String name, String email, String password) {
            int result = userService.addNewUser(name, email, password);
            if (result == 1){
                return "用户添加成功";
            }else {
                return "用户添加失败请返回重试";
            }
    }
}
