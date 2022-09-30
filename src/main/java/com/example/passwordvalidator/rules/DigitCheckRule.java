package com.example.passwordvalidator.rules;

import java.util.function.Predicate;

public class DigitCheckRule implements Predicate<String> {
    @Override
    public boolean test(String inputPassword) {
        boolean digitCaseFlag = false;
        char ch;

        for (int i = 0; i < inputPassword.length(); i++) {
            ch = inputPassword.charAt(i);
            if (Character.isDigit(ch)) {
                digitCaseFlag = true;
                break;
            }
        }
        return digitCaseFlag;
    }
}
