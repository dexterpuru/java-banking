package com.sandeep.DAO;

import com.sandeep.beans.Account;
import com.sandeep.exceptions.AccountNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface AccountDAO {
    Account createAccount(Account account) throws SQLException;

    List<Object> getAccount(int accountNumber) throws AccountNotFoundException, SQLException;

    void updateAccount(List<Object> account) throws SQLException;

    boolean deleteAccount(Account account);

    ArrayList<List<Object>> getAllAccounts() throws SQLException;
}
