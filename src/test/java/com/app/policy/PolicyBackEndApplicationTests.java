package com.app.policy;

import com.app.policy.common.Constants;
import com.app.policy.dto.InsuredDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Log4j2
class PolicyBackEndApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    Gson gson;

    InsuredDto insuredDto = new InsuredDto(14234521, "Bob", "Benic");


    @Test
    void contextLoads() {
        assertNotNull(mockMvc);
    }

    @Test
    @Order(1)
    void postInsured() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.post(Constants.INSURED_API.MAIN)
                        .content(asJsonString(insuredDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.insuredId").isNumber())
                .andReturn().getResponse().getContentAsString();
        InsuredDto insuredDtoResponse = gson.fromJson(response, InsuredDto.class);
        assertTrue(insuredDtoResponse.equals(insuredDto));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
