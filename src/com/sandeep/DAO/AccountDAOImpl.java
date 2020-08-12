package com.sandeep.DAO;

import com.sandeep.beans.Account;
import com.sandeep.exceptions.AccountNotFoundException;
import java.sql.SQLException;
//import com.sandeep.DAO.DatabaseDAO;
import com.sandeep.DAO.DatabaseDAOImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.sandeep.DAO.DatabaseDAOImpl.getAllAccountsFromDB;

public class AccountDAOImpl implements AccountDAO {

    DatabaseDAOImpl dbDAO;

    {
        try {
            dbDAO = new DatabaseDAOImpl();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    HashMap<Integer, Account> accountHashMap = new HashMap<>();


    @Override
    public Account createAccount(Account account) throws SQLException {
        if (DatabaseDAOImpl.getAccountFromDB(account.getAccountNumber()) != null) {
            System.out.println("This account number already exists");
            return account;
        } else {
            DatabaseDAOImpl.addAccountToDB(account);
            System.out.println("Congrats! Your account has been created");
            return account;
        }
    }

    @Override
    public List<Object> getAccount(int accountNumber) throws AccountNotFoundException, SQLException {
        List<Object> account = DatabaseDAOImpl.getAccountFromDB(accountNumber);
        return account;
    }

    @Override
    public void updateAccount(List<Object> account) throws SQLException {
        DatabaseDAOImpl.updateAccountToDB(account);
    }

    @Override
    public boolean deleteAccount(Account account) {
        Account temp = accountHashMap.remove(account.getAccountNumber());
        return true;
    }

    @Override
    public ArrayList<List<Object>> getAllAccounts() throws SQLException {
        return DatabaseDAOImpl.getAllAccountsFromDB();
    }
}
