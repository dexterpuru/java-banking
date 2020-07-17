package com.sandeep.service;

import com.sandeep.beans.Account;
import com.sandeep.exceptions.AccountNotFoundException;

import java.util.HashMap;
import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);

    public Account loginAccount(int accountNumber, int pin) throws AccountNotFoundException;

    public Account addAmount(int accountNumber, int amount) throws AccountNotFoundException;

    public Account getAmount(int accountNumber, int pin, int amount) throws AccountNotFoundException;

    public Account makeTransaction(int senderNum, int recieverNum, int amount, int pinNo)
            throws AccountNotFoundException;

    public boolean deleteAccount(Account account);

    public HashMap<Integer, Account> getAllAccounts();
}
