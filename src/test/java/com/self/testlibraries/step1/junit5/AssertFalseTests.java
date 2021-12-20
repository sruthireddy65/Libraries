package com.self.testlibraries.step1.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
assertFalse validates whether condition is false or not.
It has 6 overloaded methods
assertFalse(boolean condition)
assertFalse(boolean condition, String message)
assertFalse(boolean condition, Supplier<String> messageSupplier)
assertFalse(BooleanSupplier booleanSupplier)
assertFalse(BooleanSupplier booleanSupplier, String message)
assertFalse(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier)
 */
public class AssertFalseTests {

    @Test
    public void testAssertFalseWithoutMessage(){
        int x =10;
        assertFalse(x <10);
    }

    @Test
    public void testAssertFalseWithMessage(){
        int x = 10;
        assertFalse(x != 10, "x is always >= 10");
    }

    @Test
    public void testAssertFalseWithMessageSupplier(){
        int x = 10;
        assertFalse(x < 10, () -> "x is always >= 10");
    }

    @Test
    public void testAssertFalseWithBooleanSupplier(){
        int x = 10;
        assertFalse(()-> x!=10);
    }

    @Test
    public void testAssertFalseWithBooleanSupplierAndMessage(){
        int x = 10;
        assertFalse(() -> x!=10, "x is always equals to 10");
    }

    @Test
    public void testAssertFalseWithBooleanSupplierAndMessageSupplier(){
        int x = 10;
        assertFalse(() -> x!=10, () -> "x is always equals to 10");
    }

}
