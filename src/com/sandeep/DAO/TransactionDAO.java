package com.sandeep.DAO;

import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.util.HashMap;
import java.util.UUID;

public interface TransactionDAO {
    Transaction createTransaction(int sender, int reciever, int amount, String transactionType);

    Transaction getTransaction(UUID txId) throws TransactionNotFoundException;

    boolean deleteTransaction(UUID txId) throws TransactionNotFoundException;

    HashMap<UUID, Transaction> getAllTransactions();
}