package com.example.passwordvalidator.service;

import com.example.passwordvalidator.exception.PasswordValidationException;
import com.example.passwordvalidator.rules.*;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.example.passwordvalidator.constants.ValidationErrorMessageConstants.PASSWORD_SHOULD_CONTAIN_ERROR_FORMAT;

@RequiredArgsConstructor
public class PasswordValidationService implements PasswordValidation{

    private final NullCheckRule nullCheckRule;
    private final LowerCaseCharCheckRule lowerCaseCharCheckRule;

    private final DigitCheckRule digitCheckRule;
    private final NumberOfCharCheckRule numberOfCharCheckRule;
    private final UpperCaseCharCheckRule upperCaseCharCheckRule;

    @Override
    public boolean validatePassword(String inputPassword) {
        boolean isValidPassword = true;
        if (nullCheckRule.and(lowerCaseCharCheckRule).test(inputPassword)) {
            //check other rules
            CompletableFuture upperCaseFuture = CompletableFuture.supplyAsync(() -> upperCaseCharCheckRule.test(inputPassword));
            CompletableFuture digitCheckRuleFuture = CompletableFuture.supplyAsync(() -> digitCheckRule.test(inputPassword));
            CompletableFuture numberOfCharCheckRuleFuture = CompletableFuture.supplyAsync(() -> numberOfCharCheckRule.test(inputPassword));

            CompletableFuture allTest = CompletableFuture.allOf(upperCaseFuture, digitCheckRuleFuture, numberOfCharCheckRuleFuture);
            boolean containsUpperCaseLetter = false;
            boolean containsDigit = false;
            boolean containsRequiredNumberOfChar = false;
            try {
                allTest.get(1000, TimeUnit.MILLISECONDS);
                containsUpperCaseLetter = (boolean) upperCaseFuture.get();
                containsDigit = (boolean) digitCheckRuleFuture.get();
                containsRequiredNumberOfChar = (boolean) numberOfCharCheckRuleFuture.get();
            } catch (Exception e) {
                isValidPassword = false;
            }

            if (!containsUpperCaseLetter && !containsDigit && !containsRequiredNumberOfChar) {
                throw new PasswordValidationException(PASSWORD_SHOULD_CONTAIN_ERROR_FORMAT);
            }
        }
        return isValidPassword;
    }
}
