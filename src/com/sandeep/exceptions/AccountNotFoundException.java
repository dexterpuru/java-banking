package com.sandeep.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String s) {
        // call constructor of parent exception
        super(s);
    }
}
