package com.seguo.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchValidator.class)
public @interface PasswordMatch {
    String password();
    String confirmPassword() ;
    String message() default "密码和确认密码不匹配";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
