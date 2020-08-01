package com.sandeep.service;

import com.sandeep.beans.Account;
import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.AccountNotFoundException;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    Transaction createTransaction(int sender, int reciever, int amount, String transactionType);

    boolean deleteTransaction(UUID txId) throws TransactionNotFoundException;

    HashMap<UUID, Transaction> getAllTransactions();

    Account createAccount(Account account);

    Account loginAccount(int accountNumber, int pin) throws AccountNotFoundException;

    Account addAmount(int accountNumber, int amount) throws AccountNotFoundException;

    Account getAmount(int accountNumber, int pin, int amount) throws AccountNotFoundException;

    Account makeTransaction(int senderNum, int recieverNum, int amount, int pinNo)
            throws AccountNotFoundException;

    boolean deleteAccount(Account account);

    HashMap<Integer, Account> getAllAccounts();
}
