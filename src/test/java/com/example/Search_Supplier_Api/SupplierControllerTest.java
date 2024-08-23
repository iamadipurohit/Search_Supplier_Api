package com.example.Search_Supplier_Api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenValidInput_thenReturns200() throws Exception {
        mockMvc.perform(get("/api/supplier/query")
                        .param("location", "India")
                        .param("natureOfBusiness", "small_scale")
                        .param("process", "3d_printing")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenLocationIsMissing_thenReturns400() throws Exception {
        mockMvc.perform(get("/api/supplier/query")
                        .param("natureOfBusiness", "small_scale")
                        .param("process", "3d_printing"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenNatureOfBusinessIsInvalid_thenReturns400() throws Exception {
        mockMvc.perform(get("/api/supplier/query")
                        .param("location", "India")
                        .param("natureOfBusiness", "invalid_scale")
                        .param("process", "3d_printing"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenProcessIsInvalid_thenReturns400() throws Exception {
        mockMvc.perform(get("/api/supplier/query")
                        .param("location", "India")
                        .param("natureOfBusiness", "small_scale")
                        .param("process", "invalid_process"))
                .andExpect(status().isBadRequest());
    }

    // Additional test cases can be added here
}
