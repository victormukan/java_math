package com.sofiia;

import com.sofia.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Main.class)
@WebMvcTest
public class EmptyHistoryTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmptyHistory() throws Exception{
        this.mockMvc.perform(get("/history?limit=40s"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
