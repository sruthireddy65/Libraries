package com.self.libraries.rest.client.service;

import com.self.libraries.rest.client.model.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeClientService {

    private RestTemplate restTemplate = new RestTemplate();

    public void consumeGetEmployeeById(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Employee> employeeResponseEntity = restTemplate.exchange("http://localhost:8080/api/v1/employee/1",
                HttpMethod.GET, requestEntity, Employee.class);
        HttpStatus responseStatus = employeeResponseEntity.getStatusCode();
        System.out.println("response status : "+responseStatus);
        Employee employee = employeeResponseEntity.getBody();
        System.out.println("Employee : "+employee);
    }

    public void consumeGetAllEmployees(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<Employee>> employeeResponseEntity = restTemplate.exchange("http://localhost:8080/api/v1/employees", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Employee>>() {});
        System.out.println("employee list "+ employeeResponseEntity.getBody());
        List<Employee> employees = employeeResponseEntity.getBody();
        System.out.println("status code "+ employeeResponseEntity.getStatusCode());
    }

    public void consumePostEmployee(){
        Employee employee = new Employee(0, "emp3", new BigDecimal("30000"));
        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<>(employee, headers);
        ResponseEntity<Employee> responseEntity = restTemplate.exchange("http://localhost:8080/api/v1/employees",
                HttpMethod.POST, employeeHttpEntity, Employee.class);
        System.out.println("employee : "+responseEntity.getBody());
        System.out.println("headers : "+responseEntity.getHeaders());
        System.out.println("status : "+responseEntity.getStatusCode());
    }
}
