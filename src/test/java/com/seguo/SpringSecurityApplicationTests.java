package com.seguo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {
    @Value("${spring.application.name}")
    private String msg;

    @Test
    void contextLoads() {
        Assertions.assertEquals("lms",msg);
    }

}
