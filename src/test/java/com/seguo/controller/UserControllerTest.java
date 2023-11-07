package com.seguo.controller;

import com.seguo.po.AdminPageContent;
import com.seguo.properties.AdminUseProperties;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", roles = {"admin"})
public class UserControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    AdminUseProperties adminUseProperties;

    @Test
    void users() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/users"))
                .andExpect(MockMvcResultMatchers.view().name("backend/user/index"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("用户管理")))
        ;
    }
}
