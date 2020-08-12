package com.sandeep.DAO;

import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface TransactionDAO {
    Transaction createTransaction(int sender, int reciever, int amount, String transactionType) throws SQLException;

//    Transaction getTransaction(UUID txId) throws TransactionNotFoundException;
//
//    boolean deleteTransaction(UUID txId) throws TransactionNotFoundException;

    ArrayList<List<Object>> getAllTransactions() throws SQLException;
}