package com.example.web.Repo;

import com.example.web.Model.Account;
import com.example.web.Model.Income;
import com.example.web.Model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface incomeRepo {

    void addIncome(int accountId,int reoccurring, double amount, String tag) throws SQLException;
    ArrayList<Income> selectIncome (int accountId) throws SQLException;

    public void update (Income in) throws SQLException;
    public void delete (int transaction_id_in) throws SQLException;
}
