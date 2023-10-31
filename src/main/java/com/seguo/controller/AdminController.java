package com.seguo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @GetMapping("dashboard")
    String index() {
        return "backend/dashboard";
    }
    @GetMapping("users")
    String login() {
        return "backend/users";
    }
}
