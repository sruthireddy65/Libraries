package com.self.testlibraries.step1.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit-jupiter-params dependency has to be added to work with parameterized tests.
 * It can be used to unit test by passing multiple parameters to the method in test instance.
 * It should have Source files provided using @CsvSource, @CsvFileSource, @EnumSource,
 * @ValueSource, @EmptySource, @NullSource, @NullAndEmptySource, @MethodSource
 *  Cannot verify object types using @ValueSource
 */
public class ParameterizedTestTests {

    CheckParameterizedTest checkParameterizedTest;

    @BeforeEach
    public void setup(){
        checkParameterizedTest = new CheckParameterizedTest();
    }
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    public void testIsEven(int num){
        assertTrue(checkParameterizedTest.isEven(num));
    }

    @ParameterizedTest
    @NullSource
    public void testNullSource(String input){
        assertNull(checkParameterizedTest.reverse(null));
    }

    @ParameterizedTest
    @EmptySource
    public void testEmptySource(String input) {
        assertEquals("", checkParameterizedTest.reverse(""));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmptySource(String input){
        assertEquals(input, checkParameterizedTest.reverse(input));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    public void testNullAndEmpty(String input){
        assertEquals(input, checkParameterizedTest.reverse(input));
    }

    @ParameterizedTest
    @CsvSource({"car, rac", "test, tset"})
    public void testCsvSource(String input, String expect){
        assertEquals(expect, checkParameterizedTest.reverse(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csvFileSource.csv")
    public void testCsvFileSource(String input, String expect){
        assertEquals(expect, checkParameterizedTest.reverse(input));
    }

    @ParameterizedTest
    @EnumSource(value = Fruit.class, names = {"APPLE", "GRAPES"}, mode = EnumSource.Mode.EXCLUDE)
    public void testEnumSource(Fruit fruit){
        assertNotNull(fruit);
    }

    @ParameterizedTest
    @MethodSource(value = "stringArguments")
    public void testMethodSource(String input){
        assertNotNull(input);
    }

    public static Stream<String> stringArguments(){
        return Stream.of("a","b","c");
    }

    @ParameterizedTest
    @MethodSource(value = "multipleArguments")
    public void testMethodSourceWithMultipleArguments(String input, String expect){
        assertEquals(expect, checkParameterizedTest.reverse(input));
    }

    public static Stream<Arguments> multipleArguments(){
        return Stream.of(Arguments.arguments("car", "rac"), Arguments.arguments("test", "tset"));
    }
}
