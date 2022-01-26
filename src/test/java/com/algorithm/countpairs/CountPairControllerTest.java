package com.algorithm.countpairs;

import com.algorithm.countpairs.controller.CountPairController;
import com.algorithm.countpairs.service.CountPairService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CountPairControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CountPairController(new CountPairService())).build();
    }

    @Test
    public void getCountPairsByTwoLoop() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/count-pairs/by-two-loop")
                .queryParam("inputArray", "1, 1, 3, 0, 2")
                .queryParam("sum", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getCountPairsByMap() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/count-pairs/by-map")
                .queryParam("inputArray", "1, 1, 3, 0, 2")
                .queryParam("sum", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getCountPairsByTwoPointersInSortedArray() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/count-pairs/by-pointers")
                .queryParam("inputSortedArray", "0, 1, 1, 2, 3")
                .queryParam("sum", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
