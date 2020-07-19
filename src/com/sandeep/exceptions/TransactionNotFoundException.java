package com.sandeep.exceptions;

public class TransactionNotFoundException extends Exception {
    public TransactionNotFoundException(String s) {
        super(s);
    }
}