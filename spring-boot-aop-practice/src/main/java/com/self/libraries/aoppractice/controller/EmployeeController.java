package com.self.libraries.aoppractice.controller;

import com.self.libraries.aoppractice.entities.Employee;
import com.self.libraries.aoppractice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }
}
