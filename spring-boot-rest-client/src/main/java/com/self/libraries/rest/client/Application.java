package com.self.libraries.rest.client;

import com.self.libraries.rest.client.service.EmployeeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EmployeeClientService employeeClientService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeClientService.consumeGetEmployeeById(1);
        employeeClientService.consumeGetAllEmployees();
        employeeClientService.consumePostEmployee();
    }
}
