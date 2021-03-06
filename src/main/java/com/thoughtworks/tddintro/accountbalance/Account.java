package com.thoughtworks.tddintro.accountbalance;

public class Account {
    private int balance;

    public Account(int startBalance) {
        balance = startBalance;
    }

    public void deposit(int amount) {
        balance = balance + amount;
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}
