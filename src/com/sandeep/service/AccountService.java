package com.sandeep.service;

import com.sandeep.beans.Account;
import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.AccountNotFoundException;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    Transaction createTransaction(int sender, int reciever, int amount, String transactionType) throws SQLException;

//    boolean deleteTransaction(UUID txId) throws TransactionNotFoundException;

    ArrayList<List<Object>> getAllTransactions() throws SQLException;

    Account createAccount(Account account) throws SQLException;

    List<Object> loginAccount(int accountNumber, int pin) throws AccountNotFoundException, SQLException;

    List<Object> addAmount(int accountNumber, int amount, int flag) throws AccountNotFoundException, SQLException;

    void getAmount(int accountNumber, int pin, int amount, int flag) throws AccountNotFoundException, SQLException;

    void makeTransaction(int senderNum, int recieverNum, int amount, int pinNo)
            throws AccountNotFoundException, SQLException;

    boolean deleteAccount(Account account);

    ArrayList<List<Object>> getAllAccounts() throws SQLException;
}
