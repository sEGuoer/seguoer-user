package com.seguo;
import org.springframework.security.test.context.support.WithMockUser;

@WithMockUser(username = "admin", password = "password", roles = {"admin"})
public class WithMockUserBaseTest {
}
