package com.sandeep.service;

import com.sandeep.DAO.AccountDAO;
import com.sandeep.DAO.AccountDAOImpl;
import com.sandeep.beans.Account;
import com.sandeep.exceptions.AccountNotFoundException;
import com.sandeep.beans.Transaction;
import com.sandeep.service.TransactionService;
import com.sandeep.service.TransactionServiceImpl;

import java.util.HashMap;

public class AccountServiceImpl implements AccountService {

    TransactionService transactionService = new TransactionServiceImpl();

    AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public Account createAccount(Account account) {
        return accountDAO.createAccount(account);
    }

    @Override
    public Account loginAccount(int accountNumber, int pin) throws AccountNotFoundException {
        Account tempAccount = accountDAO.getAccount(accountNumber);
        if (tempAccount == null) {
            System.out.println("Account does not exists");
            return null;
        } else {
            if (tempAccount.getPin() == pin) {
                System.out.println("Details are correct : login to account");
                return tempAccount;
            } else {
                System.out.println("Incorrect pin ");
                return null;
            }
        }
    }

    @Override
    public Account addAmount(int accountNumber, int amount) throws AccountNotFoundException {
        Account account = accountDAO.getAccount(accountNumber);
        account.setCurrentBalance(account.getCurrentBalance() + amount);
        Transaction tran = transactionService.createTransaction(accountNumber, accountNumber, amount, "DEPOSIT");
        accountDAO.updateAccount(account);
        return account;
    }

    @Override
    public Account getAmount(int accountNumber, int pin, int amount) throws AccountNotFoundException {
        Account myaccount = loginAccount(accountNumber, pin);
        if (myaccount == null) {
            return null;
        } else {
            int currentBalance = myaccount.getCurrentBalance();
            if (currentBalance < amount) {
                System.out.println("Not enough balance");
                return myaccount;
            } else {
                myaccount.setCurrentBalance(myaccount.getCurrentBalance() - amount);
                Transaction tran = transactionService.createTransaction(accountNumber, accountNumber, amount,
                        "WITHDRAW");
                return accountDAO.updateAccount(myaccount);
            }
        }
    }

    @Override
    public Account makeTransaction(int senderNum, int recieverNum, int amount, int pinNo)
            throws AccountNotFoundException {
        Account senderAccount = getAmount(senderNum, pinNo, amount);
        Account recieverAccount = addAmount(recieverNum, amount);
        Transaction tran = transactionService.createTransaction(senderNum, recieverNum, amount, "TRANSFER");
        return senderAccount;
    }

    @Override
    public boolean deleteAccount(Account account) {
        return accountDAO.deleteAccount(account);
    }

    @Override
    public HashMap<Integer, Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }
}
