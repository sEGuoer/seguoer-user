package com.seguo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityApplicationTests {
    @Value("${spring.application.name}")
    private String msg;
    @Autowired
    MockMvc mvc;
    @Test
    void contextLoads() {
        Assertions.assertEquals("lms",msg);
    }
    @Test
    void login() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.view().name("login"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("登录")))
        ;
    }
    @Test
    void loginCheckedRememberMe() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "user")
                        .param("password", "password")
                        .param("remember-me", "on")
                )
                .andExpect(MockMvcResultMatchers.cookie().exists("remember-me"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login?error"))
        ;
    }
}
