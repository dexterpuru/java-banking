package com.sandeep.DAO;

import com.sandeep.beans.Account;
import com.sandeep.exceptions.AccountNotFoundException;

import java.util.HashMap;

public class AccountDAOImpl implements AccountDAO {
    HashMap<Integer, Account> accountHashMap = new HashMap<>();

    @Override
    public Account createAccount(Account account) {
        if (accountHashMap.containsKey(account.getAccountNumber())) {
            System.out.println("This account number already exists");
            return account;
        } else {
            accountHashMap.put(account.getAccountNumber(), account);
            System.out.println("Congrats! Your account has been created");
            return account;
        }
    }

    @Override
    public Account getAccount(int accountNumber) throws AccountNotFoundException {
        Account tempAccount = accountHashMap.get(accountNumber);
        if (tempAccount == null)
            throw new AccountNotFoundException("Account not found for accountNumber :" + accountNumber);
        else
//            System.out.println("Account details: " + tempAccount.toString());
        return tempAccount;
    }

    @Override
    public Account updateAccount(Account account) {
        accountHashMap.put(account.getAccountNumber(), account);
        return account;
    }

    @Override
    public boolean deleteAccount(Account account) {
        Account temp = accountHashMap.remove(account.getAccountNumber());
        return true;
    }

    @Override
    public HashMap<Integer, Account> getAllAccounts() {
        return accountHashMap;
    }
}
