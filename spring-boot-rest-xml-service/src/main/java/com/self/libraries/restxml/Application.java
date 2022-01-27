package com.self.libraries.restxml;

import com.self.libraries.restxml.config.DummyProperties;
import com.self.libraries.restxml.entity.Employee;
import com.self.libraries.restxml.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private DummyProperties dummyProperties;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee("emp1", new BigDecimal("1000")));
        employeeRepository.save(new Employee("emp2", new BigDecimal("2000")));
//        System.out.println(dummyProperties.getProp1());
    }
}
