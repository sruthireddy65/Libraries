package com.self.testlibraries.step2.mvc.repository;

import com.self.testlibraries.step2.mvc.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * To test repository layer @DataJpaTest annotation is used. It created sliced spring
 * context with @Repository, @Entity, @EntityManager, @DataSource etc annotations.
 *  @ Controller, @Component and @Service are not configured.
 * Embedded database available in the classpath is configured.
 */
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee(){
        Employee employee = new Employee("emp1");
        employeeRepository.save(employee);
        assertTrue(employee.getId() > 0);
    }
}