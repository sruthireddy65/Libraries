package com.self.testlibraries.step2.mvc.controller;

import com.self.testlibraries.step2.mvc.model.Employee;
import com.self.testlibraries.step2.mvc.service.EmployeeService;
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

import java.util.Arrays;

import static org.mockito.Mockito.when;

/**
 * This is to test Controller by using autoconfigured MockMvc instance.
 *
 * Spring boot offers support to test different layers of an application which is also called testing with sliced spring context.
 * Here only required beans are loaded into spring context and only specific autoconfigurations are done.
 * To test controllers using sliced spring context support, @WebMvcTest annotation is used where it only loads MVC components to
 * the context and other components like @Service,@Repository,@Component etc were not loaded.
 * @WebMvcTest provides Mocked servlet environment, so application won't be running on any port. Hence RestTemplate or WebClient
 * cannot be used to access the application. Autocofigured MockMvc is used to access the endpoints in Mocked servlet environment
 *
 * @Mock annotation is used to mock a bean whereas @MockBean is used to mock and inject bean to spring context
 * Mockmvc can be autowired or can be created as per our requirement
 */
@WebMvcTest(EmployeeController.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerStandardTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployees() throws Exception {
        when(employeeService.getEmployees()).thenReturn(Arrays.asList(new Employee("emp1"), new Employee("emp2")));
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("emp1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("emp2"));
    }

    @Test
    public void testPostEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"emp1\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
