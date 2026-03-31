package com.testing.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    public void depositTest() {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @Test
    public void withdrawalTest() {
        bankAccount.deposit(500);
        boolean success = bankAccount.withdraw(250);

        Assertions.assertTrue(success);
        Assertions.assertEquals(250, bankAccount.getBalance());
    }

    @Test
    public void insufficientFundsWithdrawalTest() {
        bankAccount.deposit(100);
        boolean success = bankAccount.withdraw(250);

        Assertions.assertFalse(success);
        Assertions.assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void getBalanceTest() {
        Assertions.assertEquals(0.0, bankAccount.getBalance());
    }
}
