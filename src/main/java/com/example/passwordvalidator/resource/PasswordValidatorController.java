package com.example.passwordvalidator.resource;

import com.example.passwordvalidator.exception.PasswordValidationException;
import com.example.passwordvalidator.service.PasswordValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.passwordvalidator.constants.ValidationErrorMessageConstants.SUCCESSFUL_VALIDATION_MSG;
import static com.example.passwordvalidator.constants.ValidationErrorMessageConstants.VALIDATION_FAILED_MSG;

@RestController
@RequiredArgsConstructor
public class PasswordValidatorController {

    private final PasswordValidationService passwordValidationService;
    @PostMapping(value = "validate", produces = {"application/json"})
    public ResponseEntity<String> validatePassword(@RequestParam(name = "inputStr", required = true) String inputStr) {
        if (!passwordValidationService.validatePassword(inputStr != null ? inputStr.replaceAll("^\"|\"$", ""): null)) {
            throw new PasswordValidationException(VALIDATION_FAILED_MSG);
        }
        return new ResponseEntity<>(SUCCESSFUL_VALIDATION_MSG, HttpStatus.OK);
    }
}
