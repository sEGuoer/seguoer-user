package com.seguo.controller;

import com.seguo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    @ResponseBody
    String addUser(String name, String email, String password) {
            int result = userService.addNewUser(name, email, password);
            if (result == 1){
                return "用户添加成功";
            }else {
                return "用户添加失败请返回重试";
            }
    }
    @GetMapping("dashboard")
    String dashboard() {
        return "user/dashboard";
    }
}
