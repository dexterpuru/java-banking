package com.sandeep.DAO;

import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.util.HashMap;
import java.util.UUID;

public interface TransactionDAO {
    public Transaction createTransaction(int sender, int reciever, int amount, String transactionType);

    public Transaction getTransaction(UUID txId) throws TransactionNotFoundException;

    public boolean deleteTransaction(UUID txId) throws TransactionNotFoundException;

    public HashMap<UUID, Transaction> getAllTransactions();
}