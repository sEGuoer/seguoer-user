package com.seguo.controller;


import com.seguo.entity.Post;
import com.seguo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("blogs")
    String index(Model model,
                 @RequestParam("page") Optional<Integer> page,
                 @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> pageContent = postService.findAll(currentPage, pageSize);
        model.addAttribute("page", pageContent);
        return "backend/blog/index";
    }
}
