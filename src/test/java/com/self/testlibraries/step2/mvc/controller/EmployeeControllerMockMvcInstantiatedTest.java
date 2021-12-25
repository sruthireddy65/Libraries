package com.self.testlibraries.step2.mvc.controller;

import com.self.testlibraries.step2.mvc.model.Employee;
import com.self.testlibraries.step2.mvc.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerMockMvcInstantiatedTest {

    @Autowired
    private EmployeeController employeeController;

    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    private void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController)
                .build();

//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetEmployees() throws Exception {
        when(employeeService.getEmployees()).thenReturn(Arrays.asList(new Employee("emp1"), new Employee("emp2")));
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("emp1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("emp2"));
    }
}
