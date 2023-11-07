package com.seguo.service;



import com.seguo.entity.PasswordResetToken;
import org.springframework.transaction.annotation.Transactional;

public interface PasswordResetTokenService {
    PasswordResetToken findFirstByTokenOrderByIdDesc(String token);
    PasswordResetToken save(PasswordResetToken passwordResetToken);

    PasswordResetToken findByToken(String token);

    @Transactional
    int expireThisToken(String token);
}
