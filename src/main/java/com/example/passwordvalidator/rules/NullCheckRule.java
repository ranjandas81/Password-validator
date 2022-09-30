package com.example.passwordvalidator.rules;

import com.example.passwordvalidator.exception.PasswordValidationException;

import java.util.function.Predicate;

import static com.example.passwordvalidator.constants.ValidationErrorMessageConstants.NULL_VALUE_INPUT_CHECK_ERROR;

public class NullCheckRule implements Predicate<String> {
    @Override
    public boolean test(String inputPassword) {
        if (inputPassword == null) {
            throw new PasswordValidationException(NULL_VALUE_INPUT_CHECK_ERROR);
        }
        return true;
    }
}
