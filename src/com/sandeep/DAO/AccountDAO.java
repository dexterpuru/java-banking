package com.sandeep.DAO;

import com.sandeep.beans.Account;
import com.sandeep.exceptions.AccountNotFoundException;

import java.util.HashMap;
import java.util.List;

public interface AccountDAO {
    Account createAccount(Account account);

    Account getAccount(int accountNumber) throws AccountNotFoundException;

    Account updateAccount(Account account);

    boolean deleteAccount(Account account);

    HashMap<Integer, Account> getAllAccounts();
}
