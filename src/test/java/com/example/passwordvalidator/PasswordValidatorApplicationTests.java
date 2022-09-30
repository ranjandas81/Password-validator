package com.example.passwordvalidator;

import com.example.passwordvalidator.service.PasswordValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.example.passwordvalidator.constants.ValidationErrorMessageConstants.PASSWORD_SHOULD_CONTAIN_LOWERCASE_LETTER;
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
    void password_validator_successful() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "abcDsT3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void password_validator_successful_1() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "ab9")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void password_validator_successful_2() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "gtdryweq")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void password_validator_successful_4() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "TTUQa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
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

    @Test
    void password_validator_missing_required_number_1() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "aa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());

    }

    @Test
    void password_validator_missing_required_number_2() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "aa     ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());

    }

    @Test
    void password_validator_missing_required_number_3() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/validate").param("inputStr", "aasssss")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());

    }
}
