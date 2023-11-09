package com.seguo.controller;


import com.seguo.WithMockUserForAdminBaseTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@WithUserDetails(userDetailsServiceBeanName = "jpaUserDetailsService", value = "admin@example.com")
class PostControllerTest extends WithMockUserForAdminBaseTest {

    @Test
    void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/blogs"))
                .andExpect(MockMvcResultMatchers.view().name("backend/blog/index"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Post 管理")))
        ;
    }
    @Test
    void create() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/blog/create"))
                .andExpect(MockMvcResultMatchers.view().name("backend/blog/create"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Create New Post")))
        ;
    }
}