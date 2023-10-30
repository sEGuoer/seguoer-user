package com.seguo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homepageController {
    @GetMapping("index")
    String index() {
        return "index";
    }

}
