package com.example.web.Repo;

import com.example.web.Model.User;

import java.sql.SQLException;

public interface userRepo {

    void registerUser(String userName, String fname, String lname, String email, String password) throws SQLException;
    User login (String userName, String Password) throws SQLException;

    public void update (User user) throws SQLException;
    public void delete (Long userId) throws SQLException;
}
