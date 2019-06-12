package com.sofiia;

import com.google.gson.Gson;
import com.sofia.Main;
import com.sofia.model.MathOperation;
import com.sofia.model.MathOperationResult;
import com.sofia.model.OperationType;
import com.sofia.util.Converter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Main.class)
@WebMvcTest
public class MathOperationsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdd() throws Exception{
        MathOperation operation = new MathOperation(1.2, 4, OperationType.ADD);
        MathOperationResult result = new MathOperationResult(5.2);

        Gson converter = Converter.getConverter();
        this.mockMvc.perform(post("/math")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(converter.toJson(operation)))
                .andExpect(status().isOk())
                .andExpect(content().json(converter.toJson(result)));

    }

}

