package com.self.testlibraries.step1.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 validates whether expected and actual objects are not equals or not.
 It has 3 overloaded methods
 assertNotEquals(Object expected, Object actual)
 assertNotEquals(Object expected, Object actual, String message)
 assertNotEquals(Object expected, Object actual, Supplier<String> message)
 */
public class AssertNotEqualsTests {

    @Test
    public void testAssertNotEqualsWithoutMessage(){
        String object = "abcd";
        assertNotEquals("abc", object);
    }

    @Test
    public void testAssertNotEqualsWithMessage(){
        String object = "abcd";
        assertNotEquals("abc", object, "objects should be equals");
    }

    @Test
    public void testAssertNotEqualsWithMessageSupplier(){
        String object = "abcd";
        assertNotEquals("abc", object, ()-> "objects should be equal");
    }
}
