package com.self.testlibraries.step1.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
assertTrue evaluates whether passed expression is true or not.
It has 6 overloaded methods
assertTrue(boolean condition)
assertTrue(boolean condition, String message)
assertTrue(boolean condition, Supplier<String> messageSupplier)
assertTrue(BooleanSupplier booleanSupplier)
assertTrue(BooleanSupplier booleanSupplier, String message)
assertTrue(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier)
 */
public class AssertTrueTests {

    @Test
    public void testAssertTrueWithoutMessage(){
        int x =10;
        assertTrue(x >=10);
    }

    @Test
    public void testAssertTrueWithMessage(){
        int x = 10;
        assertTrue(x == 10, "x is always >= 10");
    }

    @Test
    public void testAssertTrueWithMessageSupplier(){
        int x = 10;
        assertTrue(x >= 10, () -> "x is always >= 10");
    }

    @Test
    public void testAssertTrueWithBooleanSupplier(){
        int x = 10;
        assertTrue(()-> x==10);
    }

    @Test
    public void testAssertTrueWithBooleanSupplierAndMessage(){
        int x = 10;
        assertTrue(() -> x==10, "x is always equals to 10");
    }

    @Test
    public void testAssertWithBooleanSupplierAndMessageSupplier(){
        int x = 10;
        assertTrue(() -> x==10, () -> "x is always equals to 10");
    }
}
