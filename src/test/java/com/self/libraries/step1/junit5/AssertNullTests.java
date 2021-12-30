package com.self.libraries.step1.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * assertNull validates if given object is null or not
 * It has 3 overloaded methods
 * assertNull(Object object)
 * assertNull(Object object, String message)
 * assertNull(Object object, Supplier<String> message)
 */
public class AssertNullTests {

    @Test
    public void testAssertNullWithoutMessage(){
        String object = null;
        assertNull(object);
    }

    @Test
    public void testAssertNullWithMessage(){
        String object = null;
        assertNull(object, "object should be null");
    }

    @Test
    public void testAssertNullWithMessageSupplier(){
        String object = null;
        assertNull(object, ()-> "object should be null");
    }
}
