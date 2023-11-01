package com.seguo;

import com.seguo.properties.AdminUseProperties;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest extends  WithMockUserBaseTest{
    @Autowired
    MockMvc mvc;

    @Autowired
    AdminUseProperties adminUseProperties;

    @Test
    void dashboard() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/users"))
                .andExpect(MockMvcResultMatchers.view().name("backend/users"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("<li class=\"breadcrumb-item active\">Users</li>")))
        ;
    }


    @Test
    void testAtModelAttribute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/dashboard"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("menus"))
                .andExpect(MockMvcResultMatchers.model().attribute("menus", adminUseProperties.getAdminPageContentList()))
        ;
    }

}
