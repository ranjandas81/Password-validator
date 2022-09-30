package com.example.passwordvalidator.config;

import com.example.passwordvalidator.resource.service.PasswordValidation;
import com.example.passwordvalidator.resource.service.PasswordValidationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordValidatorConfig {

    @Bean
    public PasswordValidationService passwordValidationService() {
        return new PasswordValidationService();
    }

}
