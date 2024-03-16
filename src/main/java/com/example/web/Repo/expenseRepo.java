package com.example.web.Repo;

import com.example.web.Model.Account;
import com.example.web.Model.Expense;
import com.example.web.Model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface expenseRepo {

    void addExpense(int accountId, int reoccuring, double amount, String tag) throws SQLException;
    ArrayList<Expense> selectExpense (int accountId) throws SQLException;
    public void update (Expense out) throws SQLException;
    public void delete (int transaction_id_out) throws SQLException;
}
