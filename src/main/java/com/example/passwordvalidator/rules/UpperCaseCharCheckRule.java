package com.example.passwordvalidator.rules;

import java.util.function.Predicate;

public class UpperCaseCharCheckRule implements Predicate<String> {
    @Override
    public boolean test(String inputPassword) {
        boolean upperCaseFlag = false;
        char ch;

        for(int i=0;i < inputPassword.length();i++) {
            ch = inputPassword.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
                break;
            }
        }

        return upperCaseFlag;
    }
}
