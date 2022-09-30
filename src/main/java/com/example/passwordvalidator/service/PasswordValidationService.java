package com.example.passwordvalidator.service;

import com.example.passwordvalidator.rules.LowerCaseCharCheckRule;
import com.example.passwordvalidator.rules.NullCheckRule;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasswordValidationService implements PasswordValidation{

    private final NullCheckRule nullCheckRule;
    private final LowerCaseCharCheckRule lowerCaseCharCheckRule;

    @Override
    public boolean validatePassword(String inputPassword) {
        boolean isValidPassword = true;
        if (nullCheckRule.and(lowerCaseCharCheckRule).test(inputPassword)) {
            //check other rules
        }
        return isValidPassword;
    }
}
