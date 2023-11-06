package com.seguo.controller;

import com.seguo.dto.PasswordResetEmailDto;
import com.seguo.entity.User;
import com.seguo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("password-reset")
    String showPasswordRestForm(Model model) {
        PasswordResetEmailDto passwordResetEmailDto = new PasswordResetEmailDto();
        model.addAttribute("passwordResetEmail", passwordResetEmailDto);
        return "user/forget";
    }

    @PostMapping("password-reset")
    String passwordReset(@Valid @ModelAttribute("passwordResetEmail") PasswordResetEmailDto passwordResetEmailDto,
                         BindingResult result,
                         Model model,
                         RedirectAttributes attributes) {
        User existingUser = userService.findUserByEmail(passwordResetEmailDto.getEmail());
        if(existingUser == null){
            result.rejectValue("email", "non-existent", "找不到该邮箱对应的用户信息");
        }

        if(result.hasErrors()){
            model.addAttribute("passwordResetEmail", passwordResetEmailDto);
            return "user/forget";
        }

        // todo: send email

        attributes.addFlashAttribute("success", "密码重置邮件已发送，请注意查收");
        return "redirect:/user/password-reset";
    }
}
