package com.example.passwordvalidator.config;

import com.example.passwordvalidator.service.PasswordValidationService;
import com.example.passwordvalidator.rules.LowerCaseCharCheckRule;
import com.example.passwordvalidator.rules.NullCheckRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class PasswordValidatorConfig {

    @Bean
    @Lazy
    public NullCheckRule nullCheckRule(){
        return new NullCheckRule();
    }

    @Bean
    @Lazy
    public LowerCaseCharCheckRule lowerCaseCharCheckRule() {
        return new LowerCaseCharCheckRule();
    }

    @Bean
    public PasswordValidationService passwordValidationService( NullCheckRule nullCheckRule, LowerCaseCharCheckRule lowerCaseCharCheckRule) {
        return new PasswordValidationService(nullCheckRule, lowerCaseCharCheckRule);
    }

}
