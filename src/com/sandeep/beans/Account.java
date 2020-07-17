package com.sandeep.beans;

public class Account {
    private String accountHolderName;
    private int accountNumber;
    private int currentBalance;
    private int pin;

    public Account(String accountHolderName, int accountNumber, int currentBalance, int pin) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.pin = pin;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
