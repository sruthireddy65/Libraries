package com.self.testlibraries.step1.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * validates whether expected and actual arrays are equals
 * i.e. elements of array should match
 * order of elements should match
 * number of elements should match
 * assertArrayEquals(Object[] expected, Object[] actual)
 * assertArrayEquals(Object[] expected, Object[] actual, String message)
 * assertArrayEquals(Object[] expected, Object[] actual, Supplier<String> message)
 */
public class AssertArrayEqualsTests {

    @Test
    public void testAssertArrayEqualsWithoutMessage(){
        String[] arr1 = {new String("abc"), new String("def")};
        String[] arr2 = {new String("abc"), new String("def")};
        assertArrayEquals(arr1, arr2);
    }
}
