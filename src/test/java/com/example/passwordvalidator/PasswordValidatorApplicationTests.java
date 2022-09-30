package com.example.passwordvalidator;

import com.example.passwordvalidator.resource.service.PasswordValidationService;
import org.junit.jupiter.api.Test;
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
    void testAPi() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
