package com.testing.Junit;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {

        if (username == null || username.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Invalid password");
        }

        System.out.println("User registered successfully");
    }
}

