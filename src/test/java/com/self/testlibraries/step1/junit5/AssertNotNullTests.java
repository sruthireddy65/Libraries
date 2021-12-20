package com.self.testlibraries.step1.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
assertNotNull validates whether object is not null or not
It has 3 overloaded methods
assertNotNull(Object object)
assertNotNull(Object object, String message)
assertNotNull(Object object, Supplier<String> message)
 */
public class AssertNotNullTests {
    @Test
    public void testAssertNotNullWithoutMessage(){
        String object = "abc";
        assertNotNull(object);
    }

    @Test
    public void testAssertNotNullWithMessage(){
        String object = "abc";
        assertNotNull(object, "object should not be null");
    }

    @Test
    public void testAssertNotNullWithMessageSupplier(){
        String object = "abc";
        assertNotNull(object, ()-> "object should not be null");
    }
}
