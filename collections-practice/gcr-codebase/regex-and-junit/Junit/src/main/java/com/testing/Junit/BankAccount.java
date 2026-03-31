package com.testing.Junit;

public class BankAccount {

    private double balance = 0.0;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            return false; 
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}
