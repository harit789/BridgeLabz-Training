package com.testing.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    private final StringUtils utils = new StringUtils();

    @Test
    void reverseCheck() {
        String result = utils.reverse("car");
        String expected = "rac";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void palindromeTrueCheck() {
        boolean result = utils.isPalindrome("madam");
        Assertions.assertTrue(result);
    }

    @Test
    void palindromeFalseCheck() {
        boolean result = utils.isPalindrome("hello");
        Assertions.assertFalse(result);
    }

    @Test
    void toUpperCaseCheck() {
        String result = utils.toUpperCase("hello");
        String expected = "HELLO";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void toUpperCaseWithNumbersCheck() {
        String result = utils.toUpperCase("abc123");
        String expected = "ABC123";
        Assertions.assertEquals(expected, result);
    }
}
