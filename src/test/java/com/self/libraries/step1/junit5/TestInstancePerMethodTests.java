package com.self.libraries.step1.junit5;

import org.junit.jupiter.api.*;

/**
 * @TestInstance annotation is used to define lifecycle of class in which testcases are written.
 * For example, 3 tests i.e. 3 methods with @Test annotation were written in class TestA.
 * Then a new instance of TestA is created for each method. This is default behavior and this
 * can be achieved using @TestInstance(Lifecycle.PER_METHOD).
 * If an instance has to be created only once then use @TestInstance(Lifecyle.PER_CLASS)
 * BeforeAll and AfterAll methods have to be static if test instance per method is used.
 * Lifecycle hooks are executed in following order
 * BeforeAll - test instance is created(constructor) - BeforeEach - test method - AfterEach - AfterAll
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestInstancePerMethodTests {

    public TestInstancePerMethodTests(){
        System.out.println("constructor called");
    }
    @BeforeAll
    public static void staticSetup(){
        System.out.println("BeforeAll called");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Before each called");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After each called");
    }

    @AfterAll
    public static void staticTearDown(){
        System.out.println("After all called");
    }

    @Test
    public void test1(){
        System.out.println("test1 called");
    }

    @Test
    public void test2(){
        System.out.println("test2 called");
    }
}
