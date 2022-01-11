package com.self.libraries.restxml.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.self.libraries.restxml.entity.Employee;
import com.self.libraries.restxml.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@WebMvcTest(EmployeeController.class)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeesJson() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(new Employee("emp1", new BigDecimal("1000"))));
         mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("emp1")))
                 .andExpect(MockMvcResultMatchers.jsonPath("$[0].salary", Matchers.is(1000)));
    }

    @Test
    public void testGetEmployeesXml() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(new Employee("emp2", new BigDecimal("2000"))));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees")
                        .accept(MediaType.APPLICATION_XML_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().xml("<List><item><id>0</id><name>emp2</name><salary>2000</salary></item></List>"));
    }

    @Test
    public void testPostEmployeeJson() throws Exception {
        Employee employee = new Employee("emp1", new BigDecimal("2000"));
        when(employeeService.saveEmployee(employee)).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employees")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(employee)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json("{\"name\":\"emp1\",\"id\":0,\"salary\":2000}"));
    }

    @Test
    public void testPostEmployeeXml() throws Exception {
        Employee employee = new Employee("emp1", new BigDecimal("5000"));
        when(employeeService.saveEmployee(employee)).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employees")
                .accept(MediaType.APPLICATION_XML_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(new XmlMapper().writeValueAsString(employee)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().xml("<Employee><id>0</id><name>emp1</name><salary>5000</salary></Employee>"));
    }
}