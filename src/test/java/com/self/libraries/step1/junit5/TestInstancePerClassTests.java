package com.self.libraries.step1.junit5;

import org.junit.jupiter.api.*;

/**
 * For per class test instance beforeAll and afterAll are called after creation of test
 * instance. so those are instance methods.
 * BeforeEach and AfterEach are called before and after each test method, but unlike per method
 * test instance these are called on same test instance as only only instance is created
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstancePerClassTests {

    public TestInstancePerClassTests() {
        System.out.println("constructor called");
    }

    @BeforeAll
    public void beforeAll(){
        System.out.println("BeforeAll called");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before each");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After each");
    }

    @AfterAll
    public void afterAll(){
        System.out.println("After all");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
}
