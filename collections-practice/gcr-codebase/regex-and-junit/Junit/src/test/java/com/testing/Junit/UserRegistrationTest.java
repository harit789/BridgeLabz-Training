package com.testing.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    private UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    public void validUserRegistrationTest() {
        Assertions.assertDoesNotThrow(() ->
            userRegistration.registerUser(
                "johnDoe",
                "john@example.com",
                "password123"
            )
        );
    }

    @Test
    public void invalidUsernameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            userRegistration.registerUser(
                "jo",
                "john@example.com",
                "password123"
            )
        );
    }

    @Test
    public void invalidEmailTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            userRegistration.registerUser(
                "johnDoe",
                "johnexample.com",
                "password123"
            )
        );
    }

    @Test
    public void invalidPasswordTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            userRegistration.registerUser(
                "johnDoe",
                "john@example.com",
                "123"
            )
        );
    }
}
