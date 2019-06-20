package com.sofiia;

import com.google.gson.Gson;
import com.sofia.Main;
import com.sofia.service.HistoryBO;
import com.sofia.dto.MathOperation;
import com.sofia.dto.OperationType;
import com.sofia.util.date.Converter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
@WebMvcTest
public class HistoryTest {

    @Autowired
    private MockMvc mockMvc;

    private HistoryBO history;

    @Before
    public void sendRequests() throws Exception {
        MathOperation operation = new MathOperation(1.2, 4, OperationType.ADD);
        double result = 5.2;

        this.history = new HistoryBO();

        history.addRecord(operation, result);
        Gson converter = Converter.getConverter();


        this.mockMvc.perform(post("/math")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(converter.toJson(operation)));
    }

    @Test
    public void getHistory() throws Exception {
        Gson converter = Converter.getConverter();

        this.mockMvc.perform(get("/history"))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.toJson(this.history)));
    }
}

