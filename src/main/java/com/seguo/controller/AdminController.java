package com.seguo.controller;

import com.seguo.po.AdminPageContent;
import com.seguo.properties.AdminUseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminUseProperties adminUseProperties;
    @ModelAttribute("menus")
    List<AdminPageContent> getAdminPageContent(){
        return adminUseProperties.getAdminPageContentList();
    }
    @GetMapping("dashboard")
    String index() {
        System.out.println(adminUseProperties.getAdminPageContentList().toString());
        return "backend/dashboard";
    }
    @GetMapping("users")
    String login() {
        return "backend/users";
    }
}
