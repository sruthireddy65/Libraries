package com.self.libraries.restxml.service;

import com.self.libraries.restxml.entity.Employee;
import com.self.libraries.restxml.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> employee= employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
