package com.self.libraries.restxml.controller;

import com.self.libraries.restxml.entity.Employee;
import com.self.libraries.restxml.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/employee/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        try{
            Employee employee = employeeService.getEmployeeById(id);
            if(employee != null){
                return ResponseEntity.ok(employee);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Employee>> getAllEmployeesRE(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping(value = "/employees", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                 consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        employee =  employeeService.saveEmployee(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(employee);
    }
}
