package com.seguo.repository;

import com.seguo.entity.User;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MockMvc mvc;
    @Test
    void findUserByName() {
        User user = new User();
        String userName = "test";
        user.setName(userName);
        user.setPassword(passwordEncoder.encode("password"));
        user.setEmail(userName + "@example.com");
        user.setPhone("18888888888");
        user.setCreatedAt(LocalDateTime.now());
        user.setEnabled(true);
        userRepository.save(user);

        Optional<User> optionalUser = userRepository.findFirstByName(userName);
        Assertions.assertTrue(optionalUser.isPresent());
        userRepository.delete(user);
        Assertions.assertFalse(userRepository.findAll().contains(user));
    }

    @Test
    @DisplayName("找回页面是否正常显示")
    void getPasswordRestPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/password-reset"))
                .andExpect(MockMvcResultMatchers.content().string(StringContains.containsString("发送重置密码链接")))
        ;

    }

    @Test
    @DisplayName("输入一个数据库中没有的邮箱看结果是否符合预期")
    void postPasswordRestWithNonExistentEmail() throws Exception {
        String randomStr = UUID.randomUUID().toString().substring(0, 6);
        mvc.perform(MockMvcRequestBuilders.post("/user/password-reset")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", randomStr + "@example.com")
                )
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode("passwordResetEmail", "email", "non-existent"))
        ;
    }

    @Test
    @DisplayName("输入一个数据库中有的邮箱看结果是否可以发送邮件")
    void postPasswordRestWithExistEmail() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/user/password-reset")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "admin@example.com")
                )
                .andExpect(MockMvcResultMatchers.flash().attribute("success", "密码重置邮件已发送，请注意查收"))
        ;
    }
}
