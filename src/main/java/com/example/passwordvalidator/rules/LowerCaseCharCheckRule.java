package com.example.passwordvalidator.rules;

import com.example.passwordvalidator.exception.PasswordValidationException;

import java.util.function.Predicate;

import static com.example.passwordvalidator.constants.ValidationErrorMessageConstants.PASSWORD_SHOULD_CONTAIN_LOWERCASE_LETTER;

public class LowerCaseCharCheckRule implements Predicate<String> {
    @Override
    public boolean test(String inputPassword) {
        boolean lowerCaseFlag = false;
        char ch;
        for(int i=0;i < inputPassword.length();i++) {
            ch = inputPassword.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
                break;
            }
        }
        if (!lowerCaseFlag){
            throw new PasswordValidationException(PASSWORD_SHOULD_CONTAIN_LOWERCASE_LETTER);
        }
        return true;
    }
}
