package com.seguo.dto;

import com.seguo.annotation.PasswordMatch;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatch(password = "password",
        confirmPassword ="confirmPassword",
        message = "两次输入的密码不同")
public class PasswordResetDto {
    @NotEmpty
    @Size(min = 6, max = 20)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 20)
    private String confirmPassword;

    @NotEmpty
    private String token;
}
