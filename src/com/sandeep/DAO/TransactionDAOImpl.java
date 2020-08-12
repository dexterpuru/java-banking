package com.sandeep.DAO;

import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;
import java.util.HashMap;
import com.sandeep.DAO.DatabaseDAOImpl;

// enum txType {
//     DEPOSIT, WITHDRAW, TRANSFER
// }

public class TransactionDAOImpl implements TransactionDAO {
//    HashMap<UUID, Transaction> transactionHashMap = new HashMap<>();
    DatabaseDAOImpl dbDAO;
    {
        try {
            dbDAO = new DatabaseDAOImpl();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Transaction createTransaction(int sender, int reciever, int amount, String transactionType) throws SQLException {
        UUID txId = UUID.randomUUID();
        Timestamp txTimestamp = new Timestamp(System.currentTimeMillis());

        Transaction transaction = new Transaction(txId, txTimestamp, amount, transactionType, sender, reciever);
        DatabaseDAOImpl.addTransactionToDB(transaction);
//        transactionHashMap.put(transaction.getTxId(), transaction);
//        System.out.println(transactionHashMap);
        return transaction;
    }

//    @Override
//    public Transaction getTransaction(UUID txId) throws TransactionNotFoundException {
//        Transaction tempTransaction = transactionHashMap.get(txId);
//
//        if (tempTransaction == null)
//            throw new TransactionNotFoundException("No Transaction with Transaction id:- ");
//        return tempTransaction;
//    }
//
//    @Override
//    public boolean deleteTransaction(UUID txId) throws TransactionNotFoundException {
//        Transaction transaction = transactionHashMap.remove(txId);
//        return true;
//    }

    @Override
    public ArrayList<List<Object>> getAllTransactions() throws SQLException {
        return DatabaseDAOImpl.getAllTransactionsFromDB();
    }
}