package com.example.passwordvalidator.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordValidatorController {

    @PostMapping(value = "validate", produces = {"application/json"})
    public ResponseEntity<String> validatePassword(@RequestParam(name = "inputStr", required = true) String inputStr) {
        return new ResponseEntity<>("SUCCESSFUL_VALIDATION_MSG", HttpStatus.OK);
    }
}
