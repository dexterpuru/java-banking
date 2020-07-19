package com.sandeep.service;

import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.util.UUID;
import java.util.HashMap;

public interface TransactionService {
    public Transaction createTransaction(int sender, int reciever, int amount, String transactionType);

    public boolean deleteTransaction(UUID txId) throws TransactionNotFoundException;

    public HashMap<UUID, Transaction> getAllTransactions();
}