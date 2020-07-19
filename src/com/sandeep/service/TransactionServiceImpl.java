package com.sandeep.service;

import com.sandeep.DAO.TransactionDAO;
import com.sandeep.DAO.TransactionDAOImpl;
import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.util.HashMap;
import java.util.UUID;

public class TransactionServiceImpl implements TransactionService {

    TransactionDAO transactionDAO = new TransactionDAOImpl();

    @Override
    public Transaction createTransaction(int sender, int reciever, int amount, String transactionType) {
        return transactionDAO.createTransaction(sender, reciever, amount, transactionType);
    }

    @Override
    public boolean deleteTransaction(UUID txId) throws TransactionNotFoundException {
        return transactionDAO.deleteTransaction(txId);
    }

    @Override
    public HashMap<UUID, Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }
}