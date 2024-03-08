package com.example.web.Repo;

import com.example.web.Model.Account;
import com.example.web.Model.User;

import java.sql.SQLException;

public interface accountRepo {

    void registerAccount(Long userId, double balance) throws SQLException;
    Account getAccount (Long userId) throws SQLException;

    public void update (Account account) throws SQLException;
    public void delete (Long accountId) throws SQLException;
}
