package com.self.libraries.step1.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
validates whether expected and actual objects are equals or not.
It has 3 overloaded methods
assertEquals(Object expected, Object actual)
assertEquals(Object expected, Object actual, String message)
assertEquals(Object expected, Object actual, Supplier<String> message)
 */
public class AssertEqualsTests {

    @Test
    public void testAssertEqualsWithoutMessage(){
        String object = "abc";
        assertEquals("abc", object);
    }

    @Test
    public void testAssertEqualsWithMessage(){
        String object = "abc";
        assertEquals("abc", object, "objects should be equals");
    }

    @Test
    public void testAssertEqualsWithMessageSupplier(){
        String object = "abc";
        assertEquals("abc", object, ()-> "objects should be equal");
    }

}
