package com.example.passwordvalidator.rules;

import java.util.function.Predicate;

public class NumberOfCharCheckRule implements Predicate<String> {
    private static final int PASSWORD_MIN_LENGTH = 8;
    @Override
    public boolean test(String inputPassword) {
        if (inputPassword.length() < PASSWORD_MIN_LENGTH) {
            return false;
        }
        return true;
    }
}
