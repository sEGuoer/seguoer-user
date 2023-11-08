package com.seguo.controller.advice;

import com.seguo.po.AdminPageContent;
import com.seguo.properties.AdminUseProperties;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ModelAttribute("requestURI")
    String getRequestServletPath(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @Autowired
    AdminUseProperties adminUseProperties;
    @ModelAttribute("menus")
    List<AdminPageContent> getAdminPageContent(){
        return adminUseProperties.getAdminPageContentList();
    }
}
