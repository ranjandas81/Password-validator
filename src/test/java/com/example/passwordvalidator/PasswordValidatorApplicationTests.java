package com.example.passwordvalidator;

import com.example.passwordvalidator.resource.service.PasswordValidationService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PasswordValidatorApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PasswordValidationService passwordValidationService;

    @Test
    void contextLoads() {
    }

    @Test
    void password_validator_missing_param() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }


    @Test
    void password_validator_mandatory_field_missing() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "TT")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }



}
