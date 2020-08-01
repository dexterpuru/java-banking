package com.sandeep.DAO;

import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.util.UUID;
import java.sql.Timestamp;
import java.util.HashMap;

// enum txType {
//     DEPOSIT, WITHDRAW, TRANSFER
// }

public class TransactionDAOImpl implements TransactionDAO {
    HashMap<UUID, Transaction> transactionHashMap = new HashMap<>();

    @Override
    public Transaction createTransaction(int sender, int reciever, int amount, String transactionType) {
        UUID txId = UUID.randomUUID();
        Timestamp txTimestamp = new Timestamp(System.currentTimeMillis());

        Transaction transaction = new Transaction(txId, txTimestamp, amount, transactionType, sender, reciever);

        transactionHashMap.put(transaction.getTxId(), transaction);
//        System.out.println(transactionHashMap);
        return transaction;
    }

    @Override
    public Transaction getTransaction(UUID txId) throws TransactionNotFoundException {
        Transaction tempTransaction = transactionHashMap.get(txId);

        if (tempTransaction == null)
            throw new TransactionNotFoundException("No Transaction with Transaction id:- ");
        return tempTransaction;
    }

    @Override
    public boolean deleteTransaction(UUID txId) throws TransactionNotFoundException {
        Transaction transaction = transactionHashMap.remove(txId);
        return true;
    }

    @Override
    public HashMap<UUID, Transaction> getAllTransactions() {
//        System.out.println(transactionHashMap);
        return transactionHashMap;
    }

}