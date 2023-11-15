package com.seguo;

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
public class ResourceTest {
    @Autowired
    MockMvc mvc;
    @Test
    void resources() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/resources"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("page"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("<a class=\"btn btn-primary transition-3d-hover\" href=\"#\">查看详情</a>")))
        ;
    }
}
