package com.agrdesign.learnjunit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */

    @BeforeAll
    static void myBeforeAll() { // w/o static an error blows up
        System.out.println("my before all");
    }

    @AfterAll
    static void myAfterAll() {
        System.out.println("tests are done");
    }

    @BeforeEach
    void myBeforeEach() {
        System.out.println("hello, before each");
    }

    @AfterEach
    void myAfterEach() {
        System.out.println("my after each. we are done here. ");
    }

    App myApp = new App();

    @Test
    void testAppSix() {

        System.out.println("testAppSix: " + myApp.calculateNumbers(new int[] { 1, 2, 3 }));
        assertEquals(6, myApp.calculateNumbers(new int[] { 1, 2, 3 }));

        // int[] someNumbers = { 1, 2, 3 };

        // App myApp = new App();

        /*
         * int result = myApp.calculateNumbers(new int[] { 1, 2, 3 });// (someNumbers);
         *
         * System.out.println("hello what? " + result);
         *
         * int expectedResult = 6;
         *
         * assertEquals(expectedResult, result);
         */
    }

    @Test
    void testAppEmpty() {

        int[] someNumbers = {};

        // App myApp = new App();

        int result = myApp.calculateNumbers(someNumbers);

        System.out.println("testAppEmpty: " + result);

        int expectedResult = 0;

        assertEquals(expectedResult, result);
    }

    @Test
    void someAssertions() {
        List<String> stuff = Arrays.asList("one", "two", "three");
        boolean theTest = stuff.contains("three");
        System.out.println("size: " + stuff.size());
        assertEquals(true, theTest, "error message if not true");
        // assertFalse(theTest, "error message if not false");
        // assertArrayEquals(null, null);
        assertTrue(theTest);
    }
}
