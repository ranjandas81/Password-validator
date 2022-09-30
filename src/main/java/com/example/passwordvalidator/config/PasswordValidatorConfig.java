package com.example.passwordvalidator.config;

import com.example.passwordvalidator.rules.*;
import com.example.passwordvalidator.service.PasswordValidationService;
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
    @Lazy
    public DigitCheckRule digitCheckRule() {
        return new DigitCheckRule();
    }

    @Bean
    @Lazy
    public UpperCaseCharCheckRule upperCaseCharCheckRule() {
        return new UpperCaseCharCheckRule();
    }

    @Bean
    @Lazy
    public NumberOfCharCheckRule numberOfCharCheckRule() {
        return  new NumberOfCharCheckRule();
    }

    @Bean
    public PasswordValidationService passwordValidationService( NullCheckRule nullCheckRule,
                                                                LowerCaseCharCheckRule lowerCaseCharCheckRule,
                                                                DigitCheckRule digitCheckRule, NumberOfCharCheckRule numberOfCharCheckRule,
                                                                UpperCaseCharCheckRule upperCaseCharCheckRule) {
        return new PasswordValidationService(nullCheckRule, lowerCaseCharCheckRule,
                digitCheckRule, numberOfCharCheckRule(), upperCaseCharCheckRule());
    }

}
