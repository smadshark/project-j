package com.sonbro.projectj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {
    private final String url = "/quiz";
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @DisplayName("quiz(): GET /quiz?code=1 status:201, response body: Created!")
    @Test
    public void getQuiz1() throws Exception {
        // when
        ResultActions result = mockMvc.perform(get(url).param("code", "1"));

        // then
        result.andExpect(status().isCreated())
                .andExpect(content().string("Created!"));
    }

    @DisplayName("quiz(): GET /quiz?code=2 status:400, response body: Bad Request!")
    @Test
    public void getQuiz2() throws Exception {
        // when
        ResultActions result = mockMvc.perform(get(url).param("code", "2"));

        // then
        result.andExpect(status().isBadRequest())
                .andExpect(content().string("Bad Request!"));
    }

    @DisplayName("quiz(): POST /quiz?code=1 status:403, response body: Forbidden!")
    @Test
    public void postQuiz1() throws Exception {
        // given
        Code code = new Code(1);
        String requestBody = toJson(code);

        ResultActions result = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(requestBody));

        result.andExpect(status().isForbidden())
                .andExpect(content().string("Forbidden!"));
    }

    @DisplayName("quiz(): POST /quiz?code=13 status:200, response body: OK!")
    @Test
    public void postQuiz2() throws Exception {
        // given
        Code code = new Code(13);
        String requestBody = toJson(code);

        ResultActions result = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(requestBody));

        result.andExpect(status().isOk())
                .andExpect(content().string("OK!"));
    }

    private String toJson(Code data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }

    record Code(int value) {
    }
}