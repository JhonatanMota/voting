package com.test.corp.voting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.corp.voting.repository.AgendaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AgendaControllerTest {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    AgendaRepository agendaRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        agendaRepository.deleteAll();
        om.setDateFormat(simpleDateFormat);
    }

    @Test
    public  void testAgendaEndpointWithGETList() throws Exception{
//        String actualRecords = mockMvc.perform(get("/api/v1/agenda"))
//                .andDo(print())
//                .andExpect(status().isOk());

        String actualRecords = om.readValue(mockMvc.perform(get("/api/v1/agenda"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().toString(), new TypeReference<String>() {
        });

        Assertions.assertEquals("Hi, we had a agenda.",actualRecords);
    }


}
