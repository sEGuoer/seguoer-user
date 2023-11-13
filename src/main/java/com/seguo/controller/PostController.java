package com.seguo.controller;


import com.seguo.dto.PostDto;
import com.seguo.entity.Post;
import com.seguo.exception.PostNotFoundException;
import com.seguo.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("blog/create")
    String create(Model model) {
        model.addAttribute("post", new Post());
        return "backend/blog/create";
    }
    @Value("${custom.upload.base-path}")
    String uploadBasePath;
    @Value("${custom.upload.post-cover-dir-under-base-path}")
    String postCoverDirUnderBasePath;
    @PostMapping("blog/create")
    String store(@RequestParam(value = "coverFile",required = false) MultipartFile file, @Valid @ModelAttribute("post") PostDto postDto,
                 BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return "backend/blog/create";
        }

        if (!(file == null) &&!file.isEmpty()) {
            File dir = new File(uploadBasePath + File.separator + postCoverDirUnderBasePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFilename = UUID.randomUUID() + suffix;
            file.transferTo(new File(dir.getAbsolutePath() + File.separator + newFilename));
            postDto.setCover(postCoverDirUnderBasePath + File.separator + newFilename);
        }

        postService.savePost(postDto);
        return "redirect:/admin/blogs";
    }

    @GetMapping("blog/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postService.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException();
        } else {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "backend/blog/edit";
        }
    }

    @PutMapping("blog/update")
    @PreAuthorize("#postDto.user_id == authentication.principal.user")
    String update(@Valid @ModelAttribute("post") PostDto postDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("post", postDto);
            return "backend/blog/edit";
        }

        postService.savePost(postDto);

        return "redirect:/admin/blogs";
    }
}
