package com.sandeep.service;

import com.sandeep.DAO.AccountDAO;
import com.sandeep.DAO.AccountDAOImpl;
import com.sandeep.DAO.TransactionDAO;
import com.sandeep.DAO.TransactionDAOImpl;
import com.sandeep.beans.Account;
import com.sandeep.exceptions.AccountNotFoundException;
import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.TransactionNotFoundException;

import com.sandeep.DAO.DatabaseDAOImpl;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AccountServiceImpl implements AccountService {

    TransactionDAO transactionDAO = new TransactionDAOImpl();
    AccountDAO accountDAO = new AccountDAOImpl();
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
        return transactionDAO.createTransaction(sender, reciever, amount, transactionType);
    }

//    @Override
//    public boolean deleteTransaction(UUID txId) throws TransactionNotFoundException {
//        return transactionDAO.deleteTransaction(txId);
//    }

    @Override
    public ArrayList<List<Object>> getAllTransactions() throws SQLException{
        return transactionDAO.getAllTransactions();
    }


    @Override
    public Account createAccount(Account account) throws SQLException {
        return accountDAO.createAccount(account);
    }

    @Override
    public List<Object> loginAccount(int accountNumber, int pin) throws AccountNotFoundException, SQLException {
        List<Object> tempAccount = accountDAO.getAccount(accountNumber);
        if (tempAccount == null) {
            System.out.println("Account does not exists");
            return null;
        } else {
            if ((Integer) tempAccount.get(3) == pin) {
                System.out.println("Details are correct : login to account");
                return tempAccount;
            } else {
                System.out.println("Incorrect pin ");
                return null;
            }
        }
    }

    @Override
    public List<Object> addAmount(int accountNumber, int amount, int flag) throws AccountNotFoundException, SQLException {
        List<Object> account = DatabaseDAOImpl.getAccountFromDB(accountNumber);
        if (account == null) {
            System.out.println("No account found with this account number.");
        } else {
            int am = (Integer) account.get(2) + amount;
            account.set(2, am);
        }
        if (flag == 1) {
            Transaction tran = createTransaction(accountNumber, accountNumber, amount, "DEPOSIT");
        }
        accountDAO.updateAccount(account);
        return account;
    }

    @Override
    public void getAmount(int accountNumber, int pin, int amount, int flag) throws AccountNotFoundException, SQLException {
        List<Object> myaccount = loginAccount(accountNumber, pin);
        if (myaccount != null) {
            int currentBalance = (Integer) myaccount.get(2);
            if (currentBalance < amount) {
                System.out.println("Not enough balance");
            } else {
                myaccount.set(2, (Integer)myaccount.get(2) - amount);
                if (flag == 1) {
                    Transaction tran = createTransaction(accountNumber, accountNumber, amount, "WITHDRAW");
                }
                accountDAO.updateAccount(myaccount);
                System.out.println("Transaction Successfull");
            }
        }
    }

    @Override
    public void makeTransaction(int senderNum, int recieverNum, int amount, int pinNo)
            throws AccountNotFoundException, SQLException {
        getAmount(senderNum, pinNo, amount, 0);
        addAmount(recieverNum, amount, 0);
        Transaction tran = createTransaction(senderNum, recieverNum, amount, "TRANSFER");
    }

    @Override
    public boolean deleteAccount(Account account) {
        return accountDAO.deleteAccount(account);
    }

    @Override
    public ArrayList<List<Object>> getAllAccounts() throws SQLException {
        return accountDAO.getAllAccounts();
    }
}
